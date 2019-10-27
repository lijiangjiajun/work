public class MyString {
    private String arr;

    public MyString(String arr) {
        this.arr = arr;

    }

    public boolean MYequals(String arr2) {
        int count = 0;
        if (arr.length() != arr2.length()) {
            return false;
        } else {
            while (count < arr.length()) {
                if (arr.charAt(count) != arr2.charAt(count)) {
                    return false;
                }
                count++;
            }
            return true;
        }
    }

    public int MycompareTo(String arr2) {
        int count = 0;
        while (count < arr.length() && count < arr2.length()) {
            if (arr.charAt(count) != arr2.charAt(count)) {
                return arr.charAt(count) - arr2.charAt(count);
            }
            count++;
        }
        if (count == arr.length() && count != arr2.length()) {
            return -arr2.charAt(count);
        }
        if (count != arr.length() && count == arr2.length()) {
            return arr.charAt(count);
        }
        return 0;
    }

    public char[] MytoCharArray() {
        char[] a = new char[arr.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = arr.charAt(i);
        }
        return a;
    }

    public boolean Mycontain(char a) {
        for (int i = 0; i < arr.length(); i++) {
            if (a == arr.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public int MyindexOf(String arr2) {
        int len = arr2.length();
        int flag = 0;
        int count = 0;
        int pos = 0;
        while (count < arr.length()) {
            while (pos < arr.length() && flag < len && arr.charAt(pos) == arr2.charAt(flag)) {
                pos++;
                flag++;
            }

            if (flag == len) {
                return pos - len;
            }
            flag = 0;
            pos = count;
            count++;
        }
        return -1;
    }

//    public String MyreplaceAll(String arr2,String arr3){
//        int len = arr2.length();
//        int flag = 0;
//        int count = 0;
//        int pos = 0;
//        char[] a = new char[];
//        while (count < ) {
//   while (pos < arr.length() && flag < len && arr.charAt(pos) == arr2.charAt(flag))
//   {
//                pos++;
//                flag++;
//            }
//
//            if (flag == len){
//                for(int i=0;i<arr3.length();i++){
//                    a[count]=arr3.charAt(i);
//                    count++;
//                }
//            }
//            a[count]=arr.charAt(pos);
//            flag = 0;
//
//            count++;
//        }
//    String arr4 = new String(a);
//        return arr4;
//    }

    public String[] Mysplit(char a) {

        int fast = 0;
        int slow = 0;
        int count = 0;
        int i = 0;
        int flag=0;

        char[] b = arr.toCharArray();
        for(int  j=0;j<arr.length();j++){
            if(arr.charAt(j)==a){
                count++;
            }
        }
        String[] arr2 = new String[count];
        count=0;
        for (int j = 0; j < b.length; j++) {

            if (b[j] == a) {
                 arr2[i] = new String (b,flag,count);
                flag=j+1;
                i++;
                count=-1;
            }
            count++;
        }
        return arr2;
    }


        public boolean Myisempty(){
        if(arr.length()==0){
            return true;
        }
        else{
            return false;
        }
        }


        public int Mylength(){
        char[] arr2 = arr.toCharArray();
        return arr2.length;
        }

        public String Mytrim() {
            char[] arr2 = arr.toCharArray();
            int count=0;
            int i=0;
            while(arr2[0]==' '){
                for(int j=0;j<arr2.length-1;j++){
                    arr2[j]=arr2[j+1];
                }
            }

            while(arr2.length-1-i==' '){
                count++;
                i++;
            }
            String a = new String (arr2,0,arr2.length-count);
                return a;
        }


        public String Mysubstring(int start,int end){
        char[] arr2 = arr.toCharArray();
            String a = new String (arr2,start,end-start);
            return a;
        }
}
