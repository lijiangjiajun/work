#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int cmpdate(int year_1,int year_2,int month_1,int month_2,int date_1,int date_2)
{
	
	if (year_1 > year_2)
		return 1;
	else if (year_1 < year_2)
	{
		return 2;
	}
	if (month_1 > month_2)
		return 1;
	else if (month_1 < month_2)
	{
		return 2;
	}
	if (date_1 > date_2)
		return 1;
	else if (date_1 < date_2)
	{
		return 2;
	}
	if (date_1 == date_2)
	{
		return 0;
	}

}


int interday(int month[13])
{
	int year_1, year_2, month_1, month_2, date_1, date_2;
	int ret = 0;
	int s = 0;
	int i = 0;
	int s1=0, s2=0;
	int c1, c2;
	printf("请输入第一个年月日\n");
	scanf("%d%d%d", &year_1, &month_1, &date_1);
	printf("请输入第二个年月日\n");
	scanf("%d%d%d", &year_2, &month_2, &date_2);
	ret = cmpdate(year_1, year_2, month_1, month_2, date_1, date_2);
	if (ret == 0)
		printf("两日期相隔0天\n");
	if (ret == 1)
	{
		for (i = 1; i <= month_1; i++)
		{
			s1 = s1 + month[i];
		}
		for (i = 1; i <= month_2; i++)
		{
			s2 = s2 + month[i];
		}
		c1 = year_run(year_1);
		c2 = year_run(year_2);
		return c1-c2 + (s1 - s2) + date_1 - date_2;
	}
	if (ret == 2)
	{
		for (i = 1; i <= month_1; i++)
		{
			s1 = s1 + month[i];
		}
		for (i = 1; i <= month_2; i++)
		{
			s2 = s2 + month[i];
		}
		c1 = year_run(year_1);
		c2 = year_run(year_2);
		return -(c1 - c2 + (s1 - s2) + date_1 - date_2);
	}

}

int yearday(int year, int month[13], int date,int month_s)
{
	int ret;
	int i = 0;
	int s = 0;
	ret = year_run(year);
	if (ret == 1)
	{
		month[2] = 29;
	}
	else
		month[2] = 28;
	for (i = 1; i <= 12; i++)
	{
		s = s + month[i];
	}
	return s;


}

int year_run(int year)
{
	return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
}

int dayofyear(int year,int month_s,int date,int month[13])
{
	int c;
	int i;
	int s = 0;
	c = year_run(year);
	if (c == 1)
		month[2] = 29;
	else
		month[2] = 28;
	for (i = 1; i <= month_s; i++)
	{
		s = s + month[i];

	}
	return s;
}

int main()
{
	int year;
	int month[13] = {0,31,0,31,30,31,30,31,31,30,31,30,31};
	int date;
	int c;
	int day;
	int month_s;
	int ex;
	printf("请输入年\n");
	scanf("%d", &year);
	printf("请输入月\n");
	scanf("%d", &month_s);
	printf("请输入日\n");
	scanf("%d", &date);
	c=dayofyear(year,month_s,date,month);
	printf("%d年%d月%d日是该年的第%d天\n ",year,month_s, date , c);
	day = yearday(year,month,date,month_s);
	printf("该年有%d天\n", day);
	ex=interday(month);
	printf("这2个日期相差%d\n ", ex);
	system("pause");
	return 0;

}