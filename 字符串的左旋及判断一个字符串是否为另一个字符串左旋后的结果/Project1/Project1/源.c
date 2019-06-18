//#define _CRT_SECURE_NO_WARNINGS 
//#include <stdio.h>
//#include <stdlib.h>
//
//void left_move(char *str, int k)
//{
//	char* q =str;
//    char* p = str;
//	int n = k;
//	while (k)
//	{
//		q++;
//		k--;
//	}
//	while (*q!='\0')
//	{
//		*str = *q;
//		str++;
//		q++;
//	}
//	while (n)
//	{
//		*str = *p;
//		str++;
//		p++;
//		n--;
//	}
//	
//}
//int main()
//{
//	char p[20] = "ABCD";
//	int k;
//	printf("请输入想要左旋的字符个数\n");
//	scanf("%d", &k);
//	left_move(p, k);
//	printf("%s", p);
//	system("pause");
//	return 0;
//}