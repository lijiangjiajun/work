
#include "game.h"

int main()
{
	int input = 0;
	menu();
	srand((unsigned int)time(NULL));
	printf("请输入一个整数");
	do{
		scanf("%d", &input);
		switch (input)
		{
		case 0:
			printf("退出成功\n");
			break;
		case 1:
			game();
			break;
		default:
			printf("输入错误，请重新输入\n");
			break;
		}

	} while (input);
	system("pause");
	return 0;
}
