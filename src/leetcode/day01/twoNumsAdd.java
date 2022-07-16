package leetcode.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoNumsAdd {
    public static void main(String[] args) {
//        题目1： 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//        你可以按任意顺序返回答案。
//
// 
//
//        示例 1：
//
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
//        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//        示例 2：
//
//        输入：nums = [3,2,4], target = 6
//        输出：[1,2]
//        示例 3：
//
//        输入：nums = [3,3], target = 6
//        输出：[0,1]

        //方法一：暴力破解法  时间复杂度（O(n^2)）
        int[] nums = {3, 3};
        int target = 6;
//        int[] arr = twoSumByForce(nums, target);
//        System.out.println(Arrays.toString(arr));

        //方法二：利用Map来做，单循环O(n);
        //使用map数据结构和原有的int数组来做
        //map中的key 保存的是  目标元素 - 对应数组元素的 差值, value保存的是索引
        //eg int[]中   2，7，11，15
        //  map 中key  7，2，-2，-6
        //  map 中key  0，1， 2， 3
        //  经过观察可以发现如果有之和等于target的值。必然是
        //  num[index]的值 在map的key中。 比如 元素2，在map中也有其key
        //  同时数组的索引下标为 index，另一个是map中2对应的value 0

        //考虑特殊情况： 如果数据为[3,3] 其实就map就放不进去了，所以需要先做判断，然后再放置元素
        //eg int[]中   3，3
        //  map 中key  3
        //  map 中key  0
        int[] arr = twoSumByMap(nums, target);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] twoSumByForce(int[] nums, int target) {
        int[] index = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    public static int[] twoSumByMap(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer,Integer> container = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(container.containsKey(nums[i])) {
                index[0] = i;
                index[1]= container.get(nums[i]);
            }
            container.put(target - nums[i], i);



        }

        return index;


    }
}
