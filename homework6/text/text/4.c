#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	int m;
	int n;
	int i=31;
	int j = 31;
	int count = 0;
	printf("«Î ‰»Îm£¨n \n");
	scanf("%d",&m);
	scanf("%d", &n);
	int a[32] = { 0 };
	int b[32] = { 0 };
	for (m; m; m=m / 2)
	{
		a[i] = m % 2;			
			i--;
	}
	for (n; n; n=n/ 2)
	{
		b[j] = n % 2;
		j--;
	}
	for (i = 0; i < 32; i++)
	{
		if (a[i] != b[i])
		{
			count++;
		}
	}
	printf("%d ", count);
	system("pause");
	return 0;
}