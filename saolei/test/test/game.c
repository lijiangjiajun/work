#include "game.h"

menu()
{
	printf("****************************************\n");
	printf("**********     1 . play    *************\n");
	printf("**********     0 . exit    *************\n");
	printf("****************************************\n");
}

void explore(char mine[ROW + 2][COL + 2], char show[ROW][COL], int row, int col, int x, int y)
{
	int c;
	c = find(mine, row, col, x, y);
	if (c == 0)
	{
		show[x][y] = '0';
		if ((x - 1)>0 && (x - 1) <= row - 2 && y>0 && y <= col - 2 && show[x - 1][y] == '*')
			explore(mine, show, row, col, (x - 1), y);
		if ((x - 1)>0 && (x - 1) <= row - 2 && (y - 1)>0 && (y - 1) <= col - 2 && show[x - 1][y - 1] == '*')
			explore(mine, show, row, col, (x - 1), (y - 1));
		if ((x)>0 && (x) <= row - 2 && (y - 1) >= 1 && (y - 1) <= col - 2 && show[x][y - 1] == '*')
			explore(mine, show, row, col, x, (y - 1));
		if ((x + 1)>0 && (x + 1) <= row - 2 && (y - 1)>0 && (y - 1) <= col - 2 && show[x + 1][y - 1] == '*')
			explore(mine, show, row, col, (x + 1), (y - 1));
		if ((x + 1)>0 && (x + 1) <= row - 2 && y>0 && y <= col - 2 && show[x + 1][y] == '*')
			explore(mine, show, row, col, (x + 1), (y));
		if ((x + 1)>0 && (x + 1) <= row - 2 && (y + 1)>0 && (y + 1) <= col - 2 && show[x + 1][y + 1] == '*')
			explore(mine, show, row, col, (x + 1), (y + 1));
		if ((x)>0 && (x) <= row - 2 && (y + 1)>0 && (y + 1) <= col - 2 && show[x][y + 1] == '*')
			explore(mine, show, row, col, x, (y + 1));
		if ((x - 1)>0 && (x - 1) <= row - 2 && (y + 1)>0 && (y + 1) <= col - 2 && show[x - 1][y + 1] == '*')
			explore(mine, show, row, col, (x - 1), (y + 1));

	}
	else
	{
		show[x][y] = c + '0';
	}



}

int find(char mine[ROW + 2][COL + 2], int row, int col, int x, int y)
{
	return  mine[x - 1][y] + mine[x - 1][y - 1] + mine[x][y - 1] + mine[x + 1][y - 1]
		+ mine[x + 1][y] + mine[x + 1][y + 1] + mine[x][y + 1] + mine[x - 1][y + 1] - 8 * '0';

}


void show_print(char show[ROW + 2][COL + 2], int row, int col)
{
	int i, j;
	for (i = 0; i < row - 1; i++)
	{
		for (j = 0; j < col - 1; j++)
		{
			printf("%c ", show[i][j]);
		}
		printf("\n");
	}
}


void mine_print(char mine[ROW + 2][COL + 2], int row, int col)
{
	int i, j;
	for (i = 1; i < 10; i++)
	{
		for (j = 1; j < 10; j++)
		{
			printf("%c ", mine[i][j]);
		}
		printf("\n");
	}
}

void empty(char a[ROW + 2][COL + 2], int row, int col)
{
	memset(&a[0][0], '\0', row*col*sizeof(a[0][0]));
}

void mine_set(char mine[ROW + 2][COL + 2], int row, int col)
{
	int h = LEI;
	int x;
	int y;
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			mine[i][j] = '0';
		}
	}
	while (i)
	{
		x = rand() % ROW + 1;
		y = rand() % COL + 1;

		if (mine[x][y] == '0')
		{
			mine[x][y] = '1';
			h--;
		}

		if (h == 0)
		{
			break;
		}

	}
}


void show_set(char show[(ROW + 2)][(COL + 2)], int row, int col)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < row - 1; i++)
	{
		show[0][i] = i + '0';
	}
	for (i = 1; i < col - 1; i++)
	{
		show[i][0] = i + '0';
	}
	for (i = 1; i < row - 1; i++)
	{
		for (j = 1; j < col - 1; j++)
		{
			show[i][j] = '*';
		}
	}


}



void play(char mine[ROW + 2][COL + 2], char show[ROW + 2][COL + 2], int row, int col)
{
	int x, y;
	int c = 0;
	int d = 0;
	int a;
	int b;
	int input = 1;
	while (1)
	{
	again:
		printf("请输入要扫描的坐标");
		scanf("%d%d", &x, &y);
		while (input)
		{
			if (input == 1 && mine[x][y] == '1')
			{
				mine[x][y] = '0';

				while (1)
				{
					a = rand() % 9 + 1;
					b = rand() % 9 + 1;
					if (mine[a][b] == '0')
					{

						mine[a][b] == '1';
						break;
					}
				}

			}
			input--;
		}
		if (show[x][y] != '*')
		{
			printf("输入错误，请重新输入\n");
			goto again;
		}
		if (x >= 1 && x <= ROW &&y >= 1 && y <= COL)
		{

			if (mine[x][y] == '1')
			{
				printf("你被炸死了\n");
				mine_print(mine, row, col);
				break;

			}
			else
			{
				c = find(mine, row, col, x, y);
				if (c == 0)
				{
					explore(mine, show, row, col, x, y);
					show_print(show, row, col);
				}
				else
				{

					show[x][y] = c + '0';
					show_print(show, row, col);
					d++;
				}

			}
			if (d == ROW*COL - LEI)
			{
				printf("你赢了\n");
				break;
			}
		}
		if (x > ROW || y > COL)
			printf("输入错误，请重新输入\n");

	}
}


void game()
{
	int i, j;
	char mine[ROW + 2][COL + 2] = { 0 };
	char show[ROW + 2][COL + 2] = { 0 };
	empty(mine, (ROW + 2), (COL + 2));
	empty(show, (ROW + 2), (COL + 2));
	mine_set(mine, (ROW + 2), (COL + 2));
	show_set(show, (ROW + 2), (COL + 2));
	//mine_print(mine, (ROW + 2), (ROW + 2));
	play(mine, show, (ROW + 2), (COL + 2));

}