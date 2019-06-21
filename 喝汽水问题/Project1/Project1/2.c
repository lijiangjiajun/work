#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int money=20;
	int empty=0;
	int bottle=0;
	int tmp;
	while (money != 0)
	{
		money--;
		empty++;
		bottle++;
	}
	while (empty > 1)
	{
		tmp= empty / 2;
		empty = empty % 2;
		bottle = bottle + tmp;
		empty = empty + tmp;
	}
	printf("%d ", bottle);
	system("pause");
	return 0;
}