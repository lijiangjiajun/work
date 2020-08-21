import java.util.Scanner;

public class Main {

	public int minSubArray(int[] nums, int m) {
		int[] sum = new int[nums.length];
		int M = 0;
		int sumtemp = 0;
		while (M < m) {
			sumtemp = sumtemp + nums[M];
			sum[m - 1] = sumtemp;
			M++;
		}
		int min = sum[m - 1];
		for (int i = m; i < nums.length; i++) {
			if (sum[i - 1] < 0) {
				sum[i] = sum[i - 1] + nums[i];
				min = Math.min(min, sum[i]);
			} else {
				int temp = 0;
				int z = i;
				for (int j = m; j > 0; j--) {

					temp = temp + nums[z--];
				}
				sum[i] = Math.min(temp, sum[i - 1] + nums[i]);
				min = Math.min(min, sum[i]);
			}

		}

		return min;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = in.nextInt();

		}
		Main test = new Main();
		System.out.println(test.minSubArray(num, m));
	}

}

