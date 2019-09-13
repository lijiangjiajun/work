public class Text5{
    public static void main(String[] args){
        int[] arr = {0,0,0,0,0};
        int[] b = {0,0,0,0,0}; 
        int a=0b1000011111;
        int i=0;
        int j=0;
        int tmp=a;
        while(tmp!=0){
            arr[i]=tmp&1;
            tmp=tmp>>2;
            i++;
        }
        a=a>>1;
        while(a!=0){
            b[j]=a&1;
            a=a>>2;
            j++;
        }
        print(arr);
        System.out.println();
        print(b);
    }
    public static void print(int[] c){
        for(int i=0;i<5;i++){  
        System.out.println(c[4-i]);
    }
    }
}