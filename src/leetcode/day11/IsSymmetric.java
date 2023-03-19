package leetcode.day11;

import java.util.LinkedList;

public class IsSymmetric {
    public static void main(String[] args) {
        //思路分析：
        // 问题拆解：
        //1. 如果所给根节点为空，那么是对称的
        //2. 如果所给的根节点不为空，则需要判断左右的子树是否相等？  ==>3


        //3. 如何判断左右子树是否相等呢？  （===> 如果判断左右子树是否不相等呢？）

        //4. 左子树的左节点  == 右子树的右节点  且 左子树的右节点 == 右子树的左节点   ===> 好绕啊？？

        //递归点出现： 判断左右子树是否相等  <==>左右子树的子节点对称情况

        //时间复杂度O(n): 需要遍历n个节点
        //空间复杂度O(n): 需要递归的深度，也即树的深度，最坏的情况下树变成一个链表，高度是n。

        //构建测试数据
        /**
         *
         *              1
         *         2        2
         *     3      4    4     3
         *
         *
         * */

        TreeNode root = new TreeNode(1);
        TreeNode node02 = new TreeNode(2);
        TreeNode node03 = new TreeNode(2);
        TreeNode node04 = new TreeNode(3);
        TreeNode node05 = new TreeNode(4);
        TreeNode node06 = new TreeNode(4);
        TreeNode node07 = new TreeNode(3);

        root.left = node02;
        root.right = node03;

        node02.left = node04;
        node02.right = node05;

        node03.left = node06;
        node03.right = node07;


        boolean result = isSymmetric(root);

        System.out.println(result);



    }




    //方法一： 递归实现
    public static boolean isSymmetric(TreeNode root) {
        //1. 根节点为空，返回true
        if(root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        boolean result = isSymmetricMore(left, right);

        return result;

    }

    public static boolean isSymmetricMore(TreeNode left, TreeNode right) {
        //递归终止条件是： 1、两个节点都为空了、 2、其中仅一个为空  3、对应的值不相等

        //2. 根节点不空（仅有根节点），子节点全空
        if (left == null && right == null) {
            return true;
        }


        //3.其中一个节点为空，另一个节点不为空，返回false

        if(left == null || right == null) {
            return false;
        }

        //4. 一个节点的对称位置的值不同，返回false
        if(left.val != right.val) {
            return false;
        }

        return isSymmetricMore(left.left, right.right) && isSymmetricMore(left.right, right.left);
    }
    //方法二：队列实现
    //思路： 每遍历一层，然后将该成的数据放入队列，然后通过出队列，进行数据比较。
    //注意放入的时候，左子树：现放左节点，后放右节点。 右子树：先放右节点，再放左节点

    public static boolean isSymmetricByQueue(TreeNode root) {
        //1.构造队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (queue.size() > 0) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            if(left.val != right.val) {
                return false;
            }
            //将左节点的左孩子，右节点的有孩子放入队列

        }


        return false;


    }
}
