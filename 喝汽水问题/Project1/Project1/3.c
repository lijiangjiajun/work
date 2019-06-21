#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
MYstrcpy(char* a, const char* p)
{
	int i = 0;
	while (*p != '\0')
	{
		*a = *p;
			a++;
			p++;
	}
}
int main()
{
	char a[10] = "asdfg";
	char* p = "qwert";
	MYstrcpy(a, p);
	printf("%s\n", a);
	system("pause");
	return 0;
}