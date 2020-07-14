class Solution {

    public int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        char[][] arr = new char[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O')
                dfs(board,0,i,arr);
            if(board[board.length-1][i]=='O')
                dfs(board,board.length-1,i,arr);
        }
        for(int i=1;i<board.length-1;i++){
            if(board[i][0]=='O')
                dfs(board,i,0,arr);
            if(board[i][board[0].length-1]=='O')
                dfs(board,i,board[0].length-1,arr);
        }
        for(int i=1;i<board.length-1;i++){
            for(int j=1;j<board[0].length-1;j++){
                if(arr[i][j]=='*') {
                    board[i][j]='O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] borad,int x,int y,char[][] arr){
        if(borad==null){
            return;
        }
        if(x>=borad.length || y>=borad[0].length || x<0 || y<0){
            return;
        }
        if(borad[x][y]=='O' && arr[x][y]==0){
            arr[x][y]='*';
            for(int i=0;i<4;i++){
                dfs(borad,x+pos[i][0],y+pos[i][1],arr);
            }
        }
    }
}

