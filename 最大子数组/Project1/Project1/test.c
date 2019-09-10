#define _CRT_SECURE_NO_WARNINGS 1


int maxSubArray(int* nums, int numsSize){
	int sum = 0;
	int *p = nums;
	int i = 0;
	int max = nums[0];
	for (i = 0; i<numsSize; i++)
	{
		if (sum >= 0)
		{
			sum = sum + nums[i];
		}
		else
		{
			sum = nums[i];
		}

		if (sum>max)
		{
			max = sum;
		}

	}
	return max;
}