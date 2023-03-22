package leetcode.day07;

public class maxSubArray {
    public static void main(String[] args) {
        //  53. 最大子数组和

        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);

//        int result = maxSubArrayByDynamicProgramming(nums);
//        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        //思路一: 贪心算法

       //设置一个游标，用于遍历求和，
       // 当游标小于0时抛弃之前的遍历过程，并将游标置0继续向后遍历
       //当游标大于0时，取cur
       //然后最大值取max 和 cur 中的较大值。

       /**
        * 过程分析：
        *
        * -2， 5， -4，,7，-1，-2
        *
        * 游标初始化为 0，当cur 还行第一个元素时，元素为负，当cur置为0，继续遍历
        * 游标指向第2个元素， cur = 5, 将cur 赋值为max
        * 游标指向第3个元素,  cur = cur + num[2] = 1, 结果为正，那cur 与 max进行比较，去较大值。 
        *
        *
        *
        * */

        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int n: nums) {
            cur += n;
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
         return max;




    }

    public static int maxSubArrayByDynamicProgramming(int[] nums) {
        //方法二： 动态规划
        // 核心思想是 若前一个元素 > 0 ,则将其加到当前元素上
        //eg： -2，1，-3，4，-1，2，1，-5，4
        //初始中-2 不变

        /**
         *   -2，1，-3，4，-1，2，1，-5，4
         *   -2，1，-2，4，3， 5，6，1，5
         */
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }

        }
        int max = nums[0];
        for(int num: nums) {
            if (num >= max){
                max = num;
            }
        }
        return max;

    }
}
