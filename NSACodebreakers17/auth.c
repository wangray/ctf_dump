/*
MIT License

Copyright (c) 2017 National Security Agency

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

#include<stdlib.h>
#include<string.h>
#include<stdint.h>

#include"auth.h"
#include"sha3.h"

/* Wrapper function to hash the buffer with SHA3 and return
 * the result allocated on the heap
 */
char* HASH(const char* buf, unsigned int len)
{
    sha3_context c;
    const uint8_t *hash;

    sha3_Init256(&c);
    sha3_Update(&c, buf, len);
    hash = sha3_Finalize(&c);

    char* r = (char*)malloc(32);
    if(!r) return NULL;
    memcpy(r, hash, 32);
    return r;
}

/* constant time equality comparison
 * compares variable number of bytes 4 at a time for additional speed.
 * 
 * result is always 0 or -1, 0 if equal, -1 otherwise
 * if n % 4 != 0 the result may be inaccurate
 *
 * derived from NaCL crypt_verify [1] (code in the public domain)
 * [1] https://nacl.cr.yp.to/verify.html
 */
int const_memequal(const void *a, const void *b, size_t n)
{
    uint64_t differentbits = 0;
#define F(i) differentbits |= x[i] ^ y[i];
    uint32_t* x = (uint32_t*)a;
    uint32_t* y = (uint32_t*)b;
    n /= 4;
    for(size_t i = 0; i < n; ++i)
    {
        F(i);    
    }
    return (1 & ((differentbits - 1) >> 32)) - 1;
}

/* Main 'entry-point' authentication function.
 *
 * Expects password is a buffer with 0 < length < 64k (based on MQTT)
 * Returns 1, 0, or -1 for pass, fail, or error respectively
 *
 * This is a modified version of S/KEY where the password field contains
 * not just 1 OTP key, but 2 OTP keys.  The latter is the new key for the
 * server to store.  When these keys are the same, it operates exactly as
 * S/KEY does.  If they are different, it allows a user to move to a new set
 * of OTPs, since presumably they've run out of the current set.
 *
 * Swapping in a new hash function with different length is easy:
 * The two keys are always the same length, and the password[0] byte indictates
 * the offset to the 2nd OTP key (which is equivalent to the key size).
 */
int authenticate(pauthctx ctx, const char* username, const char* password)
{
    if(!ctx || !username || !password) return -1;

    // parse password for current OTP and next OTP
    unsigned int otpsize = (unsigned int)password[0];
    const char* otp = password+1;

    // chek size is non-zero and a multiple of 4 to use constant time memcmp
    if(!otpsize || (otpsize % 4)) return -1;

    // main S/KEY step, hash the OTP
    char* hashed_otp = HASH(otp, otpsize);
    if(!hashed_otp) return -1;

    char* expected_nextotp = load_nextotp(ctx, username);
    if(!expected_nextotp) return -1;

    // main verification step - check hash equality (in constant time)
    if(0==const_memequal(expected_nextotp, hashed_otp, otpsize))
    {
        free(expected_nextotp);
        free(hashed_otp);

        // S/KEY does this
        // store_nextotp(ctx, username, otp);
        //
        // our modifed version does this
        const char* nextotp = password + 1 + otpsize;
        if(0!=store_nextotp(ctx, username, nextotp, otpsize))
        {
            // some error updating the next OTP
            return -1;
        }

        return 1; // authentication passed
    }
    free(expected_nextotp);
    free(hashed_otp);
    return 0; // authentication failed
}

