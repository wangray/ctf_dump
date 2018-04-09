#include "stdio.h"

static int rnd_seed;

void set_rnd_seed (int new_seed)
{
    rnd_seed = new_seed;
}

int rand_int (void)
{
    int k1;
    int ix = rnd_seed;

    k1 = ix / 127773;
    ix = 16807 * (ix - k1 * 127773) - k1 * 2836;
    if (ix < 0)
        ix += 2147483647;
    rnd_seed = ix;
    return rnd_seed;
}

int bruteforce(){
  int x;
  for (int i = 0x803b0000; i < 0x803b776d; i++){
    // printf("%d\n", i);
    set_rnd_seed(i);

    for( int j= 0; j < 23; j++){
      x = rand_int();
    }
    if (x < 0x80ed390 && x > 0x80ecfc0){
    // if (x > 0x80ecfc0){

      printf("i: %08x x: %08x\n", i, x);

      // return 1;
    }
  }
}


// int main(){
//   bruteforce();
// }
int main(){
  bruteforce();

}
