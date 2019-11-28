import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String predict = scanner.next();
            String actually = scanner.next();
            predict = predict.toUpperCase();
            actually = actually.toUpperCase();
            Set<Character> pre = new HashSet<>();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < actually.length(); i++) {
                pre.add(actually.charAt(i));
            }
            for (int j = 0; j < predict.length(); j++) {
                if (!pre.contains(predict.charAt(j))) {
                    if (!set.contains(predict.charAt(j))) {
                        set.add(predict.charAt(j));
                        System.out.print(predict.charAt(j));
                    }
                }
            }
        }
}
}
