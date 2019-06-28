/*#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
void *MYmemcpy(void *dest, const void *src, size_t count)
{
	void *ret = dest;
	while (count)
	{
		*((char*)dest) = *((char*)src);
		((char*)dest)++;
		((char*)src)++;
		count--;	
	}
	return ret;
}

int main()
{
	char dest[20] = "asdfddb";
	const char* src = "qwe";
	char* ret = MYmemcpy(dest, src, 4);
	printf("%s", ret);
	system("pause");
	return 0;

}*/