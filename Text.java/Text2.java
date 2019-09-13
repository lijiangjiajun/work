public class Text2{
    public static void main(String[] args){
        int i=0;
        for(i=100;i<999;i++){
           int[] a={0,0,0};
           a[0]=i%10;
           a[1]=i/10%10;
           a[2]=i/100;
           int ret=pow(a[0])+pow(a[1])+pow(a[2]);
           if(ret==i){
               System.out.println(i);
           }
        }
      
    }
      public static int pow(int x){
            return x*x*x;
        }
}