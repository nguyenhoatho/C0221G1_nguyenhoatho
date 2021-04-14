package example.example2;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack();
        String expressionInput ="(– b + (b^2 – 4*a*c)^(0.5/ 2*a)) ";
        for (int i=0;i<expressionInput.length();i++){
           if (expressionInput.charAt(i)== '('){
               stack.push(expressionInput.charAt(i));


           }else if (expressionInput.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
               stack.pop();
           }else if (expressionInput.charAt(i)==')'){
               stack.push(expressionInput.charAt(i));
           }
        }
        if (stack.isEmpty()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}
