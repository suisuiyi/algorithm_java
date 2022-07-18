package leetcode.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        /***
         *编写一个函数来查找字符串数组中的最长公共前缀。
         *
         * 如果不存在公共前缀，返回空字符串 ""。
         *
         *  
         *
         * 示例 1：
         *
         * 输入：strs = ["flower","flow","flight"]
         * 输出："fl"
         * 示例 2：
         *
         * 输入：strs = ["dog","racecar","car"]
         * 输出：""
         * 解释：输入不存在公共前缀。
         *
         *
         * ====>思路1：
         * 1、将每个字符串拆分成字符数组
         * 2、然后进行循环每个位置的比较
         * 3、如果遇到不同的元素则结束，其前i-1个元素组成的数组就是公共前缀
         *
         * 考虑特殊情况，如果字符串数组中有空字符串，则肯定没有公共前缀了
         *
         *
         *
         */

        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"ab","a"};
        String[] strs4 = {"flower","flower","flower","flower"};
        String[] strs5 = {"aaa","aa","aaa"};
        String result1 = longestCommonPrefix(strs1);
        String result2 = longestCommonPrefix(strs2);
        String result3 = longestCommonPrefix(strs3);
        String result4 = longestCommonPrefix(strs4);
        String result5 = longestCommonPrefix(strs5);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }

    public static String longestCommonPrefix(String[] strs) {
        //如果数组只有一个值，则返回该值
        if(strs.length == 1) {
            return strs[0];
        }

        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        int minCount = strs[0].length();
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].isEmpty()) {
                return "";
            } else {
                List<Character> characterList = strs[i].chars().mapToObj(x -> (char) x).collect(Collectors.toList());
                map.put(i, characterList);

                if(characterList.size() <= minCount) {
                    minCount = characterList.size();
                }
            }
        }

//        System.out.println(map.values());
        //前几个字符均相同的索引位置
        int index = 0;
        int isAllEquals = 1;
        //循环的次数需要根据字符中数量最小的来确定
        System.out.println("最小个数的字符串个数为：" + minCount);
        for(int i = 0; i < minCount; i++) {
//            System.out.println("第" + i +"轮循环");
            for(int j = 0; j < map.keySet().size() -1; j++) {
                if(map.get(j).get(i).equals(map.get(j+1).get(i))) {
                    isAllEquals *= 1;
                    index = i;
                } else {
                    isAllEquals *= 0;
                    index = i;
                    break;
                }
            }

            if(isAllEquals == 0) {
                break;
            }


        }
        System.out.println(index);
        //全相等、部分相等、仅有一个相等
        if(index >= 1 && isAllEquals == 1) {
            return strs[0].substring(0, index+1);
        }else if(isAllEquals == 0) {
            return strs[0].substring(0, index);
        }
        else if(index == 0 && isAllEquals == 1) {
            return strs[0].substring(0,1);
        }
        return "";
    }

}
