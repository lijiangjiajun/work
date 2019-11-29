import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {9, 5, 2,7,3,6,8};
        sort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
