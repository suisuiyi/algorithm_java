public class quick_select {
    public static void main(String[] args) {
        int[] arr = {8,5,9,3,6,4,10,2,7};
        int k = quickSelect(arr, 0, arr.length-1, 5);
        System.out.println(k);
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
        if (left > right) {
            return 0;
        }

        int i = left; int j = right;


        while (i < j) {

            while(i < j && nums[j] > nums[left]) {
                j--;
            }


            while (i < j && nums[i] <= nums[right]) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }

        }
        swap(nums, left, i);
        if(k == i - left + 1) {
            return nums[i];
        }
        else if(k < i - left + 1) {
            return quickSelect(nums, left, i-1, k);
        }
        else  {
            return  quickSelect(nums, i+1, right, k-(i - left + 1));
        }
    }



}
