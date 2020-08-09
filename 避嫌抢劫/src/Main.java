import java.util.*;

class Pair{
    int pos;
    int money;
    public Pair(int pos,int money){
        this.pos = pos;
        this.money=money;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int distance = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Pair(x,y));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.pos-o2.pos;
            }
        });
        int max= 0;
        int res = 0;
        for(int i=0,j=0;i<list.size();i++){
            while(j+1<i && list.get(i).pos-list.get(j).pos>=distance){
               max = Math.max(max,list.get(j).money);
               j++;
            }
            if(list.get(list.size()-1).pos-list.get(i).pos>= distance || list.get(i).pos-list.get(0).pos>= distance)
            res = Math.max(res,max+list.get(i).money);
        }
        System.out.println(res);
    }
}
