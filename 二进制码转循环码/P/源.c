#define _CRT_SECURE_NO_WARNINGS 1
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#define N 4
//void getdata(char* PC, char* PR)
//{
//	int i = 0;
//	*(PC+1) = *(PR+1);
//	for (i = 2; i < N+1; i++)
//	{
//		*(PR + i ) = (*(PC+ i )) ^ (*(PC + i-1));	
//	}
//}
//
//double data_del(char* PC)
//{
//	int i = 0;
//	double ret = 0.0;
//	for (i = 1; i < N+1; i++)
//	{
//		ret =ret+ (*(PC + i)) * (pow(2.0, N - i));
//	}
//	return ret;
//}
//
//
//int main()
//{
//	char c[N+1] = { 0 };
//	char r[N+1] = { 0 };
//	int i = 0;
//	double data;
//	double s = 360.0 / pow(2.0, N);
//	double a;
//	
//	for (i = 1; i < N+1; i++)
//	{
//		printf("请输入1个N位二进制码的第%d位\n",i);
//		scanf("%d", &c[i]);
//	}
//	getdata(c,r);
//	printf("对应的循环码是");
//	for (i = 1; i < N + 1; i++)
//	{
//		printf("%d",r[i]);
//	}
//	data = data_del(c);
//	a = data*s;
//	printf("角度为%lf", a);
//	system("pause");
//	return 0;
//
//}

//int main()
//{
//	char a[10];
//	gets(a);
//	printf("%d ", a[1]);
//	puts(a);
//	system("pause");
//	return 0;
//}