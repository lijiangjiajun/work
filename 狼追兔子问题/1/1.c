#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
int main()
{
	
	int N = 0;
	int i = 0;
	printf("请输入；狼从第N个洞开始寻找,0-9\n");
	scanf("%d", &N);
	int pos = N;
	int rabbit[10] = { 1,1,1,1,1,1,1,1,1 ,1};
	for (i = 1; i < 100; i++)
	{
		
		if (pos>10)
		{
			pos %= 10;
		}
		rabbit[pos] = 0;
		pos = pos + i+1;

	}
	for (i = 0; i < 10; i++)
	{
		if (rabbit[i] == 1)
			printf("兔子可能在%d个洞\n", i+1);
	}
	system("pause");
	return 0;
	

	
}