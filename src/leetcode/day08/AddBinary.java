package leetcode.day08;

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args) {
        //67. 二进制求和
        //思路：
        // 1、针对两个二级制字符串
        // 2、从尾部开始遍历求和，如果遇到两个数之和 = 2 则 记录一个进位
        // 3、下次循环的的和 + 1，如果遇到两个数之和 = 2 则 记录一个进位
        // 4、逆序拼接的，需要反转一下

        // 考虑特殊情况，即最高位发生进位的情况，则除了进位的数字，其他位需要反转。

        String a = "1010";
        String b = "1011";

        String res = addBinary(a, b);
        System.out.println(res);


        System.out.println("playground---->");
        int m = 0;  //二进制 0
        int n = 1;  //二进制 1
        int k = 2;  //二进制 10
        int m1 = m >> 1;
        int n1 = n >> 1;
        int k1 = k >> 1;
        System.out.println(m1);
        System.out.println(n1);
        System.out.println(k1);




    }

    public static String addBinary(String a, String b) {

        if(a == null || a.isEmpty()) return b;

        if(b == null || b.isEmpty()) return a;

        StringBuilder stb = new StringBuilder();

        int i = a.length() -1;

        int j = b.length() -1;

        int c = 0;  //进位

        while(i >= 0 || j >= 0) {

            if(i >= 0) {
                c += a.charAt(i) - '0';
            }

            if(j >= 0) {
                c += b.charAt(j) - '0';
            }
            //如果能被2除尽，表示发生了进位，拼接0（和为 2或者0）
            //如果不能被2除尽，表示未发生进位，拼接1（和为1）
            stb.append(c % 2);
            i--;
            j--;
            //这句是啥意思？
            //右移一位，及将最右边的一位删掉。c>>=1  <==>  c = c / 2;

            //如果c = 2, c需要保留一个1，用于后续的运算
            //如果c = 0 或者1，不需要保留。
            c >>= 1;

        }

        //最后如果c > 0 则代表发生了进位，需要拼接一个1。
        return c > 0 ? '1' + stb.reverse().toString(): stb.reverse().toString();
    }
}
