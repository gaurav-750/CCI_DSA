package Blind75_Neetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Date: 22-07-2023
        // 19:00
//        TODO  1.ARRAYS AND HASHING
//        todo  https://leetcode.com/problems/contains-duplicate/
        int[] nums = {-1,0,1,2,-1,-4};
//        containsDuplicate(nums);

//        todo https://leetcode.com/problems/valid-anagram/
//        System.out.println("Is Valid Anagram: " +
//                isValidAnagram("anagram", "nagaram"));

//        todo https://leetcode.com/problems/two-sum/
//        twoSum(nums, 9);


        // Date: 23-07-2023
        // 08:45
//        todo https://leetcode.com/problems/group-anagrams/
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        groupAnagrams(strs);

//        todo https://leetcode.com/problems/top-k-frequent-elements/
//        topKFrequent(nums, 2);

//        todo https://leetcode.com/problems/product-of-array-except-self/
//        productExceptSelf(nums);

//        todo https://leetcode.com/problems/longest-consecutive-sequence/
//        longestConsecutive(nums);

//        todo https://leetcode.com/problems/valid-palindrome/
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println("Is valid palindrome: " + isValidPalindrome(s));

//        todo https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//        System.out.println(Arrays.toString(twoSumSortedArray(nums, 18)));

//        todo https://leetcode.com/problems/3sum/
//        threeSum(nums);

//        todo https://leetcode.com/problems/container-with-most-water/
//        int[] heights = {1,4,8,5,1,6,9,7};
//        maxAreaContainer(heights);

//        todo https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//        int[] prices = {7,1,5,3,6,4};
//        System.out.println("Max Profit: " + maxProfit(prices));

//        todo https://leetcode.com/problems/longest-substring-without-repeating-characters/
//        lengthOfLongestSubstring("pwwkew");

//        todo https://leetcode.com/problems/longest-repeating-character-replacement/
        characterReplacement("AABABBA", 1);


    }

    private static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLenSubstr = 0;

        while (r < s.length()){
            char cur = s.charAt(r);
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            //length of substr - max Freq.char <= k

            Map.Entry<Character, Integer> maxValueEntry = Collections.max(map.entrySet(),
                    (entry1, entry2) -> entry1.getValue() - entry2.getValue());
            if ((r-l+1) - maxValueEntry.getValue() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLenSubstr = Math.max(maxLenSubstr, (r-l+1));
            r++;
        }
        return maxLenSubstr;
    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int l = 0, r = 0;

        while (r < s.length()){
            char cur = s.charAt(r);

            if (set.contains(cur)){ //set contains the char 'cur'
                while (set.contains(cur)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }

            set.add(cur);
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0, buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, profitIfSoldToday);

            if (prices[i] < buyPrice)
                buyPrice = prices[i]; //today's Price
        }
        return maxProfit;
    }

    private static int maxAreaContainer(int[] heights) {
        int l = 0, r = heights.length-1;

        int curArea, maxArea = -1;
        while (l < r){
            curArea = Math.min(heights[l], heights[r]) * (r-l);
            maxArea = Math.max(curArea, maxArea);

            if (heights[l] <= heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int a = nums[i]; //current outer element
            int l = i+1, r = nums.length-1;
            while (l < r){
                int threeSum = a + nums[l] + nums[r];

                //two sum 2
                if (threeSum > 0)
                    r--;
                else if (threeSum < 0)
                    l++;
                else { //threeSum == 0
                    res.add(new ArrayList<>(Arrays.asList(a, nums[l], nums[r])));

                    //we could have multiple sols with the current a
                    l += 1;
                    while (nums[l] == nums[l-1] && l < r)
                        l += 1;
                }
            }
        }
        return res;
    }

    private static int[] twoSumSortedArray(int[] nums, int k) {
        int[] res = new int[2];
        int l = 0, r = nums.length-1;

        while (l < r){
            int curSum = nums[l] + nums[r];

            if (curSum == k){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            }

            if (curSum > k)
                r--;
            else
                l++;
        }
        return res;
    }

    private static boolean isValidPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l <= r){
            while (l < s.length() && !isAlphaNumeric(s.charAt(l)))
                l++;

            while (r >= 0 && !isAlphaNumeric(s.charAt(r)))
                r--;

            if (Character.toLowerCase(s.charAt(l)) !=
                Character.toLowerCase(s.charAt(r)))
                return false;
            l++; r--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return ('A' <= c && c <= 'Z') ||
                ('a' <= c && c <= 'z') ||
                ('0' <= c && c <= '9');
    }

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        int count, max = -1;
        for (int num : nums) {
            int cur = num;

            count = 0;
            if (!set.contains(cur - 1)) {
                //this is the first element in the sequence
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 1, post = 1;

        //pre
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }

        //post
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] = res[i] * post;
            post *= nums[i];
        }
        return res;
    }

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //Build a Max Heap
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        //Return the top k frequent elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = maxHeap.poll().getKey();
        return res;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            //sort the string
            char[] sArr = str.toCharArray();
            Arrays.sort(sArr);
            String sortedString = new String(sArr);

            //put in HashMap
            if (!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());

            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
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
