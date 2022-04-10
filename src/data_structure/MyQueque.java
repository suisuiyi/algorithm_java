package data_structure;

//   使用数组实现队列

/**
 * 问题分析：
 * 1.声明一个数组存储数据
 * 2.声明两个变量标识队头和对尾
 *
 * 3. 实现入队的方法
 *
 * 4. 实现出队的方法
 *
 */

public class MyQueque {
    private int[] array;
    private int front;
    private int rear;

    public MyQueque(int capacity) {
        this.array = new int[capacity];
    }

    public static void main(String[] args) throws Exception{
        MyQueque queque = new MyQueque(10);
        System.out.println("队顶为：" + queque.front + " 队尾为： "  + queque.rear);
        queque.inQueue(1);
        queque.inQueue(2);
        queque.inQueue(3);
        queque.inQueue(4);
        queque.inQueue(5);
        System.out.println("入队后的元素值：");
        queque.outPut();
        System.out.println("出队一次后元素值：");
        queque.outQueue();
        queque.outPut();

    }

    /**
     * 元素入队： 队尾放入元素
     * ！！！ 放队列满的时候，而前面元素有出队列的时候，需要将队尾的指针执行队列前的元素（环形队列）
     * 此时需要 % array.length
     * @param element
     */
    public void inQueue(int element) throws Exception {
//      1. 判断队列是否已满: 画图分析，队尾向后移动一位，会指向队头。
        if((rear + 1) % array.length  == front ) {
            throw new Exception("队列已满");
        }
//      2.放置元素
        array[rear] = element;
//      3.移动队尾
        rear = (rear + 1) % array.length;

    }

    /**
     * 元素出队：队头出元素, 移动队列的头指针
     *
     *
     */
    public void outQueue() throws Exception {
//        1.判断队列是否为空
        if(front == rear) {
            throw new Exception("队列为空, 无法在再进行出队");

        }

        front = (front + 1) % (array.length);


    }

    /**
     * 打印出队列内的所有元素
     */
    public void outPut(){
        for(int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }


}


