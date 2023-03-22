package leetcode.day09;

import java.util.Arrays;

public class MergeTwoArrays {
    //88. 合并两个有序数组
    public static void main(String[] args) {
        //思路一：
        //将数组2追加的数组1中，然后进行排序


        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;

        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //考虑特殊情况
        // 注意📢： m 代表实际存在的数据个数。
        if(n == 0) {
            //num2 为空，啥也不做
            return;
        }

        if(m == 0) {
            //num1为空，直接将nums2的值赋值到nums1中
            for(int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }

        //1、数据由nums2搬迁到nums1中
        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[nums1.length-i-1];
        }

        //2、冒泡排序
        for(int i = 0; i < nums1.length-1; i++) {
            for(int j = 0; j < nums1.length - 1 - i; j++) {
                if(nums1[j] >= nums1[j+1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = temp;
                }
            }
        }

        //3. 排序也可使用
//        Arrays.sort(nums1);

    }
}
