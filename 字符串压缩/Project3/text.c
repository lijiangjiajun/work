#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

void del(char* p)
{
	while (*p != '\0')
	{
		*p = '\0';
		p++;
	}
}

int sentense(char* p)
{
	if (*p == *(p + 1))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int main()
{
	char a[] = "xxxyyyyz";

	char* p = a;
	char count[10] = {'\0'};
	char flag[10] = {'\0'};
	int i = 0;
	int k = 0;
	int ret = sentense(p);

		while (*p != '\0')
		{
			flag[i] = *p;
			count[i] = '1';
				
				while (sentense(p) == 1)
				{
					p++;
					count[i]++;
				}
				i++;
			p++;
	}
		i = 0;
		del(a);
		while (flag[i]!='\0')
		{
			if (count[i] >= '2')
			{
				a[k] = count[i];
				k++;
				a[k] = flag[i];
			}
			else
			{
			a[k] = flag[i];
			}
			i++;
			k++;

		}
		printf("%s\n", a);
		system("pause");
		return 0;
	
}