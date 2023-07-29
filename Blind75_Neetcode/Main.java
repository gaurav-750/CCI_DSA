package Blind75_Neetcode;

import java.util.*;

import BinaryTrees.BinaryTree;
import BinaryTrees.TreeNode;
import LinkedList.Node;


class BSTReturn{
    boolean isBST;
    int min;
    int max;

    public BSTReturn(boolean isBST, int min, int max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}

public class Main {
    public static void main(String[] args) {

        // Date: 22-07-2023
        // 19:00
//        TODO  1.ARRAYS AND HASHING
//        todo  https://leetcode.com/problems/contains-duplicate/
//        int[] nums = {4,5,6,7,0,1,2};
//        containsDuplicate(nums);

//        todo https://leetcode.com/problems/valid-anagram/
//        System.out.println("Is Valid Anagram: " +
//                isValidAnagram("anagram", "nagaram"));

//        todo https://leetcode.com/problems/two-sum/
//        twoSum(nums, 9);


        // Date: 23-07-2023
        // 08:45
//        todo https://leetcode.com/problems/group-anagrams/
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        groupAnagrams(strs);

//        todo https://leetcode.com/problems/top-k-frequent-elements/
//        topKFrequent(nums, 2);

//        todo https://leetcode.com/problems/product-of-array-except-self/
//        productExceptSelf(nums);

//        todo https://leetcode.com/problems/longest-consecutive-sequence/
//        longestConsecutive(nums);

//        todo https://leetcode.com/problems/valid-palindrome/
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println("Is valid palindrome: " + isValidPalindrome(s));

//        todo https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//        System.out.println(Arrays.toString(twoSumSortedArray(nums, 18)));

//        todo https://leetcode.com/problems/3sum/
//        threeSum(nums);

//        todo https://leetcode.com/problems/container-with-most-water/
//        int[] heights = {1,4,8,5,1,6,9,7};
//        maxAreaContainer(heights);

//        todo https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println("Max Profit: " + maxProfit(prices));

//        todo https://leetcode.com/problems/longest-substring-without-repeating-characters/
//        lengthOfLongestSubstring("pwwkew");

//        todo https://leetcode.com/problems/longest-repeating-character-replacement/
//        characterReplacement("AABABBA", 1);


        // Date: 28-07-2023
//        todo https://leetcode.com/problems/valid-parentheses/
//        System.out.println("Is Valid: " + isValid("({}[])"));

//        todo https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//        int[] nums = {1};
//        System.out.println("Min Element: " + findMin(nums));

//        todo https://leetcode.com/problems/reorder-list/
//        Linked_List ll = new Linked_List();
//        Node<Integer> head = ll.takeInput();
//        reorderList(head);

//        todo https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//        ll.printLL(removeNthFromEnd(head, 1));

//        todo https://leetcode.com/problems/invert-binary-tree/
//        BinaryTree obj = new BinaryTree();
//        TreeNode<Integer> root = obj.takeInput();
//        obj.printBinaryTree(invertBinaryTree(root));

//        todo https://leetcode.com/problems/same-tree/
//        TreeNode<Integer> root2 = obj.takeInput();
//        System.out.println("Is same tree: " + isSameTree(root, root2));

//        todo https://leetcode.com/problems/subtree-of-another-tree/
//        System.out.println("Is Sub Root: " + isSubTree(root, root2));

//        todo https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//        TreeNode<Integer> p = obj.takeInput(), q = obj.takeInput();
//        lowestCommonAncestor(root, p, q);

//        todo https://leetcode.com/problems/binary-tree-level-order-traversal/
//        levelOrder(root);

//        todo https://leetcode.com/problems/validate-binary-search-tree/
//        System.out.println(validIsBST(root).isBST);

//        todo https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//        kthSmallestElement(root, 3);

//        todo https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};
//        constructTree(preorder, inorder);

//        todo https://leetcode.com/problems/binary-tree-maximum-path-sum/
//        maxPathSum(root);
//        System.out.println("max = " + max);

//        todo https://leetcode.com/problems/house-robber/
//        int[] money = {1,2,3};
//        System.out.println("Max Rob: " + maxRob(money));

//        todo https://leetcode.com/problems/house-robber-ii/
//        System.out.println("Max Circle House Rob: " + maxRob2(money));

//        todo https://leetcode.com/problems/longest-palindromic-substring/description/
        System.out.println("LPS: " +
                longestPalindromeSubstring("babad"));



    }

