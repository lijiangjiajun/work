#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int fox(int n,int k)
{
	int s = 1;
	
	if (k > 0)
	{
		
		s = n*fox(n,k-1);
	}
	return s;

}

int main()
{
	int k = 0;
	int n = 0;
	int c;
	printf("«Î ‰»În");
	scanf("%d", &n);
	printf("«Î ‰»Îk");
	scanf("%d", &k);
	c = fox(n,k);
	printf("%d ", c);
	system("pause");
	return 0;
}