package leetcode.day11;

import leetcode.day11.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {
        //思路： 遍历所有的节点，然后所有的节点均相同，则两棵树相同。否则不同
        //1、如果两个树都为空，则相同
        //2、如果任意一个为空且另一个不为空，则不相同
        //3、如果两个都不为空，则进行后续比较

        //测试数据一
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        boolean result = isSameTree(node1, node1);
        System.out.println(result);


        //测试数据二
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);

        node4.left = node5;
        node4.right = node6;

        boolean result01 = isSameTree(node1, node4);
        System.out.println(result01);



    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }
        //递归比较左节点的值，右节点的值
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
