package leetcode.day09;

public class ClimbStairs {
    public static void main(String[] args) {
        // 70. 爬楼梯
        //思路： 没有思路
        //看答案才知道是动态规划解法


        //列竖式找规律
        // n = 1  ==1=> 1
        // n = 2  ==2=> 1+1, 2
        // n = 3  ==3=> 1+1+1, 2+1, 1+2
        // n = 4  ==5=> 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2


        // n = 5  ==8=> 1+1+1+1+1, 2+1+1+1, 1+2+1+1, 1+1+2+1, `2+2+1`, （n=4的基础上 +1步）
        //              `1+1+1+2,`, `2+1+1`, `1+2+2`, (n=3的基础上 +2步)
        //因为只有+1 或者 +2的两种选项。所以f(n) = f(n-1) + f(n-2);

        //总结出规律:当为n时，需要在f(n-1)的基础上再爬1阶，就能达到n阶梯
        //          当为n时，需要在f(n-2)的基础上再爬2阶，就能达到n阶梯
        //即： 第n个台阶只能从第n-1或者n-2个上来
        //考虑边界值：
        //n = 1    1
        //n = 2    2



        //时间复杂度O(n)
        //空间复杂度O(1)
        int result = climbStairs(5);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        //n 至少得>=1
        //创建一个数组用于保存运算后的值
        //因为0号元素，没有使用，需要多申请一个空间
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }
}
