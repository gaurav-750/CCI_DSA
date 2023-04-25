package Two_Pointers;

import java.util.HashMap;

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/valid-palindrome/
//        System.out.println("Is Palindrome: " + isPalindrome("A man, a plan, a canal: Panama"));

//        todo https://leetcode.com/problems/valid-palindrome-ii/
        System.out.println("Is Palindrome: " + isPalindrome2("abc"));

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
