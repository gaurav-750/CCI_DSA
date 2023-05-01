package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {5,7,7,8,8,10};

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
//        int[] piles = {805306368,805306368,805306368};
//        System.out.println("Min Eating Speed: " + minEatingSpeed(piles, 1000000000));

//        todo https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//        int[] arr = {3,4,5,6,7,0,1,2};
//        findMin(arr);

//        todo https://leetcode.com/problems/search-in-rotated-sorted-array/
//        System.out.println("Search in rotated array: " + searchInRotatedArray(arr, 0));

//        todo https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//        searchRange(arr, 8);

//        todo https://leetcode.com/problems/search-suggestions-system/
//        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
//        String searchWord = "mouse";
//        System.out.println(searchSuggestion(products, searchWord));


    }

    private static List<List<String>> searchSuggestion(String[] products, String searchWord) {
//        sort the products
        Arrays.sort(products);
        int s = 0, e = products.length-1;
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i); //current character
            while (s <= e && (products[s].length() <= i || products[s].charAt(i) != c))
                s++;
            while (s <= e && (products[s].length() <= i || products[e].charAt(i) !=c))
                e--;

            int remain = e-s+1;
            ArrayList<String> innerList = new ArrayList<>();
            for (int j = 0; j < Math.min(3, remain); j++) {
                innerList.add(products[s+j]);
            }
            res.add(innerList);
        }
        return res;
    }

    private static int[] searchRange(int[] arr, int x) {
        int[] res = new int[2];
        res[0] = firstPosition(arr, x);
        res[1] = lastPosition(arr, x);
        return res;
    }

    private static int firstPosition(int[] arr, int x) {
        int s = 0, e = arr.length-1;
        boolean isPresent = false;

        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == x){
                e = mid-1;
                isPresent = true;
            }else if(arr[mid] > x)
                e = mid-1;
            else
                s = mid+1;
        }

        System.out.println(e+1);
        return isPresent ? e+1 : -1;
    }

    private static int lastPosition(int[] arr, int x) {
        int s = 0, e = arr.length-1;
        boolean isPresent = false;

        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == x){
                s = mid+1;
                isPresent = true;
            }else if (arr[mid] > x)
                e = mid-1;
            else
                s = mid+1;
        }
        return isPresent ? s-1 : -1;
    }

    private static int searchInRotatedArray(int[] arr, int k) {
        //get the pivot Index
        int pivot = getPivotIndex(arr);
        int ans = binarySearch(arr, k, 0, pivot-1);
        if (ans != -1) return ans;

        return binarySearch(arr, k, pivot, arr.length-1);
    }

    private static int binarySearch(int[] arr, int k, int s, int e) {
        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == k)
                return mid;
            else if (arr[mid] > k)
                e = mid-1;
            else
                s = mid+1;
        }
        return -1;
    }

    private static int getPivotIndex(int[] arr) {
        int s = 0, e = arr.length-1;
        int pivotIndex = 0;

        while (s <= e){
            int mid = (s+e)/2;
            if (mid != arr.length-1 && arr[mid] > arr[mid+1])
                return mid+1;

            if (arr[s] <= arr[mid])
                s = mid+1;
            else
                e = mid-1;
        }
        return pivotIndex;
    }

    private static int findMin(int[] arr) {
        int s = 0, e = arr.length-1;
        int res = arr[0];

        while (s <= e){
            if (arr[s] <= arr[e])
                return Math.min(res, arr[s]);

            int mid = (s+e)/2;
            res = Math.min(res, arr[mid]);

            if (arr[s] <= arr[mid])
                s = mid+1;
            else //arr[mid] < arr[s]
                e = mid-1;
        }
        return res;
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
