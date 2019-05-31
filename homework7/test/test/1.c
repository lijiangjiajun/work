#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int unequal(int A,int B,int C,int D,int E)
{
	if (A != B && A != C &&A != D && A != E &&B != C && B != D &&B != E  &&C != D &&C != E  &&D != E)
		return 1;
	else
		return 0;
}
int main()
{
	int A, B, C, D, E;
	int ret;
	for (A = 1; A <= 5; A++)
	{

		for (B = 1; B <= 5; B++)
		{

			for (C = 1; C <= 5; C++)
			{

				for (D = 1; D <= 5; D++)
				{

					for (E = 1; E <= 5; E++)
					{
						ret = unequal(A, B, C, D, E);
						if (((B == 2 && A == 3) + (B == 2 && E == 4) + (C == 1 && D == 2) + (C == 5 && D == 3)
							+ (E == 4 && A == 1) == 0) && ((B == 2 || A == 3) + (B == 2 || E == 4) + (C == 1 || D == 2) + (C == 5 || D == 3) + (E == 4 || A == 1) == 5) && (ret == 1))
							printf("A=%d B=%d C=%d D=%d E=%d\n", A, B, C, D, E);



					}
				}
			}
		}
	}
		system("pause");
		return 0;
	}
