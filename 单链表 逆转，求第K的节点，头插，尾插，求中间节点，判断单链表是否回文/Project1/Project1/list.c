#include "list.h"

void InitList(pList plsit)
{
	assert(plsit != NULL);
	plsit->data = 0;
	plsit->next = NULL;
}

//得到一个节点
Node *GetNode(int val)
{
	Node* pGet = (Node *)malloc(sizeof(Node));
	assert(pGet != NULL);
	pGet->data = val;
	pGet->next = NULL;
	return pGet;
}

//头插   plist:  头结点的地址
void InsertHead(pList plist, int val)//55
{
	Node *pGet = GetNode(val);
	assert(plist != NULL);
	pGet->next = plist->next;
	plist->next = pGet;
}

void InsertTail(pList plist, int val)
{
	Node *pGet = GetNode(val);
	Node*p = plist;
	while (p->next != NULL)
	{
		p = p->next;
	}
	p->next = pGet;
}

Node *LastKNode(pList plist, int k)
{
	int i;
	Node *p = plist;
	Node *q = plist;
	if (k < 0)
	{
		return NULL;
	}

	for (i = 0; i <= k - 2; i++)
	{
		if (q != NULL)
			q = q->next;
		else
			return NULL;
	}
	while (q != NULL)
	{
		p = p->next;
		q = q->next;
	}
	return p;

	//1、让一个指针先走K-1步
	//两个指针同时走
}


void Show(pList plist)
{
	Node* p = plist->next;
	while (p != NULL)
	{
		printf("%d ", p->data);
		p = p->next;
	}
}


Node *FindMidleNode(pList plist)
{
	Node *pFast = plist;
	Node *pSlow = plist;

	while (pFast != NULL)
	{
		pSlow = pSlow->next;
		if (pFast->next != NULL)
		{

			pFast = pFast->next;
		}
		else
		{
			return pSlow;
		}

		if (pFast->next != NULL)
		{

			pFast = pFast->next;
		}
		else
		{
			return pSlow;
		}

	}
}


void reverseHead(pList plist)
{
	Node *pCur = plist->next;
	Node *pCurN = plist->next;
	plist->next = NULL;
	while(pCurN != NULL)
	{
		pCurN = pCur->next;
		pCur->next = plist->next;
		plist->next = pCur;
		pCur = pCurN;
	}
}

Node* reverse(pList plist)
{
	Node* pCur = plist->next;
	Node* pCurN = plist->next;
	Node *prev = plist;
	prev->next = NULL;
	while (pCurN != NULL)
	{
		pCurN = pCur->next;
		pCur->next = prev;
		prev = pCur;
		pCur = pCurN;
	}
	return prev;
}

void Show1(pList plist)
{
	Node* p = plist;
	while (p->next != NULL)
	{
		printf("%d ", p->data);
		p = p->next;
	}
}

int Return(pList plist)
{
	Node* w = plist->next;
	Node *p=FindMidleNode(plist);
	Node *q = reverse(p);
	while ( w!=p && q!=p ) 
	{
		if (w->data == q->data)
		{
			w = w->next;
			q = q->next;
		}
		else
		{
			return 0;
		}
		return 1;

	}
}