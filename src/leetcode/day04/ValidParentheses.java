package leetcode.day04;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        /**
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
         *
         * 有效字符串需满足：
         *
         * 左括号必须用相同类型的右括号闭合。
         * 左括号必须以正确的顺序闭合。
         *  
         *
         * 示例 1：
         *
         * 输入：s = "()"
         * 输出：true
         * 示例 2：
         *
         * 输入：s = "()[]{}"
         * 输出：true
         * 示例 3：
         *
         * 输入：s = "(]"
         * 输出：false
         * 示例 4：
         *
         * 输入：s = "([)]"
         * 输出：false
         * 示例 5：
         *
         * 输入：s = "{[]}"
         * 输出：true
         *
         * */


        /**
         *
         * ===思路：
         * 括号对称问题可以栈来解决
         * 1、遍历当遇到左边的括号时，将右括号入栈
         * 2、遍历到右边括号时，然后将元素出栈
         * 3、当栈为空时，则代表括号是对称的。
         *
         *
         * 考虑集中不对称的情况：
         *
         * 1、左边括号多与右边括号，极端情况： "（（（（"
         * 2、右边括号多与左边括号，极端情况： "））"
         * 3、正常左右不对称  "（ ]"
         *
         *
         *
         * */




        boolean result = isValid("()");
        System.out.println(result);



    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if(stack.isEmpty()) {  // 第2种情况
                return false;
            } else if(c != stack.peek()) { // 第3种情况
                return false;
            } else {
                stack.pop();
            }

        }
        return stack.isEmpty();    //第1种情况和正常情况  如果是全是左括号，则stack是不空的
                                  // 正常情况栈是空的
    }


}
