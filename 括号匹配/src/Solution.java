import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==0){
            return true;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
                continue;

            }
            if(stack.isEmpty()){
                return false;
            }
            char a = stack.pop();
            if(a=='(' && c==')'){
                continue;
            }
            if(a=='[' && c==']'){
                continue;
            }
            if(a=='{' && c=='}'){
                continue;
            }
            return false;

        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}