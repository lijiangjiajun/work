#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void reverse(char* str, int k)
{
	int i = 0;
	char tmp;
	for (i = 0; i < k / 2; i++)
	{
		tmp = *(str + i);
		*(str + i) = *(str + k - 1 - i);
		*(str + k - 1 - i) = tmp;
	}
}

void left_move(char *str, int k)
{
	reverse(str, k);
	reverse(str + k, strlen(str) - k);
	reverse(str, strlen(str));

}

int is_left_move(char *arr, const char *p)
{
	int ret;
	ret = strlen(arr);
	while (ret)
	{
		left_move(arr, 1);
		ret--;
		if (strcmp(arr, p) == 0)
			return 1;
		
	}
	return 0;
}
int main()
{
	char* p = "AABCD";
	char arr[20] = "BCDA";
	int ret;
	ret = is_left_move(arr, p);
	printf("%d\n", ret);
	system("pause");
	return 0;
}