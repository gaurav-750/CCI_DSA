package BinaryTrees;

import java.util.Stack;

public class NeetCode {
    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        TreeNode<Integer> root = bt.takeInput();
        bt.printBinaryTree(root);

//        todo https://leetcode.com/problems/binary-tree-inorder-traversal/
//        inorderTraversal(root);

//        todo https://leetcode.com/problems/binary-tree-preorder-traversal/
//        preorderTraversal(root);

//        todo https://leetcode.com/problems/binary-tree-postorder-traversal/
//        postorderTraversal(root);

//        todo https://leetcode.com/problems/invert-binary-tree/
        bt.printBinaryTree(invertBinaryTree(root));


    }

    private static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root) {
//        base case
        if (root == null) return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode<Integer> leftNode = invertBinaryTree(root.left);
        TreeNode<Integer> rightNode = invertBinaryTree(root.right);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    private static void postorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack1 = new Stack<>(), stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            //pop from stack1
            TreeNode<Integer> node = stack1.pop();

            stack2.push(node);
            if (node.left != null)
                stack1.push(node.left);
            if (node.right != null)
                stack1.push(node.right);
        }

        while (!stack2.isEmpty())
            System.out.print(stack2.pop().data + " ");
    }

    private static void preorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode<Integer> cur = stack.pop();
            System.out.print(cur.data + " ");

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    //    Iterative Approach
    private static void inorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = root;

        while (cur != null || stack.size() > 0){
            //push all the left into the stack
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode<Integer> top = stack.pop();
            System.out.print(top.data + " ");
            cur = top.right;
        }
    }


}
