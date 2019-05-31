#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

void triangle(int n,int a[100][100])
{
	int i = 0;
	int j = 0;
	a[0][0] = 1;
	a[1][0] = 1;
	a[1][1] = 1;
	for (i = 2; i < n; i++)
	{
		for (j = 1; j < i; j++)
		{
			a[i][0] = 1;
			a[i][i] = 1;
			a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
		}
	}
	

	for (i = 0; i < n; i++)
	{
		for (j = 0; j <= i; j++)
		{
			printf("%d ", a[i][j]);
		}
		printf("\n");
	}

		
}


int main()
{

	int a[100][100];
	int n = 0;
	printf("请输入要打印的行数");
	scanf("%d", &n);
	triangle(n,a);
	system("pause");
	return 0;
}