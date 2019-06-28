#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
void *MYmemmove(void *dest, const void *src, int count)
{
	void *ret = dest;
	int cnt = count;
	if (dest < src)
	{
		while (count)
		{
			*((char*)dest) = *((char*)src);
			((char*)dest)++;
			((char*)src)++;
			count--;
		}
	}
	else
	{

		while (count)
		{
			*((char*)dest + cnt-1) = *((char*)src + cnt-1);
			(((char*)dest)--);
			(((char*)src)--) ;
			count--;
		}
	}
			return ret;
}
int main()
{
	int  str[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };	
	char* ret = MYmemmove(str+2 , str, 16);
	int i;
	for (i = 0; i < 10; i++)
	{
		printf("%d ", str[i]);
	}
	system("pause");
	return 0;
}

