package BinaryTrees;

import java.util.Stack;

class Balanced{
    boolean isBalanced;
    int height;

    public Balanced(boolean isBalanced, int height){
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

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
//        bt.printBinaryTree(invertBinaryTree(root));

//        todo https://leetcode.com/problems/maximum-depth-of-binary-tree/
//        System.out.println("Maximum Depth: " + maximumDepth(root));

//        todo https://leetcode.com/problems/balanced-binary-tree/
//        System.out.println("Is Balanced Binary Tree: " +
//                isBalancedBinaryTree(root).isBalanced);

//        todo https://leetcode.com/problems/same-tree/
//        TreeNode<Integer> root2 = bt.takeInput();
//        System.out.println("Is Same Tree: " + isSameTree(root, root2));

//        todo https://leetcode.com/problems/subtree-of-another-tree/description/
//        isSubTree(root, root2);

//        todo https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//        int[] arr = {-10, -3, 0, 5, 9};
//        bt.printBinaryTree(sortArrayToBST(arr));

//        todo https://leetcode.com/problems/merge-two-binary-trees/
//        System.out.println("Merged Tree:");
//        bt.printBinaryTree(mergeTwoBinaryTrees(root, root2));

//        todo https://leetcode.com/problems/path-sum/
//        System.out.println("Has Path Sum: " + hasPathSum(root, 22));

//        todo https://leetcode.com/problems/construct-string-from-binary-tree/description/
//        buildString(root);
//        System.out.println(res);

//        todo https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//        System.out.println("Lowest Common Ancestor: " + lcaOfBinaryTree(root, 4, 5).data);

//        todo https://leetcode.com/problems/insert-into-a-binary-search-tree/
//        bt.printBinaryTree(insertIntoBST(root, 5));

    



    }

    private static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
//        base case
        if (root == null)
            return new TreeNode<>(val);

        if (val < root.data) {//go left
            root.left = insertIntoBST(root.left, val);
            return root;
        }

        //go right
        root.right = insertIntoBST(root.right, val);
        return root;
    }

    private static TreeNode<Integer> lcaOfBinaryTree(TreeNode<Integer> root, int p, int q) {
        if (p == root.data || q == root.data)
            return root;

        if (p < root.data && q > root.data ||
            p > root.data && q < root.data)
            return root;

        if (p < root.data && q < root.data)
            return lcaOfBinaryTree(root.left, p, q);

        // p >= q > root.data
        return lcaOfBinaryTree(root.right, p, q);
    }

    static String res = "";
    private static void buildString(TreeNode<Integer> root) {
//        base case
        if (root == null)
            return;

        res += root.data;
        if (root.left == null && root.right == null) //leaf node
            return;

        res += "(";
        if (root.left != null)
            buildString(root.left);
        res += ")";

        if (root.right != null) {
            res += "(";
            buildString(root.right);
            res += ")";
        }
    }

    private static boolean hasPathSum(TreeNode<Integer> root, int x) {
        return helperHasPathSum(root, 0, x);
    }

    private static boolean helperHasPathSum(TreeNode<Integer> root, int curSum, int x) {
//        base case
        if (root == null)
            return false;

        curSum += root.data;
        //if this is the leaf node, check for sum == x
        if ((root.left == null && root.right == null) &&
                (curSum == x))
            return true;

        if (helperHasPathSum(root.left, curSum, x))
            return true;

        return helperHasPathSum(root.right, curSum, x);
    }

    private static TreeNode<Integer> mergeTwoBinaryTrees(TreeNode<Integer> root1,
                                                         TreeNode<Integer> root2){
//        base case
        if (root1 == null && root2 == null)
            return null;

        TreeNode<Integer> root;
        if (root1 != null && root2 != null){
            root = new TreeNode<>(root1.data + root2.data);
            root.left = mergeTwoBinaryTrees(root1.left, root2.left);
            root.right = mergeTwoBinaryTrees(root1.right, root2.right);
        }else if (root1 != null){ //root2 = null
            root = new TreeNode<>(root1.data);
            root.left = mergeTwoBinaryTrees(root1.left, null);
            root.right = mergeTwoBinaryTrees(root1.right, null);
        }else { //root1 == null && root2 != null
            root = new TreeNode<>(root2.data);
            root.left = mergeTwoBinaryTrees(null, root2.left);
            root.right = mergeTwoBinaryTrees(null, root2.right);
        }

        return root;
    }

    private static TreeNode<Integer> sortArrayToBST(int[] arr) {
        return helperArrayToBST(arr, 0, arr.length-1);
    }

    private static TreeNode<Integer> helperArrayToBST(int[] arr, int l, int r) {
//        base case
        if (l > r)
            return null;
        if (l == r)
            return new TreeNode<Integer>(arr[l]);

        int mid = (l+r)/2;
        TreeNode<Integer> root = new TreeNode<>(arr[mid]);

        root.left = helperArrayToBST(arr, l, mid-1);
        root.right = helperArrayToBST(arr, mid+1, r);
        return root;
    }

    private static boolean isSubTree(TreeNode<Integer> root, TreeNode<Integer> subroot) {
//        base case
        if (root == null)
            return false;

        if (root.data == subroot.data){
            if (isSameTree(root, subroot))
                return true;
        }

        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    private static boolean isSameTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
//        base case
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        boolean isLeftSame = isSameTree(root1.left, root2.left);
        boolean isRightSame = isSameTree(root1.right, root2.right);

        return root1.data == root2.data && (isLeftSame && isRightSame);
    }

    private static Balanced isBalancedBinaryTree(TreeNode<Integer> root) {
//        base case
        if (root == null)
            return new Balanced(true, 0);

        Balanced left = isBalancedBinaryTree(root.left);
        Balanced right = isBalancedBinaryTree(root.right);

        //balance rehne k liye do conditions
        boolean isBalanced = Math.abs(left.height-right.height) <= 1 &&
                (left.isBalanced && right.isBalanced);
        return new Balanced(isBalanced, Math.max(left.height, right.height)+1);
    }

    private static int maximumDepth(TreeNode<Integer> root) {
//        base case
        if (root == null)
            return 0;

        int leftDepth = maximumDepth(root.left);
        int rightDepth = maximumDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
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
