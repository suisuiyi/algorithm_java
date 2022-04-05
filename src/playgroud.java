public class playgroud {

    public static int computeMiddle(int[] nums, int left, int right) {
        int head = nums[left];
        int tail = nums[right];
        int middle;
        int result;
//      如果数组的元素刚好为奇数个;如果为偶数个，则从中间的元素中任选一个，此时选中间值的后一个也可以
//      即middle 的索引为 （right - left + 1）/ 2
        if ((right - left + 1) % 2 == 0) {
            middle = nums[(right - left + 1) / 2  ];
        } else {
            middle = nums[(right - left + 1) / 2 ];
        }
        System.out.println("head: " + head);
        System.out.println("middle: " + middle);
        System.out.println("tail: " + tail);

//      对三个元素进行比较,返回中间的值
        result = compareWithThreeNumbersReturunMiddle(head, middle, tail);
//      返回值对应的索引位置，用于作为轴枢元素分隔数组
        return result;
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return middle中间值
     * 假定a是中间值  (b-a) * (a-c) >= 0;
     *       假定b是中间值  (a-b) * (b-c) >= 0;
     *       假定c是中间值  (a-c) * (c-b) >= 0;
     *
     */
    public static int compareWithThreeNumbersReturunMiddle(int a, int b, int c){

        if((b-a) * (a-c) >= 0) {
            return  a;
        } else if ((a-b) * (b-c) >= 0){
            return b;
        } else {
            return c;
        }

    }
}
