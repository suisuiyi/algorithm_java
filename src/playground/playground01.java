package playground;

import java.util.Scanner;

public class playground01 {
    public static void main(String[] args) {
        String s;
        String s1 = "123456";
        String s2 = new String("abc");


        //while 循环
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("请输入密码...");
//
//        int input_num = scanner.nextInt();
//
//        int password = 123456;
//
//        while (input_num != password) {
//            System.out.println("请输入正确的密码...");
//            input_num = scanner.nextInt();
//        }
//
//        System.out.println("输入正确...");
//
//        scanner.close();



        //forEach

        int[] arr = {1,2,3,5};

        for(int x: arr) {
            System.out.println(x);
        }

    }
}
