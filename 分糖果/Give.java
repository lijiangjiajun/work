public class Give{
    public static void main(String[] args){
        int n=1;
        int[] arr = {10,2,8,22,16,4,10,6,14,20};
          while(isEqual(arr)==false){
              show(arr,n);
              give(arr);
              n++;
          }
          show(arr,n);
    }
    public static boolean isEqual(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] !=arr[i+1]){
                return false;
            }  
        }
        return true;
    }
    public static  void show(int[] arr,int n){
        System.out.println("第"+n+"次为:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void give(int[] arr){
        int m=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            // for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]/2+arr[i]/2;       
        }
        arr[0]=m/2+arr[0]/2;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                arr[i]++;
            }
        }
    }
}