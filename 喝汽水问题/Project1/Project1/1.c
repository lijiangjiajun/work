#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int a[10] = { 1, 5, 1, 2, 2, 2, 2, 3, 3, 8 };   //0101
	int tmp=0;                                      //1000   
	int pos = 0;                                    //1101
	int x = 0;
	int y = 0;
	int i;
	for (i = 0; i < 10; i++)
	{
		tmp = tmp^a[i];
	}
	for (i = 0; i < 32; i++)
	{
		if (pos = (tmp >> i) & 1 == 1)
		{
			pos = i;
		}
	}
	for (i = 0; i < 10; i++)
	{
		if ((a[i] >> pos) & 1 == 1)
		{
			x = x^a[i];
		}
		else
		{
			y = y^a[i];
		}
	}

	printf("%d %d ", x,y);
	system("pause");
	return 0;


}
