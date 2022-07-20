package leetcode.day04;

import java.util.List;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(4);
        list1.next = list2;
        list2.next = list3;


        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(3);
        ListNode list6 = new ListNode(5);
        list4.next = list5;
        list5.next = list6;

        /**
         *
         * 思路：
         * 1、先创建一个node = node(0)
         * 2、比较list1 和list2的值，取其中小的放在node的next
         *
         * */
        ListNode listNode = mergeTwoLists(list1, list4);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {



        //1、考虑异常情况: 两个list其中之一存在为空的情况

        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1 == null && list2 == null) {
            return null;
        }

        //2、正常情况处理
        //   考虑链表长度不一致的情况


        ListNode firstHead = new ListNode(0);

        ListNode cur = firstHead;
        //因为链表的最后一个元素如果为null. 则代表链表结束了。
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                //刚开始将虚拟节点的指向list1
                // 将比较小的值赋值到cur中
                cur.next = list1;
                // list1 替换成下一个元素,然后进行后续的比较
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            //这个我没看懂!!
            // cur = cur.next一直是跟随的比较小的值
            // 是将2个链表中比价小的值，接到新的链表中。然后一定链表的位置，才能接入下一个元素。
            cur = cur.next;

        }

        //list1 遍历结束了，直接接上list2即可
        if(list1 == null) {
            cur.next = list2;
        }
        //list2 遍历结束了，直接接上list1即可
        if(list2 == null) {
            cur.next = list1;
        }

        return firstHead.next;
    }
}
