#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char a[20] = {0};
char b[20] = {0};
void knock()
{
	printf("��������Ҫ���ܵ��ַ���\n");
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
	printf("������ܺ���%s\n", a);
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
	printf("���ܵ�������ܺ���%s\n", a);
}


int main()
{
	
	int input;
	printf("����1������ܣ�����2������ܣ�����3����������ܣ�����0�˳�ϵͳ\n");
	
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
			printf("�˳��ɹ�\n");
			break;
		default :
			printf("�����������������\n");
			break;
		}
	
	}while (input);
	system("pause");
	return 0;

}
