package Neetcode;

import java.math.BigInteger;
import java.util.*;

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
//        System.out.println("LPS: " +
//                longestPalindromeSubstring("babad"));

//        todo https://leetcode.com/problems/coin-change/
//        int[] coins = {2};
//        System.out.println("Minimum Coin Change: " +
//                minCoinChange(coins, 3));

//        todo https://leetcode.com/problems/maximum-product-subarray/
//        int[] nums = {-2,0,-1};
//        System.out.println("Max Product SubArray: " + maxProductSubArray(nums));

//        todo https://leetcode.com/problems/palindromic-substrings/
//        System.out.println("Total Palindrome Count: " +
//                totalPalindromicSubstrings("babad"));

//        todo https://leetcode.com/problems/dungeon-game/description/
//        int[][] mat = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        System.out.println("Minimum HP: " + calculateMinimumHP(mat));

//        todo https://leetcode.com/problems/permutation-in-string/
//        System.out.println("Contains Permutation: " + checkInclusion("ab", "eidboaoo"));

//        todo https://leetcode.com/problems/minimum-window-substring/
//        String s = "a", t = "aa";
//        System.out.println("Min Window Substring: " +
//                minWindowSubstring(s, t));

//        todo https://leetcode.com/problems/generate-parentheses/
//        generateParentheses(3);
//        System.out.println(res);

//        todo https://leetcode.com/problems/daily-temperatures/
//        int[] temperatures = {73,74,75,71,69,72,76,73};
//        dailyTemperatures(temperatures);

//        todo https://leetcode.com/problems/koko-eating-bananas/
//        int[] piles = {3,6,7,11}; int h = 8;
//        System.out.println("Minimum bananas: " + minEatingSpeed(piles, h));

//        todo https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//        int[] nums = {4,5,6,7,8,1,2};
//        System.out.println("Min in rotated sorted array: " +
//                            findMinRotatedSortedArray(nums));

//        todo https://leetcode.com/problems/search-in-rotated-sorted-array/
//        int[] nums = {4,5,6,7,8,1,2};
//        System.out.println("Index: " + searchInRotatedSortedArr(nums, 8));

//        todo https://leetcode.com/problems/count-good-nodes-in-binary-tree/
//        BinaryTree obj = new BinaryTree();
//        TreeNode<Integer> root = obj.takeInput();
//        totalGoodNodes(root);

//        todo https://leetcode.com/problems/k-closest-points-to-origin/
//        int[][] points = {{3,3},{5,-1},{-2,4}}; int k = 2;
//        kClosestPoints(points, k);

//        todo https://leetcode.com/problems/jump-game/
//        int[] nums = {2,3,1,1,4};
//        System.out.println("Can Jump: " + jumpGame(nums));

//        todo https://leetcode.com/problems/jump-game-ii/
//        System.out.println("Min Jumps: " + minJumps(nums));

//        todo https://leetcode.com/problems/hand-of-straights/
//        int[] hand = {1,1,3,6,2,3,4,7,8}; int groupSize = 3;
//        System.out.println("Divide array in set of k consecutive numbers: " +
//                isNStraightHand(hand, groupSize));

//        todo https://leetcode.com/problems/partition-labels/
//        partitionLabels("ababcbacadefegdehijhklij");

//        todo https://leetcode.com/problems/valid-parenthesis-string/
//        System.out.println("Is Valid Parentheses: " + isValidParentheses("(*))" ));

//        todo https://leetcode.com/problems/longest-increasing-subsequence/
//        int[] arr = {0,1,0,3,2,3};
//        System.out.println("Length Of LIS: " +
//                lengthOfLIS(arr));

//        todo https://leetcode.com/problems/longest-common-subsequence/
//        System.out.println("LCS: " + longestCommonSubseq("abcde", "ace"));

//        todo https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//        int[] prices = {1,2,3,0,2};
//        System.out.println("Max profit with cooldown: " +
//                maxProfitWithCooldown(prices));

//        todo https://leetcode.com/problems/coin-change-ii/
//        int[] coins = {1,2,5};
//        System.out.println("Total coins combinations: " +
//                coinsCombinations(coins, 5));

