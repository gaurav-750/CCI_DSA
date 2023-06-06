package Dynamic_Programming;

import java.util.Arrays;

public class Neetcode_Dp_Patterns {
    public static void main(String[] args) {
        //Spreadsheet Link
        //https://docs.google.com/spreadsheets/d/1pEzcVLdj7T4fv5mrNhsOvffBnsUH07GZk7c2jD-adE0/edit#gid=0

        // 1. Fibonacci
//        todo https://leetcode.com/problems/climbing-stairs/
//        System.out.println("Climbing Stairs: " + climbStairs(5));

//        todo https://leetcode.com/problems/house-robber/
//        int[] houses = {2,7,9,3,1};
//        System.out.println("Rob Houses: " + robHouses(houses));

//        todo https://leetcode.com/problems/maximum-alternating-subsequence-sum/
        int[] nums = {6,2,1,2,4,5};
        System.out.println("Max Alternating sum: " + maxAlternatingSum(nums));




    }

    private static long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for (long[] arr: dp)
            Arrays.fill(arr, -1);

        return maxAltSumHelper(0, true, nums, dp); //index, isEvenIndex, array
    }

    private static long maxAltSumHelper(int i, boolean isEvenIndex, int[] nums, long[][] dp) {
        //base case
        if (i == nums.length)
            return 0;

        if (dp[i][isEvenIndex ? 1 : 0] != -1) //already calculated
            return dp[i][isEvenIndex ? 1 : 0];

        if (isEvenIndex){
            //take
            long take = nums[i] + maxAltSumHelper(i+1, false, nums, dp);

            //not take
            long notTake = maxAltSumHelper(i+1, true, nums, dp);

            dp[i][1] = Math.max(take, notTake);
            return Math.max(take, notTake);
        }

        // I'm on odd index
        //take
        long take =  maxAltSumHelper(i+1, true, nums, dp) - nums[i];

        //not take
        long notTake = maxAltSumHelper(i+1, false, nums, dp);

        dp[i][0] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }

    private static int robHouses(int[] houses) {
        int[] dp = new int[houses.length];
        Arrays.fill(dp, -1);

        return robHouseHelper(0, houses, dp);
    }

    private static int robHouseHelper(int i, int[] houses, int[] dp) {
        //base case
        if (i >= houses.length)
            return 0;
        if (i == houses.length-1)
            return houses[i];

        if (dp[i] != -1)
            return dp[i];

        //rob
        int rob = houses[i] + robHouseHelper(i+2, houses, dp);

        //not rob
        int notRob = robHouseHelper(i+1, houses, dp);

        dp[i] = Math.max(rob, notRob);
        return dp[i];
    }

    private static int climbStairs(int n) {
        //using only 2 variables

        int prev = 0, present = 1;
        for (int i = 0; i < n; i++) {
            int temp = present;
            present = present + prev;
            prev = temp;
        }
        return present;
    }
}
