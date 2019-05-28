#include "game.h"

int main()
{
	int n = 0;
	srand((unsigned int)time(NULL));
	menu();
	do
	{
		printf("请输入一个数字选择\n");
		scanf("%d", &n);
		switch (n)
		{
		case 0:

			printf("游戏结束\n");
			break;

		case 1:

			game();
			break;

		default:

			printf("输入错误，请重新输入\n");
			break;


		}
	} while (n);
	system("pause");
	return 0;
}