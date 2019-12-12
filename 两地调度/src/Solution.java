import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // Sort by a gain which company has
        // by sending a person to city A and not to city B
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            sum = sum + costs[i][0];
        }
        for (int j = n; j < costs.length; j++) {
            sum = sum + costs[j][1];
        }
        return sum;
    }
}
