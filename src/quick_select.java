import java.util.Arrays;

public class quick_select {
    public static void main(String[] args) {
//        int[] arr = {30,83,56,76,21,95};
        int[] arr = {8,2,3,5,10,7,19,4,14};

//      快速选择算法：从数组中找出排名第k位的元素，并输出。
//      eg: 从数据中找出排名第2的元素。
        int k = 2;
//      int k = 3;
//      int k = 1;

        int result = quickSelect(arr, 0, arr.length-1, k);

        System.out.println("排名第" + k +  "位的元素值为：" + result + "\n");

        System.out.println("此时数组的内容为：" + Arrays.toString(arr
        ));
    }

    public static void swap(int[] nums, int i, int j ) {
        if(i == j) {
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 快速排序的核心思想是找到排名第k位置的元素， 所以仅需保证前k-1的元素比k位置的元素小即可，
     * 没有必要对整个数组进行全部的排序
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return  返回的是排名第K位置的元素值。
     */

    public static int quickSelect(int[] nums, int left, int right, int k) {
        if(left > right) {
            return 0;
        }

        while (left < right) {
            int privot = nums[left];

            while (left < right && nums[right] >= privot) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && nums[left] <= privot) {
                left++;
            }

            nums[right] = privot;
        }

//      完成了第一轮比较，此时left和right相等，均指向第一个轴枢元素。即ind = left = right
        int ind = left;
        if(ind == k - 1) {
            return nums[ind];
        } else if (ind < k - 1) {
            return quickSelect(nums, ind + 1, nums.length-1, k);
        } else {
            return  quickSelect(nums, 0, ind-1, k);
        }
    }



}
