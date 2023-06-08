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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        result = prime * result + target;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (index != other.index)
            return false;
        return target == other.target;
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
//        int[] nums = {1,1,1,1,1};
//        System.out.println("Total target ways: " + findTargetSumWays(nums, 3));


        // 3. Unbounded Knapsack
//        todo https://leetcode.com/problems/coin-change/
//        int[] coins = {1,2,5};
//        System.out.println("Minimum number of coins: " + coinChange(coins, 11));

//        todo https://leetcode.com/problems/coin-change-ii/
//        int[] coins = {1,2,5};
//        System.out.println("Total number of combinations: " +
//                change(coins, 5));

//        todo https://leetcode.com/problems/minimum-cost-for-tickets/
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println("Min Cost of ticket: " + minCostOfTickets(days, costs));



    }

    private static int minCostOfTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);

        return minTicketCostHelper(0, days, costs, dp);
    }

    private static int minTicketCostHelper(int i, int[] days, int[] costs, int[] dp) {
        //base case
        if (i >= days.length)
            return 0;

        if (dp[i] != -1)//already calculated
            return dp[i];

        //1 day pass
        int oneDay = costs[0] + minTicketCostHelper(i+1, days, costs, dp);

        //7 day pass
        int nextIndex = nextIndex(i, 7, days);
        int sevenDays = costs[1] + minTicketCostHelper(nextIndex, days, costs, dp);

        //30 day pass
        nextIndex = nextIndex(i, 30, days);
        int thirtyDays = costs[2] + minTicketCostHelper(nextIndex, days, costs, dp);

        dp[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
        return dp[i];
    }

    private static int nextIndex(int curDayIndex, int numOfDays, int[] days) {
        int lastDay = days[curDayIndex]+numOfDays-1;
        int i = curDayIndex;
        while (i < days.length && days[i] <= lastDay)
            i++;
        return i;
    }


    private static int change(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return changeHelper(0, target, coins, dp);
    }

    private static int changeHelper(int i, int target, int[] coins, int[][] dp) {
        //base case
        if (target == 0)
            return 1;
        if (i == coins.length-1){
            if (target%coins[i] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[i][target] != -1) //already calculated
            return dp[i][target];

        int take = 0;
        if (coins[i] <= target)
            take = changeHelper(i, target-coins[i], coins, dp);

        int notTake = changeHelper(i+1, target, coins, dp);

        dp[i][target] = take + notTake;
        return take+notTake;
    }

    private static int coinChange(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        int ans = coinHelper(0, coins, target, dp);
        return ans != (int) 1e9 ? ans : -1;
    }

    private static int coinHelper(int i, int[] coins, int target, int[][] dp) {
        //base case
        if (i == coins.length-1){
            if (target % coins[i] == 0)
                return target/coins[i];
            else
                return (int) 1e9;
        }
        if (target == 0)
            return 0;

        if (dp[i][target] != -1) //already calculated
            return dp[i][target];


        //take
        int take = Integer.MAX_VALUE;
        if (coins[i] <= target)
            take = 1 + coinHelper(i, coins, target - coins[i], dp);

        //dont take
        int notTake = coinHelper(i+1, coins, target, dp);

        dp[i][target] = Math.min(take, notTake);
        return Math.min(take, notTake);
    }

    private static int findTargetSumWays(int[] nums, int target) {
        HashMap<Pair, Integer> map = new HashMap<>();
        return findTargetSumWaysHelper(0, nums, target, map);
    }

    private static int findTargetSumWaysHelper(int i, int[] nums, int target, HashMap<Pair, Integer> dp) {
        //base case
        if (i == nums.length)
            return target == 0 ? 1 : 0;

        Pair pair = new Pair(i, target);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }

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
