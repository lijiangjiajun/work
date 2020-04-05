import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //测试样例个数
        int n = sc.nextInt();
        //存结果
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (n-- != 0) {
            //人数
            int people = sc.nextInt();
            int[] score = new int[people + 1];
            //保存分数
            for (int i = 0; i < people; i++) {
                score[i] = sc.nextInt();
            }
            score[people] = score[0];
            int res1 = countAward(score);
            res.add(res1);
        }
        for (Integer i : res)
            System.out.println(i);

    }
    private static int countAward(int[] score) {
        int res1 = 0;
        int[] award = new int[score.length];
        score[0] = 1;
        award[0] = 1;
        //先从左往右遍历，满足了每个人都至少有一个奖品
        for (int i = 1; i < score.length; i++) {
            if (score[i] > score[i - 1])
                award[i] = award[i - 1] + 1;
            else
                award[i] = 1;
        }
        //再从右往左遍历
        for (int i = score.length - 2; i > -1; i--) {
            if (score[i]> score[i+1]) {
                if (award[i] > award[i+1])
                    continue;
                else
                    award[i] = Math.max(award[i],award[i+1]+1);
            }
        }
        for (int i = 0; i < award.length-1; i++) {
            res1 += award[i];
        }
        return res1;
    }

}