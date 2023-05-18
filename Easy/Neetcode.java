package Easy;

import java.util.Arrays;

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
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max Profit: " + maxProfit(prices));



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
