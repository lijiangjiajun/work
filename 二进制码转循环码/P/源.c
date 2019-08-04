#include <stdio.h>
#include <math.h>
#define N 4
void getdata(char* PC, char* PR)
{
	int i = 0;
	*(PR+1) = *(PC+1);
	for (i = 2; i < N+1; i++)
	{
		*(PC + i ) = (*(PR+ i )) ^ (*(PC + i-1));	
	}
}

double data_del(char* PC)
{
	int i = 0;
	double ret = 0.0;
	for (i = 1; i < N+1; i++)
	{
		ret =ret+ (*(PC + i)) * (pow(2.0, N - i));
	}
	return ret;
}


int main()
{
	char c[N+1] = { 0 };
	char r[N+1] = { 0 };
	int i = 0;
	double data;
	double s = 360.0 / pow(2.0, N);
	double a;
	
	for (i = 1; i < N+1; i++)
	{
		printf("请输入1个N位循进制码的第%d位\n",i);
		scanf("%d", &r[i]);
	}
	getdata(c,r);
	printf("对应的二进制是");
	for (i = 1; i < N + 1; i++)
	{
		printf("%d",c[i]);
	}
	data = data_del(c);
	a = data*s;
	printf("角度为%lf", a);
	return 0;
}

