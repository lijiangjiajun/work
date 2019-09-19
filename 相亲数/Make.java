// import java.util.Scanner;
// public class Make{
//   public static void main(String[] args){
//     Scanner sc = new Scanner(System.in);
//     System.out.println("请输入数字");
//     int n= sc.nextInt();
//     boolean a=  judge(n);
//     System.out.println(a);
//   }
// public static boolean judge(int n){
//   int sum=0;
//   for(int i=1;i<n;i++){
//     if(n%i==0)
//     {
//       sum=sum+i;
//     }
//   }
//   if(sum==n){
//     return true;
//   }
//   else{
//     return false;
//   }
// }
// }

// import java.util.Scanner;
public class Make{
  public static void main(String[] args){
  judge();
  }
public static void judge(){
  int sum=0;
  int k=0;
  int tem=0;
  int i=0;
  int j=0;
  int count=1;
  int[] arr = new int[20];
  for( j=2;j<=10000;j++){
  for( i=1;i<j;i++){
    if(j%i==0)
    {
      sum=sum+i;
    }
  }
for(k=1;k<sum;k++){
if(sum%k==0){
  tem+=k;
}
}
if(j!=arr[count-1]){
if(j==tem && j!=sum){
  arr[count]=sum;
  count++;
  System.out.println(j+" "+sum+"相亲数");
}
}
sum=0;
tem=0;
  }

}

}