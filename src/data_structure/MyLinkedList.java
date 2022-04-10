package data_structure;

public class MyLinkedList {
//  头节点指针
    private Node head;
//  尾节点指针
    private Node tail;
//  链表长度
    private int size;


    public static void main(String[] args)  throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.outPut();
        System.out.println("开始删除元素值....");
        System.out.println("删除头部元素值....");
        myLinkedList.delete(0);
        myLinkedList.outPut();
        System.out.println("删除尾部元素值....");
        myLinkedList.delete(3);
        myLinkedList.outPut();
        System.out.println("删除中间元素值....");
        myLinkedList.delete(1);
        myLinkedList.outPut();


    }

//  实现链表的插入元素
//  插入链表的场景分析：
//  1、链表为空
//  2、链表头部插入
//  3、链表尾部插入
//  4、链表中间插入

    public void insert(int data, int index) throws Exception {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出节点范围");
        }

        Node insertNode = new Node(data);

        if(size == 0) {
//          空链表: 头尾节点均赋值为插入的节点
            head = insertNode;
            tail = insertNode;
        } else if(index ==0) {
//            头部插入：插入节点的指针指向头节点；原来的头指针指向被插入的元素。
            insertNode.next = head;
            head = insertNode;
        } else if(index == size) {
//            尾部插入：尾节点的指针指向被插入元素;
//            尾节点变为被插入元素
            tail.next = insertNode;
            tail = insertNode;


        } else {
            //插入中间
            Node preNode = get(index-1);

            insertNode.next = preNode.next;

            preNode.next = insertNode;


        }

        size++;

    }


    public Node delete(int index) throws Exception {

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
//      删除同样有三种情况：
//      1、尾部删除
//      2、头部删除
//      3、中间删除
//      要被移除的元素
        Node removeNode = null;
        if(index == size -1) {
            //尾部删除
            Node preNode = get(index-1);

            tail = preNode;

//          要删除元素处理赋值
            removeNode = preNode.next;
            preNode.next = null;
        } else if (index == 0) {
//          头部删除
            removeNode = head;
            head = head.next;
        } else {
//            中间删除

            Node preNode = get(index-1);
            removeNode = preNode.next;

            Node nextNode = preNode.next.next;

            preNode.next = nextNode;
        }

        size--;

        return removeNode;
    }

    /**
     * 链表查找元素： 根据索引返回要插入位置的前一个元素。
     * @param index
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node temp = head;
//      不停的连着链表找到要插入位置的元素Node
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * 输出链表的内容
     */
    public void outPut(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }




//  定义链表的节点
    private static class Node {
        int data;
//      指针位置
        Node next;
//      初始化节点
        Node(int data) {
            this.data = data;
        }
    }

}
