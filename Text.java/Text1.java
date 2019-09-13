public class Text1{
    public static void main(String[] args){
        int sum=0;
        int i=0;
        int tmp=0;
        for(i=1;i<=99;i++){
            if(i%10==9){
                sum++;
            }
            tmp=i/10;
            if(tmp%10==9){
                sum++;
            }
        }
        System.out.println(sum);
    }
}