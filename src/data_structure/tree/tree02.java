package data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.util.Arrays.asList;

/*
  --广度优先遍历---
  借助队列来实现二叉树的层级遍历。

 */
public class tree02 {

    /**
     * 定义一个Node
     *
     */
    public static class TreeNode {
        int data;
        TreeNode leftChildNode;
        TreeNode rightChildNode;

        TreeNode(int data) {
            this.data = data;
        }

    }

    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        TreeNode  treeNode= null;

        while(linkedList == null || linkedList.isEmpty()) {
            return  null;
        }

        Integer data = linkedList.removeFirst();

        if (data != null) {
            treeNode = new TreeNode(data);

            treeNode.leftChildNode = createBinaryTree(linkedList);
            treeNode.rightChildNode = createBinaryTree(linkedList);
        }

        return treeNode;
    }


    public static void levelOrderTarveral(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);

            if(node.leftChildNode != null) {
                queue.offer(node.leftChildNode);
            }

            if(node.rightChildNode != null) {
                queue.offer(node.rightChildNode);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null,4}));

        TreeNode treeNode = createBinaryTree(inputList);
//      预期输出值为： 3、2、8、9、10、4
        levelOrderTarveral(treeNode);

    }


}

