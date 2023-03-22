package leetcode.day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMoreNumber {

    public static void main(String[] args) {

        //给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        int[] arr = {1,2,3,3,3};
//        System.out.println(sortGetMid(arr));
//        System.out.println(mapCount(arr));
        System.out.println(moloVote(arr));
    }

    //方法1：Map统计法
    //核心思想就是统计好每个出现数字的个数，然后再次筛选
    public static int mapCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            if(map.get(i) == null) {
                map.put(i, 1);
            }else {
                int count = map.get(i);
                map.put(i, count +1);
            }
        }

        int result = 0;

        for(int j: map.keySet()) {
            if(map.get(j) > arr.length / 2) {
                result = map.get(j);
            }
        }

        System.out.println(map.toString());

        return result;
    }


    //方法2：sort方法
    // 排序后，取中值，中值就是目标值
    public static int sortGetMid(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length /2];
    }


    //方法3： 摩尔投票法
    //核心思想是不同的值比拼消耗，最后剩下的肯定是目标值，因为他大于了数组个数的一半
    //做法：
    //1. 记录数组元素的值
    //2. 记录数组元素的个数
    //3. 遇到不同的值，对个数做减法
    //4. 最后剩下的肯定就是目标值
    /**
     * 举例：{1,2,3,3,3}
     * int num = 1
     * int count = 1
     * 循环到2的时候，num与2比较，发现不一样，对count-1
     * 当count = 0, 对num重新赋值
     */

    public static int  moloVote(int[] arr) {
        int num = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length;  i++) {

            if(count == 0) {
                num = arr[i];
            }

           if(num == arr[i]) {
               count = count +1;
           } else {
               count = count -1;
           }


        }
        return num;
    }





}
