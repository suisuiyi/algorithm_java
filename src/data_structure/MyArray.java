package data_structure;

import java.util.Arrays;

public class MyArray {

    private int[] array;
    private  int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);
        try {
            myArray.insert(1,0);
            myArray.insert(3,1);
            myArray.insert(4,2);
            myArray.insert(5,3);
            myArray.outputArray(myArray);
//          将2插入到第二个位置上
            myArray.insert(2, 1);
            myArray.outputArray(myArray);


//          将数据6添加到数组中
            myArray.insert(6,5);
            myArray.outputArray(myArray);

//          删除第6个元素
            myArray.delete(5);
            myArray.outputArray(myArray);

//          删除第2个元素
            myArray.delete(1);
            myArray.outputArray(myArray);






        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//  Q1: 用代码实现数组的插入?

//  数组的插入，存在三种场景：
//  1、尾部插入： 直接将索引的值赋值即可,比如空数组中添加一位元素;  已有一位元素的情况下，追加一位元素。
//  2、中间插入： 需要将插入位置的元素及以后的元素整体后移一位，再插入元素
//  3、超范围插入： 当数组已被占满时，需要再次申请空间，复制后插入.
//  超范围插入的时间复杂度：扩容的复杂度为O(n),插入和移动的复杂度也是O(n) 综合起来的负责为O(n)




//  中间插入
    public void insert(int element, int index) throws Exception{
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际范围");
        }
//      如果实际元素达到数组容量上限，即数组已满
        if (size == array.length) {
            resize();
        }

        for(int i = size-1; i >= index; i--) {
            array[i+1] = array[i];
        }

        array[index] = element;

        size++;


    }
//   数组的删除操作
//   将删除位置后的元素不停向前移动，进行覆盖
//   删除的时间复杂度为O(n)

//   数组的优势在于查找，劣势是插入和删除
//   因为插入和删除导致大量的元素被移动，影响效率

    public void delete(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际范围");
        }
        for(int j = index; j < size; j++) {
            array[j] = array[j+1];

        }

    }


//       数组扩容
    public void resize(){
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array,0 ,newArray, 0, array.length);
        array = newArray;

    }




    public void outputArray(MyArray array) {
        System.out.println(Arrays.toString(array.array));
    }

    
}
