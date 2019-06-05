#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int a, b;
	int middle;

	printf("«Î ‰»Î a b \n");
	scanf("%d%d", &a, &b);

	middle = b + (a - b) / 2;
	printf("%d \n", middle);
	system("pause");
	return 0;


}