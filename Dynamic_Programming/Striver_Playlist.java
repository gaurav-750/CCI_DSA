package Dynamic_Programming;

import java.util.Arrays;

public class Striver_Playlist {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/fibonacci-number/description/
//        fibonacci(5);

//        todo https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
        int[] heights = {10,20,30,10};
//        System.out.println("Minimum energy lost: " + frogJump(heights));
//        System.out.println("Minimum energy: " + frogJumpTabulation(heights));

//        todo https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
        int[] arr = {2, 1, 4, 9};
        System.out.println("Max Sum of non adjacent elements: " +
                                        maxSumNonAdjacent(arr));


    }

    private static int maxSumNonAdjacent(int[] arr) {
        return maxSumHelper(0, arr);
    }

    private static int maxSumHelper(int i, int[] arr) {
//        base case
        if (i >= arr.length)
            return 0;
        if (i == arr.length-1)
            return arr[i];


        int pick = arr[i] + maxSumHelper(i+2, arr);
        int notPick = maxSumHelper(i+1, arr);

        return Math.max(pick, notPick);
    }

    private static int frogJumpTabulation(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[n-1] = 0;

        for (int i = n-2; i >= 0; i--) {
            int oneStep = Math.abs(heights[i] - heights[i+1]) + dp[i+1];

            int twoStep = Integer.MAX_VALUE;
            if (i+2 < n){
                twoStep = Math.abs(heights[i] - heights[i+2]) + dp[i+2];
            }

            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[0];
    }

    private static int frogJump(int[] heights) {
        int[] dp = new int[heights.length+1];
        Arrays.fill(dp, -1);

        return frogJumpHelper(0, heights, dp);
    }

    private static int frogJumpHelper(int i, int[] heights, int[] dp) {
//        base case
        if (i == heights.length-1)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int ans1 = frogJumpHelper(i+1, heights, dp);
        ans1 += Math.abs(heights[i] - heights[i+1]);

        int ans2 = Integer.MAX_VALUE;
        if (i+2 < heights.length){
            ans2 = frogJumpHelper(i+2, heights, dp);
            ans2 += Math.abs(heights[i] - heights[i+2]);
        }

        dp[i] = Math.min(ans1, ans2);
        return dp[i];
    }

    private static int fibonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= 5; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
