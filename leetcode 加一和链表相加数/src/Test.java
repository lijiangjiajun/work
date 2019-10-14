//public class Test {
//    public static void main(String[] args){
//          int[] nums1={4,1,2};
//          int[] nums2={1,3,4,2};
////          int[] arr = new int[nums1.length];
//          int[] arr = nextGreaterElement(nums1,nums2);
//          for(int i=0;i<arr.length;i++){
//              System.out.println(arr[i]);
//          }
//    }
//
//    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int i ;
//        int j;
//        int k=0;
//        int a;
//        int[] arr = new int[nums1.length];
//        for(i=0;i<nums1.length;i++){
//            for(j=0;j<nums2.length;j++){
//
//                if(nums2[j]==nums1[i]){
//                    for(;j<nums2.length;j++){
//                        if(nums2[j]>nums1[i]){
//                            arr[k]=nums2[j];
//                        }
//                        else{
//                            arr[k]=-1;
//                        }
//                    }
//                }
//            }
//            k++;
//        }
//        return arr;
//
//    }
//}


public  class Test {



    public  static  int[] plusOne(int[] digits) {
        if(digits[digits.length-1]+1==10 && digits[0]+1==10){
            int[] arr = new int[digits.length+1];
            for(int i=digits.length;i>=0;i--){
                if(i==digits.length){
                    arr[i]=digits[i-1]+1;
                }
                else{
                    if(i>=1) {
                        arr[i] = arr[i] + digits[i - 1];
                    }
                }
                if(arr[i]==10){
                    arr[i]=0;
                    arr[i-1]++;
                }


            }
            return arr;
        }

        else{
            int[] arr2 = new int[digits.length];
            for(int i=digits.length-1;i>=0;i--){
                if(i==digits.length-1){
                    arr2[i]=digits[i]+1;
                }
                else{
                    arr2[i]=arr2[i]+digits[i];

                }
                if(arr2[i]==10 &&i>=1){
                    arr2[i]=0;
                    arr2[i-1]++;
                }


            }
            return arr2;
        }
    }

    public static void main(String[] args){
        int[] digits={9};
        int[] arr = plusOne(digits);
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }
}