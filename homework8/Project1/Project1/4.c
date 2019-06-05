#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int your_strlen(char * a)   //计算由空格开始到下一个空格或空字符的长度
{
	int i = 0;
	while ((*a !=' ') &&(*a !='\0'))
	{
		i++;
		a++;
	}
	return i;
}

int my_strlen(char * a )
{
	int i=0;
	while (*a!='\0')
	{	
			i++;
			a++;
	}
	return i;
}

void my_spin(char* p ,int len)
{
	int i = 0;
	char t;
	for (i = 0; i < len/2; i++)
	{
		t = *(p+i);
		*(p+i) = *(p+len-1-i);
		*(p + len - 1 - i) = t;
		
	}
	
}

int main()
{
	char a[20] = "student a am i";
	int len;
	int len2;
	int i;
	len = my_strlen(a);
	
	my_spin(a,len);
	            //i ma a tneduts
	for (i = 0; i < len; i++)
	{
		if (a[i] == ' ')
		{
			len2 = your_strlen(&a[i+1]);
			my_spin(&a[i+1], len2);
		}

	}
	printf("%s\n", a);
	system("pause");
	return 0;
}