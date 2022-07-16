package interview;

import com.sun.deploy.util.StringUtils;

public class StrRepeateJudge {
    public static void main(String[] args) {
        //题目2： 判断一个字符串中是否有不重复的字符，如果有则返回true，否则返回false

        //示例： str=aaa, 返回false
        //示例： str=abab, 返回false
        //示例： str=abc, 返回true


        //思路一： 暴力破解法
        //双循环进行比较，如果一轮比较中，
        //所有的均不相同，则代表有不重复元素
        //如果有相同元素，则开始下一轮比较
//        String str = "123456";
//        String str = "a";
//        String str = "aa";
        String str = "ab";
//        String str = "aba";

        boolean result = checkStrByForce(str);

        System.out.println(result);





        //思路二：String索引判断
        // 利用String的方法indexof() 和  lastIndexOf()
        //根据返回的目标元素的首次位置与目标元素的最后出现位置进行
        //遍历所有字符，如果相等则该字符在字符串中无重复
        //否则有重复元素

//        String str = "123456";
//        String str = "a";
//        String str = "aa";
//        String str = "ab";
//        String str = "aba";
//        String str = null;
//        String str = "";
//        try {
//            boolean result = checkStr(str);
//            System.out.println(result);
//        } catch (Exception e) {
//            System.out.println("参数非法，请检查....");
//        }

        //思路三: 数据统计个数判断
        // 创建一个大小为256的数组 用来存储每个字符出现的次数
        //然后遍历该数组，如果有为1的值，则代表有不重复的元素
        //提示： 字符强转成int 会返回其ascii值
//        String str = "ab*12k|?>";
//
//        boolean result = checkStrByArr(str);
//
//        System.out.println(result);



    }

    public static boolean checkStrByForce(String str) {
        char[] chars = str.toCharArray();
        if(chars.length == 1) {
            return true;
        }
        for(int i = 0; i < chars.length; i++) {
            int hasRepeated = 0;
            for(int j = i + 1; j < chars.length; j++) {
                if(chars[i] == chars[j]) {
                    hasRepeated = 1;
                    continue;
                }
            }

            if(hasRepeated == 0) {
                return true;
            }

        }
        return false;
    }


    public static boolean checkStrByString(String str) throws IllegalArgumentException {
        //异常场景判断
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        char[] arr =  str.toCharArray();
        for(char c: arr) {
            if(str.indexOf(c) == str.lastIndexOf(c)) {
                System.out.println("第一个不重复的字符：" + c);
                return true;
            }
        }
        return false;
    }

    public static boolean checkStrByArr(String str) {
        //ascii表一共有256个字符
        int[] arr = new int[256];

        char[] chars = str.toCharArray();
        int index = 0;
        for(char c: chars) {
            index = c;
            arr[index]+= 1;
        }
        for(int i: arr) {
            if(i == 1) {
                return true;
            }
        }

        return false;

    }


}
