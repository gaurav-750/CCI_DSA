package Striver_SDE_Sheet.Arrays_01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/set-matrix-zeroes/
//        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
//        setZeroes(matrix);

//        https://leetcode.com/problems/maximum-subarray/
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println("Subarray with the largest sum: " + maxSubArray(arr));

//        todo https://leetcode.com/problems/sort-colors/
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);



    }

    private static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;

        while (mid <= high){
            if (arr[mid] == 0){
                swap(low, mid, arr);
                low++;
                mid++;
            }else if (arr[mid] == 1){
                mid++;
            }else { //arr[mid] == 2
                swap(mid, high, arr);
                high--;
            }
        }

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static int maxSubArray(int[] arr) {
        // Kadane's Algorithm
        int max = Integer.MIN_VALUE, curSum = 0;
        for (int elem: arr){
            curSum += elem;
            max = Math.max(max, curSum);

            if (curSum < 0)
                curSum = 0;
        }
        return max;
    }

    private static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] row = new int[rows];
        int[] col = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }

    }

}
