#include "game.h"

void menu()
{
	printf("*****  1.paly  ******\n");
	printf("*****  0.exit  ******\n");
	printf("*********************\n");
	printf("*********************\n");

}

int win(char a[ROW][COL], int row, int col)
{
	int i = 0;
	int j = 0;
	int d = 0;
	for (i = 0; i < row; i++)
	{
		if ((a[i][0] == a[i][1]) && (a[i][1] == a[i][2]) && (a[i][0] != '\0'))
			return a[i][0];
	}
	for (j = 0; j < col; j++)
	{
		if ((a[0][j] == a[1][j]) && (a[1][j] == a[2][j]) && (a[0][j] != '\0'))
			return a[0][j];
	}


	if ((a[0][0] == a[1][1]) && (a[1][1] == a[2][2]) && (a[0][0] != '\0'))
		return a[0][0];
	if ((a[2][0] == a[1][1]) && (a[1][1] == a[0][2]) && (a[2][0] != '\0'))
		return a[2][0];


	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (a[i][j] != '\0')
				d++;
		}

	}
	if (d == (row*col))
	{
		return 'Q';
	}
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (a[i][j] == '\0')
				return 'C';
		}

	}




}



void play(char a[ROW][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	char c;
	while (1)
	{
		c = win(a, row, col);
		if (c == 'C')
		{
			while (1)
			{
				{
					printf("�����\n");
					printf("����������");
					scanf("%d%d", &x, &y);
					if (a[x - 1][y - 1] == '\0')
					{
						a[x - 1][y - 1] = '*';
						board(a, row, col);
						printf("\n");
						break;
					}
					else
						printf("�����������������\n");
				}
			}
		}
		else
			break;


		c = win(a, ROW, COL);
		if (c == 'C')
		{

			printf("������\n");
			while (1)
			{

				x = rand() % 3;
				y = rand() % 3;
				if (a[x][y] == '\0')
				{

					a[x][y] = '#';
					board(a, ROW, COL);
					break;
				}
			}
		}
		else
			break;
	}
	if (c == 'Q')
	{
		printf("ƽ��");

	}
	if (c == '*')
	{
		printf("���Ӯ");

	}
	if (c == '#')
	{
		printf("����Ӯ");

	}
}


void board(char a[ROW][COL], int row, int col)
{

	int i = 0, j = 0;
	//for (i = 0; i < ROW; i++)
	//{
	//	for (j = 0; j < COL; j++)
	//		a[i][j] = " ";
	//}

	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf(" %c ", a[i][j]);
			if (j < col - 1)
				printf("|");
		}
		printf("\n");
		for (j = 0; j < col; j++)
		{

			if (i < row - 1)
				printf("--- ");
		}
		printf("\n");

	}
}


void game()
{
	char a[ROW][COL] = { 0 };
	memset(&a[0][0], '\0', ROW*COL*sizeof(a[0][0]));
	int i, j;
	board(a, ROW, COL);
	play(a, ROW, COL);
}