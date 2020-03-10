import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (queue.size() != 1) {
            while (count < 2) {
                int tmp = queue.poll();
                queue.add(tmp);
                count++;
            }
            count = 0;
            queue.poll();
        }
        System.out.println(queue.peek());
    }
}