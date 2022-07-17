package leetcode.day01;

public class HuiWenNumber {
    public static void main(String[] args) {
        /**
         * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
         *
         * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
         *
         * 例如，121 是回文，而 123 不是。
         *
         * ===> 解决思路： 将数字转换成字符串，然后利用字符的charAt(i)方法获取对应的元素进行比较
         *
         *
         *
         *
         * 注意点📢： 需考虑特殊情况：
         * 1. 一个数，天然是回文数：比如1
         * 2. 2个数判断： 22是回文数，23不是回文数。带入到方法中进行验证。
         *
         *
         * */

        int x = 121;
        int y = 1;
        int z = 21;
        int w = 22;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
        System.out.println(isPalindrome(z));
        System.out.println(isPalindrome(w));

    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        for(int i = 0; i < (str.length() + 1) / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() -i -1)) {
                return false;
            }
        }
        return true;
    }
}
