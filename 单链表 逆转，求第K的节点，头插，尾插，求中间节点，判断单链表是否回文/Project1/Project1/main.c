#include "list.h"
int main()
{
	Node head;//头结点
	Node *p = NULL;
	Node *q = NULL;
	Node *w = NULL;
	int ret = 0;
	InitList(&head);

	InsertHead(&head, 12);
	InsertHead(&head, 22);
	InsertHead(&head, 32);
	InsertHead(&head, 22);
	InsertHead(&head, 12);
	ret=Return(&head);
	if (ret == 1)
	{
		printf("该单链表是回文\n");
	}
	else
	{
		printf("该单链表不是回文\n");
	}

	//reverseHead(&head);
	// w=reverse(&head);
	//q=FindMidleNode(&head);

	//Show(&head);//
	//Show1(w);
	//printf("\n");
	//printf("%d\n", q->data);
 //                               
	//p = LastKNode(&head, 3);
	//printf("%d\n", p->data);
	system("pause");
	return 0;
}