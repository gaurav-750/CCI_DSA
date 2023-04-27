package Arrays_Strings;

import java.util.*;

public class Neetcode {
    public static void main(String[] args) {

        int[] arr = {0,3,7,2,5,8,4,6,0,1};

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
//        int len = removeElement(arr, 2);

//        todo https://leetcode.com/problems/unique-email-addresses/
//        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
//        System.out.println("Number of unique emails: " + numUniqueEmails(emails));

//        todo https://leetcode.com/problems/isomorphic-strings/
//        System.out.println("Is Isomorphic: " + isIsomorphic("foo", "bar"));

//        todo https://leetcode.com/problems/can-place-flowers/
//        System.out.println("Can Place Flowers: " + canPlaceFlowers(arr, 2));

//        todo https://leetcode.com/problems/next-greater-element-i/
//        int[] arr1 = {1,3,5,2,4};
//        int[] arr2 = {6,5,4,3,2,1,7};
//        nextGreaterElement(arr1, arr2);
//        nextGreaterElementUsingStack(arr1, arr2);

//        todo https://leetcode.com/problems/find-pivot-index/
//        System.out.println("Pivot Index: " + pivotIndex(arr));


//        https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//        findDisappearedNumbers(arr);

//        todo https://leetcode.com/problems/maximum-number-of-balloons/
//        System.out.println("Max number of balloons: " + maxNumberOfBalloons("nlaebolko"));

//        todo https://leetcode.com/problems/word-pattern/
//        String pattern = "abba", str = "dog dog dog dog";
//        System.out.println("Same Pattern: " + wordPattern(pattern, str));

//        todo https://leetcode.com/problems/sort-an-array/
//        sortArray(arr);

//      todo https://leetcode.com/problems/top-k-frequent-elements/
//        topKFrequentElements(arr, 2);

//        todo https://leetcode.com/problems/product-of-array-except-self/
//        productExceptSelf(arr);
//        productExceptSelfOptimized(arr);

//        todo https://leetcode.com/problems/longest-consecutive-sequence/description/
        longestConsecutive(arr);


    }

