import java.util.Random;

public class ThreeMonkDrinkWater {
    private volatile static int index = 0;

    private static class Monk extends Thread {
        int[] array;

        Monk(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            while (index < array.length) {
                synchronized (Monk.class) {
                    if (index < array.length) {
                        array[index] = array[index] * 3;
                        index++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(20191215);
        int[] array = new int[10_0000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        Monk m1 = new Monk(array);
        Monk m2 = new Monk(array);
        Monk m3 = new Monk(array);
        m1.start();
        m2.start();
        m3.start();
        m1.join();
        m2.join();
        m3.join();
        System.out.println(array[0]);
        System.out.println(array[3]);
        System.out.println(array[107]);
        System.out.println(array[323]);
        System.out.println(array[6666]);
        System.out.println(array[88888]);
        System.out.println(array[93192]);
    }
}
