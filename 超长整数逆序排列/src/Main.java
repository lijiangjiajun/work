import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            List<BigInteger> list =new ArrayList<>();
            int n= scanner.nextInt();
            for(int i=0;i<n;i++) {
                list.add(scanner.nextBigInteger());
            }
            Collections.sort(list, new Comparator<BigInteger>() {
                @Override
                public int compare(BigInteger o1, BigInteger o2) {
                    if(o1.compareTo(o2)==-1){
                        return 1;
                    }
                    else if(o1.compareTo(o2)==1){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
            System.out.println(list);
        }
    }
}
