package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Diam{
    int diam;
    int height;

    public Diam(int diam, int height){
        this.diam = diam;
        this.height = height;
    }
}

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
//        levelOrder(root);

//        todo Count number of nodes in Binary Tree
//        System.out.println("Number of nodes: " + countNodes(root));

//        todo Sum of nodes in Binary Tree
//        System.out.println("Sum of nodes: " + sumOfNodes(root));

//        todo Height of Binary Tree
//        System.out.println("Height: " + heightOfBTree(root));

//        todo https://leetcode.com/problems/diameter-of-binary-tree/
//        System.out.println("Diameter of Binary Tree: " + diameterOfBTree(root));
//        System.out.println("Diameter of Binary Tree: " + diameter(root).diam);

//        todo https://leetcode.com/problems/subtree-of-another-tree/
        BinaryTreeNode<Integer> subRoot = bt.takeInput();
        System.out.println("Is SubTree: " + isSubTree(root, subRoot));


    }

    private static boolean isSubTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
        if (subRoot == null) return true;
        if (root == null)
            return false;
        
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)){
                return true;
            }
        }
        
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isIdentical(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
//        base case
        if (root == null && subRoot == null)
            return true;
        if (subRoot == null || root == null || root.data != subRoot.data)
            return false;

        return root.data == subRoot.data &&
                isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    private static Diam diameter(BinaryTreeNode<Integer> root) {
//        base case
        if (root == null)
            return new Diam(0,0);

        Diam leftObj = diameter(root.left);
        Diam rightObj = diameter(root.right);

        int d = leftObj.height + rightObj.height + 1;
        int h = Math.max(leftObj.height, rightObj.height) + 1;
        int maxD = Math.max(Math.max(leftObj.diam, rightObj.diam), d); //return the max Diameter until this node
        return new Diam(maxD, h);
    }

    private static int diameterOfBTree(BinaryTreeNode<Integer> root) {
//        base case
        if (root == null) return 0;

        int leftDiameter = diameterOfBTree(root.left);
        int rightDiameter = diameterOfBTree(root.right);
        int rootDiameter = heightOfBTree(root.left) + heightOfBTree(root.right) + 1;

        return Math.max(Math.max(leftDiameter, rightDiameter), rootDiameter);
    }

    private static int heightOfBTree(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;

        return Math.max(heightOfBTree(root.left), heightOfBTree(root.right)) + 1;
    }

    private static int sumOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return root.data;

         return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    private static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
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
