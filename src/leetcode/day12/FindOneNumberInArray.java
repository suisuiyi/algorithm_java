package leetcode.day12;

public class FindOneNumberInArray {
    public static void main(String[] args) {


        /**
         * 1、异或运算满足结合律  即  a^(b^c) = (a^b)^c
         * 2、异或运算满足交换律  即  a^b = b ^a
         * 3、任意数与自身异，均是0 即 a^a = 0
         * 4、任意一个数与0异或，均是其本身 即a ^ 0 = a
         */

        //题目1：不用新的变量，完成两个数的交换

        int a = 2;
        int b = 3;

        System.out.println("a的值是：" + a  + "\t b的值是： " + b);

        a = a ^ b;

        b = a ^ b;

        a = a ^ b;

        System.out.println("a的值是：" + a  + "\t b的值是： " + b);

        /*
        * 解析：
        * 第二行中 b = a ^ b 将第一行中的a = a ^ b代入 即
        *
        * b = (a ^ b) ^ b  ==> a ^ b ^ b ==> a ^ (b ^ b) = a ^ 0 = a;
        *
        * 所以说此时 b = a
        *
        * 第三行中 a = a ^ b 同理做运算，将第二行中的代入
        * a = a ^ b = a ^ (a ^ b) = b;
        *
        * 此时 a = b;
        *
        *
        *
        *
        * */



        //题目：给定一个非空的整数数组，除了某个元素进出现一次以外，其他元素均出现偶数次，请找出哪个只出现一次的元素？

        int[] arr = {1,2,2,3,3,4,4};

        //方法一:采用异或运算的形式去解决
        //因为a^a = 0 且 a^0 = a, 在通过交换律，这样最后只会剩下最后一个单个的数

        int result = 0;

        for(int i: arr) {
            result = result ^ i;
        }

        System.out.println("唯一的数是：" + result);

    }
}
