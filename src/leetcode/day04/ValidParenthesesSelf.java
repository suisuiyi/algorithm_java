package leetcode.day04;

import java.util.Stack;

public class ValidParenthesesSelf {
    public static void main(String[] args) {
        boolean result = isValid("()");
        System.out.println(result);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty()){  //全是右括号
                return false;
            } else if (c != stack.peek()) {  //正常不对称 "c]"   其中:  ] != )
                return false;
            }
        }

        return stack.isEmpty();   // 正常场景&&全是左括号的情况。



    }

}
