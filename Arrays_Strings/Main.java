package Arrays_Strings;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        todo Is Unique
//        String str = sc.nextLine();
//        Method 1
//        System.out.println(isUnique(str));
//        Method 2
//        System.out.println(isUnique2(str));

//        todo Check permutation
//        String str1 = sc.nextLine();
//        Method 1
//        System.out.println(checkPermutation(str, str1));
//        Method 2
//        System.out.println(checkPermutationOptimized(str, str1));

//        todo Swapping Arrays:
//        int[] arr = {10,20,30,40,50,60,70,80};
//        swapArrays(arr, 0, 7);
//        System.out.println(Arrays.toString(arr));

//        todo Max Value
//        System.out.println(findMaxValue(arr));

//        todo Odd or Even (by logical operators):
//        System.out.println(isOdd(19));

//        todo Find unique elements from array:
        int[] arr1 = {2,3,4,4,3,2,6};
//        findUniqueElement(arr1);

//        todo Linear Search
//        System.out.println(linearSearch("Samuel", 'u'));

//        todo Search in 2D array:
        int[][] arr2D = {
                {1,2,3},
                {8,9,10},
                {18,19,20}
        };
//        System.out.println(Arrays.toString(searchIn2D(arr2D, 10)));

//        todo https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
//        int[] arr = {12,345,2,6,7896,0};
//        System.out.println("Even digits numbers: " + findNumbers(arr));

//        todo Binary Search
//        int[] arr = {16,14,12,10,8,6,4,2};
//        System.out.println("Index: " + binarySearch(arr, 6));

//        todo Order Agnostic Binary Search
//        System.out.println("Agnostic Binary Search: " + agnosticBinarySearch(arr, 6));

//        todo Ceiling and Floor of a number
//        smallest element >= target element
//        int[] arr = {2,4,6,8,10,12,14,16};
//        System.out.println("Ceiling: " + ceilingOfNumber(arr, 9));
//        System.out.println("Floor: " + floorOfNumber(arr, 9));

//        todo https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//        int[] arr = {5,7,7,8,8,10};
//        int[] arr = {1};
//        System.out.println(Arrays.toString(searchRange(arr, 1)));

//        todo Bubble Sort
//        int[] arr = {50, 13, -2, 0, 1};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

//        todo Selection Sort
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));

//        todo Insertion Sort:
//        int[] arr = {5,4,3,1,2};
//        insertionSort(arr);
//        System.out.println(Arrays.toString(arr));

//        todo Cyclic Sort:
        int[] arr = {4,5,1,2,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));



    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length){
            System.out.println("i = " + i);

            if (arr[i] != i+1) //the element is not at its correct position
                swap(arr, i, arr[i]-1);
            else
                i++;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if (arr[j-1] > arr[j])
                    swap(arr, j-1, j);
                else //that means the array is already sorted
                    break;
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length-i-1;
//            find the maximum element in the remaining array and swap it with the element at its correct position
            int maxIndex = findMaxValue(arr, last);
            swap(arr, maxIndex, last);
        }
    }

    private static int findMaxValue(int[] arr, int last){
        int maxIndex = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) swap(arr, j, j+1);
            }
        }
    }

    private static int[] searchRange(int[] arr, int x) {
        if (arr.length == 0) return new int[]{-1,-1};

        int floor = floor(arr, x);
        int ceil = ceil(arr, x);
        return new int[]{floor, ceil};
    }

    private static int ceil(int[] arr, int x) {
        int start = 0, end = arr.length-1;
        if (x > arr[arr.length-1]) return -1;
        boolean isPresent = false;

        while (start <= end){
            int mid = (start+end)/2;

            if (arr[mid] == x) {
                start = mid+1;
                isPresent = true;
            }else if (arr[mid] < x){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return isPresent ? start-1 : -1;
    }

    private static int floor(int[] arr, int x) {
        int start = 0, end = arr.length-1;
        if (x > arr[arr.length-1]) return -1;
        boolean isPresent = false;

        while (start <= end){
            int mid = (start+end)/2;

            if (arr[mid] == x){
                end = mid-1;
                isPresent = true;
            }else if (arr[mid] > x){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }

        return isPresent ? end+1 : -1;
    }

    private static int floorOfNumber(int[] arr, int x) {
        int start = 0, end = arr.length-1;
        if (x > arr[arr.length-1]) return -1;

        while (start <= end){
            int mid = (start+end)/2;

            if (arr[mid] == x){
                return mid;
            }else if (arr[mid] > x){
                end = mid-1;
            }else { // arr[mid] < x
                start = mid+1;
            }
        }
//        start > end
        return end;
    }

    private static int ceilingOfNumber(int[] arr, int x) {
        int start = 0, end = arr.length-1;
        if (x > arr[arr.length-1]) return -1;

        while (start <= end){
            int mid = (start+end)/2;

            if (arr[mid] == x){
                return mid;
            }else if (arr[mid] > x){
                end = mid-1;
            }else { // arr[mid] < x
                start = mid+1;
            }
        }

//        start > end
        return start;
    }

    private static int agnosticBinarySearch(int[] arr, int x) {
        int s = 0, e = arr.length-1;
        boolean isAscending = arr[s] < arr[e];

        while (s <= e){
            int mid = (s+e)/2;
            if (arr[mid] == x) return mid;

            if (isAscending){
                if (arr[mid] > x) e = mid-1;
                else s = mid+1;
            }else {
                if (arr[mid] < x) e = mid-1;
                else s = mid+1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int x) {
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

    private static boolean containsEven(int num) {
        if (num == 0) return false;
        int cnt = 0;
        while (num > 0){
            num /= 10;
            cnt++;
        }
        return cnt % 2 == 0;
    }

    private static int findNumbers(int[] arr) {
        int count = 0;
        for (int num : arr){
            if (containsEven(num))
                count++;
        }
        return count;
    }

    private static int[] searchIn2D(int[][] arr2D, int x) {
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == x)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1, -1};
    }

    private static int linearSearch(String str, char x) {
        char[] arr = str.toCharArray();
//        ['s', 'a', ....]
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    private static void findUniqueElement(int[] arr) {
        int uniElem = arr[0];
        for (int i = 1; i < arr.length; i++){
            uniElem = uniElem ^ arr[i];
        }
        System.out.println("uniElem = " + uniElem);
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private static int findMaxValue(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        for (int elem: arr){
            if (elem > maxValue){
                maxValue = elem;
            }
        }
        return maxValue;
    }

    private static void swapArrays(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private static boolean checkPermutationOptimized(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] charArr = new int[128]; int n = str1.length();
        for (int i = 0; i < n; i++) {
            charArr[str1.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            charArr[str2.charAt(i)]--;
            if (charArr[str2.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    private static String sortString(String s){
        char[] temp1 = s.toCharArray();
        Arrays.sort(temp1);
        return new String(temp1);
    }

    private static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

//        sort both the strings and check of they r equal:
        return sortString(str1).equals(sortString(str2));
    }

    private static boolean isUnique2(String str) {
        if (str.length() > 128) return false;
        boolean[] charArr = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (charArr[curr])
                return false;
            charArr[curr] = true;
        }
        return true;
    }

    //    Using HashMap
    private static boolean isUnique(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i));
            if (map.containsKey(str.charAt(i))){
                return false;
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        return true;
    }
}
