#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
void InitContact(Contact* pCon)
{
	assert(pCon != NULL);
	pCon->capticty = DEFAULT_SIZE;
	pCon->usedSize = 0;
	pCon->per = (PersonInfo *)malloc(sizeof(PersonInfo)* pCon->capticty);
	assert(pCon->per != NULL);
	memset(pCon->per, 0, sizeof(PersonInfo)* pCon->capticty);

}

static int explan(Contact *pCon)
{
	assert(pCon != NULL);
	PersonInfo* str = NULL;
	if (pCon->usedSize == pCon->capticty)
	{
		str = (PersonInfo*)realloc(pCon->per, pCon->capticty*sizeof(Contact)* 2);
		if (str != NULL);
		{
			pCon->per = str;
			pCon->capticty *= 2;
			printf("扩容成功\n");
			return 1;
		}
		if (str==NULL)
			return 0;
		
	}
	return 1;
}

void AddContact(Contact *pCon)
{
	int ret=explan(pCon);
	if (ret == 0)
	{
		printf("扩容失败");
		return;
	}
	printf("请输入要增加的姓名\n");
	scanf("%s", pCon->per[pCon->usedSize].name);
	printf("请输入要增加的年龄\n");
	scanf("%d", &(pCon->per[pCon->usedSize].age));
	printf("请输入要增加的电话\n");
	scanf("%s", pCon->per[pCon->usedSize].tele);
	printf("请输入要增加的地址\n");
	scanf("%s", pCon->per[pCon->usedSize].addr);
	printf("请输入要增加的性别\n");
	scanf("%s", pCon->per[pCon->usedSize].sex);
	pCon->usedSize++;
	printf("添加成功\n");
}
int SearchContact(Contact* pCon)
{
	int i;
	char name[20];
	if (pCon->usedSize == 0)
	{
		printf("通讯录为空\n");
		return -1;
	}
	printf("请输入姓名\n");
	scanf("%s", name);
	for (i = 0; i < pCon->usedSize; i++)
	{
		if (strcmp(pCon->per[i].name, name) == 0)
		{
			printf("找到了下标是%d\n", i);
			return i;
		}

	}
	return -1;
}
void DelContact(Contact* pCon)
{
	char name;
	int i;
	int ret = 0;
	ret = SearchContact(pCon);
	if (ret != -1)
	{
		for (i = ret; i <pCon->usedSize - 1; i++)
		{
			pCon->per[i] = pCon->per[i + 1];
		}
		printf("删除成功\n");
	}
	if (ret == -1)
	{
		printf("查无此人\n");
	}
}
void ShowContact(Contact *pCon)
{
	int i = 0;
	printf("%-20s %-10s %-10s %-11s %-15s\n", "姓名", "年龄", "电话", "地址", "性别");
	for (i = 0; i < pCon->usedSize; i++)
	{
		printf("%-20s %-10d %-10s %-11s %-15s\n", pCon->per[i].name, pCon->per[i].age,
			pCon->per[i].tele, pCon->per[i].addr, pCon->per[i].sex);
	}
}

void ClearContact(Contact *pCon)
{
	assert(pCon != NULL);
	pCon->usedSize = 0;
	memset(pCon->per, 0, sizeof(pCon->per));
}

void DestroyContact(Contact *pCon)
{
	assert(pCon != NULL);
	pCon->capticty = 0;
	pCon->usedSize = 0;
	free(pCon->per);
	pCon->per = NULL;
}