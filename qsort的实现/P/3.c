#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
/*
void qsort( void *base, size_t num,
size_t width,
int (__cdecl *compare )
(const void *elem1, const void *elem2 ) );
*/
void swap(void* a, void*b,int size)
{
	int i = 0;
	int tmp;
	for (i = 0; i < size; i++)
	{
		tmp = *((char*)a + i);
		*((char*)a + i) = *((char*)b + i);
		*((char*)b + i) = tmp;
	}
}

void Show(int *arr, int len)
{
	int i = 0;
	for (i = 0; i < len; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}

int Int_cmp(void* elem1, void* elem2)
{
	return *(int*)elem1 - *(int*)elem2;
}

void MyQsort(void *base, int len,
	int size,
	int(*Int_cmp)(const void *elem1, const void *elem2))
{
	int i = 0;
	int j = 0;
	for (i = 0; i < len - 1; i++)
	{
		for (j = 0; j < len - 1 - i; j++)
		{
			if (Int_cmp((char*)base + j*size, (char*)base + (j+1)*size)> 0)
			{
				swap((char*)base + j*size, (char*)base + (j + 1)*size,size);
			}
		}
	}


}
int main()
{
	int arr[10] = {15,5,2,89,76,336,519,170,1,267};	
	Show(arr,sizeof(arr)/sizeof(arr[0]));
	MyQsort(arr, sizeof(arr) / sizeof(arr[0]), sizeof(int), Int_cmp);
	Show(arr,sizeof(arr)/sizeof(arr[0]));
	system("pause");
	return 0;
}