
#include "game.h"

int main()
{
	int input = 0;
	menu();
	srand((unsigned int)time(NULL));
	printf("������һ������");
	do{
		scanf("%d", &input);
		switch (input)
		{
		case 0:
			printf("�˳��ɹ�\n");
			break;
		case 1:
			game();
			break;
		default:
			printf("�����������������\n");
			break;
		}

	} while (input);
	system("pause");
	return 0;
}
