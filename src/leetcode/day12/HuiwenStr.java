package leetcode.day12;

public class HuiwenStr {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     *
     *
     *
     *
     */
    //
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama1";
        //使用正则匹配，将字符串中非a-zA-Z0-9得数字，替换成空字符
        boolean result  = isPalindrome(s);

        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String res = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        if (sb.reverse().toString().equals(sb.toString())) {
            return true;
        }
        return false;
    }
}
