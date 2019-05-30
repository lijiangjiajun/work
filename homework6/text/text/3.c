#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

void fox(int n)
{
	if (n != 0)
	{   
		fox(n / 10);

		printf("%d ", n % 10);
	}
}

int main()
{
	int n;
	printf("请输入一个整数");
	scanf("%d", &n);
	if (n < 0)
	{
		n = -n;
	}
	fox(n);
	system("pause");
	return 0;
}