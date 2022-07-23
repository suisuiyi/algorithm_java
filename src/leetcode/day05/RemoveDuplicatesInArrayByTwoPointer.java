package leetcode.day05;

import java.util.Arrays;

public class RemoveDuplicatesInArrayByTwoPointer {
    public static void main(String[] args) {
        //官方解答： 使用快慢指针的形式解决
        //思路：
        //快指针用于元素的遍历，慢指针用于元素的赋值
        //快指针遍历到元素不相同的情况，将该元素赋值给慢指针的位置上即可。
        // 0号与1号元素不同的话，需要保留两者，所以替换的应该从1开始。
        //同时需要考虑特殊情况
        /**
         * 数组长度为0 时返回0
         * 数组长度为1 时返回1，且仅有一个元素
         * 数组长度大于1 场景
         *
         * */
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicatesByTwoPointer(nums);
        System.out.println("result: "+result);
        System.out.println(Arrays.toString(nums));


    }

    public static int removeDuplicatesByTwoPointer(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return 0;
        }

        int slow = 1;
        int fast = 0;
        while (fast < n-1) {
            //有问题，少了 0号元素与1号元素的比较， 所以快指针的要从0开始，替换的操作要从1开始。
            if(nums[fast] != nums[fast+1]) {
                nums[slow] = nums[fast+1];
                slow+=1;
            }

            fast+=1;
        }

        return slow;
    }

}


