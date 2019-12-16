public class Solution {
    public String toHex(int num) {
    if(num==0){
        return "0";
    }
    String str = "";
    String mode = "0123456789abcdef";
    while(num!=0 && str.length()<8){
        str = mode.charAt(0xf&num) +str;
        num=num>>4;
    }
    return str;
    }
}
