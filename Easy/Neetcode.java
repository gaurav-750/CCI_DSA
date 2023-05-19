package Easy;

import BinaryTrees.BinaryTree;
import BinaryTrees.TreeNode;
import LinkedList.Linked_List;
import LinkedList.Node;

import java.util.*;

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/maximum-subarray/
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println("Max SubArray sum: " + maximumSubArray(nums));

//        todo https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//        int[] arr = {2,7,11,15};
//        twoSum2(arr, 9);

//        todo https://leetcode.com/problems/house-robber/
//        int[] houses = {5,1,8,10,1,3};
//        System.out.println("Maximum possible robbery: " + houseRobber(houses));

//        todo https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println("Max Profit: " + maxProfit(prices));

//        todo https://leetcode.com/problems/climbing-stairs/
//        System.out.println("Number of ways to climb the stairs: " + climbingStairs(5));

//        todo https://leetcode.com/problems/palindrome-linked-list/
//        Node<Integer> head = linkedListInput();
//        isLinkedListPalindrome(head);

//        todo https://leetcode.com/problems/invert-binary-tree/
        BinaryTree bt = new BinaryTree();
//        TreeNode<Integer> root = bt.takeInput();
//        bt.printBinaryTree(invertBinaryTree(root));

//        todo https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//        int[] arr = {17,18,5,4,6,1};
//        System.out.println("Replace Elements: " + Arrays.toString(replaceElements(arr)));

//        todo https://leetcode.com/problems/merge-two-binary-trees/
//        TreeNode<Integer> root1 = bt.takeInput();
//        TreeNode<Integer> root2 = bt.takeInput();
//        bt.printBinaryTree(mergeTwoBinaryTrees(root1, root2));

//        todo https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//        TreeNode<Integer> root = bt.takeInput();
//        lcaOfBST(root, new TreeNode<>(2), new TreeNode<>(6));

//        todo https://leetcode.com/problems/happy-number/description/
//        isHappyNumber(19);

//        todo https://leetcode.com/problems/search-insert-position/
//        int[] arr = {1,3,5,6};
//        System.out.println("Insert Position: " + insertPosition(arr, 7));

//        todo https://leetcode.com/problems/last-stone-weight/
//        int[] stones =  {2,7,4,1,8,1};
//        System.out.println("Last stone weight: " + lastStoneWeight(stones));

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(nums));

//        todo https://leetcode.com/problems/ugly-number/
//        System.out.println("Is Ugly Number: " + isUglyNumber(6));

//        todo https://leetcode.com/problems/length-of-last-word/
//        String str =  "   fly me   to   the moon  ";
//        System.out.println("Length of last word: " + lengthOfLastWord(str));




    }

    private static int lengthOfLastWord(String str) {
        str = str.trim();
        System.out.println("str = " + str);

        String[] words = str.split("\\s+");
        System.out.println(Arrays.toString(words));
        return words[words.length-1].length();
    }

    private static boolean isUglyNumber(int n) {
        if (n <= 0)
            return false;
        List<Integer> list = Arrays.asList(2,3,5);

        for (int primeFactor : list){
            while (n % primeFactor == 0)
                n = n/primeFactor;
        }
        return n == 1;
    }

    private static int removeDuplicates(int[] nums) {
        int l = 0, r = 0;

        while (r < nums.length){
            while (r < nums.length-1 && nums[r] == nums[r+1])
                r++;

            nums[l] = nums[r];
            l++;
            r++;
        }
        return l;
    }

    private static int lastStoneWeight(int[] stones) {
        //Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> b-a
        );
        for (int stone: stones)
            pq.add(stone);

        while (!pq.isEmpty() && pq.size() != 1){
            int y = pq.poll();
            int x = pq.poll();

            if (y != x)
                pq.add(y-x);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

    private static int insertPosition(int[] arr, int x) {
        int l = 0, r = arr.length-1;

        while (l <= r){
            int mid = (l+r)/2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }

    private static boolean isHappyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)){
            set.add(n);
            System.out.println(set);

            n = sumOfSquares(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n != 0){
            int rem = n%10;
            sum += (rem*rem);
            n /= 10;
        }
        return sum;
    }

    private static TreeNode<Integer> lcaOfBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        //base case
        if (root.data == p.data || root.data == q.data)
            return root;

        if (p.data < root.data && q.data < root.data){
            return lcaOfBST(root.left, p, q);
        }else if (p.data > root.data && q.data > root.data)
            return lcaOfBST(root.right, p, q);
        else
            return root;
    }

    private static TreeNode<Integer> mergeTwoBinaryTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
