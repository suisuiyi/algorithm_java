package leetcode.day10;

import apple.laf.JRSUIUtils;

import java.util.*;

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

//        List<Integer> result =  inorderTraversal(root1);
        List<Integer> result =  inorderTraversalByDieDai(root1);

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
        // 中序遍历是先遍历左子树，然后根节点，然后是右子树
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static List<Integer>  inorderTraversalByDieDai(TreeNode root) {
        //迭代思想:就是先遍历所有的左节点，然后将所有的值入栈
        //遇到为空则代表最左的节点遍历完成
        //出栈的时候记录数据元素
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();

        while(root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;

    }
}