    private static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: arr)
            set.add(num);

        int max = -1, cur;
        for (int num: arr){
            int curnum = num; cur = 0;

            if (!set.contains(curnum-1)){ //we r at the minimal element
                while (set.contains(curnum)){
                    cur++;
                    curnum++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    private static int[] productExceptSelfOptimized(int[] arr) {
        int[] res = new int[arr.length];
        int pre = 1, post = 1;
        for (int i = 0; i < arr.length; i++) {
            res[i] = pre;
            pre = pre*arr[i];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            res[i] = res[i]*post;
            post = post*arr[i];
        }

//        System.out.println(Arrays.toString(res));
        return res;
    }

    private static int[] productExceptSelf(int[] arr) {
        int[] prefix = new int[arr.length];
        int[] postfix = new int[arr.length];

        int pre = 1;
        for (int i = 0; i < arr.length; i++) {
            pre = pre*arr[i];
            prefix[i] = pre;
        }

        int post = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            post = post*arr[i];
            postfix[i] = post;
        }

        for (int i = 0; i < arr.length; i++) {
            pre = 1; post = 1;
            if (i-1 >= 0)
                pre = prefix[i-1];
            if (i+1 < arr.length)
                post = postfix[i+1];
            arr[i] = pre *  post;
        }
        return arr;
    }

    private static int[] topKFrequentElements(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: arr)
            map.put(num, map.getOrDefault(num, 0)+1);

//        declare a maxHeap
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue());

//        add all the map elements to the maxHeap
        maxHeap.addAll(map.entrySet());

//        poll k from maxHeap
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res[i] = entry.getKey();
        }
        return res;
    }

    private static int[] sortArray(int[] arr) {
//        base case
        if (arr.length == 1)
            return arr;

        int mid = arr.length/2;
        int[] firstHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(arr, mid, arr.length);

        int[] arr1 = sortArray(firstHalf);
        int[] arr2 = sortArray(secondHalf);
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

    private static boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split("\\s");
        if (pattern.length() != strArr.length)
            return false;

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String cur = strArr[i];

            if (map1.containsKey(c) && !map1.get(c).equals(cur))
                return false;
            if (map2.containsKey(cur) && c != map2.get(cur))
                return false;

            map1.put(c, cur);
            map2.put(cur, c);
        }
        return true;
    }

    private static int maxNumberOfBalloons(String str) {
        String s = "balloon";
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map1.containsKey(str.charAt(i))) map1.put(str.charAt(i), map1.get(str.charAt(i)) + 1);
            else map1.put(str.charAt(i), 1);
        }

        int count = 0; int i;
        while (true){
            for (i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map1.containsKey(c) && map1.get(c) > 0)
                    map1.put(c, map1.get(c)-1);
                else
                    return count;
            }

            if (i == s.length())
                count += 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length){
            if (arr[i] != i+1 && arr[i] != arr[arr[i]-1]){
                swap(arr, i, arr[i]-1);
            }else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < arr.length; j++)
            if (arr[j] != j+1)
                res.add(j+1);
        return res;
    }

    private static int pivotIndex(int[] arr) {
        int totalSum = 0;
        for (int elem: arr) totalSum += elem;

        int leftSum = 0, rightSum = totalSum;
        for (int i = 0; i < arr.length; i++) {
            rightSum = rightSum - arr[i];

            if (leftSum == rightSum)
                return i;
            leftSum += arr[i];
        }
        return -1;
    }

    private static int[] nextGreaterElementUsingStack(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++)
            map.put(arr1[i], i);
        Arrays.fill(arr1, -1);

        Stack<Integer> stack = new Stack<>();
        for (int cur : arr2) {
            while (!stack.isEmpty() && cur > stack.peek()) {
                int val = stack.pop();
                int idx = map.get(val);
                arr1[idx] = cur;
            }

            if (map.containsKey(cur))
                stack.push(cur);
        }
        return arr1;
    }

    private static int[] nextGreaterElement(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], i);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])){
//                find the next greater element
                int greater = -1;
                for (int j = i+1; j < arr2.length; j++) {
                    if (arr2[j] > arr2[i]){
                        greater = arr2[j];
                        break;
                    }
                }

                System.out.println("greater = " + greater);
                arr1[map.get(arr2[i])] = greater;
                System.out.println(Arrays.toString(arr1));
            }
        }
        return arr1;
    }

    private static boolean canPlaceHere(int[] arr, int i) {
        if (i-1 >= 0 && arr[i-1] == 1)
            return false;
        if (i+1 < arr.length && arr[i+1] == 1)
            return false;
        return true;
    }

    private static boolean canPlaceFlowers(int[] arr, int n) {
        if (n == 0) return true;

        int i = 0;
        while (i < arr.length){
            if (arr[i] == 0 && canPlaceHere(arr, i)) {
                arr[i] = 1; n--;
                if (n == 0) return true;
            }
            i++;
        }
        return false;
    }

    private static boolean isIsomorphic(String str1, String str2) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        int i = 0;
        while (i < str2.length()){
            char c1 = str1.charAt(i), c2 = str2.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2) return false;
            else map1.put(c1, c2);

            if (map2.containsKey(c2) && map2.get(c2) != c1) return false;
            else map2.put(c2, c1);
            i++;
        }
        return true;
    }

    private static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email: emails){
            email = formatEmail(email);
            set.add(email);
        }
        return set.size();
    }

    private static String formatEmail(String email) {
//        "test.email+alex@leetcode.com"
        String[] arr = email.split("@");
//      [test.email+alex, leetcode.com]
        String local = arr[0];
        local = local.replaceAll("\\.", "");
//        testemail+alex

        String[] localNameArr = local.split("\\+");
        String localName = localNameArr[0];
        return localName + "@" + arr[1];
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
