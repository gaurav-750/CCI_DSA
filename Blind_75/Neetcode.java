package Blind_75;

import java.util.Arrays;

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
        System.out.println("Minimum Coins: " + coinChangeDP(coins, 3));




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
