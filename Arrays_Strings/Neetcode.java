package Arrays_Strings;

import java.util.*;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {0,1,2,2,3,0,4,2};

//        todo https://leetcode.com/problems/contains-duplicate/
//        containsDuplicate(arr);

//        todo https://leetcode.com/problems/valid-anagram/
//        System.out.println("Is Anagram: " + isAnagram("anagram", "nagaram"));

//        todo https://leetcode.com/problems/concatenation-of-array/
//        getConcatenation(arr);

//        todo https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//        replaceElements(arr);

//        todo https://leetcode.com/problems/is-subsequence/
//        System.out.println("Is Subsequence: " + isSubsequence("abc", "ahbgdc"));

//        todo https://leetcode.com/problems/length-of-last-word/
//        System.out.println("Length of last word: " + lengthOfLastWord("   fly me   to   the moon  "));

//        todo https://leetcode.com/problems/longest-common-prefix/
//        String[] strs = {"flower","flow","flight"};
//        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));

//        todo https://leetcode.com/problems/group-anagrams/description/
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        System.out.println("Group Anagrams: " + groupAnagrams(strs));

//        https://leetcode.com/problems/pascals-triangle/
//        generatePascalsTriangle(5);

//        todo https://leetcode.com/problems/remove-element/
        int len = removeElement(arr, 2);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static int removeElement(int[] arr, int val) {
        int i = 0, j = 0; int count = 0;
        while (j < arr.length){
            System.out.println(i + ", " + j);
            if (arr[i] == val) { // arr[i] = 2
                while (j < arr.length && arr[j] == val)
                    j++;

                //place element of j at i
                if (j < arr.length) {
                    count++;
                    arr[i] = arr[j];
                    arr[j] = 2;
                }

                i++;
            }else {
                i++;
                j++;
            }
        }
        return arr.length-count;
    }

    private static List<List<Integer>> generatePascalsTriangle(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        res.add(innerList);

        int i = 1;
        while (i < n){
            List<Integer> prevList = res.get(i-1);
            innerList = new ArrayList<>();

            innerList.add(1);
            for (int j = 0; j < prevList.size()-1; j++) {
                innerList.add(prevList.get(j) + prevList.get(j+1));
            }
            innerList.add(1);

            res.add(innerList);
            i++;
        }
        return res;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
//            sort the string
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedString = String.valueOf(strArr);

            if (!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            if (isCommon(strs, c, i)){
                prefix += c;
            }else
                return prefix;
        }
        return prefix;
    }

    private static boolean isCommon(String[] strs, char c, int ind) {
        for (String str : strs){
            if (str.length() <= ind || str.charAt(ind) != c)
                return false;
        }
        return true;
    }

    private static int lengthOfLastWord(String str) {
        str = str.trim();
        int i = str.length()-1, len = 0;

        while (i >= 0 && str.charAt(i) != ' '){
            len++;
            i--;
        }
        return len;
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
