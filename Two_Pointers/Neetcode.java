package Two_Pointers;

import java.util.Arrays;
import java.util.HashMap;

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/valid-palindrome/
//        System.out.println("Is Palindrome: " + isPalindrome("A man, a plan, a canal: Panama"));

//        todo https://leetcode.com/problems/valid-palindrome-ii/
//        System.out.println("Is Palindrome: " + isPalindrome2("abc"));

//        todo https://leetcode.com/problems/reverse-string/
//        char[] sArr = {'h','e','l','l','o'};
//        reverseAString(sArr);

//        todo https://leetcode.com/problems/merge-sorted-array/description/
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        mergeSortedArray(nums1, nums2, m, n);

    }

    private static void mergeSortedArray(int[] nums1, int[] nums2, int m, int n) {
        int i = 0, j = 0;
        while (i < m && j < n){
            if (nums1[i] <= nums2[j]){
                i++;
            }else if (nums1[i] > nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++; j++;
            }
//            i--;j--;

            while (j < nums1.length){
                nums1[i] = nums2[j];
                i++; j++;
            }
            System.out.println(Arrays.toString(nums1));
        }
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
