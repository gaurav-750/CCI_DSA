package Dynamic_Programming;

import java.util.Arrays;
import java.util.HashMap;

class Pair{
    int index;
    int target;

    public Pair(int index, int target){
        this.index = index;
        this.target = target;
    }
}

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
//        int[] nums = {6,2,1,2,4,5};
//        System.out.println("Max Alternating sum: " + maxAlternatingSum(nums));


        // 2. 0/1 Knapsack
//        todo https://leetcode.com/problems/partition-equal-subset-sum/
//        int[] nums = {1,2,3,5};
//        System.out.println("Can Partition: " + canPartition(nums));

//        todo https://leetcode.com/problems/target-sum/
        int[] nums = {1,1,1,1,1};
        System.out.println("Total target ways: " + findTargetSumWays(nums, 3));




    }

    private static int findTargetSumWays(int[] nums, int target) {
        HashMap<Pair, Integer> map = new HashMap<>();

        return findTargetSumWaysHelper(0, nums, target, map);
    }

    private static int findTargetSumWaysHelper(int i, int[] nums, int target, HashMap<Pair, Integer> dp) {
        //base case
        if (i == nums.length)
            return target == 0 ? 1 : 0;

//        if (dp.containsKey(new Pair(i, target))) {
//            System.out.println("Cache");
//            return dp.get(new Pair(i, target));
//        }
        System.out.println(i + ", " + target);

        //add
        int add = findTargetSumWaysHelper(i+1, nums, target-nums[i], dp);

        //subtract
        int sub = findTargetSumWaysHelper(i+1, nums, target+nums[i], dp);

        dp.put(new Pair(i, target), add+sub); //add (cache) it to HashMap
        return add+sub;
    }

    private static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num: nums)
            totalSum += num;

        //if totalsum is odd - we cannot partition
        if (totalSum%2 != 0)
            return false;

        int target = (totalSum/2);
        int[][] dp = new int[nums.length][target+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return sumToK(0, target, nums, dp);
    }

    private static boolean sumToK(int i, int target, int[] nums, int[][] dp) {
        //base case
        if (target == 0)
            return true;
        if (i >= nums.length)
            return false;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;


        //take
        boolean take = false;
        if (nums[i] <= target) {
            take = sumToK(i+1, target - nums[i], nums, dp);
            if (take) {
                dp[i][target] = 1;
                return true;
            }
        }

        //not take
        boolean notTake = sumToK(i+1, target, nums, dp);
        dp[i][target] = notTake ? 1 : 0;
        return notTake;
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
