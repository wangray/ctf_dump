#include <stdio.h>
#include <stdlib.h>

int main()
{
  
   srand((unsigned int)0);

   /* Print 5 random numbers from 0 to 50 */
   for(int i = 0 ; i < 5 ; i++ ) 
   {
      printf("%d\n", rand());
   }
   
   return(0);
}
