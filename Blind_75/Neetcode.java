package Blind_75;

import BinaryTrees.BinaryTree;
import BinaryTrees.TreeNode;

import java.util.*;

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

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/product-of-array-except-self/
//        int[] arr = {2,3,4,6};
//        System.out.println(Arrays.toString(productsExceptSelf(arr)));

//        todo https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//        int[] arr = {4,5,6,7,0,1,2};
//        System.out.println("Min: " + findMinInSortedArray(arr));

//        todo https://leetcode.com/problems/container-with-most-water/
//        int[] heights = {1,8,6,2,5,4,8,3,7};
//        System.out.println("Container with most water: " + containerWithMostWater(heights));

//        todo https://leetcode.com/problems/missing-number/
//        int[] nums = {9,6,4,2,3,5,7,0,1};
//        System.out.println("Missing number: " + missingNumber(nums));

//        todo https://leetcode.com/problems/coin-change/description/
        int[] coins = {2};
//        int[] coins = {186,419,83,408};
//        System.out.println("Minimum number of coins: " + coinChange(coins, 7));
        //Using Dynamic Programming:
//        System.out.println("Minimum Coins: " + coinChangeDP(coins, 3));

//        todo https://leetcode.com/problems/top-k-frequent-elements/
//        int[] nums = {1,1,1,2,2,3};
//        System.out.println(Arrays.toString(topKFrequent(nums, 2)));

//        todo https://leetcode.com/problems/longest-consecutive-sequence/
//        int[] nums = {100,4,200,1,3,2};
//        System.out.println("Longest Consecutive Sequence: " +
//                longestConsecutiveSequence(nums));

//        todo https://leetcode.com/problems/longest-substring-without-repeating-characters/
//        String s = "qrsvbspk";
//        System.out.println("Length of longest substring: " + lengthOfLongestSubString(s));

//        todo https://leetcode.com/problems/validate-binary-search-tree/
        BinaryTree bt = new BinaryTree();
        TreeNode<Integer> root = bt.takeInput();
        System.out.println("Is BST: " + validateBST(root));





    }

    private static boolean validateBST(TreeNode<Integer> root) {
        return validateBstHelper(root).isBST;
    }

    private static BSTReturn validateBstHelper(TreeNode<Integer> root) {
//        base
        if (root == null)
            return new BSTReturn(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        //leaf node
        if (root.left == null && root.right == null)
            return new BSTReturn(true, root.data, root.data);


        BSTReturn left = validateBstHelper(root.left);
        BSTReturn right = validateBstHelper(root.right);

        boolean isBst = true;
        if (root.data <= left.max || right.min < root.data){
            isBst = false;
        }
        if (!left.isBST || !right.isBST)
            isBst = false;

        int min = Math.min(Math.min(left.min, right.min), root.data);
        int max = Math.max(Math.max(left.max, right.max), root.data);

        return new BSTReturn(isBst, min, max);
    }

    private static int lengthOfLongestSubString(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0, r = 0, maxLength = 0;
        while (r < s.length()){
            char c = s.charAt(r);
            while (set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            System.out.println("set = " + set);
            maxLength = Math.max(maxLength, set.size());
            r++;
        }
        return maxLength;
    }

    private static int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        int max = 0;
        for (int num: nums){
            int cur = 0;

            if (!set.contains(num-1)){
                while (set.contains(num)){
                    cur++;
                    num += 1;
                }

                max = Math.max(max, cur);
            }
        }
        return max;
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int elem: nums)
            map.put(elem, map.getOrDefault(elem, 0) + 1);

        //MaxHeap
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        //pop k elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int val = maxHeap.poll().getKey();
            res[i] = val;
        }
        return res;
    }

    private static int coinChangeDP(int[] coins, int amount) {
        //make a dp array
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //i -> current amount
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins){
                //lets take every coin and find the minimum
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    private static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        return coinHelper(amount, dp, coins);
    }

    private static int coinHelper(int amount, int[] dp, int[] coins) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if (dp[amount] != -1)
            return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = coinHelper(amount - coins[i], dp, coins);

            if (ans != -1)
                minCoins = Math.min(minCoins, ans+1);
        }

        dp[amount] = minCoins != Integer.MAX_VALUE ? minCoins : -1;
        return dp[amount];
    }

//    private static int coinChange(int[] coins, int amount) {
//        if (amount == 0)
//            return 0;
//        if (amount < 0)
//            return -1;
//
//        System.out.println("amount = " + amount);
//        int minCoins = Integer.MAX_VALUE;
//        for (int i = 0; i < coins.length; i++) {
//            int ans = coinChange(coins, amount - coins[i]);
//
//            if (ans != -1)
//                minCoins = Math.min(minCoins, ans+1);
//        }
//
//        return minCoins != Integer.MAX_VALUE ? minCoins : -1;
//    }

    private static int missingNumber(int[] nums) {
        // [0,n]
        //sort the numbers using cyclic sort
        int i = 0;
        while (i < nums.length){
            if (nums[i] != i && nums[i] != nums.length){
                swap(nums, nums[i], i);
            }else
                i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j)
                return j;
        }
        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int containerWithMostWater(int[] heights) {
        int l = 0, r = heights.length-1;
        int maxArea = -1;

        while (l < r){
            int currentArea = (r-l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, currentArea);

            if (heights[l] <= heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    private static int findMinInSortedArray(int[] arr) {
        int l = 0, r = arr.length-1;
        int res = arr[0];

        while (l <= r){
             //if you are already in the sorted portion, return arr[l]
            if (arr[l] < arr[r]) {
                res = Math.min(res, arr[l]);
                break;
            }

            int mid = (l+r)/2;
            res = Math.min(res, arr[mid]);
            if (arr[l] <= arr[mid])
                l = mid+1;
            else
                r = mid-1;
        }
        return res;
    }

    private static int[] productsExceptSelf(int[] arr) {
        int[] res = new int[arr.length];
        int pre = 1, post = 1;

        //pre product
        for (int i = 0; i < res.length; i++) {
            res[i] = pre;
            pre *= arr[i];
        }

        //post product
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= arr[i];
        }
        return res;
    }
}
