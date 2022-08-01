package leetcode.day11;

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



    }





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

        //2. 根节点不空，子节点全空
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
}
