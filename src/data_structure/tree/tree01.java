package data_structure.tree;

import java.util.LinkedList;
import java.util.Stack;

import static java.util.Arrays.asList;
import static java.util.Arrays.setAll;

/*

  借助栈来实现二叉树的前、中、后序遍历。

 */
public class tree01 {

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

    public static void preOrderTraveralWithStack(TreeNode root) {
//      创建一个栈，用于盛放所有的节点元素
//      利用进栈和出栈遍历元素

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode treeNode = root;

//      当根节点有值或者栈不空的时候，进行遍历
//      通过入栈这个操作，进行元素的遍历
        while(treeNode != null || !stack.isEmpty()) {
//           迭代访问节点的左孩子，并入栈
//           treeNode 如果不为空，代表树还有值没有被遍历
            while(treeNode != null) {
//              打印根节点的值
                System.out.println(treeNode.data);
//              根节点入栈
                stack.push(treeNode);
//              根节点的左孩子入栈
                treeNode = treeNode.leftChildNode;
            }
//           如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()) {
//              返回出栈的元素
                treeNode = stack.pop();
                treeNode = treeNode.rightChildNode;
            }
        }
    }

    public static void midOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()){

            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChildNode;

            }
            if(!stack.isEmpty()) {
                treeNode =  stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChildNode;
            }

        }


    }

    /**
     * 后序遍历相对比较复杂，暂停跳过
     * @param root
     */
    public static void postOrderTraveralWithStack(TreeNode root){

    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null,4}));

        TreeNode treeNode = createBinaryTree(inputList);

        System.out.println("前序遍历.....");
        preOrderTraveralWithStack(treeNode);

        //中序遍历是先遍历叶子节点，再遍历根节点，再叶子节点
        System.out.println("中序遍历.....");
        midOrderTraveralWithStack(treeNode);

        //后序遍历是先遍历左子树所有的叶子，在遍历根节点
        System.out.println("后序遍历.....");
        postOrderTraveralWithStack(treeNode);














    }


}
