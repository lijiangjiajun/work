#define _CRT_SECURE_NO_WARNINGS 1
#include "stdio.h"
#include <string.h>
bool isUgly(int num){
	int i = 2;
	int j = 0;
	int flag = 1;
	if (num == 1)
	{
		return true;
	}
	if (num <= 0)
	{
		return false;
	}
	for (j = 2; j<num; j++)
	{
		if (num%j == 0)
		{
			flag = 0;
			break;
		}
	}

	if (flag == 1)
	{
		return false;
	}
	while (num != 1)
	{
		while (num%i != 0)
		{
			i++;
		}
		if (i != 2 && i != 3 && i != 6)
		{
			return false;
		}
		num = num / i;
		i = 2;
	}
	return true;
}
int main(){
bool c=	isUgly(2);
	return 0;
}