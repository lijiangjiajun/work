import java.util.Scanner;
import java.util.Stack;

/*中缀表达式转后缀表达式的方法：
1.遇到操作数：直接输出（添加到后缀表达式中）
2.栈为空时，遇到运算符，直接入栈
3.遇到左括号：将其入栈
4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
6.最终将栈中的元素依次出栈，输出。

后缀表达式的计算机求值：
与前缀表达式类似，只是顺序是从左至右：
从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 op 栈顶元素），并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果。
例如后缀表达式“3 4 + 5 × 6 -”：
(1) 从左至右扫描，将3和4压入堆栈；
(2) 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素，注意与前缀表达式做比较），计算出3+4的值，得7，再将7入栈；
(3) 将5入栈；
(4) 接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
(5) 将6入栈；
(6) 最后是-运算符，计算出35-6的值，即29，由此得出最终结果。
* */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            String s = Tobehind(str);
            System.out.println(calculator("3 4 + 5 * 6 -"));
        }
    }

    public static String Tobehind(String str){
        Stack<Character> stack = new Stack<>();
        String s = "";
        int flag=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(flag==0 && s!=""){
                s=s+" ";
            }
            if(c>='0' && c<='9'){
                s += str.charAt(i);
                flag=1;//21+9/3-5
            }
            if( c=='+' || c=='-' ){
                while(!stack.isEmpty()) {
                    char c2 =stack.pop();
                        s=s+" ";
                        s=s+c2;
                }
                stack.push(c);
                flag=0;
            }
            if(c=='*' || c=='/'){
                while(!stack.isEmpty()) {
                    char c2=stack.pop();
                    if(c2=='*' || c2=='/') {
                        s=s+" ";
                        s = s + c2;
                    }
                    else{
                        stack.push(c2);
                        break;
                    }
                }
                stack.push(c);
                flag=0;
            }
        }
        while(!stack.isEmpty()){
            s=s+" ";
            s=s+stack.pop();
        }
        return s;
    }

    public static int calculator(String str){
        String[] arr = str.split(" ");
        Stack<Integer> stack = new Stack<>();//"3 4 + 5 * 6 -"
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("*") && !arr[i].equals("/")){
                stack.push(Integer.parseInt(arr[i]));
            }
            if(arr[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int c = a+b;
                stack.push(c);
            }
            if(arr[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                int c = b-a;
                stack.push(c);
            }
            if(arr[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int c = b*a;
                stack.push(c);
            }
            if(arr[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int c = b/a;
                stack.push(c);
            }
        }
        return stack.pop();
    }
}
