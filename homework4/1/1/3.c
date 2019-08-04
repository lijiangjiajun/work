#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
 
int s = 0;
int  DigitSum(int n)
{
	if (n > 10)
	{
		DigitSum(n / 10);
	}
	s = s + n % 10;
	return s;
}

int main()
{
	int n = 0;
	int b = 0;
	int s = 0;
	scanf("%d", &n);
	b = DigitSum(n);
	printf("%d ", b);
	system("pause");
	return 0;
}