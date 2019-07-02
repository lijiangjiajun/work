#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"

void 	LoadContact(Contact *pCon)
{
	FILE *pf = fopen("Contanct.bat", "rb");
	PersonInfo tmp = { 0 };
	//assert(pf != NULL);
	if (pf == NULL)
	{
		printf("%s\n", strerror(errno));
		return;
	}
	while (fread(&tmp, sizeof(PersonInfo), 1, pf)>0)
	{
		CheckFull(pCon);
		pCon->per[pCon->usedSize++] = tmp;
	}
	fclose(pf);
	pf = NULL;
	printf("����ɹ�");
}
void InitContact(Contact* pCon)
{
	assert(pCon != NULL);
	//pCon->usedSize = 0;
	////��������г�ʼ��
	//memset(pCon->per,0,sizeof(pCon->per));

	pCon->capticty = DEFAULT_SIZE;
	pCon->usedSize = 0;
	pCon->per = (PersonInfo *)malloc(sizeof(PersonInfo)* pCon->capticty);
	assert(pCon->per != NULL);
	memset(pCon->per, 0, sizeof(PersonInfo)* pCon->capticty);
	LoadContact(pCon);

}

static int CheckFull(Contact *pCon)
{
	if (pCon->usedSize == pCon->capticty)
	{
		//2������  realloc(     ,    )
		PersonInfo *ptr = (PersonInfo *)realloc(
			pCon->per, pCon->capticty*sizeof(PersonInfo)* 2);
		if (ptr != NULL)
		{
			pCon->per = ptr;
			pCon->capticty *= 2;
			printf("���ݳɹ�\n");
			return 1;
		}
		else
		{
			return 0;
		}
	}
	return 1;
}
void AddContact(Contact *pCon)
{
	int ret = CheckFull(pCon);
	if (ret == 0)
	{
		printf("����ʧ��\n");
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
		if (strcmp(pCon->per[i].name, name) == 0)
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
	ret = SearchContact(pCon);
	if (ret != -1)
	{
		for (i = ret; i <pCon->usedSize - 1; i++)
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

void SaveContact(Contact *pCon)
{
	//�ļ�д
	int i = 0;
	FILE *pf = fopen("Contanct.bat", "wb");
	assert(pf != NULL);

	for (i = 0; i < pCon->usedSize; i++)
	{
		//pCon->per[i]  &ch
		fwrite(pCon->per + i, sizeof(PersonInfo), 1, pf);
	}
	fclose(pf);
	pf = NULL;
	printf("����ɹ�");
}

void DestroyContact(Contact *pCon)
{

	SaveContact(pCon);
	assert(pCon != NULL);
	free(pCon->per);
	pCon->per = NULL;
	pCon->capticty = 0;
	pCon->usedSize = 0;
}