//        todo https://leetcode.com/problems/interleaving-string/
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
//        System.out.println("Is Interleave: " + isInterleave(s1, s2, s3));

//        todo https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
//        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));

//        todo https://leetcode.com/problems/distinct-subsequences/
//        String s = "babgbag", t = "bag";
//        System.out.println("Distinct Subsequences: " + distinctSubSeqs(s, t));

//        todo https://leetcode.com/problems/insert-interval/
//        int[][] intervals = {{1,3}, {6,9}};
//        int[] newInterval = {2,5};
//        insertInterval(intervals, newInterval);

//        todo https://leetcode.com/problems/merge-intervals/
//        int[][] intervals = {{1,3},{8,10},{2,6},{10,18}};
//        mergeIntervals(intervals);

//        todo https://www.lintcode.com/problem/920/
        int[][] intervals = {{7,10}, {2,4}};
//        System.out.println("Can attend all meetings: " +
//                canAttendAllMeetings(intervals));

//        todo https://www.lintcode.com/problem/919/
//        minMeetingRooms(intervals);

//        todo https://leetcode.com/problems/spiral-matrix/
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        spiralMatrix(matrix);

//        todo https://leetcode.com/problems/set-matrix-zeroes/description/
//        setMatrixZeroes(matrix);

//        todo https://leetcode.com/problems/plus-one/
//        int[] arr = {9};
//        System.out.println("Plus One: " + Arrays.toString(plusOne(arr)));

//        todo https://leetcode.com/problems/rotate-image/
//        rotateImage(matrix);

//        todo https://leetcode.com/problems/valid-sudoku/
        char[][] board =
//                {{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};
                {{'3','.','.','.','.','4','.','.','.'},
                {'.','.','.','.','1','.','8','.','.'},
                {'.','7','2','.','.','.','.','.','.'},
                {'.','.','5','.','.','.','.','.','.'},
                {'.','4','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','1'},
                {'1','3','.','.','.','5','.','.','.'},
                {'.','.','.','.','5','.','.','2','.'}};
//        System.out.println("Is Valid Sudoku: " + isValidSudoku(board));

//        todo https://leetcode.com/problems/brick-wall/
//        int[][] wall = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
//        System.out.println("Least bricks to cross: " + leastBricks(wall));

//        todo https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println("Max Profit: " + maxProfit2(prices));

//        todo https://leetcode.com/problems/subarray-sum-equals-k/
//        nums = new int[]{1,-1,1,1,1,1};
//        System.out.println("Total Sub Arrays: " + subArrays(nums, 3));

//        todo https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
//        System.out.println("Unique Palindromes of length 3: " +
//                countPalindromicSubsequence("aabca"));

//        todo https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
//        System.out.println("Min Swaps: " + minSwaps("]]][[["));

//        todo https://leetcode.com/problems/find-all-anagrams-in-a-string/
//        String s = "cbaebabacd", p = "abc";
//        allAnagrams(s, p);

//        todo https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//        String haystack = "mississippi", needle = "issipi";
//        System.out.println("First Occurrence: " +
//                firstOccurrence(haystack, needle));

//        todo https://leetcode.com/problems/largest-number/
//        int[] nums = {1,2,3,4,5,6,7,8,9,0};
//        System.out.println("Largest Number: " + largestNumber(nums));

//        todo https://leetcode.com/problems/continuous-subarray-sum/
        int[] nums = {23,2,6,4,7,8};
//        System.out.println("Subarray: " + checkSubarraySum(nums, 13));

//        pattern(3, 5);


        findThirdLargest(nums);



    }

    private static int findThirdLargest(int[] nums) {
        int max = -1, secondMax = -1, thirdMax = -1;

        for (int num: nums){
            if (num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }
            if (num > secondMax && num < max) {
                thirdMax = secondMax;
                secondMax = num;
            }
            if (num > thirdMax && num < secondMax)
                thirdMax = num;
        }
        return thirdMax;
    }

    private static void pattern(int start, int n){

        for (int i = 1; i <= n; i++) {
            int j = 0;
            while (j < i){
                System.out.print(start + " ");
                j++;
            }
            System.out.println();

            start += 1;
        }
        start -= 1;
        for (int i = n; i > 0; i--) {
            int j = 0; //i = 4,3,2,1
            while (j < i){
                System.out.print(start + " ");
                j++;
            }
            System.out.println();

            start -= 1;
        }

    }

    private static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
                // remainder, index

        map.put(0, -1); //for handling base case. e.g [23,2,4,6,6];
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            int rem = sum%k;

            if (map.containsKey(rem)){
                //that means remainder is repeating
                //check if subarray length >= 2
                if (i - map.get(rem) >= 2)
                    return true;
            }else {
                map.put(rem, i);
            }
