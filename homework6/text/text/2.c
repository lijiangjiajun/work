#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int n = 0;
	printf("������һ������");
	scanf("%d", &n);  
	int c = n;
	int i = 0;
	int j = 0; 
	int a[16] = { 0 };
	int b[16] = { 0 };
	for (i = 15; i >= 0; i--)
	{
		
			a[i] = (c & 1);
			c = c >> 2;

		
	}
	n = n >> 1;
	for (j = 15; j >=0; j--)
	{
		
		b[j] = (n & 1);
		n = n >> 2;


	}
	printf("ż��λ��");
	for (i = 0; i < 16; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
	printf("����λ��");
	for (j = 0; j < 16; j++)
	{
		printf("%d ", b[j]);
	}
	printf("\n");


	system("pause");
	return 0;

}