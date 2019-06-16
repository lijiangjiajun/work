#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
char* MyStrcat(char* dest,const char* src)
{
	char* p = dest;
	assert(dest != NULL &&src != NULL);
	while (*src!='\0')
	{
		dest++;
		if (*dest == '\0')
		{
			while (*src != '\0')
			{

				*dest = *src;
				src++;
				dest++;
			}
			*dest = '\0';
			return p;
		}
	
	}
	return p;
}

int Mystrcmp(const char*str1, const char* str2)
{
	assert(str1 != NULL &&  str2!= NULL);
	while (1)
	{
		if (*str1 > *str2)
		{
			return 1;
		}
		else if (*str1 < *str2)
		{
			return -1;
		}
		else if (*str1 == *str2 && *str1!='\0')
		{
			str1++;
			str2++;
		}
		else if (*str1 == *str2 && *str1 == '\0')
		{
			return 0;
		}
		 		
	}
}

char* MyStrncpy(char*dest, const char *src, int n)
{
	char*p = dest;
	assert(dest != NULL &&  src!= NULL);
	while (n)
	{
		*dest = *src;
		dest++;
		src++;
		n--;
	}	
		*dest = '\0';	
	return p;
}

char* MyStrncat(char* dest,const char* src,int n)
{
		char* p = dest;
		assert(dest != NULL &&src != NULL);
	
			if (*dest == '\0')
			{
				while (n)
				{
	
					*dest = *src;
					src++;
					dest++;
					n--;
				}
				*dest = '\0';
				return p;
			}
		
		
}

int Mystrcmp(const char*str1, const char* str2,int n)
{
	assert(str1 != NULL &&  str2 != NULL);
	while (*str1 == *str2 && n>0)
	{
		if (*str1 != '\0')
		{
			str1++;
			str2++;
			n--;
		}
	}
	if (n==0)
	{
		return 0;
	}
	else if (*str1 > *str2)
	{
		return 1;
	}
	else if (*str1 < *str2)
	{
		return -1;
	}

}

int main()
{
	char* c=NULL;
	char *a = "ab";
	char* p = "abllo";
	 MyStrstr(a, p);
	 printf("%s", a);
	system("pause");
	return 0;
}