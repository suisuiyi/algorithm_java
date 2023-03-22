package leetcode.day07;

public class SearchInsert {
    public static void main(String[] args) {
        //35. 搜索插入位置
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;

//        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsertYouhua(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        //1、存在，返回索引
        //2、不存在，顺序插入，并返回索引
        //3、考虑、头尾部插入问题
        int i;
        boolean isExist = true;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i == nums.length - 1) {
                isExist = false;
            }
        }


        if (!isExist) {
            for (i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;

                }
            }

        }

        return nums.length;

    }

    public static int searchInsertYouhua(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;

    }
}
