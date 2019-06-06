#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char a[20] = {0};
char b[20] = {0};
void knock()
{
	printf("请输入想要加密的字符串\n");
	scanf("%s",&a);
	int len=0;
	int i = 0;
	while (a[i]!='\0')
	{
		len++;
		i++;
	}
	for (i = 0; i < len; i++)
	{
		a[i] = a[i] + 5 + i;
	}
	printf("密码加密后是%s\n", a);
}

void del()
{
	int i = 0;
	for (i = 0; i < 20; i++)
	{
		if (a[i] == '\0')
		{
			break;
		}
		else
			a[i] = a[i] - 5 - i;
	}
	printf("加密的密码解密后是%s\n", a);
}


int main()
{
	
	int input;
	printf("输入1密码加密，输入2密码解密，输入3对新密码加密，输入0退出系统\n");
	
	do
	{
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			knock();
			break;
		case 2:
			del();
			break;
		case 3:
			knock();
			break;
		case 0:
			printf("退出成功\n");
			break;
		default :
			printf("输入错误，请重新输入\n");
			break;
		}
	
	}while (input);
	system("pause");
	return 0;

}
