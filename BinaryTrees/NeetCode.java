package BinaryTrees;

import java.util.Stack;

public class NeetCode {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        BinaryTreeNode<Integer> root = bt.takeInput();
        bt.printBinaryTree(root);

//        todo https://leetcode.com/problems/binary-tree-inorder-traversal/
        inorderTraversal(root);

    }

    private static void inorderTraversal(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();

    }


}
