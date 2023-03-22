package leetcode.day05;

import java.util.Arrays;

public class RemoveDuplicatesInArray {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println("result: " + result);
        System.out.println(Arrays.toString(nums));
        /**
         * 自己的思路：
         *
         * 时间复杂度：O（n^2）
         * 空间复杂度：O(1)
         * */
    }


    public static int removeDuplicates(int[] nums) {
        //1、将相同的数变掉
        //2、将相同的数追加到最后一位
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j< nums.length; j++) {
                if(nums[i] == nums[j]) {
                    nums[j] = -1000000;
                }
                continue;
            }
        }

        int result = 0;
        //2.排序
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length -1 - i; j++) {
                if(nums[j] < nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }

        }
        //3.获取索引
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] > -1000000) {
                result++;
            }
        }

        //4. 对前result元素再进行排序
        for(int i = 0; i < result; i++) {
            for(int j = 0; j< result-1-i; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }
        return result;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
