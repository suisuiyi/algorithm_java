package leetcode.day06;

import java.util.Arrays;

public class RemoveElementInArray {
    //27.移除元素
    public static void main(String[] args) {

//        int[] nums = new int[]{3,2,2,3};
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));

    }
    public static int removeElement(int[] nums, int val) {
        //参考之前的移除重复元素，也采用快慢指针的思路实现
        //重点是找到不相等的元素，然后赋值给慢指针即可

        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }
        return slow;
    }
}
