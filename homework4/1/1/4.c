#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char b[10];
char* p = &b;
void reverse_string(char* (string))
{
	
	if (*(string) != '\0')
	reverse_string(string + 1);	
	*p = *(string - 1);
	p++;
}
int main()
{
	int i = 0;
	char a[10] = "asdfghjkl";
	reverse_string( a);
	for (i = 0; i < 9; i++)
		a[i] = b[i];
	printf("%s\n", a);
	system("pause");
	return 0;

}