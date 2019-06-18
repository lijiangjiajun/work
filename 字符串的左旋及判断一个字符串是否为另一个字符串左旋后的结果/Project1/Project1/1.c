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
		tmp = *(str+i);
		*(str+i) = *(str + k - 1-i);
		*(str + k - 1-i) = tmp;
	}
}

void left_move(char *str, int k)
{
	reverse(str, k);
	reverse(str + k, strlen(str)-k);
	reverse(str, strlen(str));

}
int main()
{
	char p[20] = "ABCD";
	int k;
	printf("请输入想要左旋的字符个数\n");
	scanf("%d", &k);
	left_move(p, k);
	printf("%s", p);
	system("pause");
	return 0;
}