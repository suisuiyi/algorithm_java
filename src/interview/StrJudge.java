package interview;

public class StrJudge {

        public static void main (String[]args){
            // 题目1： 判断一个字符串是否是回文串？如果是对称则返回true,否则返回false
            //举例： str = "1", str = "11", str = "12321", str="1221"  返回true
            //str = "12345" 返回false

            //思路：对元素的前一半元素进行循环，然后逐个与后面倒数的元素进行比较，如果遇到不相同的直接返回false。
            // 循环结束均相同，则返回true

          //测试数据
//        String str = "12321";
//        String str = "1221";
//        String str = "1";
        String str = "12324";
//        String str = "";
            boolean result = checkString(str);
            System.out.println(result);

        }

    public static boolean checkString(String str) {
        if(str == null || str.isEmpty()) {
            System.out.println("输入不合法..., 请检查");
            return false;
        }
        for(int i = 0; i < str.length() -1 / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
