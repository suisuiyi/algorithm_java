package leetcode.day07;

import com.sun.deploy.util.StringUtils;

public class strStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
//        System.out.println(strStr(haystack, needle));
       int result =  strStrByForce(haystack, needle);

        System.out.println(result);
    }
    //方法一： 使用Java的系统函数
    public static int strStr(String a, String b) {
        return a.indexOf(b);
    }
    //方法二: 暴力法
    public static int strStrByForce(String a, String b) {
        //考虑几种情况
        /**
         *
         * 1、b 为空，返回 0
         * 2、a 为空，直接返回返回-1
         * 3、a 、b 均不为空： 一种是 a中包含b, 一种是a中不包含b(1中是本来就没有，一种是a的长度小于b)
         * 可以转化成，从a中找b中的子数组问题
         * 做法是： 将needle与长度为其长度的  haystack的子串均匹配一次。
         *
         *
         * 至于循环的确定还是找规律
         * i = 0; j = 0;  b[0] 与 a[0] 比较，不等，跳出该轮循环
         *
         * i = 1; j = 0;  b[0] 与 a[1] 比较，不等，跳出该轮循环
         *
         * i = 2; j = 0;  b[0] 与 a[2] 比较，相等，继续循环
         *        j = 1;  b[1] 与 a[3] 比较，相等，继续循环，条件不满足了，结束。
         *        b中的元素遍历完了，即此时 j 又加+1
         *        可以得知当 j = b.length 的时候，就代表找到了子串，返回此时的i值
         *
         *
         * */
        if(b.isEmpty()){
            return 0;
        }

        if(a.isEmpty()) {
            return -1;
        }

        char[] chars_a = a.toCharArray();

        char[] chars_b = b.toCharArray();

        int m = chars_a.length;

        int n = chars_b.length;


        if(m < n) {
            return -1;
        } else {
            //因为要拿b中的元素然后与a中的字符进行比较
            //所以循环的次数需要加上b的长度
            for(int i = 0; i <= m - n; i++ ) {
                int j;
                for(j = 0; j < n; j++) {
                    //遇到不相等的情况直接结束，进行下一轮循环
                    //具体的比较是 b中的一个值，然后与a中的值进行比较，如果不相同，则开始下一轮比较。
                    if(chars_b[j] != chars_a[i+j]) {
                        break;
                    }
                }

                //结束的标志: 遍历了b中的所有元素，均与a中的相同
                if(j == n) {
                    return i;
                }


            }


        }
        return 0;
    }

}
