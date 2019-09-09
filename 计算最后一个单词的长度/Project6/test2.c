#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int lengthOfLastWord(char * s){
	char *p = s;
	char *q = s;
	int count = 0;
	while (*q != '\0')
	{
		if (*q == ' ')
		{
			p = q + 1;
		}
		q++;
	}
	while (*p != '\0')
	{
		count++;
		p++;
	}
	return count;
}
int main()
{
	char a[2] = "a";
	int ret=lengthOfLastWord(a);
	printf("%d ", ret);
	return 0;
}

