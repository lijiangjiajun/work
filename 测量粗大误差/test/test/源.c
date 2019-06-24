#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void menu()
{
	printf("*****0.退出程序************\n");
	printf("*****1.判断粗大误差********\n");
	printf("*****2.删除元素************\n");
}
float sigma(float R[15], float s, int len) //算标准差
{
	float b;
	float t = 0.0;
	int i = 0;
	for (i = 0; i < len; i++)
	{
		b= R[i] - s;
		b = b*b;
		t = t + b;
	}
	
	t = t / (len - 1);
	t = sqrt(t);
	return t;
}

void show(float R[15], int len)  //展示电阻
{
	int i = 0;
	for (i = 0; i<len; i++)
	{
		printf("%f ", R[i]);
	}
}
int error(float x, float kg, float s, float sig)   //判断粗大误差
{
	float c = 0.0;
	c = x - s;
	if (c<0)
	{
		c = -c;
	}
	if (c > (kg*sig))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

void decrease(float R[15], int j, int len)  //删除数组中的元素
{
	int i;
	for (i = j; i < len; i++)
	{
		R[i] = R[i + 1];
	}
}

float average(float R[15], int len)   //计算平均值
{
	int avg = 0;
	int i = 0;
	float s = 0.0;
	for (i = 0; i < 15; i++)
	{
		s = s + R[i];
	}
	s = s / len;
	return s;
}
int main()
{
	int input=0;  //选择数
	float ret;     //标准差函数的返回值
	int judge;     //判断是否有粗大误差
	float s = 0.0;  //接受平均值
	int signal = 15;  //记录有效数字的个数
	int j;            //想要删除元素的下标
	int a;          //想要判断误差的数字的下标
	float R[15] = { 10.65, 10.58, 10.62, 10.78, 10.67, 10.62, 10.63,
		10.68, 10.63, 10.64, 10.60, 10.64, 10.61, 10.63, 10.65 };
	float G[15] = { 0, 0, 1.135, 1.463, 1.672, 1.822, 1.938, 2.032, 2.110, 2.176,
		2.234, 2.285, 2.331, 2.371, 2.409 };
	int len = sizeof(R) / sizeof(R[0]);
	do 
	{
		menu();
		len = signal;
		s = average(R, len);
		ret=sigma(R, s, len);
		show(R, len);
		printf("请输入选择\n");
		scanf("%d", &input);
		switch(input)
		{
		case 1:
			printf("请输入想要判断误差的数字下标\n");
			scanf("%d", &a);
			judge = error(R[a-1], G[signal-1], s, ret);
			if (judge == 1)
			{
				printf("%f存在粗大误差\n",R[a-1]);
			}
			else
			{
				printf("%f不存在粗大误差\n",R[a-1]);
			}
			break;
		case 2:
			printf("请输入想要删除的数的下标\n");
			scanf("%d", &j);
			decrease(R, j-1, len);
			signal--;
			break;
		default:
			printf("老铁输入错误啦\n");
			break;
		}		
	}while (input);
	system("pause");
	return 0;
}