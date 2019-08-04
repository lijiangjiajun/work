#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
//int fox(int n)
//{
//	int i = 0;
//	int ret = 1;
//	for (i = 1; i <=n; i++)
//	{
//		ret = ret*i;
//	}
//	return ret;
//}
int  Ret(int n)
{
	if (n == 1 && n == 0)
	{
		n = 1;

	}
	if (n > 1)
	{
		n = n*Ret(n - 1);
	}
	return n;
}
int main()
{
	int n;
	scanf("%d", &n);
	/*int c = fox(n);*/
	int c = Ret(n);
	printf("%d ",c);
	system("pause");
	return 0;
}