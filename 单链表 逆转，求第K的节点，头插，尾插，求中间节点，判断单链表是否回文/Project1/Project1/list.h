#define _CRT_SECURE_NO_WARNINGS 1
#ifndef __LIST_H__
#define __LIST_H__
//#pragma once
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>

typedef struct Node
{
	int data;
	struct Node *next;
}Node, *pList;

//初始化
void InitList(pList plsit);
void InsertTail(pList plist, int val);
Node *LastKNode(pList plist, int k);
Node* reverse(pList plist);
void Show(pList plist);
void Show1(pList plist);
int Return(pList plist);
//头插

//尾插

//打印



//任意位置插入

//删除

//查找
Node *FindMidleNode(pList plist);


void reverseHead(pList plist);


#endif //__LIST_H__

