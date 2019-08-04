#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int fib_d(int n)
{
	if (n <= 2)
		return 1;
	else

		return fib_d(n - 1) + fib_d(n - 2);
}

int  fib(int n)
{
	int a = 1;
	int b = 1;
	int i = 0;
	int c = 0;
	if (n <= 2)
	{
		return 1;
	}
	else 
	for (i = 0; i < n - 2; i++)
	{
		c = a + b;
		a = b;
		b = c;

	}
	return c;
}
int main()
{
	int a = 0;
	int n = 0;
	int c = 0;
	scanf("%d", &n);
	/*c=fib(n);*/
	c = fib_d(n);
	printf("%d ", c);
	system("pause");
	return 0;




}