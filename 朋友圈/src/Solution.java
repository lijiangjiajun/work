class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for(int i=0;i<parent.length;i++){
            parent[i]=-1;
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1 && i!=j){
                    union(parent,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                count++;
            }
        }
        return count;
    }

    public void union(int[] parent,int i,int j){
        int x = find(parent,i);
        int y = find(parent,j);
        if(x!=y){
            parent[x]=y;
        }
    }


    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}


//import java.util.*;
//
//class Solution {
//    public static int findContentChildren(int[] g, int[] s) {
//        List<Integer> cookie = new ArrayList<>();
//        List<Integer> children = new ArrayList<>();
//        for(int i=0;i<s.length;i++){
//            cookie.add(s[i]);
//        }
//        for(int i=0;i<g.length;i++){
//            children.add(g[i]);
//        }
//        Collections.sort(cookie, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        Collections.sort(children, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        int i=0;
//        int j=0;
//        int count=0;
//        while (i<children.size() && j<cookie.size()){
//            if(children.get(i)<=cookie.get(j)){
//                i++;
//                j++;
//                count++;
//            }
//            else{
//                i++;
//            }
//        }
//        return count;
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        int[] arr2 = {1,1};
//        System.out.println(findContentChildren(arr, arr2));
//    }
//}