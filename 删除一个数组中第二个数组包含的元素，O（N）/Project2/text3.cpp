#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
char c[256] = { 0 };
void define(char* b)
{
	while (*b != '\0')
	{
		c[*b] = 1;
		b++;
	}
}

void DeleteRepeateChar(char* str1)
{
	char* p = str1;
	char* q = str1;
	int flag=0;
	while (*q != '\0')
	{
		if (c[*p] == 1 ||flag==1)
		{
			while (c[*q] == 1)
			{
				q++;
			}
			*p = *q;
			flag = 1;
		}
		p++;
		q++;
	}
	*p = '\0';
}
int main()
{
	char a[] = "welcome to cetv";
	char* b = "come";
	define(b);
	DeleteRepeateChar(a);
	printf("%s", a);
	system("pause");
	return 0;
}