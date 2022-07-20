package leetcode.day04;

public class MergeTwoListsSelf {
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

        ListNode listNode = mergeTwoListsSelf(list1, list4);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode mergeTwoListsSelf(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1 == null && list2 == null) {
            return null;
        }

        ListNode headNode = new ListNode(-1);
        ListNode cur = headNode;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;

        }

        if(list1 == null) {
            cur.next = list2;
        }
        if(list2 == null) {
            cur.next = list1;
        }


        return headNode.next;

    }
}
