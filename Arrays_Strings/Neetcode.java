package Arrays_Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {17,18,5,4,6,1};

//        todo https://leetcode.com/problems/contains-duplicate/
//        containsDuplicate(arr);

//        todo https://leetcode.com/problems/valid-anagram/
//        System.out.println("Is Anagram: " + isAnagram("anagram", "nagaram"));

//        todo https://leetcode.com/problems/concatenation-of-array/
//        getConcatenation(arr);

//        todo https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//        replaceElements(arr);

//        todo https://leetcode.com/problems/is-subsequence/
        System.out.println("Is Subsequence: " + isSubsequence("abc", "ahbgdc"));



    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    private static int[] replaceElements(int[] arr) {
        int maxTillNow = Integer.MIN_VALUE, prev = -1, curr;

        for (int i = arr.length-1; i >= 0; i--) {
            curr = arr[i];
            if (prev > maxTillNow){
                arr[i] = prev;
                maxTillNow = prev;
            }else
                arr[i] = maxTillNow;

            if (curr > prev)
                prev = curr;
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static int[] getConcatenation(int[] arr) {
        int[] ans = new int[arr.length*2];
        for (int i = 0; i < arr.length; i++)
            ans[i] = arr[i];
        for (int i = arr.length; i < ans.length; i++)
            ans[i] = arr[i-arr.length];

        return ans;
    }

    private static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        HashMap<Character, Integer> map1 = new HashMap<>(),
//                map2 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map1.containsKey(s.charAt(i)))
//                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
//            else map1.put(s.charAt(i), 1);
//            if (map2.containsKey(t.charAt(i)))
//                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
//            else map2.put(t.charAt(i), 1);
//        }
//        return map1.equals(map2);
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String s_sort = new String(sArr);
        String t_sort = new String(tArr);
        return s_sort.equals(t_sort);
    }

    private static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int elem: arr){
            if (set.contains(elem))
                return true;
            else
                set.add(elem);
        }
        return false;
    }
}
