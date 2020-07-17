import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int[][] arr = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
            }
        }
        int count=0;
        int flag=0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Pair pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx=pair.x + arr[j][0];
                    int ny=pair.y + arr[j][1];
                    if(grid[pair.x][pair.y]==1) {
                        grid[pair.x][pair.y] = 2;
                        flag = 1;
                    }
                    if (nx >= 0 && nx < grid.length &&
                            ny >= 0 && ny < grid[0].length && grid[nx][ny]==1 ) {
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            if(flag==1){
                count++;
            }
            flag=0;
        }
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    return -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] t= {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(t));
        for(int i=0;i<t.length;i++){
            for(int j = 0;j<t[0].length;j++){
                System.out.println(t[i][j]);
            }
        }
    }
}