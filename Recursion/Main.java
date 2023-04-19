package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        todo nth fibonacci number
//        System.out.println("Fibonacci Number: " + fibonnaci(8));

//        todo Binary search using Recursion
//        int[] arr = {15,17,21,27,28};
//        System.out.println("BS Index: " + binarySearchRec(arr, 0, arr.length-1, 177));

//        todo Print nums from n to 1
//        printNums(10);

//        todo Print nums from 1 to n
//        printNums2(10);

//        todo Factorial of a number
//        System.out.println("Factorial: " + fact(8));

//        todo Sum of digits
//        System.out.println("Sum of digits: " + sumOfDigits(1234));

//        todo Reverse the number
//        12345 -> 54321
//        System.out.println("Reverse: " + reverseNumber(12345));

//        todo Find count of zeroes in a number
//        countZeroes(100210);

//        todo https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
//        System.out.println("Number of steps: " + numberOfSteps(123));

//        todo Check if array is sorted
//        int[] arr = {1,2,4,5,17,9};
//        System.out.println("Is Array Sorted: " + isArraySorted(arr, 0));

//        todo Linear Search using Recursion
//        System.out.println("Index: " + linearSearch(arr, 0, 17));

//        todo Find multiple occurrences inside Array
//        int[] arr = {1,2,5,3,4,5,5};
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println("List: " + findMultipleOccurrences(arr, 0, 5, list));

//        todo Pattern1
//        pattern1(5, 0);
//        pattern2(0, 4);

//        todo bubble sort using Recursion
//        int[] arr = {4,3,2,5,1,9,8};
//        bubbleSort(arr, 0, arr.length-1);
//        bubbleSort2(arr, arr.length);
//        System.out.println(Arrays.toString(arr));

//        todo Selection Sort using Recursion
//        selectionSort(arr, 0);

//        todo Merge Sort
        int[] arr = {8,3,4,12,5,6};
        mergeSort(arr);


    }

    private static int[] mergeSort(int[] arr) {
//        base case
        if (arr.length == 1)
            return arr;

        int mid = (arr.length)/2;
        int[] firstHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(arr, mid, arr.length);

        int[] arr1 = mergeSort(firstHalf);
        int[] arr2 = mergeSort(secondHalf);
        return merge(arr1, arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        if (arr1.length == 0) return arr2;
        if (arr2.length == 0) return arr1;

        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length){
           if (arr1[i] <= arr2[j]) {
               arr[k] = arr1[i];
               i++;
           }else { // arr2[j] > arr1[i]
               arr[k] = arr2[j];
               j++;
           }
           k++;
        }

        while (i < arr1.length){
            arr[k] = arr1[i];
            k++; i++;
        }
        while (j < arr2.length){
            arr[k] = arr2[j];
            k++; j++;
        }
        return arr;
    }

    private static void selectionSort(int[] arr, int start) {
//        base case
        if (start == arr.length-1) return;

        int minIndex = getMinIndex(arr, start);
        swap(arr, minIndex, start);
        selectionSort(arr, start+1);
    }

    private static int getMinIndex(int[] arr, int start) {
        int mIndex = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[mIndex])
                mIndex = i;
        }
        return mIndex;
    }

    private static void bubbleSort2(int[] arr, int last) {
//        base case
        if (last == 0) return;
        for (int i = 0; i < last-1; i++) {
            if (arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }

        bubbleSort2(arr, last-1);
    }

    private static void bubbleSort(int[] arr, int cur, int last) {
//        base case
        if (last == 0) return;
        if (cur == last) {
            bubbleSort(arr, 0, last - 1);
            return;
        }

        if (arr[cur] > arr[cur+1])
            swap(arr, cur, cur+1);

        bubbleSort(arr, cur+1, last);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void pattern2(int cur, int row) {
//        base case
        if (cur == row) return;

        for (int i = 0; i <= cur; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
        pattern2(cur+1, row);
    }

    private static void pattern1(int row, int col) {
//        base case
        if (row == 0) return;

        if (row > col) {
            System.out.print("*" + " ");
            pattern1(row, col + 1);
        }else {
            System.out.println();
            pattern1(row-1, 0);
        }
    }

    private static ArrayList<Integer> findMultipleOccurrences(int[] arr, int ind, int x, ArrayList<Integer> list) {
        System.out.println(ind + ", " + list);
//        base case
        if (arr.length == ind)
            return list;

        if (arr[ind] == x)
            list.add(ind);

        return findMultipleOccurrences(arr, ind+1, x, list);
    }

    private static int linearSearch(int[] arr, int ind, int x) {
//        base case
        if (arr.length == ind)
            return -1;

        if (arr[ind] == x) return ind;
        return linearSearch(arr, ind+1, x);
    }

    private static boolean isArraySorted(int[] arr, int ind) {
//        base case
        if (arr.length-1 == ind)
            return true;

        if (arr[ind] > arr[ind+1])
            return false;
        return isArraySorted(arr, ind+1);
    }

    private static int numberOfSteps(int n) {
//        base case
        if (n == 0)
            return 0;

        if (n % 2 == 0)
            return numberOfSteps(n/2)+1;
        else //odd
            return numberOfSteps(n-1)+1;
    }

    private static void countZeroes(int num) {
        if (num == 0)
            System.out.println(1);

        System.out.println("Number of Zeroes: " + helperZeroes(num, 0));
    }

    private static int helperZeroes(int num, int count) {
//        base condition
        if (num == 0)
            return count;

        int rem = num%10;
        if (rem == 0)
            return helperZeroes(num/10, count+1);
        else
            return helperZeroes(num/10, count);
    }

    //    static int res = 0;
    private static int reverseNumber(int num) {
//        base condition
        if (num < 10)
            return num;

        int smallOutput = reverseNumber(num/10);
        int power = (int) Math.log10(smallOutput) + 1;
        return (int) (num%10 * Math.pow(10, power)) + smallOutput;
//        res = res * 10 + num%10;
//        reverseNumber(num/10);
    }

    private static int sumOfDigits(int num) {
//        base condition
        if (num < 10)
            return num;

        return num%10 + sumOfDigits(num/10);
    }

    private static int fact(int n) {
//        base condition
        if (n == 0 || n == 1)
            return 1;

        return n * fact(n-1);
    }

    private static void printNums2(int n) {
//        base condition
        if (n < 1)
            return;

        printNums2(n-1);
        System.out.println(n);
    }

    private static void printNums(int n) {
        if (n < 1)
            return;

        System.out.println(n);
        printNums(n-1);
    }

    private static int binarySearchRec(int[] arr, int s, int e, int x){
//        base condition
        if (s > e)
            return -1;

        int mid = (s+e)/2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return binarySearchRec(arr, s, mid-1, x);
        else
            return binarySearchRec(arr, mid+1, e, x);
    }

    private static int fibonnaci(int num) {
//        base condition
        if (num == 0 || num == 1)
            return num;

        return fibonnaci(num-1) + fibonnaci(num-2);
    }

}
