import java.util.*;
class Pair implements Comparable<Pair>{
    public int n1;
    public int n2;
    public int sum;
    public Pair(int n1,int n2){
        this.n1=n1;
        this.n2=n2;
        sum=n1+n2;
    }


    @Override
    public int compareTo(Pair o) {
        if(this.sum<o.sum){
            return 1;
        }
        if(this.sum>o.sum){
            return -1;
        }
        if(this.sum==o.sum){
            return 0;
        }
        return 0;
    }
}

public class TopK {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k<1){
            return result;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(int i=0;i<nums1.length && i<k;i++){
            for(int j=0;j<nums2.length && j<k;j++){
                queue.offer(new Pair(nums1[i],nums2[j]));
                if(queue.size()>k){
                    queue.poll();
            }
        }
        }
        while(!queue.isEmpty()){
            Pair pair =queue.poll();
            List<Integer> list = new ArrayList<Integer>();
            list.add(pair.n1);
            list.add(pair.n2);
            result.add(0,list);
        }
        return result;


    }
}
