package leetcode.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestCommonPrefixOptimize {
    public static void main(String[] args) {

        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"ab","a"};
        String[] strs4 = {"flower","flower","flower","flower"};
        String[] strs5 = {"aaa","aa","aaa"};
        String result1 = longestCommonPrefixOptimize(strs1);
        String result2 = longestCommonPrefixOptimize(strs2);
        String result3 = longestCommonPrefixOptimize(strs3);
        String result4 = longestCommonPrefixOptimize(strs4);
        String result5 = longestCommonPrefixOptimize(strs5);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }

    public static String longestCommonPrefixOptimize(String[] strs) {

        //随便找一个字符串，然后慢慢减少字符串的长度，每减一次就比较一下。
        String s = strs[0];
        for(int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(s)) {
                s = s.substring(0, s.length() -1);
            }
        }

        if(s.length() == 0) {
            return "";
        } else {
            return s;
        }

    }
}
