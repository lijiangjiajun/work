class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<0){
            return false;
        }
        int i=0;
        int j = (int) Math.sqrt(c);
        while(i<=j ){
            if(i*i+j*j==c){
                return true;
            }
            else if(i*i+j*j>c){
                j--;
            }
            else if(i*i+j*j<c){
                i++;
            }
        }
        return false;
    }
}