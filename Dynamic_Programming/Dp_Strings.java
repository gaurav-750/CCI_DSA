package Dynamic_Programming;

import java.util.Arrays;
import java.util.Collections;

public class Dp_Strings {
    public static void main(String[] args) {
//        DP on Strings
//        todo https://leetcode.com/problems/longest-common-subsequence/
//        System.out.println("LCS: " + longestCommonSubsequence("adebc", "acadb"));

//        todo https://www.geeksforgeeks.org/printing-longest-common-subsequence/
//        System.out.println("Longest Common Subsequence: " +
//                printLCS(0, 0, "adebc", "acadb"));

//        todo https://leetcode.com/problems/longest-palindromic-subsequence/
        System.out.println("Longest Palindromic Subsequence: " +
                longestPalindromicSubsequence("bbbab"));


    }

    private static int longestPalindromicSubsequence(String s1) {
        String s2 = "";
        for (int i = s1.length()-1; i >= 0; i--) {
            s2 += s1.charAt(i);
        }

        return longestCommonSubsequence(s1, s2);
    }

    private static String printLCS(int i, int j, String s1, String s2) {
//        base case
        if (i >= s1.length() || j >= s2.length())
            return "";

        //match
        if (s1.charAt(i) == s2.charAt(j)){
            return s1.charAt(i) + printLCS(i+1, j+1, s1, s2);
        }

        //not match
        String ans1 = printLCS(i+1, j, s1, s2);
        String ans2 = printLCS(i, j+1, s1, s2);

        return ans1.length() > ans2.length() ? ans1 : ans2;
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
