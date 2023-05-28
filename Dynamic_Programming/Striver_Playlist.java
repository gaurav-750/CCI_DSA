package Dynamic_Programming;

import java.util.ArrayList;
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
//        int[] arr = {2, 1, 4, 9};
//        System.out.println("Max Sum of non adjacent elements: " +
//                                        maxSumNonAdjacent(arr));

//        todo https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
//        int[][] points = {
//                {10,40,70},
//                {20,50,80},
//                {30,60,90}};
//        System.out.println("Max Ninja training points: " + ninjaTraining(3, points));

//        todo https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470?leftPanelTab=0
//        System.out.println("Total Unique Paths: " + uniquePaths(3, 3));

//        todo https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241
//        int[][] mat = {
//                {0,0,0},
//                {0,-1,0},
//                {0,0,0}};
//        System.out.println("Paths with obstacles: " + uniquePathsWithObstacles(3, 3, mat));

//        todo https://leetcode.com/problems/minimum-path-sum/description/
//        int[][] path = {
//                {1,3,1},
//                {1,5,1},
//                {4,2,1}};
//        System.out.println("Min Path Sum: " + minimumPathSum(path));

//        todo https://www.codingninjas.com/codestudio/problems/triangle_1229398
        int[][] triangle = {
                {1},
                {2,3},
                {3,6,7},
                {8,9,6,10}};
        System.out.println("Min Path Sum Triangle: " + minPathSumTriangle(triangle));




    }

    private static int minPathSumTriangle(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return minPathSumTriangleHelper(0, 0, triangle, dp);
    }

    private static int minPathSumTriangleHelper(int i, int j, int[][] triangle, int[][] dp) {
//        base case -> you have reached the last row
        if (i == triangle.length-1)
            return triangle[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        //down
        int down = minPathSumTriangleHelper(i+1, j, triangle, dp);

        //diagonal
        int diagonal = minPathSumTriangleHelper(i+1, j+1, triangle, dp);

        dp[i][j] = triangle[i][j] + Math.min(down, diagonal);
        return dp[i][j];
    }

    private static int minimumPathSum(int[][] path) {
        int[][] dp = new int[path.length][path[0].length];
//        for (int[] arr: dp)
//            Arrays.fill(arr, -1);
//
//        return minPathHelper(0, 0, path, dp);

//        TABULATION
        int m = path.length-1, n = path[0].length-1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) { //base case
                    dp[i][j] = path[i][j];
                    continue;
                }

                int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
                if (j+1 <= n)
                    right = dp[i][j+1];
                if (i+1 <= m)
                    down = dp[i+1][j];

                dp[i][j] = path[i][j] + Math.min(right, down);
            }
        }
        return dp[0][0];
    }

    private static int minPathHelper(int i, int j, int[][] path, int[][] dp) {
        if (i >= path.length || j >= path[0].length)
            return Integer.MAX_VALUE;
//        base case
        if ((i == path.length-1 )&& (j == path[0].length-1))
            return path[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];

        int right = minPathHelper(i, j+1, path, dp);
        int down = minPathHelper(i+1, j, path, dp);

        dp[i][j] = path[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    private static int uniquePathsWithObstacles(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];

        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return uniquePathsWithObstaclesHelper(0, 0, m, n, mat, dp);
    }

    private static int uniquePathsWithObstaclesHelper(int i, int j, int m, int n, int[][] mat, int[][] dp) {
        if (i == m || j == n) //out of bounds
            return 0;
//        base case
        if (mat[i][j] == -1)
            return 0;
        if (i == m-1 && j == n-1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = uniquePathsWithObstaclesHelper(i, j+1, m, n, mat, dp);
        int down = uniquePathsWithObstaclesHelper(i+1, j, m, n, mat, dp);

        dp[i][j] = right+down;
        return right+down;
    }

    private static int uniquePaths(int row, int col) {
        int[][] dp = new int[row][col];

//        for (int[] arr: dp)
//            Arrays.fill(arr, -1);
//        return uniquePathsHelper(0, 0, row, col, dp);

        //Using tabulation

        for (int i = (row-1); i >= 0; i--) {
            for (int j = (col-1); j >= 0; j--) {
                if (i == row-1 && j == col-1) {
                    dp[i][j] = 1; //base case
                    continue;
                }

                int right = 0, down = 0;
                if (j+1 < col)
                    right = dp[i][j+1];
                if (i+1 < row)
                    down = dp[i+1][j];

                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
    }

    private static int uniquePathsHelper(int i, int j, int row, int col, int[][] dp) {
        if (i == row || j == col) //out of bounds
            return 0;
//        base case
        if (i == row-1 && j == col-1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        //right
        int right = uniquePathsHelper(i, j+1, row, col, dp);
        //down
        int left = uniquePathsHelper(i+1, j, row, col, dp);

        dp[i][j] = right+left;
        return right+left;
    }

    private static int ninjaTraining(int n, int[][] points) {
        //n -> rows (number of days)
        int[][] dp = new int[n][4];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return maxPoints(n-1, points[0].length, points, dp);
    }

    private static int maxPoints(int day, int last, int[][] points, int[][] dp) {
//        base case
        if (day == 0){
            int max = -1;
            for (int i = 0; i < points.length; i++) {
                if (i != last)
                    max = Math.max(max, points[0][i]);
            }
            return max;
        }

        if (dp[day][last] != -1)
            return dp[day][last];

        int max = -1;
        for (int i = 0; i < points.length; i++) {
            if (i == last)
                continue;

            int smallPoints = points[day][i] + maxPoints(day-1, i, points, dp);
            max = Math.max(max, smallPoints);
        }

        dp[day][last] = max;
        return max;
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
