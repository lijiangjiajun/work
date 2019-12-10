public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        int i = 1;
        for (i = 1; i < array.length; i++)
        {
            if (sum < 0)
            {
                sum = array[i];
            }
            else
            {
                sum += array[i];
            }

            if (sum > max)
            {
                max = sum;
            }
        }
        return max;
    }
}
