public class Test {
    public static  int[] numberOfLines(int[] widths, String S) {
        int line = 0;
        int sum = 0;
        int prev = 0;
        int i = 0;
        // HashMap<Character,Integer> map = new HashMap<>();
        while (i < S.length()) {
            while (i < S.length() && (sum + widths[((int) S.charAt(i)) - 97]) <=100) {
                sum = sum + widths[((int) S.charAt(i)) - 97];
                i++;
            }

            prev = sum;
            sum = 0;
            line++;
        }

        int[] arr = new int[2];
        arr[0] = line;
        arr[1] = prev;
        return arr;
    }
}
