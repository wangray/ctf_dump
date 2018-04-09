#include <stdio.h>
#define LEN 0x7FFF

FILE * logfp;
void logstate(unsigned short eip, unsigned short inst, unsigned short next, unsigned short rest)
{
	fprintf(logfp, "EIP %04x INST %04x NEXT %04x RESET %04x\n", eip, inst, next, rest);
	fflush(logfp);
}

void logstore(unsigned short eip, unsigned short inst, unsigned short next, unsigned short rest, unsigned short newval)
{
	fprintf(logfp, "EIP %04x INST %04x NEXT %04x RESET %04x - WRITE %04x\n", eip, inst, next, rest, newval);
	fflush(logfp);
}

void logoutput(unsigned short eip, unsigned short inst, unsigned short next, unsigned short rest, char newval)
{
	fprintf(logfp, "EIP %04x INST %04x NEXT %04x RESET %04x - PRINT %c\n", eip, inst, next, rest, newval);
	fflush(logfp);
}

int main(void)
{
	logfp = fopen("log.txt", "w");
	short prog[LEN];
	{
		FILE *fp = fopen("./dumped.sq", "r");
		fread(prog, sizeof(prog), 1, fp);
		fclose(fp);
	}
	int eip = 0;
	long iter = 0;

	short inst, next, rest;

	while(1)
	{
		while(1)
		{
			while(1)
			{
				if(iter > 20000000)
				{
					printf("Done1\n");
					return 0;
				}

				if (eip >= LEN)
				{
					printf("Done2\n");
					return 0;
				}

				inst = prog[eip];
				next = prog[eip+1];
				rest = prog[eip+2];

				logstate(eip, inst, next, rest);

				if(rest > LEN)
				{
					printf("Done3\n");
					return 0;
				}

				if (inst == -1 && next == -1) {
					printf("IO Fault\n");
					return 0;
				}
				//input
				if(inst != -1)
				{
					break;
				}

				if(next > LEN)
				{
					printf("Invalid address1\n");
					return 0;
				}
				prog[next] = fgetc(stdin);
				printf("stdin %d\n", prog[next]);
				logstore(eip, inst, next, rest, prog[next]);
				
				if(prog[next] > 0)
					eip += 3;
				else
					eip = rest;
				iter++;
			}

			//output
			if(next != -1)
			{
				break;
			}

			if(inst > LEN)
			{
				printf("Invalid address2\n");
				return 0;
			}

			putchar(prog[inst]);
			logoutput(eip, inst, next, rest, prog[inst]);

			fflush(stdout);
			eip += 3;

			iter++;
		}

		//execute reglar
		if (next > LEN || inst > LEN)
		{
			break;
		}
		prog[next] -= prog[inst];
		if (prog[next] > 0)
			eip += 3;
		else
			eip = rest;
	}
	fclose(logfp);
	return 0;
}

