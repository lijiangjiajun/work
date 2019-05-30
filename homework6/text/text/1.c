#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>


int count_one_bits(unsigned int value)
{
	int count = 0;
	while (value != 0)
	{
		count++;
		value = (value & (value-1));

	}
	return count;
}



int main()
{
	int a=13;  
	int c;
	c = count_one_bits(a);
	printf("%d ", c);
	system("pause");
	return 0;

}