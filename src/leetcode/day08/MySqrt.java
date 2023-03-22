package leetcode.day08;

public class MySqrt {
    public static void main(String[] args) {
        int x = 8;
        int result = mySqrt(x);
        int result1 = mySqrtByMySelf(x);
        System.out.println(result1);

        //69. x 的平方根

        //思路：二分查找思想
        //k^2 <=x  找到最大k值即可
        //左边界为0， 右边界设置为x, k设置为0,代表我们要找的值
        //二分查找的找到中间值
        //比如 1,2,3,4,5,6,7,8,9
        //找中间值的形式 mid = (1 + 9) /2 = 5
        //比如 1,2,3,4,5,6,7,8
        //mid = (1 + 8) /2 = 4


        //具体分析 比如输入的值是4
        // l = 0, r =4, k = -1
        // 第一轮：mid =( 0 + 4 ) / 2 = 2
        // 判断mid^2 与  x比较，如果相等 则mid 就是求解的值。

        //具体分析 比如输入的值是8
        // l = 0, r =8, k = -1
        // 第一轮: mid = 4,
        // 4^2 = 16 > 8 则数据在左半区。
        //此时l 不变，r = mid -1 = 3
        //二分的范围变成了  0,1,2,3
        //第二轮：mid = ( 0 + 3) /2 = 1
        //1^2 = 1 < 8 则数据在右半区。
        //此时 r不变 r = 3, l = mid + 1 = 2
        //数据范围变成了 2,3
        //第三轮：mid = (2 + 3) /2 = 2
        //2^2 = 4 < 8 则数据在左半区。
        //仅有一个数子了则 mid = 2 就是答案。



    }

    public static int mySqrt(int x) {
        int l = 0, r = x, k = -1;
        while (l <= r) {
            //这个是啥意思呢？  二分法的  是  （头 + 尾）/2 得到中间值
            int mid = (r + l) / 2;
            //则代表在右半区
            if((long)mid * mid <= x) {
                k = mid;
                l = mid + 1;
            } else { //目标值在左半区
                r = mid - 1;
            }
        }

        return k;
    }


    public static int mySqrtByMySelf(int x){
        int l = 0, r = x, k = -1;

        while (l < r) {
           //找中间值
           int mid = (l + r) /2;

           if(mid * mid <= x){  //目标值在右半区
                l= mid + 1;
               //如果刚好相等，此时mid求解的值
               k = mid;
           } else { //目标值在左半区
               r = mid - 1;
           }
        }
        return k;
    }

}
