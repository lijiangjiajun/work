import java.util.Arrays;

public class Enum {
        enum Week {
            MON, TUE, WEN, THUS, FRI, SAT, SUN;
        }

        public static void main(String[] args) {
            Week[] values = Week.values();
            System.out.println(Arrays.toString(values));
        }
    }


