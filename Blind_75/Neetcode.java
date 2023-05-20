package Blind_75;

import java.util.Arrays;

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/product-of-array-except-self/
//        int[] arr = {2,3,4,6};
//        System.out.println(Arrays.toString(productsExceptSelf(arr)));

//        todo https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("Min: " + findMinInSortedArray(arr));





    }

    private static int findMinInSortedArray(int[] arr) {
        int l = 0, r = arr.length-1;
        int res = arr[0];

        while (l <= r){
             //if you are already in the sorted portion, return arr[l]
            if (arr[l] < arr[r]) {
                res = Math.min(res, arr[l]);
                break;
            }

            int mid = (l+r)/2;
            res = Math.min(res, arr[mid]);
            if (arr[l] <= arr[mid])
                l = mid+1;
            else
                r = mid-1;
        }
        return res;
    }

    private static int[] productsExceptSelf(int[] arr) {
        int[] res = new int[arr.length];
        int pre = 1, post = 1;

        //pre product
        for (int i = 0; i < res.length; i++) {
            res[i] = pre;
            pre *= arr[i];
        }

        //post product
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= arr[i];
        }
        return res;
    }
}