//            System.out.println(map);
        }
        return false;
    }

    private static String largestNumber(int[] nums) {
        //convert this int nums array to a String array:
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numbers[i] = String.valueOf(nums[i]);

        //sort this array
        //but this is not a normal sort. We have to compare 2 strings:
        //eg. "3" & "30" => "330" or "303". So we'd add both the strings a+b, b+a and then compare them
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String num1 = s1+s2, num2 = s2+s1;
                return num1.compareTo(num2);//comparing strings lexicographically
            }
        });
//        System.out.println(Arrays.toString(numbers));
        if (numbers[numbers.length-1].equals("0"))//base case
            return "0";

        StringBuilder res = new StringBuilder();
        for (int i = numbers.length-1; i >= 0; i--)
            res.append(numbers[i]);
        return res.toString();
    }

    private static int firstOccurrence(String s, String p) {
        if (p.length() > s.length())
            return -1;

        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == p.charAt(0)){
                //this is a possible answer
                int j = i, k = 0;
                while (j < s.length() && k < p.length()){
                    if (s.charAt(j) != p.charAt(k))
                        break;
                    j++; k++;
                }

                if (k == p.length())//the complete string is traversed, that means we've found our solution
                    return i;
            }
            i++;
        }

        return -1;
    }

    private static List<Integer> allAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length())
            return res;

        HashMap<Character, Integer> pCount = new HashMap<>(),
                                    sCount = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (pCount.equals(sCount))
            res.add(0);

        int l = 0;
        for (int r = p.length(); r < s.length(); r++) {
            //add the character at 'r'
            sCount.put(s.charAt(r), sCount.getOrDefault(s.charAt(r), 0) + 1);

            //decrement the count of char at 'l'
            sCount.put(s.charAt(l), sCount.get(s.charAt(l)) - 1);
            if (sCount.get(s.charAt(l)) == 0)//if the count is 0, remove from HashMap
                sCount.remove(s.charAt(l));
            l += 1;

            if (pCount.equals(sCount))
                res.add(l);
        }
        return res;
    }

    private static int minSwaps(String s) {
        int close = 0, maxClose = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']')
                close++;
            else // '['
                close--;

            maxClose = Math.max(close, maxClose);
        }

        return (int) Math.ceil(maxClose/2.0);
    }

    private static int countPalindromicSubsequence(String s) {
        //store the start and end of every char in the string s
        int[][] indexes = new int[26][2];
        for (int[] arr: indexes)
            Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexes[c - 'a'][0] == -1) {
                indexes[c - 'a'][0] = i;
            }
            indexes[c - 'a'][1] = i;
        }

        int totalPalindromeOfLen3 = 0;
        //we have got the s and e index of every character now
        //now we'll see how many unique characters are present between start & end of them
        for (int i = 0; i < 26; i++) {
            int start = indexes[i][0], end = indexes[i][1];
            HashSet<Character> uniqueChars = new HashSet<>();

            for (int j = start+1; j < end; j++)
                uniqueChars.add(s.charAt(j));
            totalPalindromeOfLen3 += uniqueChars.size();
        }
        return totalPalindromeOfLen3;
    }

    //this is a very optimized approach
    private static int subArrays(int[] nums, int k) {
        int totalSubArrays = 0, curSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
             // prefixSum, count
        map.put(0, 1);

        for (int num: nums){
            curSum += num;
            int diff = curSum- k;

            if (map.containsKey(diff))
                totalSubArrays += map.get(diff);

            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
//            System.out.println(map);
        }
        return totalSubArrays;
    }

    private static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return profitHelper(0, 1, prices, dp);
    }

    private static int profitHelper(int ind, int buy, int[] prices, int[][] dp) {
        //base case
        if (ind >= prices.length)
            return 0;

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int totalProfit = 0;
        if (buy == 1){
            //buy (or) skip
            int buyKiya = -prices[ind] + profitHelper(ind+1, 0, prices, dp);
            int skipKiya = profitHelper(ind+1, 1, prices, dp);
            totalProfit = Math.max(buyKiya, skipKiya);
        }else {
            //sell or skip
            int sellKiya = prices[ind] + profitHelper(ind+1, 1, prices, dp);
            int skipKiya = profitHelper(ind+1, 0, prices, dp);
            totalProfit = Math.max(sellKiya, skipKiya);
        }

        dp[ind][buy] = totalProfit;
        return totalProfit;
    }

    private static int leastBricks(int[][] wall) {
        HashMap<Integer, Integer> gaps = new HashMap<>();
               //width,   gapCount

        for (int[] layer : wall) {
            int sum = 0;
            for (int i = 0; i < layer.length-1; i++) {
                sum += layer[i];
                gaps.put(sum, gaps.getOrDefault(sum, 0) + 1);
            }
        }

        //get the maximum gap
        int maxGap = 0;
        for (int gap: gaps.values())
            maxGap = Math.max(maxGap, gap);

        return wall.length - maxGap;
    }

    private static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                if (inRow(i, j, board) || inCol(i, j, board) ||
                    inSubBoard(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean inSubBoard(int i, int j, char[][] board) {
        int k = (i/3) * 3,
            l = (j/3) * 3;
        char c = board[i][j];

        for (int a = k; a < k+3; a++) {
            for (int b = l; b < l+3; b++) {
                if (a == i && b == j) continue;
                if (board[a][b] == c)
                    return true;
            }
        }
        return false;
    }

    private static boolean inCol(int i, int j, char[][] board) {
        char c = board[i][j];
        for (int k = 0; k < 9; k++) {
            if (k == i) continue; //dont the the same character
            if (board[k][j] == c)
                return true;
        }
        return false;
    }

    private static boolean inRow(int i, int j, char[][] board) {
        char c = board[i][j];
        for (int k = 0; k < 9; k++) {
            if (k == j) continue; //dont the the same character
            if (board[i][k] == c)
                return true;
        }
        return false;
    }

    private static void rotateImage(int[][] mat) {
        int left = 0, right = mat.length-1;

        while (left < right){ //will run n/2 times

            for (int i = 0; i < (right-left); i++) {
                int top = left, bottom = right;

                //save the top left
                int topLeft = mat[top][left + i];

                //move bottom left -> top left
                mat[top][left + i] = mat[bottom - i][left];

                //move bottom right -> bottom left
                mat[bottom - i][left] = mat[bottom][right - i];

                //move top right -> bottom right
                mat[bottom][right - i] = mat[top + i][right];

                //move top left -> top right
                mat[top + i][right] = topLeft;
            }

            left += 1;
            right -= 1;
        }

        System.out.println(Arrays.deepToString(mat));
    }

    private static int[] plusOne(int[] arr) {
        int n = arr.length;
        if (arr[n-1] < 9){
            arr[n-1] = arr[n-1] + 1;
            return arr;
        }

        // that means the last digit is '9'
        int carry = 1, i = n-1, sum;
        while (i >= 0){
            sum = arr[i] + carry;

            if (sum == 10) {
                arr[i] = 0;
            }else { //sum < 10
                arr[i] = sum;
                return arr;
            }
            i -= 1;
        }


        //carry bacha hai
        int[] res = new int[n+1];
        res[0] = 1;
        for (int j = 1; j < res.length; j++)
            res[j] = arr[j-1];
        return res;
    }

    private static void setMatrixZeroes(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[] rows = new int[r],
              cols = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows[i] == 1)
                    mat[i][j] = 0;
                if (cols[j] == 1)
                    mat[i][j] = 0;
            }
        }
    }

    private static List<Integer> spiralMatrix(int[][] mat) {
        int top = 0, bottom = mat.length-1,
            left = 0, right = mat[0].length-1;
        List<Integer> res = new ArrayList<>();

        while (top <= bottom && left <= right){
            //top
            int x = left;
            while (x <= right){
                res.add(mat[top][x]);
                x++;
            }
            top += 1;
            if (top > bottom)
                break;

            //right
            x = top;
            while (x <= bottom){
                res.add(mat[x][right]);
                x++;
            }
            right -= 1;
            if (right < left)
                break;

            x = right;
            //bottom
            while (x >= left){
                res.add(mat[bottom][x]);
                x--;
            }
            bottom -= 1;

            x = bottom;
            //left
            while (x >= top){
                res.add(mat[x][left]);
                x--;
            }
            left += 1;
        }
        System.out.println(res);
        return res;
    }

    private static int minMeetingRooms(int[][] intervals) {
        //sort them wrt start time
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        int end = intervals[0][1];
        int rooms = 0;

        for (int[] interval: intervals){

            if (interval[0] < end) {
                rooms += 1;

                end = Math.min(end, interval[1]);
            }else { //interval[0] > end -> no overlapping
                //no extra room needed
                end = interval[1];
            }
        }

//        System.out.println("rooms = " + rooms);
        return rooms;
    }

    private static boolean canAttendAllMeetings(int[][] intervals) {
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] < end)
                return false;

            end = interval[1];
        }
        return true;
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        //sort the intervals in ASC order
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);

        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval: intervals){

            if (interval[0] <= end)
                end = Math.max(end, interval[1]);
            else if (end < interval[0]){
                //add s,e
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        res.add(new int[]{start, end});
//        for (int[] arr: res)
//            System.out.print(Arrays.toString(arr) + " ");
        return res.toArray(new int[res.size()][]);
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals){

            //1. newInterval baadme, matlab right me hoga current Interval k
            if (newInterval == null || newInterval[0] > interval[1])
                res.add(interval);
            //2. newInterval pehle hoga, so insert karlo
            else if (newInterval[1] < interval[0]){
                res.add(newInterval); //new Interval is added!
                res.add(interval);
                newInterval = null;
            }else { //overlapping
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null)
            res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    private static int distinctSubSeqs(String s, String t) {
        return dfs(0, s, t, "");
    }

    private static int dfs(int ind, String s, String t, String cur) {
        //base case
        if (cur.equals(t))
            return 1;
        if (ind >= s.length())
            return 0;

        if (cur.length() >= t.length()) //no point in checking further, e.g cur -> "bab"
            return 0;

        int take = dfs(ind+1, s, t, cur+s.charAt(ind));
        int skip = dfs(ind+1, s, t, cur);
        return take + skip;
    }

    private static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        int maxLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == -1)
                    maxLength = Math.max(maxLength, dfs(i, j, matrix, -1, dp));
            }
        }

        return maxLength;
    }

    private static int dfs(int r, int c, int[][] matrix, int prevValue, int[][] dp) {
        //base case
        if (r >= matrix.length ||
            c >= matrix[0].length ||
            r < 0 || c < 0 ||
            matrix[r][c] <= prevValue)
            return 0;

        if (dp[r][c] != -1)
            return dp[r][c];

        int res = 1, parent = matrix[r][c];
        res = Math.max(res, 1 + dfs(r, c+1, matrix, parent, dp));
        res = Math.max(res, 1+ dfs(r, c-1, matrix, parent, dp));
        res = Math.max(res, 1 + dfs(r+1, c, matrix, parent, dp));
        res = Math.max(res, 1+ dfs(r-1, c, matrix, parent, dp));

        dp[r][c] = res;
        return res;
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return isInterleaveHelper(0, 0, s1, s2, s3, dp);
    }

    private static boolean isInterleaveHelper(int i, int j, String s1, String s2, String s3, int[][] dp) {
        //base case
        if (i+j == s3.length()) //string traversal is complete
            return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean first = i < s1.length() && s1.charAt(i) == s3.charAt(i + j);
        boolean second = j < s2.length() && s2.charAt(j) == s3.charAt(i + j);

        boolean ans = false;
        if (first && second)
            ans = isInterleaveHelper(i + 1, j, s1, s2, s3, dp) || isInterleaveHelper(i, j + 1, s1, s2, s3, dp);
        else if (first)
            ans = isInterleaveHelper(i + 1, j, s1, s2, s3, dp);
        else if (second)
            ans = isInterleaveHelper(i, j + 1, s1, s2, s3, dp);

        dp[i][j] = ans ? 1 : 0;
        return dp[i][j] == 1;
    }

    private static int coinsCombinations(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return changeHelper(0, 0, coins, target, dp);
    }

    private static int changeHelper(int ind, int sum, int[] coins, int target, int[][] dp) {
        //base case
        if (ind >= coins.length) return 0;
        if (sum == target)
            return 1;

        if (dp[ind][sum] != -1)//already calculated
            return dp[ind][sum];

        //take the current coin, if we can take it
        int take = 0;
        if (sum + coins[ind] <= target){
            take = changeHelper(ind, sum+coins[ind], coins, target, dp);
        }

        //skip the current coin
        int dontTake = changeHelper(ind+1, sum, coins, target, dp);
        dp[ind][sum] = take + dontTake;
        return dp[ind][sum];
    }

    private static int maxProfitWithCooldown(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return maxProfitCooldownHelper(0, 1, prices, dp);
    }

    private static int maxProfitCooldownHelper(int i, int buy, int[] prices, int[][] dp) {
        //base case
        if (i >= prices.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int totalProfit = 0;
        if (buy == 1){
            //we can choose to buy it or skip it
            int buyKiya = -prices[i] + maxProfitCooldownHelper(i+1, 0, prices, dp);
            int skipKiya = maxProfitCooldownHelper(i+1, 1, prices, dp);

            totalProfit = Math.max(buyKiya, skipKiya);
        }else { //buy = 0
            // we can choose to sell it or skip it
            int sellKiya = prices[i] + maxProfitCooldownHelper(i+2, 1, prices, dp);
            int skipKiya = maxProfitCooldownHelper(i+1, 0, prices, dp);

            totalProfit = Math.max(sellKiya, skipKiya);
        }

        dp[i][buy] = totalProfit;
        return totalProfit;
    }

    private static int longestCommonSubseq(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return LCSHelper(0, 0, s1, s2, dp);
    }

    private static int LCSHelper(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if (i >= s1.length() || j >= s2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + LCSHelper(i + 1, j + 1, s1, s2, dp);
            return dp[i][j];
        }

        //s1.charAt(i) != s2.charAt(j)
        dp[i][j] = Math.max(LCSHelper(i+1, j, s1, s2, dp), LCSHelper(i, j+1, s1, s2, dp));
        return dp[i][j];
    }

    private static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        return lengthOfLISHelper(0, nums, list);
    }

    private static int lengthOfLISHelper(int i, int[] nums, ArrayList<Integer> list) {
        //base case
        if (i == nums.length)
            return list.size();


        //take -> if it can be taken
        int take = Integer.MIN_VALUE;
        if (list.size() == 0 || list.get(list.size()-1) < nums[i]) {
            list.add(nums[i]);
            take = lengthOfLISHelper(i+1, nums, list);

            //remove the last added element
            list.remove(list.size()-1);
        }

        //dont take
        int dontTake = lengthOfLISHelper(i+1, nums, list);
        return Math.max(take, dontTake);
    }

    private static boolean isValidParentheses(String s) {
        return parenthesesHelper(0, s, new Stack<>());
    }

    private static boolean parenthesesHelper(int i, String s, Stack<Character> stack) {
        //base case
        if (i == s.length())
            return stack.isEmpty();


        if (s.charAt(i) == ')'){
            if (stack.peek() != '(')
                return false;
            stack.pop();

            if (parenthesesHelper(i+1, s, stack))
                return true;
        }


        if (s.charAt(i) == '*'){
            stack.push('(');
           if (parenthesesHelper(i+1, s, stack))
               return true;
           stack.pop();

           if (parenthesesHelper(i+1, s, stack))
               return true;
           stack.pop();

           stack.push(')');
           if (parenthesesHelper(i+1, s, stack))
               return true;
           stack.pop();
        }else { // s.charAt(i) == '('
            stack.push('(');
            if (parenthesesHelper(i+1, s, stack))
                return true;
        }

        return false;
    }

    private static List<Integer> partitionLabels(String s) {
        //build a hashmap with Character, its last index occurrence
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        List<Integer> res = new ArrayList<>();
        int end = 0, size = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //update the end and increment size
            end = Math.max(end, map.get(c));
            size += 1;

            //if we have reached the end of the window
            if (i == end){
                res.add(size);
                size = 0;
            }
        }

        return res;
    }

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        //build a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: hand)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //take the keys from the map, and construct a MinHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());

        while (!minHeap.isEmpty()){
            int first = minHeap.peek();

            for (int i = first; i < first+groupSize; i++) {
                if (!map.containsKey(i))
                    return false;

                //decrement its count
                map.put(i, map.get(i)-1);

                if (map.get(i) == 0){
                    if (minHeap.peek() != i)
                        return false;
                    minHeap.poll();
                }
            }
        }

        return true;
    }

    private static int minJumps(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return minJumpHelper(0, nums, dp);
    }

    private static int minJumpHelper(int i, int[] nums, int[] dp) {
        //base case
        if (i >= nums.length-1)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int maxJump = nums[i], min = (int) 1e9;
        for (int j = maxJump; j > 0; j--) {
            int jump = minJumpHelper(i + j, nums, dp);
            min = Math.min(min, jump);
        }

        dp[i] = min+1;
        return min+1;
    }

    private static boolean jumpGame(int[] nums) {
        int[] visited = new int[nums.length];
        Arrays.fill(visited, -1);
        return jumpHelper(0, nums, visited) == 1;
    }

    private static int jumpHelper(int i, int[] nums, int[] visited) {
        //base case
        if (i >= nums.length-1)
            return 1;

        if (visited[i] != -1)
            return visited[i];
        System.out.println("i = " + i);

        int curMaxJump = nums[i];
        for (int j = curMaxJump; j > 0; j--) {
            int canJump = jumpHelper(i + j, nums, visited);

            if (canJump == 1) {
                visited[i] = 1;
                return 1;
            }
        }

        visited[i] = 0;
        return 0;
    }

    private static int[][] kClosestPoints(int[][] points, int k) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        Collections.addAll(minHeap, points);

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }

    private static int totalGoodNodes(TreeNode<Integer> root) {
        return helperGoodNodes(root, root.data);
    }

    private static int helperGoodNodes(TreeNode<Integer> root, int max) {
        //base case
        if (root == null)
            return 0;

        int count = 0;
        if (root.data >= max) {
            count++;
            max = root.data;
        }

        count += helperGoodNodes(root.left, max);
        count += helperGoodNodes(root.right, max);
        return count;
    }

    private static int searchInRotatedSortedArr(int[] nums, int target) {
        //we will use somewhat modified Binary search here
        int l = 0, r = nums.length-1;

        while (l <= r){
            int mid = (l+r)/2;
            if (nums[mid] == target)
                return mid;

            if (target < nums[mid]){
                if (target < nums[l])
                    l = mid+1;
                else
                    r = mid-1;
            }else //target > nums[mid]
                if (nums[r] <= target)
                    l = mid+1;
                else
                    r = mid-1;
            }
            return -1;
        }

    private static int findMinRotatedSortedArray(int[] nums) {
        int l = 0, r = nums.length-1;
        int res = nums[0];

        while (l <= r){
            int mid = (l+r)/2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] <= nums[r]) //search in left
                r = mid-1;
            else //nums[mid] > nums[e], mtlb sorted portion is in right
                l = mid+1;
        }
        return res;
    }

    //we want to find the min no.of bananas 'Koko' can eat, such that it can finish all bananas within h hours
    private static int minEatingSpeed(int[] piles, int h) {
        int e = maxInPiles(piles); //so koko can eat 'max' no. of bananas
        int s = 1; //minimum no. of bananas

        int mid, res = e;
        while (s <= e){
            mid = (s+e)/2;

            //lets calculate how many hours it'd take if Koko eats mid.no of bananas each hour
            int hours = calculateHours(piles, mid);

            if (hours <= h){
                res = Math.min(res, mid);
                e = mid-1;
            }else //hours > h, means Koko would be need to eat more no.of bananas
                s = mid+1;
        }

        return res;
    }

    private static int calculateHours(int[] piles, int mid) {
        int hours = 0;
        for (int pile: piles)
            hours += (int) Math.ceil((double) pile/mid);
        return hours;
    }

    private static int maxInPiles(int[] piles) {
        int max = -1;
        for (int pile: piles)
            max = Math.max(max, pile);
        return max;
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();//to store the indices
        for (int i = n-1; i >= 0; i--) {
            int curTemp = temperatures[i];

            //remove the temperatures which is less than the current temperature
            while (!stack.isEmpty() && curTemp >= temperatures[stack.peek()])
                stack.pop();

            if (!stack.isEmpty())
                ans[i] = stack.peek() - i;

            stack.push(i);
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

    static List<String> res = new ArrayList<>();
    private static List<String> generateParentheses(int n) {
        helperGenerateParentheses(0, 0, "", n);
        return res;
    }

    private static void helperGenerateParentheses(int open, int close, String cur, int n) {
        //base case
        if (open == n && close == n) {
            res.add(cur);
            return;
        }

        if (open < n)
            helperGenerateParentheses(open+1, close, cur+"(", n);

        if (close < open)
            helperGenerateParentheses(open, close+1, cur+")", n);
    }

    //return the min window substring of s
    private static String minWindowSubstring(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> map1 = new HashMap<>(),
                                    map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);

        int l = 0, r = 0;
        while (r < s.length()){
            map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r), 0) + 1);
            r++;
        }
        r--; // r is at the end of String s


        while (l < s.length()){
            char c = s.charAt(l);

            if (map1.containsKey(c)){
                if (map2.get(c) > map1.get(c))
                    map2.put(c, map2.get(c) - 1);
                else if (map2.get(c) == map1.get(c))
                    break;
            }else
                map2.remove(c);

            l++;
        }

        //time to decrement r
        while (r >= l){
            char c = s.charAt(r);

            if (map1.containsKey(c)){
                if (map2.get(c) > map1.get(c))
                    map2.put(c, map2.get(c) - 1);
                else if (map2.get(c) == map1.get(c))
                    break;
            }

            r--;
        }
