#include <stdio.h>
#include <stdlib.h>     /* atoi */


int main( int argc, char *argv[], char *envp[] )  {

    // printf("%p", envp);
    int v1 = 0;
    int v2 = 0;
    int v3 = 0;
    int v4 = 0;
    int v5 = 0;

    *(char*)&v1 = 0x31;
    *(char*)(&v1+1) = 0x31;
    printf("%i\n", atoi((char*)&v1));

}

// unsigned int stroul()

//   unsigned int result; // eax@4
//   int v4; // [sp+0h] [bp-20h]@38
//   int v5; // [sp+4h] [bp-1Ch]@5
//   int v6; // [sp+4h] [bp-1Ch]@20
//   signed int v7; // [sp+8h] [bp-18h]@1
//   signed int v8; // [sp+Ch] [bp-14h]@18
//   unsigned int v9; // [sp+10h] [bp-10h]@18
//   unsigned int v10; // [sp+18h] [bp-8h]@18
//   _BYTE *v11; // [sp+1Ch] [bp-4h]@1

//   v11 = a1;
//   v7 = 0;
//   if ( a3 <= 36 && a3 >= 0 && a3 != 1 )
//   {
//     do
//       v5 = *v11++;
//     while ( *((_WORD *)off_411490 + v5) & 8 );
//     if ( v5 == 45 )
//     {
//       v7 = 1;
//       v5 = *v11++;
//     }
//     else if ( v5 == 43 )
//     {
//       v5 = *v11++;
//     }
//     if ( (!a3 || a3 == 16) && v5 == 48 && (*v11 == 120 || *v11 == 88) )
//     {
//       v5 = v11[1];
//       v11 += 2;
//       a3 = 16;
//     }
//     if ( !a3 )
//       a3 = 2 * (v5 != 48) + 8;
//     v10 = ((unsigned int)(v7 != 0) + 0x7FFFFFFF) / a3;
//     v9 = 0;
//     v8 = 0;
//     while ( 1 )
//     {
//       if ( *((_WORD *)off_411490 + v5) & 4 )
//       {
//         v6 = v5 - 48;
//       }
//       else
//       {
//         if ( !(*((_WORD *)off_411490 + v5) & 0x100) )
//           break;
//         v6 = v5 - ((*((_WORD *)off_411490 + v5) & 1) != 0 ? 55 : 87);
//       }
//       if ( v6 >= a3 )
//         break;
//       if ( v8 >= 0 && v9 <= v10 && (v9 != v10 || v6 <= (signed int)(((unsigned int)(v7 != 0) + 0x7FFFFFFF) % a3)) )
//       {
//         v8 = 1;
//         v9 = v6 + a3 * v9;
//       }
//       else
//       {
//         v8 = -1;
//       }
//       v5 = *v11++;
//     }
//     if ( v8 >= 0 )
//     {
//       if ( v7 )
//         v9 = -v9;
//     }
//     else
//     {
//       v9 = (v7 != 0) + 0x7FFFFFFF;
//       *_errno() = 34;
//     }
//     if ( a2 )
//     {
//       if ( v8 )
//         v4 = (int)(v11 - 1);
//       else
//         v4 = (int)a1;
//       *a2 = v4;
//     }
//     result = v9;
//   }
//   else
//   {
//     *_errno() = 22;
//     result = 0;
//   }
//   return result;
// }