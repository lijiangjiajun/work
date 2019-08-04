#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int str(char*  a)
{
	int b=0;
	while ((*a) != '\0')

	{
		a++;
		b++;
	}
	return b;
}
int str_d(char* a)
{
	int b = 1;
	int s = 0;
	if (*a != '\0')
		s = b + str_d(a + 1);
	return s;
	
}


int main()
{
	char a[10]="asdfghjkl";
	int c;
	
	/*c = str(a);*/
	c = str_d(a);
	printf("%d ", c);
	system("pause");
	return 0;

}