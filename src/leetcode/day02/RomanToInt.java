package leetcode.day02;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        /***
         * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
         *
         * 字符          数值
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
         *
         * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
         *
         * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
         * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
         * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
         * 给定一个罗马数字，将其转换成整数。
         *
         *  
         *
         * 示例 1:
         *
         * 输入: s = "III"
         * 输出: 3
         * 示例 2:
         *
         * 输入: s = "IV"
         * 输出: 4
         * 示例 3:
         *
         * 输入: s = "IX"
         * 输出: 9
         * 示例 4:
         *
         * 输入: s = "LVIII"
         * 输出: 58
         * 解释: L = 50, V= 5, III = 3.
         * 示例 5:
         *
         * 输入: s = "MCMXCIV"
         * 输出: 1994
         * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
         *
         *
         */


        String str1 = "III";
        String str2 = "IV";
        String str3 = "IX";
        String str4 = "LVIII";
        String str5 = "MCMXCIV";
        int result1 = romanToInt(str1);
        int result2 = romanToInt(str2);
        int result3 = romanToInt(str3);
        int result4 = romanToInt(str4);
        int result5 = romanToInt(str5);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);


    }

    public static  int romanToInt(String s) {
        //维护一个列表
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put(new Character('I'), 1);
        dict.put(new Character('V'), 5);
        dict.put(new Character('X'), 10);
        dict.put(new Character('L'), 50);
        dict.put(new Character('C'), 100);
        dict.put(new Character('D'), 500);
        dict.put(new Character('M'), 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        int num1;
        for(int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I': num1 = dict.get(chars[i]); break;
                case 'V': num1 = dict.get(chars[i]); break;
                case 'X': num1 = dict.get(chars[i]); break;
                case 'L': num1 = dict.get(chars[i]); break;
                case 'C': num1 = dict.get(chars[i]); break;
                case 'D': num1 = dict.get(chars[i]); break;
                case 'M': num1 = dict.get(chars[i]); break;
                default: num1 = 0;

            }
            if(i >= 1) {
                if(chars[i-1] == 'I' && chars[i] == 'V') {
                    num1-=2*dict.get(chars[i-1]);
                }
                if(chars[i-1] == 'I' && chars[i] == 'X') {
                    num1-=2*dict.get(chars[i-1]);
                }
                if(chars[i-1] == 'X' && chars[i] == 'L') {
                    num1-=2*dict.get(chars[i-1]);

                }
                if(chars[i-1] == 'X' && chars[i] == 'C') {
                    num1-=2*dict.get(chars[i-1]);
                }
                if(chars[i-1] == 'C' && chars[i] == 'D') {
                    num1-=2*dict.get(chars[i-1]);

                }
                if(chars[i-1] == 'C' && chars[i] == 'M') {
                    num1-=2*dict.get(chars[i-1]);

                }

            }


            result += num1;
        }

        return result;
    }
}
