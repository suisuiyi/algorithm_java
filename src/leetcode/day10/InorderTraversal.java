package leetcode.day10;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
        //思路：递归解法
        //将左子树、根节点，右子树。一层一层拆分。天然符合递归的思路
        //递归的结束条件是 节点不存了。即node = null



        TreeNode root1 = new TreeNode(1);
        root1.left = null;
        TreeNode root2 = new TreeNode(2);
        root1.right = root2;
        root2.left = new TreeNode(3);

        List<Integer> result =  inorderTraversal(root1);

        for(Integer i: result) {
            System.out.println(i);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }

    public static  void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
