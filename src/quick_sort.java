import java.util.Arrays;

public class quick_sort {

    public static void main(String[] args) {

        int[] arr = new int[] {8,2,3,5,10,7,19,4,14};

        quickSort(arr, 0 ,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


    public void swap(int[] nums, int i, int j) {
        if(i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    public static void quickSort(int[] nums, int left, int right) {
        int middle;
        if(left < right) {
            middle = partition(nums, left, right);
//          对分界值分隔的两个数组，继续递归该方法。
            quickSort(nums, left, middle-1);
            quickSort(nums, middle+1, right);
        }

    }
    //执行完一次后，输出分界值的坐标
    public static int  partition(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

//      1、先把基准值拿出来 ===> 基准值的位置留空。
        int pivot = nums[left];

        while(left < right) {
//          2、从右边开始找比基准值小的元素
//          控制循环的移动，当满足条件的时候移动指针，当遇到不满足的情况说明找了比基准值小的元素。
            while (left < right && nums[right] >= pivot) {
                right--;
            }
//          找到比基准值小的元素，将该元素放到基准值空出的位置上即：
            nums[left] = nums[right];
//          3、同步的开始从左边开始找比基准值大的元素。
            while (left < right && nums[left] <= pivot) {
                left++;
            }

//          找到比基准值大的元素，将该元素，放置到之前空出元素的位置
            nums[right] = nums[left];

        }
//      所有的循环结束时，即左右指针相遇，此时将基准值，放在空的位置上。
        nums[left] = pivot;

        return left;
    }

}
