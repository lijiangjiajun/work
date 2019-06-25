#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
void InitContact(Contact* pCon)
{
	assert(pCon != NULL);
	pCon->usedSize = 0;
	memset(pCon->per, 0, sizeof(pCon->per));
}
void AddContact(Contact *pCon)
{
	if (pCon->usedSize == MAX_NUMPERSON)
	{
		printf("������˼������ͨѶ¼����\n");
		return;
	}
	printf("������Ҫ���ӵ�����\n");
	scanf("%s", pCon->per[pCon->usedSize].name);
	printf("������Ҫ���ӵ�����\n");
	scanf("%d", &(pCon->per[pCon->usedSize].age));
	printf("������Ҫ���ӵĵ绰\n");
	scanf("%s", pCon->per[pCon->usedSize].tele);
	printf("������Ҫ���ӵĵ�ַ\n");
	scanf("%s", pCon->per[pCon->usedSize].addr);
	printf("������Ҫ���ӵ��Ա�\n");
	scanf("%s", pCon->per[pCon->usedSize].sex);
	pCon->usedSize++;
	printf("��ӳɹ�\n");
}
int SearchContact(Contact* pCon)
{
	int i;
	char name[20];
	if (pCon->usedSize == 0)
	{
		printf("ͨѶ¼Ϊ��\n");
		return -1;
	}
	printf("����������\n");
	scanf("%s", name);
	for (i = 0; i < pCon->usedSize; i++)
	{
		if (strcmp(pCon->per[i].name,name) == 0)
		{
			printf("�ҵ����±���%d\n", i);
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
	ret=SearchContact(pCon);
	if (ret != -1)
	{
		for (i = ret; i <pCon->usedSize-1; i++)
		{
			pCon->per[i] = pCon->per[i + 1];
		}
		printf("ɾ���ɹ�\n");
	}
	if (ret == -1)
	{
		printf("���޴���\n");
	}
}
void ShowContact(Contact *pCon)
{
	int i = 0;
	printf("%-20s %-10s %-10s %-11s %-15s\n", "����", "����", "�绰", "��ַ", "�Ա�");
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