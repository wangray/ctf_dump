#include <stdio.h>


int main(){
  unsigned int state0; // ecx@1
  unsigned int state1; // edx@1
  unsigned int v4; // eax@1
  int v5; // er11@2
  char *plaintext = "AAAAAAAAAAAAAAAA";

  state0 = 0;
  state1 = 0;

  int iteration = 0;

  v4 = 1048021904;
  int i = 0;

  do
  {

    int* ptr_plaintext = (int*) plaintext;
    v5 = v4 + ptr_plaintext[v4 & 3];
    v4 -= 2081982279;
    state0 += (state1 + (16 * state1 ^ (state1 >> 5))) ^ v5;
    state1 += (v4 + plaintext[(v4 >> 11) & 3]) ^ (state0 + (16 * state0 ^ (state0 >> 5)));
    printf("%d\n", i);
    i++;
  }
  while ( v4 != 2096043808 );
  state0 = state0;
  state1 = state1;

  printf("%x\n", state0);
    printf("%x\n", state1);
}
