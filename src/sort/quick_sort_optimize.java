package sort;

import java.util.Arrays;

public class quick_sort_optimize {


    public static void main(String[] args) {

        int[] arr = new int[] {8,2,3,5,10,7,19,4,14};

        baseValueChooseOptimize(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] nums, int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }


    // 1. 基准值选择优化
    public static void baseValueChooseOptimize(int[] nums, int left, int right){
        int pivot;
        if(left < right) {
            pivot = baseValueChoosePartition(nums, left, right);
            baseValueChooseOptimize(nums, left, pivot-1);
            baseValueChooseOptimize(nums, pivot+1, right);
        }

    }

    public static  int baseValueChoosePartition(int[] nums, int left, int right) {
        //计算并获得3个数中，轴枢元素的坐标
//      获取中间元素的下标
        int m = left + (right - left)/2;
        if(nums[left] > nums[right]) {   //保证左边较小
            swap(nums, left, right);
        }

        if(nums[m] > nums[right]) {
            swap(nums, m, right);      //保证中间较小
        }

        if(nums[m] > nums[left]) {    //保证左端是中间值
            swap(nums, left, m);
        }

        //      为啥这里要用的是nums[left]呢？
        //      因为快排开始执行的时候是将第一个元素作为轴枢元素开始分割的，需要将三个元素中，中间的那个放到left的位置上。
        int pivot = nums[left];

        System.out.println("基准值为：" + pivot);

        while(left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];


        }
        nums[left] = pivot;
        return left;

    }

    // 2、单边递归优化
    public void singleRecursionOptimize(int[] nums, int left, int right) {
        int middle = 0;
        while(left < right) {
            middle = partition(nums, left, right);
//          对分界值分隔的两个数组;
//          middle左边的数组在一个循环里，继续执行partion操作
//          middle右边的数组在下一次递归中再进行调用。
            quickSort(nums, middle+1, right);
            right = middle -1;
        }

    }

    // 3、partation操作优化

    public static int partitionOptimize(int[] nums, int left, int right) {
        return 0;
    }


    public static void quickSort(int[] nums, int left, int right) {
        int middle = 0;
        if(left < right) {
            middle = partition(nums, left, right);
//          对分界值分隔的两个数组，继续递归该方法。
            quickSort(nums, left , middle-1);
            quickSort(nums, middle+1, right);
        }


    }
    //执行完一次后，输出分界值的坐标
    public static int partition(int[] nums, int left, int right) {

        if (left > right) {
            return 0;
        }

        int pivot = nums[left];

        while(left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            nums[right] = nums[left];


        }
        nums[left] = pivot;

        return left;
    }

}
