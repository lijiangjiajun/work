#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int a[10] = { 1, 2 ,3, 6, 7, 1, 3, 2, 6 };
	int len = sizeof(a) / sizeof(a[0]);
	int i;
	int sum = 0;
	for (i = 0; i < len; i++)
	{
		sum = sum^a[i];
	}
	printf("%d ", sum);
	system("pause");
	return 0;
}
