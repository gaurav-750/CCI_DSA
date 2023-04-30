package BinarySearch;

import java.util.Arrays;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {-4,-1,0,3,10};

//        todo https://leetcode.com/problems/binary-search/
//        search(arr, 9);

//        todo https://leetcode.com/problems/search-insert-position/
//        System.out.println("Insert Position: " + searchInsertPosition(arr, 7));

//        todo https://leetcode.com/problems/guess-number-higher-or-lower/
//        guessNumber(10);

//        todo https://leetcode.com/problems/squares-of-a-sorted-array
//        sortedSquares(arr);

//        todo https://leetcode.com/problems/valid-perfect-square/
//        System.out.println("Is Perfect Square: " + isPerfectSquare(2147483647));

//        todo https://leetcode.com/problems/search-a-2d-matrix/description/
//        int[][] arr2D = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        System.out.println("Is Present in Matrix: " + searchIn2D(arr2D, 0, 164));

//        todo https://leetcode.com/problems/koko-eating-bananas/
        int[] piles = {805306368,805306368,805306368};
        System.out.println("Min Eating Speed: " + minEatingSpeed(piles, 1000000000));



    }

    private static int minEatingSpeed(int[] piles, int h) {
        //find the max eating speed -> it'll be the max. in the piles
        int e = findMax(piles), s = 1; //minimum eating speed will obv. be 1 (cannot be 0, iska matlab vo kha hi nahi raha)

        int mid = 0, res = e;
        while (s <= e){
            mid = (s+e)/2;
            long hoursToEat = calculateHours(piles, mid);

            if (hoursToEat <= h) {
                res = Math.min(res, mid); //possible answer
                e = mid - 1;
            }
            else //hoursToEat > h
                s = mid+1;
        }
        return res;
    }

    private static long calculateHours(int[] piles, int k) {
        long hours = 0;
        for (int elem: piles){
           int h = (int) Math.ceil((double) elem/k);
           hours += h;
        }
        return hours;
    }

    private static int findMax(int[] piles) {
        int max = -1;
        for (int elem: piles){
            if (max < elem)
                max = elem;
        }
        return max;
    }

    private static boolean searchIn2D(int[][] arr2D, int row, int k) {
//        base case
        if (row == arr2D.length)
            return false;

        if (arr2D[row][arr2D[0].length-1] < k)
            return searchIn2D(arr2D, row+1, k);

        //search
        int ans = search(arr2D[row], k);
        return ans != -1;
    }

    private static boolean isPerfectSquare(int n) {
        int s = 1, e = n;

        while (s <= e){
            int mid = s + (e-s)/2;
            long squared = (long) mid *mid;

            System.out.println("squared = " + squared);

            if (squared == n)
                return true;
            else if (squared > n)
                e = mid-1;
            else
                s = mid+1;
        }
        return false;
    }

    private static int[] sortedSquares(int[] arr) {
        int l = 0, r = arr.length-1, i = arr.length-1;
        int[] res = new int[arr.length];

        while (l <= r){
            int l2 = arr[l]*arr[l];
            int r2 = arr[r]*arr[r];

            if (r2 > l2) {
                res[i] = r2;
                r--;
            }else {//l2 >= r2
                res[i] = l2;
                l++;
            }
            i--;
        }
        return res;
    }

    private static int guessNumber(int n) {
        int s = 1, e = n;
        while (s <= e){
            int mid = s + (e-s)/2;

            int output = guess(mid);
            if (output == 0)
                return mid;
            else if (output == 1) //our guess is lower than the pick number
                s = mid+1;
            else //output == -1
                e = mid-1;
        }
        return -1;
    }

    private static int guess(int mid) {
        return 0;
    }

    private static int searchInsertPosition(int[] arr, int k) {
        int s = 0, e = arr.length-1;

        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == k)
                return mid;

            if (arr[mid] < k)
                s = mid+1;
            else //arr[mid] > k
                e = mid-1;
        }
        return s;
    }

    public static int search(int[] arr, int x) {
        int s = 0, e = arr.length-1;

        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                e = mid-1;
            else
                s = mid+1;
        }
        return -1;
    }

}
