package data_structure.tree;

import java.util.LinkedList;

import static java.util.Arrays.asList;

/*


  1、使用链表生成一个树，并使用递归的方式进行前、中、后序遍历


* */

public class tree {

//  1、定义一个二叉树的节点： 1、数据、2、左孩子  3、右孩子

    private static class  TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightCHild;

        TreeNode(int data) {
            this.data = data;
        }
    }

//  2、生成一个树： 使用一个链表来生成一个树

    /**
     *
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
//      输入的链表为空，或者不存在，则返回null
        if((inputList == null) || inputList.isEmpty()) {
            return  null;
        }
//      ? 为啥要移除第一个元素
//      removes and returns the first element from this lis
//      data 表示是链表的第一个元素萨
        Integer data = inputList.removeFirst();
        if(data != null) {
//          使用第一个元素创建一个根节点
            node = new TreeNode(data);
//          根节点的的左孩子使用inputList的第2个元素
            node.leftChild = createBinaryTree(inputList);
//          根节点的右孩子使用inputList的第3个元素
            node.rightCHild = createBinaryTree(inputList);
        }

        return  node;
    }

    /**
     *  二叉树的前序遍历
     * @param node  二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }

        System.out.println(node.data);

//      递归调用
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightCHild);
    }

    /**
     * 中序遍历: 左子树、根节点、右子树
     * @param node
     */
    public static void midOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        midOrderTraveral(node.leftChild);
        System.out.println(node.data);
        midOrderTraveral(node.rightCHild);


    }

    /**
     * 后序遍历： 左子树、右子树、根节点
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }

        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightCHild);
        System.out.println(node.data);
    }




    public static void main(String[] args) {
//        LinkedList<Integer> inputList = new LinkedList<Integer>(asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null,4}));
        LinkedList<Integer> inputList = new LinkedList<Integer>(asList(new Integer[]{3, 2, 9, 8, 6, 10, 1, 7,  5,4}));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历：...");
        preOrderTraveral(treeNode);


        System.out.println("中序遍历: ...");
        midOrderTraveral(treeNode);


        System.out.println("后续遍历: ...");
        postOrderTraveral(treeNode);


    }


}
