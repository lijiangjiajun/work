#define _CONTACT_H_
#ifndef  __CONTACT__H__
#define __CONTACT__H__
#include <stdio.h>
#include <assert.h>
#include <string.h>
#include <stdlib.h>

enum Option
{
	EXIT,
	ADD,
	SEAR,
	DEL,
	SHOW,
	CLEAR,
	SORT,
	DESTROY
};

#define MAX_NAME  20
#define MAX_TEL      11
#define MAX_ADDR  15
#define MAX_SEX      3
#define DEFAULT_SIZE 1
#define MAX_NUMPERSON      1000
//������Ϣ
typedef struct PersonInfo
{
	//name  age   tele  addr   sex
	char name[MAX_NAME];
	short age;
	char tele[MAX_TEL];
	char addr[MAX_TEL];
	char sex[MAX_SEX];
}PersonInfo;
//ͨѶ¼
typedef struct Contact
{
	
	PersonInfo *per;
	int usedSize;//��ʹ�õĸ���
	int capticty;
}Contact;

void InitContact(Contact *pCon);


#endif// __CONTACT__H__
void AddContact(Contact *pCon);
int SearchContact(Contact* pCon);
void DelContact(Contact* pCon);
void ShowContact(Contact *pCon);
static int explan(Contact *pCon);
void DestroyContact(Contact *pCon);