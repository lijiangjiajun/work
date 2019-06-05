#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

unsigned int reverse_bit(unsigned int value)
{
	int a[32] = { 0 };
	int i =0 ;
	unsigned int c=0;
	for (i = 0; i < 32; i++)
	{
		a[i] = ((value >> i)&1);
	}
	for (i = 0; i < 32; i++)
	{
		c = c + a[i] * pow(2.0,31.0-i);
	}
	return c;

}
int main()
{
	int value = 0;
	printf("请输入一个数字");
	scanf("%d", &value);
	unsigned int c;
	c= reverse_bit( value);
	printf("%u ", c);
	system("pause");
	return 0;


}