//        System.out.println(l + ", " + r);
        return s.substring(l, r+1);
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>(),
                                    map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i < s1.length(); i++)
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);


        int l = 0, r = s1.length()-1;
        while (r < s2.length()){
            if (map1.equals(map2))
                return true;

            if (map2.get(s2.charAt(l)) == 1)
                map2.remove(s2.charAt(l));
            else
                map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
            l++; r++;


            if (r < s2.length())
                map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
        }
        return false;
    }


    private static int totalPalindromicSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        int palindromeCount = 0;
        //make the diagonals 1, as a string of length 1 is a valid Palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            palindromeCount++;
        }

        int k = n-1, l = 1;
        int i, j; //i & j are actual pointers for the string
        while (k >= 0){
            i = 0; j = l;

            while (i < k && j < n){
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i == 1 || dp[i+1][j-1] == 1) {
                        dp[i][j] = 1;
                        palindromeCount++;
                    }
                }

                i++; j++;
            }

            k--;
            l++;
        }

        return palindromeCount;
    }

    private static int maxProductSubArray(int[] nums) {
        int curMax = 1, curMin = 1;
        int res = 0;

        for (int n: nums){

            int temp = n*curMax;
            curMax = Math.max(n, Math.max(n*curMax, n*curMin));
            curMin = Math.min(n, Math.min(temp, n*curMin));

            System.out.println("curMax = " + curMax + ", CurMin = " + curMin);
            res = Math.max(res, curMax);
        }
        return res;
    }

    private static int minCoinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        int ans = coinHelper(coins, 0, amount, dp);
        return ans != (int) 1e9 ? ans : -1;
    }

    private static int coinHelper(int[] coins, int i, int amount, int[][] dp) {
        //base case
        if (amount < 0) return (int) 1e9;
        if (i == coins.length-1)
            if (amount % coins[i] == 0)
                return amount/coins[i];
            else
                return (int) 1e9;

        if (amount == 0)
            return 0;
        if (dp[i][amount] != -1)
            return dp[i][amount];


        //take this coin
        int take = 1 + coinHelper(coins, i, amount-coins[i], dp);
        //dont take this coin
        int notTake = coinHelper(coins, i+1, amount, dp);

        dp[i][amount] = Math.min(take, notTake);
        return Math.min(take, notTake);
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
