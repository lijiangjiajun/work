import java.io.File;

public class  Print {
  static int index=0;
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three"};
        for (int i = 0; i < 3; i++) {
            new Thread(new MyRunnable() {
                @Override
                public void run() {
                    while(true) {
                        synchronized (Print.class) {
                            if(index ==0) {
                                System.out.println(arr[0]);
                                index = 1;
                            }
                            if(index ==1){
                                System.out.println(arr[1]);
                                index =2;
                            }
                            if(index ==2){
                                System.out.println(arr[2]);
                                index =0;
                            }

                        }
                    }
                }
            }).start();

        }

    }
}

