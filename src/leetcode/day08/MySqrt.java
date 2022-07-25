package leetcode.day08;

public class MySqrt {
    public static void main(String[] args) {
        int x = 8;
        int result = mySqrt(x);
        System.out.println(result);

        //69. x 的平方根

        //思路：二分查找思想
        //k^2 <=x  找到最大k值即可
        //左边界为0， 右边界设置为x, k设置为0,代表我们要找的值


    }

    public static int mySqrt(int x) {
        int l = 0, r = x, k = -1;
        while (l <= r) {
            //这个是啥意思呢？
            int mid = l + (r - l) / 2;
            //则代表在右半区
            if((long)mid * mid <= x) {
                k = mid;
                l = mid + 1;
            } else { //目标值在左半区
                r = mid - 1;
            }
        }

        return k;


//        return (int)Math.sqrt(x);

    }
}
