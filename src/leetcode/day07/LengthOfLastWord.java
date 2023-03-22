package leetcode.day07;

public class LengthOfLastWord {
    public static void main(String[] args) {

        //58. 最后一个单词的长度

        String s = "Hello World";
        //思路： 倒叙遍历，从非零字符开始计数。
        //考虑特殊情况： 最后N个是空格时，N个零字符，不返回值。

        int result = lengthOfLastWord(s);
        System.out.println(result);

    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int length = 0;
        for(int i = chars.length-1; i >= 0; i--) {
            //1、最后一个不是空格,开始计数，等于' ',返回计数。
            //2、最后一个是空格时，length = 0, 此时不应该返回0
            // 即length > 0 的时候，才可以返回。
            if(chars[i] != ' ') {
                length++;
            } else if(length > 0) {
                return length;
            }

        }

        return length;
    }
}
