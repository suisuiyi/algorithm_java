package leetcode.day08;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        //66. 加一


        //思路一： 正常是对最后一个数做加一运算，不过要考虑进去进位的情况。
        //有个问题❌： 当Integer.parseInt 可能存在超出范围的情况。
        // eg： [1, 3, 4] + 1  ===> [1, 3, 5]
        // 特殊值：
        // [1, 8, 9]  + 1  ====>  [1, 9, 0]
        // 极端情况
        // [9, 9] + 1 ===> [1, 0, 0];

        int[] nums1 = new int[]{1,2,3};

        int[] res1 = plusOneByForce(nums1);

        System.out.println(Arrays.toString(res1));



        //思路二： 直接对里的元素做加一运算。
        // 需考虑特殊情况： 发生进位的情况
        // normal: 1,2,3 ==> 1,2,4
        // special: 1,2,9 ==> 1,3,0;
        //          9,9   ==> 1, 0, 0
        //

        //最后1位不是9， 直接对最后一位+1, 返回
        //最后一位是9， 将最后一位改成0, 倒数第二位 + 1;
        //如果全是9，则在数组前插入1，将其余所有位数变成 0；




    }

    public static int[]  plusOne(int[] digits) {

        for(int i = digits.length -1; i >= 0; i--) {
            //1. 最后一个不是9
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            //2. 最后一个不是9，置为0， 然后对前一位 + 1 后返回。
            digits[i] = 0;

        }

        //3、当全是9的时候，数组内已全是0，此时新建一个数组的长度 = digits.length + 1
        //同时将首个元素置为1 即可。
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;

    }




    public static int[]  plusOneByForce(int[] digits) {
        String s = "";
        for(int n : digits) {
            s += n;
        }

        Integer n = Integer.valueOf(s) + 1;

        String result = String.valueOf(n);

        int[] res_arr = new int[result.length()];

        for(int i = 0; i < result.toCharArray().length; i++) {
            res_arr[i] = Integer.parseInt("" + result.charAt(i));
        }

        return res_arr;

    }

}
