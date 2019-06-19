#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

int score[4][4];
int main()
{
	int i, j, k, who;
	score[1][1] = 7;
	score[2][1] = 8;
	score[3][1] = 9;
	for (i = 4; i<6; i++)
	for (j = 4; j<7; j++)
	for (k = 4; i != j&&k<7; k++)
	if (k != i&&k != j && 15 - i - score[1][1] != 15 - j - score[2][1]
		&& 15 - i - score[1][1] != 15 - k - score[3][1]
		&& 15 - j - score[2][1] != 15 - k - score[3][1])
	{
		score[1][2] = i; score[1][3] = 15 - i - 7;
		score[2][2] = j; score[2][3] = 15 - j - 8;
		score[3][2] = k; score[3][3] = 15 - k - 9;
	}
	for (who = 0, i = 1; i <= 3; i++, printf("\n"))
	for (j = 1; j <= 3; j++)
	{
		printf("%d", score[i][j]);
		if (score[i][j] == 1)
			who = i;
	}
	if (who == 1)
		printf("最后一名是张家孩子\n");
	else if (who == 2)
		printf("最后一名是王家孩子\n");
	else
		printf("最后一名是李家孩子\n");
	system("pause");
	return 0;
}