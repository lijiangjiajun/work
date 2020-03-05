import java.util.*;

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        for(int i=0;i<n;i++){
            if(A.charAt(i)!='(' && A.charAt(i)!=')' ){
                return false;
            }
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='('){
                stack.push(A.charAt(i));
            }
            if(A.charAt(i)==')'){
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}