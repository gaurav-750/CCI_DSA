package Dynamic_Programming;

import java.util.Arrays;

public class Dp_Strings {
    public static void main(String[] args) {
//        DP on Strings
//        todo https://leetcode.com/problems/longest-common-subsequence/
        System.out.println("LCS: " + longestCommonSubsequence("adebc", "acadb"));



    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);

        return lcsHelper(0, 0, s1, s2, dp);
    }

    private static int lcsHelper(int i, int j, String s1, String s2, int[][] dp) {
//        base case
        if (i >= s1.length() || j >= s2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];


        //match - current chars do match of String s1, s2
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcsHelper(i + 1, j + 1, s1, s2, dp);
            return dp[i][j];
        }

        //not match - current chars do not match of String s1 and s2
        dp[i][j] = Math.max(lcsHelper(i+1, j, s1, s2, dp), lcsHelper(i, j+1, s1, s2, dp));
        return dp[i][j];
    }
}
