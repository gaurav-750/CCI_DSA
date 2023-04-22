package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        BinaryTreeNode<Integer> root = bt.takeInput();
        bt.printBinaryTree(root);

//        todo Preorder Traversal
//        preOrder(root);
//        System.out.println();

//        todo Inorder Traversal
//        inOrder(root);
//        System.out.println();

//        todo PostOrder Traversal
//        postOrder(root);

//        todo Level Order Traversal
        levelOrder(root);



    }

    private static void levelOrder(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            ArrayList<BinaryTreeNode<Integer>> list = new ArrayList<>();
            while (!queue.isEmpty()){
                BinaryTreeNode<Integer> frontNode = queue.poll();
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null)
                    list.add(frontNode.left);
                if (frontNode.right != null)
                    list.add(frontNode.right);
            }
            System.out.println();
            queue.addAll(list);
        }
    }

    private static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
