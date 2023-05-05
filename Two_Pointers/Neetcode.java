package Two_Pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,2,3,3};

//        todo https://leetcode.com/problems/valid-palindrome/
//        System.out.println("Is Palindrome: " + isPalindrome("A man, a plan, a canal: Panama"));

//        todo https://leetcode.com/problems/valid-palindrome-ii/
//        System.out.println("Is Palindrome: " + isPalindrome2("abc"));

//        todo https://leetcode.com/problems/reverse-string/
//        char[] sArr = {'h','e','l','l','o'};
//        reverseAString(sArr);

//        todo https://leetcode.com/problems/merge-sorted-array/description/
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        mergeSortedArray(nums1, 3, nums2, 3);

//        todo https://leetcode.com/problems/move-zeroes/
//        moveZeroesToEnd(arr);

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//        System.out.println("Number of unique elements: " + removeDuplicates(arr));
//        System.out.println(Arrays.toString(arr));

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//        System.out.println("Ans: " + removeDuplicates2(arr));

        


    }

    private static int removeDuplicates2(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length){
            int count = 1;
            //jab tak duplicate elements hai, aage badhao j ko
            while (j+1 < arr.length && arr[j] == arr[j+1]){
                j++;
                count++;
            }

            //copy Math.min(2,count) times element at j to i, i++;
            for (int k = 0; k < Math.min(2, count); k++) {
                arr[i] = arr[j];
                i++;
            }

            j++;
        }

//        System.out.println(Arrays.toString(arr));
        return i;
    }

    private static int removeDuplicates(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length){
            while (j < arr.length && arr[i] == arr[j])
                j++;

            if (j == arr.length)
                break;
            //elements at i and j are not equal
            i++;
            arr[i] = arr[j];
        }
        return i+1;
    }

    private static void moveZeroesToEnd(int[] arr) {
        int i = 0, j = 0;

        while (j < arr.length){
            if (arr[j] != 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
            j++;
        }
    }

    private static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = nums1.length-1;

        while (i >= 0 && j >= 0){
            if (nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else { //nums2[j] > nums1[i]
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (i >= 0){
            nums1[k] = nums1[i];
            i--; k--;
        }
        while (j >= 0){
            nums1[k] = nums2[j];
            j--; k--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    private static void reverseAString(char[] sArr) {
        int i = 0, j = sArr.length-1;
        while (i < j){
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            i++; j--;
        }
    }

    private static boolean isPalindrome2(String str) {
        int s = 0, e = str.length()-1;

        while (s < e){
            if (str.charAt(s) != str.charAt(e)){
                return checkIfRemainingIsPalindrome(str, s+1, e) ||
                        checkIfRemainingIsPalindrome(str, s, e-1);
            }
            s++; e--;
        }
        return true;
    }

    private static boolean checkIfRemainingIsPalindrome(String str, int s, int e) {
        while (s < e){
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++; e--;
        }
        return true;
    }

    private static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s", "");
//        to remove all characters except letters and numbers
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();

//        str -> amanaplanacanalpanama
        int s = 0, e = str.length()-1;
        while (s < e){
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
}
