package leetcode.day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExistRepeatedNumber {
    public static void main(String[] args) {
        //217. 存在重复元素
        //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

        int[] arr = {1,2,3,1};
//        System.out.println(checkRepeate(arr));
        System.out.println(sortMethod(arr));

    }

    //方法1: 使用集合的不重复性，然后比较前后的个数是否变化
    // 集合的个数 = 数组个数，则false
    // 集合的个数 < 数组的个数，则true
    public static boolean checkRepeate(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i: arr) {
            set.add(i);
        }

        return set.size() == arr.length ? false : true;

    }



    //方法2: 进行排序后，看相邻的元素是否相等
    public static boolean sortMethod(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                return true;
            }
        }

        return false;
    }
}