//        base case
        if (root1 == null && root2 == null)
            return null;


        TreeNode<Integer> root;
        if (root1 != null && root2 != null){
            root = new TreeNode<>(root1.data + root2.data);
            root.left = mergeTwoBinaryTrees(root1.left, root2.left);
            root.right = mergeTwoBinaryTrees(root1.right, root2.right);
        }else if (root1 != null){
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

    private static int[] replaceElements(int[] arr) {
        int maxTillNow = -1;

        for (int i = arr.length-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxTillNow;
            maxTillNow = Math.max(maxTillNow, temp);
        }
        return arr;
    }

    private static Node<Integer> linkedListInput() {
        Linked_List ll = new Linked_List();
        Node<Integer> head = ll.takeInput();
        ll.printLL(head);
        return head;
    }

    private static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root) {
//        base case
        if (root == null)
            return null;


        TreeNode<Integer> left = invertBinaryTree(root.left);
        TreeNode<Integer> right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    private static boolean isLinkedListPalindrome(Node<Integer> head) {
        if (head == null || head.data == null)
            return true;

        //find the mid of the Linked List and reverse it
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) //for odd length LL
            slow = slow.next;

        Node<Integer> head2 = reverseLinkedList(slow);
        while (head2 != null){
            if (head.data != head2.data)
                return false;

            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> past = null,
                    present = head,
                    future = head.next;

        while (present != null){
            present.next = past;
            past = present;
            present = future;

            if (future != null)
                future = future.next;
        }
        return past;
    }

    private static int stairsHelper(int n, int[] arr) {
//        base case
        if (n == 1 || n == 2)
            return n;
        if (arr[n] != -1)
            return arr[n];


        //take 1 step
        int step1 = stairsHelper(n-1, arr);
        //take 2 step
        int step2 = stairsHelper(n-2, arr);

        arr[n] = step1 + step2;
        return arr[n];
    }

    private static int climbingStairs(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);

        return stairsHelper(n, arr);
    }

    private static int maxProfit(int[] prices) {
        int i = 1, max = 0, buy = prices[0];

        while (i < prices.length){
            int todaysPrice = prices[i];
            if (todaysPrice - buy > max) // if sold today
                max = todaysPrice - buy;

            if (buy > todaysPrice)
                buy = todaysPrice;
            i++;
        }
        return max;
    }

    private static int houseRobber(int[] houses) {
        int[] arr = new int[houses.length];
        Arrays.fill(arr, -1);
        return Math.max(houseRobberHelper(0, houses, arr), houseRobberHelper(1, houses, arr));
    }

    private static int houseRobberHelper(int i, int[] houses, int[] arr) {
//        base case
        if (i >= houses.length)
            return 0;

        if (arr[i] != -1) //DP
            return arr[i];

        if (i == houses.length-2 || i == houses.length-1) {
            arr[i] = houses[i];
            return houses[i];
        }


        int r1 = houseRobberHelper(i+2, houses, arr);
        int r2 = houseRobberHelper(i+3, houses, arr);

        arr[i] = houses[i] + Math.max(r1, r2);
        return arr[i];
    }

    private static int[] twoSum2(int[] arr, int target) {
        int i = 0, j = arr.length-1;

        while (i < j){
            int curSum = arr[i] + arr[j];

            if (curSum == target)
                return new int[]{i+1, j+1};
            else if (curSum > target)
                j--;
            else //curSum < target
                i++;
        }
        return new int[]{-1,-1};
    }

    private static int maximumSubArray(int[] nums) {
        int i = 0, cur = 0, max = Integer.MIN_VALUE;

        while (i < nums.length){
            cur += nums[i];
            max = Math.max(max, cur);
            if (cur < 0)
                cur = 0;

            i++;
        }
        return max;
    }
}
