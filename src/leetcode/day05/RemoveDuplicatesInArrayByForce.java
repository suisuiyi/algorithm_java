package leetcode.day05;

import java.util.Arrays;

public class RemoveDuplicatesInArrayByForce {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println("result: "+result);
        System.out.println(Arrays.toString(nums));


        /**
         * 自己的思路：使用额外的数组空间
         * 比较遇到不相等的放入新数组,然后将新数组赋值给老数组
         *
         * 时间复杂度：O（n）
         * 空间复杂度：O(n)
         */
    }

    public static int removeDuplicates(int[] nums) {
        int[] temArr = new int[nums.length];
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]) {
                temArr[count] = nums[i];
                count++;
            }
            temArr[count] = nums[nums.length - 1];
        }
        //复制元素到另一个数组
        for(int i = 0; i < nums.length - 1; i++) {
            nums[i] = temArr[i];
        }

//        System.out.println(Arrays.toString(temArr));

        return count + 1;
    }

}