    private static String longestPalindromeSubstring(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        //make the diagonal 1 -  as a character is always a palindrome
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        int k = n-1, l = 1;
        int i, j, maxi = 0, maxj = 0;
        //i and j are actual pointers for the string
        while (k >= 0){
            i = 0; j = l;
            while (i < k && j < n){
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i == 1 || dp[i+1][j-1] == 1) { // (j-i == 1) condition is for, if the indices are 1,2 or 2,3
                        dp[i][j] = 1;

                        //update the max palindromic substring
                        if (maxj-maxi+1 < (j-i+1)) {
                            maxi = i;
                            maxj = j;
                        }
                    }
                }
                i++; j++;
            }
            k--; l++;
        }
        return s.substring(maxi, maxj+1);
    }

    private static int maxRob2(int[] money) {
        int[] dp = new int[money.length];
        Arrays.fill(dp, -1);

        int x = circleHouseRob(money, dp, 0, money.length-2);
        Arrays.fill(dp, -1);
        int y = circleHouseRob(money, dp, 1, money.length-1);
        return Math.max(x, y);
    }

    private static int circleHouseRob(int[] money, int[] dp, int i, int n) {
        //base case
        if (i > n)
            return 0;
        if (dp[i] != -1)
            return dp[i];


        int rob = money[i] + circleHouseRob(money, dp, i+2, n);
        int notRob = circleHouseRob(money, dp, i+1, n);

        dp[i] = Math.max(rob, notRob);
        return dp[i];
    }

    private static int maxRob(int[] money) {
        int[] dp = new int[money.length];
        Arrays.fill(dp, -1);

        return maxRobHelper(money, dp, 0);
    }

    private static int maxRobHelper(int[] money, int[] dp, int i) {
        //base case
        if (i >= money.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];


        //rob
        int rob = money[i] + maxRobHelper(money, dp, i+2);

        //do not rob
        int notRob = maxRobHelper(money, dp, i+1);
        dp[i] = Math.max(rob, notRob);
        return dp[i];
    }

    static int max = 0;
    private static int maxPathSum(TreeNode<Integer> root) {
        //base case
        if (root == null)
            return 0;

        int leftSum = maxPathSum(root.left);
        int rightSum = maxPathSum(root.right);

        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);

        max = Math.max(max, root.data+leftSum+rightSum);
        return root.data + Math.max(leftSum, rightSum);
    }

    private static TreeNode<Integer> constructTree(int[] preorder, int[] inorder) {
        return helpConstructTree(preorder, inorder, 0, inorder.length-1, 0, inorder.length-1);
    }

    private static TreeNode<Integer> helpConstructTree(int[] preorder, int[] inorder, int sp, int ep, int si, int ei) {
        //base case
        System.out.println(sp + ", " + ep);
        if (si > ei || sp > ep)
            return null;

        int rootData = preorder[sp];
        int index = findIndexInInorder(inorder, rootData);

        int lenOfSubTree = index - si;
        TreeNode<Integer> root = new TreeNode<>(rootData);

        root.left = helpConstructTree(preorder, inorder, sp+1, sp+lenOfSubTree, si, index-1);
        root.right = helpConstructTree(preorder, inorder, sp+lenOfSubTree+1, ep, index+1, ei);
        return root;
    }

    private static int findIndexInInorder(int[] inorder, int x) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == x)
                return i;
        }
        return -1;
    }

    private static Integer kthSmallestElement(TreeNode<Integer> root, int k) {
        Stack<Integer> stack = new Stack<>();
        buildStack(root, stack);

        int toBeRemoved = stack.size() - k;
        for (int i = 0; i < toBeRemoved; i++)
            stack.pop();
        return stack.peek();
    }

    private static void buildStack(TreeNode<Integer> root, Stack<Integer> stack) {
        //base case
        if (root == null)
            return;

        buildStack(root.left, stack);
        stack.push(root.data);
        buildStack(root.right, stack);
    }

    private static BSTReturn validIsBST(TreeNode<Integer> root) {
        //base case
        if (root == null)
            return new BSTReturn(true, Integer.MAX_VALUE, Integer.MIN_VALUE);


        BSTReturn left = validIsBST(root.left);
        BSTReturn right = validIsBST(root.right);


        boolean isBST = left.isBST && right.isBST;
        if (root.data < left.max || root.data > right.min)
            isBST = false;

        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        return new BSTReturn(isBST, min, max);
    }

    private static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            int n = queue.size();

            while (n != 0){
                TreeNode<Integer> frontNode = queue.poll();
                ans.add(frontNode.data);

                if (frontNode.left != null)
                    queue.add(frontNode.left);
                if (frontNode.right != null)
                    queue.add(frontNode.right);
                n--;
            }
            res.add(ans);
        }
        return res;
    }

    private static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        //base case
        if (root.data == p.data || root.data == q.data)
            return root;

        if (p.data < root.data  && q.data < root.data)
            return lowestCommonAncestor(root.left, p, q);
        if (p.data > root.data && q.data > root.data)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    private static boolean isSubTree(TreeNode<Integer> root, TreeNode<Integer> subRoot) {
        //base case
        if (root == null)
            return false;

        if (root.data == subRoot.data){
            if (isSameTree(root, subRoot))
                return true;
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        //base case
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.data != root2.data)
            return false;

        return isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right);
    }

    private static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root) {
        //base case
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode<Integer> leftNode = invertBinaryTree(root.left);
        root.left = invertBinaryTree(root.right);
        root.right = leftNode;
        return root;
    }

    private static Node<Integer> removeNthFromEnd(Node<Integer> head, int k) {
        if (head == null) return null;

        Node<Integer> slow = head, fast = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;

        if (fast == null)
            return slow.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    private static void reorderList(Node<Integer> head) {
        if (head == null || head.next == null)
            return;

        //get the middle of the linked list
        Node<Integer> middle = getMiddle(head);

        //reverse the linked list from the middle
        Node<Integer> rHead = reverseLL(middle);
//        System.out.println(middle.data + ", " + rHead.data);

        Node<Integer> temp = new Node<>(0);
        while (true){
            temp.next = head;
            head = head.next;
            temp = temp.next;

            temp.next = rHead;
            rHead = rHead.next;
            temp = temp.next;

            if (head == rHead || head == temp){
                break;
            }
        }
    }

    private static Node<Integer> reverseLL(Node<Integer> head) {
        Node<Integer> past = null, present = head, future = head.next;

        while (present != null){
            present.next = past;
            past = present;
            present = future;

            if (future != null)
                future = future.next;
        }
        return past;
    }

    private static Node<Integer> getMiddle(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int res = nums[0];

        while (l <= r){
            if (nums[l] < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }

            int mid = (l+r)/2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[l])
                l = mid+1;
            else
                r = mid-1;
        }
        return res;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //current bracket

            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')'){
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else return false;
            }else if (c == '}'){
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else return false;
            }else if (c == ']'){
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }

    private static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLenSubstr = 0;

        while (r < s.length()){
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            //length of substr - max Freq.char <= k

            Map.Entry<Character, Integer> maxValueEntry = Collections.max(map.entrySet(),
                    (entry1, entry2) -> entry1.getValue() - entry2.getValue());
            if ((r-l+1) - maxValueEntry.getValue() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLenSubstr = Math.max(maxLenSubstr, (r-l+1));
            r++;
        }
        return maxLenSubstr;
    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;

        while (r < s.length()){
            char cur = s.charAt(r);

            if (set.contains(cur)){ //set contains the char 'cur'
                while (set.contains(cur)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }

            set.add(cur);
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0, buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, profitIfSoldToday);

            if (prices[i] < buyPrice)
                buyPrice = prices[i]; //today's Price
        }
        return maxProfit;
    }

    private static int maxAreaContainer(int[] heights) {
        int l = 0, r = heights.length-1;

        int curArea, maxArea = -1;
        while (l < r){
            curArea = Math.min(heights[l], heights[r]) * (r-l);
            maxArea = Math.max(curArea, maxArea);

            if (heights[l] <= heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int a = nums[i]; //current outer element
            int l = i+1, r = nums.length-1;
            while (l < r){
                int threeSum = a + nums[l] + nums[r];

                //two sum 2
                if (threeSum > 0)
                    r--;
                else if (threeSum < 0)
                    l++;
                else { //threeSum == 0
                    res.add(new ArrayList<>(Arrays.asList(a, nums[l], nums[r])));

                    //we could have multiple sols with the current a
                    l += 1;
                    while (nums[l] == nums[l-1] && l < r)
                        l += 1;
                }
            }
        }
        return res;
    }

    private static int[] twoSumSortedArray(int[] nums, int k) {
        int[] res = new int[2];
        int l = 0, r = nums.length-1;

        while (l < r){
            int curSum = nums[l] + nums[r];

            if (curSum == k){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            }

            if (curSum > k)
                r--;
            else
                l++;
        }
        return res;
    }

    private static boolean isValidPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l <= r){
            while (l < s.length() && !isAlphaNumeric(s.charAt(l)))
                l++;

            while (r >= 0 && !isAlphaNumeric(s.charAt(r)))
                r--;

            if (Character.toLowerCase(s.charAt(l)) !=
                Character.toLowerCase(s.charAt(r)))
                return false;
            l++; r--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return ('A' <= c && c <= 'Z') ||
                ('a' <= c && c <= 'z') ||
                ('0' <= c && c <= '9');
    }

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        int count, max = -1;
        for (int num : nums) {
            int cur = num;

            count = 0;
            if (!set.contains(cur - 1)) {
                //this is the first element in the sequence
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1, post = 1;

        //pre
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }

        //post
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= nums[i];
        }
        return res;
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //Build a Max Heap
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        //Return the top k frequent elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = maxHeap.poll().getKey();
        return res;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            //sort the string
            char[] sArr = str.toCharArray();
            Arrays.sort(sArr);
            String sortedString = new String(sArr);

            //put in HashMap
            if (!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());

            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static int[] twoSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++){
            int numToBeFound = k-nums[i];
            if (map.containsKey(numToBeFound)) {
                //return ans
                ans[0] = map.get(numToBeFound);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    private static boolean isValidAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
//            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        return map1.equals(map2);

        //sort both the strings and then compare them
        char[] sArr = s.toCharArray(),
                tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return new String(sArr).equals(new String(tArr));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int elem: nums){
            if (set.contains(elem))
                return true;
            set.add(elem);
        }
        return false;
    }
}
