class Solution {
    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                String tmp = (char)(str.charAt(i)+32)+"";
                sb.append(tmp);
            }
            else{
                sb.append(str.charAt(i)+"");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "ABSKJ";
        System.out.println(toLowerCase(str));
    }
}


