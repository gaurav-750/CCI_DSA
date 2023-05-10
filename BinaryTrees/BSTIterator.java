package BinaryTrees;
import java.util.Stack;

public class BSTIterator{

        Stack<TreeNode<Integer>> stack;

        //constructor
        public BSTIterator(TreeNode<Integer> root) {
                stack = new Stack<>();
                fillStack(root);
        }

        private void fillStack(TreeNode<Integer> root) {
//                base case
                if (root == null)
                        return;
                fillStack(root.right);
                stack.push(root);
                fillStack(root.left);
        }

        public int next() {
                TreeNode<Integer> removedNode = stack.pop();
                return removedNode.data;
        }

        public boolean hasNext() {
                return stack.size() > 0;
        }

}