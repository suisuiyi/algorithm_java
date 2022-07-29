package leetcode.day10;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalSelf {

    public static void main(String[] args) {

        //左子树、根节点、右子树
        //递归的终止条件是遇到node为空
        //递归的时候，需要将每个值放置到List中

        TreeNode root1 = new TreeNode(2);
        root1.left = null;
        TreeNode root2 = new TreeNode(3);
        root1.right = root2;
        root2.left = new TreeNode(5);

        List<Integer> result = inorderTraversal(root1);

        for (Integer i : result) {
            System.out.println(i);
        }
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();  //用于保存结果
        digui(root, result);
        return result;

    }

    public static void digui(TreeNode node, List<Integer> res) {

        if (node == null) {
            return;
        }
        digui(node.left, res);  //递归左子树
        res.add(node.val);  //放进去根节点
        digui(node.right, res); //递归右子树
    }

}
