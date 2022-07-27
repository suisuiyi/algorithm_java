package leetcode.day09;

import com.sun.tools.javac.util.List;

public class DeleteDuplicates {

    public static void main(String[] args) {

        //83. 删除排序链表中的重复元素
        //思路： 存储下第一个NodeA，然后与后续的值进行比较，直至遇到不相同元素B。
        //然后的A.next指向B。然后从B开始新一轮的循环
        //如果A.val = A.next.val 则  A.next = A.next.next。
        //如果不相同，则A = A.next 走到下一个值（移动指针的位置）


        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode listNode = deleteDuplicates(listNode1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        //空值
        if(head == null) {
            return null;
        }

        //只有一个值
        if(head.next == null) {
            return head;
        }
        //使用引用保存头指针的位置，然后用于遍历
        ListNode cur = head;

        while (cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;

    }


}
