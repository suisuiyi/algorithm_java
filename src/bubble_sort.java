import java.util.Arrays;

public class bubble_sort {

    public static void main(String[] args) {

        int[] arr = new int[]{8,5,9,3,6,4,10,2,7};

        System.out.println(Arrays.toString(bullbleSort(arr)));
    }

    public static void swap(int[] nums, int m, int n) {

        if(m == n) {
            return;
        }

        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;

    }


    public static int[] bullbleSort(int[] nums) {

        if (nums.length == 0 ){
            System.out.println("数组为空，无需排序");
        }

        if(nums.length == 1) {
            System.out.println("数组仅有一个元素，无需排序");
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length-1 -i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                }

            }
        }
        return nums;

    }

}
