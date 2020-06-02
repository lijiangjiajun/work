import com.sun.jmx.snmp.SnmpUnknownModelException;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

class Customer  {
    int number; // 这组顾客的人数
    int budget; // 这组顾客预计花多少钱

    public Customer(int number,int budget){
        this.number= number;
        this.budget=budget;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "number=" + number +
                ", budget=" + budget +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int n = scanner.nextInt();//桌子数量
            int m = scanner.nextInt();//有M批客人
            for(int i=0;i<n;i++){
                int a = scanner.nextInt();
                int count = map.getOrDefault(a,0);
                map.put(a,count+1);
            }
            Customer[] customers = new Customer[m];
            for(int i=0;i<m;i++){
                int number = scanner.nextInt();
                int budget = scanner.nextInt();
                customers[i]=new Customer(number,budget);
            }
            Arrays.sort(customers,new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((Customer) o2).budget-((Customer) o1).budget;
                }
            });
            long profit = 0;
            for(int i=0;i<customers.length && !map.isEmpty();i++){
                int number = customers[i].number;
                Integer key = map.ceilingKey(number);
                if(key!=null){
                    int count = map.get(key);
                if(count>0){
                    profit+=customers[i].budget;
                    map.put(key,count-1);
                }
                else{
                    map.remove(key);
                }
                }

            }
            System.out.println(profit);
        }

    }
}
