package data_structure.tree;

import java.util.Arrays;

public class binaryHeap {
    /*
    使用数组构建一个二叉堆
    * */



    /**
     * "下沉调整": 父节点如果比子节更小的那个  小的话，下沉
     *
     * @param array 要调整的堆
     * @param parentIndex 要调整的父节点
     * @param length 堆的元素的个数
     */


    public static void downAdjust(int[] array, int parentIndex, int length) {
//      拿到父节点的值
        int temp = array[parentIndex];

//      计算该父节点左孩子节点的索引
        int leftChildIndex = 2 * parentIndex + 1;
//        int rightChildIndex = 2 * parentIndex + 2;
//      int rightChildIndex = leftChildIndex + 1;
//      开始循环：左孩子的索引小于堆的大小的时候，开始循环
        while (leftChildIndex < length) {
//           如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(leftChildIndex + 1 < length && array[leftChildIndex + 1] < array[leftChildIndex]) {
                leftChildIndex++;
            }
//          如果父节点大于任何一个孩子节点的话，执行交换，下沉。
//          如果父节点小于任何一个孩子的话，跳出当前循环。
            if(temp <= array[leftChildIndex])
                break;
//          子节点与父节点交换
            swap(array, parentIndex, leftChildIndex);
        }

    }

    /**
     * 上浮，是叶子节点，一个一个遍历，
     * @param array 仅需提供一个堆即可。
     */

    public static void upAdjust(int[] array) {
//      先获取一个最后的一个父节点的右孩子
        int rightChildIndex = array.length - 1;
//      首次计算插入叶子节点的父节点
        int parentIndex = (rightChildIndex - 2) /2;

//      进入上浮循环的条件是 左右孩子比父节点的值要小
        while(rightChildIndex > 0 && array[rightChildIndex] < array[parentIndex]) {
            swap(array, rightChildIndex, parentIndex);
//          父节点要重新算
        }


    }


    public static void buildHeap(int[] array) {
//      从最后一个（非叶子节点）开始， 依次做下沉处理
//
/**
 * Q1： 如何找的最后的一个父节点？？
 * 问题分析：
 * 根据已有知识，堆中最后一个元素（右孩子）的位置的索引为
 *  rightChildIndex = 2 * parentIndex + 2
 *
 *
 *  rightChildIndex = array.length - 1;
 *  代如上述公式，可以得出第一个父节点
 *
 *  parentIndex = (array.length -1 - 2) / 2
 *
 *  因为是数组排列，经观察，第一个父节点前面的元素都是父节点了
 *  所以i 开始的值是 = (array.length -1 -2) / 2
 *  后续可以使用i--  继续找父节点了。
 *
 *
 */

        for(int i = (array.length -1 -2) /2; i>=0; i--) {
            downAdjust(array, i, array.length);
        }
    }


    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println("上浮后的结果是：");
        System.out.println(Arrays.toString(array));

        array = new int[] {7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

    }

}
