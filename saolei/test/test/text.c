#include "game.h"

int main()
{
	int n = 0;
	srand((unsigned int)time(NULL));
	menu();
	do
	{
		printf("������һ������ѡ��\n");
		scanf("%d", &n);
		switch (n)
		{
		case 0:

			printf("��Ϸ����\n");
			break;

		case 1:

			game();
			break;

		default:

			printf("�����������������\n");
			break;


		}
	} while (n);
	system("pause");
	return 0;
}