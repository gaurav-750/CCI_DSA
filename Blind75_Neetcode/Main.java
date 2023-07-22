package Blind75_Neetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // Date: 22-07-2023
        // 19:00
//        TODO  1.ARRAYS AND HASHING
//        todo  https://leetcode.com/problems/contains-duplicate/
        int[] nums = {1,2,3,1};
//        containsDuplicate(nums);

//        todo https://leetcode.com/problems/valid-anagram/
//        System.out.println("Is Valid Anagram: " +
//                isValidAnagram("anagram", "nagaram"));

//        todo https://leetcode.com/problems/two-sum/
//        twoSum(nums, 9);
z2


    }

    private static int[] twoSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++){
            int numToBeFound = k-nums[i];
            if (map.containsKey(numToBeFound)) {
                //return ans
                ans[0] = map.get(numToBeFound);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    private static boolean isValidAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
//            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        return map1.equals(map2);

        //sort both the strings and then compare them
        char[] sArr = s.toCharArray(),
                tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return new String(sArr).equals(new String(tArr));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int elem: nums){
            if (set.contains(elem))
                return true;
            set.add(elem);
        }
        return false;
    }
}
