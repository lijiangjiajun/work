public class Solution {
    public static  String replaceSpace(StringBuffer str) {
        StringBuffer stringbuffer = new StringBuffer();
        String str2 = str.toString();
        for(int i=0;i<str2.length();i++){
            if(str2.charAt(i)!=' '){
                stringbuffer.append(str2.charAt(i));
            }
            else{
                stringbuffer.append("%20");

            }
        }
        return stringbuffer.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("asf rg");
        System.out.println(replaceSpace(sb));
    }
}