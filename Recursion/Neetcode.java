package Recursion;

import java.util.*;

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/subsets/
//        int[] arr = {1,2,3};
//        System.out.println("Subsets: " + getSubsets(arr));

//        todo https://leetcode.com/problems/combination-sum/description/
//        int[] arr = {2,3,5};
//        System.out.println("Combination Sum: " + combinationSum(arr, 8));

//        todo https://leetcode.com/problems/combinations/
//        System.out.println("All Combinations: " + combinations(4, 3));

//        todo https://leetcode.com/problems/permutations/
//        int[] arr = {1,2,3};
//        System.out.println("Permutations: " + permutations(arr));

//        todo https://leetcode.com/problems/subsets-ii/
//        int[] arr = {1,2,2};
//        System.out.println("Subsets: " + subsets2(arr));

//        todo https://leetcode.com/problems/combination-sum-ii/
//        int[] arr = {10,1,2,7,6,1,5};
//        System.out.println("Combination sum 2: " + combinationSum2(arr, 8));

//        https://leetcode.com/problems/permutations-ii/
//        int[] arr = {1,2,2};
//        System.out.println("Permutations 2: " + permutations2(arr));

//        todo https://leetcode.com/problems/word-search/
//        char[][] board = {{'C', 'A', 'A'},
//                          {'A', 'A', 'A'},
//                          {'B', 'C', 'D'}};
//        String word = "AAB";
//        System.out.println("Found: " + wordSearch(board, word));

//        todo https://leetcode.com/problems/palindrome-partitioning/
//        System.out.println("Partitions: " + palindromePartition("aab"));

//        todo https://leetcode.com/problems/restore-ip-addresses/
//        restoreIpAddresses("25525511135");

//        todo https://leetcode.com/problems/matchsticks-to-square/
//        int[] matchSticks = {1,1,2,2,2};
//        System.out.println("Can make square: " + makeSquare(matchSticks));

        System.out.println(Integer.parseInt("00004"));
//        todo https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
        System.out.println("Can Split: " + splitString("0500403"));



    }

    private static boolean splitString(String s) {
        if (Integer.parseInt(s) < 10)
            return false;

        return splitHelper(0, "", s);
    }

    private static boolean splitHelper(int curInd, String prev, String s) {
        System.out.println(curInd + ", " + prev);
//        base case
        if (curInd == s.length())
            return true;


        for (int i = curInd; i < s.length(); i++) {
            String subStr = s.substring(curInd, i+1);
            System.out.println("subStr = " + subStr + " " + (curInd + "," + (i+1)));
            if (subStr == (s))
                return false;
            if (!prev.equals("") && Integer.parseInt(prev) - Integer.parseInt(subStr) != 1) {
                System.out.println("diff is not 1..");
                return false;
            }

            boolean ans = splitHelper(i+1, subStr, s);
            if (ans) return true;
        }

        return false;
    }

    private static boolean makeSquare(int[] matchSticks) {
        int sum = 0;
        for (int elem: matchSticks)
            sum += elem;

        int length = sum/4;
        if (sum % 4 != 0) //cannot be a square
            return false;

        reverseArr(matchSticks);
        int[] sides = new int[4];
        return makeSquareHelper(0, length, sides, matchSticks);
    }

    private static void reverseArr(int[] matchSticks) {
        int i = 0, j = matchSticks.length-1;
        while (i < j){
            int temp = matchSticks[i];
            matchSticks[i] = matchSticks[j];
            matchSticks[j] = temp;
            i++;j--;
        }
    }

    private static boolean makeSquareHelper(int i, int length, int[] sides, int[] matchSticks) {
        if (i == matchSticks.length)
            return true;

        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchSticks[i] <= length){
                sides[j] += matchSticks[i];

                boolean canMakeSquare = makeSquareHelper(i+1, length, sides, matchSticks);
                if (canMakeSquare)
                    return true;
                sides[j] = sides[j] - matchSticks[i];
            }
        }
        return false;
    }

//    private static void restoreIpAddresses(String s) {
//    }

    private static List<List<String>> palindromePartition(String s) {
        List<List<String>> list = new ArrayList<>();
        partitionHelper(s, new ArrayList<String>(), list);
        return list;
    }

    private static void partitionHelper(String s, ArrayList<String> temp, List<List<String>> list) {
        if (s.equals("")){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i+1);
            if (!isPalindrome(subStr))
                continue;

            temp.add(subStr);
            partitionHelper(s.substring(i+1), temp, list);

            temp.remove(temp.size()-1);
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }

    private static boolean wordSearch(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (searchHelper(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean searchHelper(char[][] board, String word, int ind, int i, int j, boolean[][] visited) {
        //out of bounds
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;

        //current char does not matches with the cell, (or) if it is already visited
        if (board[i][j] != word.charAt(ind) || visited[i][j])
            return false;

                //current char matches with the current cell
        //make this cell visited
        visited[i][j] = true;

        //if this is the end of word search, return true. That means we've searched the entire word
        if (ind == word.length()-1)
            return true;

        //right
        boolean right = searchHelper(board, word, ind+1, i, j+1, visited);
        if (right) return true;

        //left
        boolean left = searchHelper(board, word, ind+1, i, j-1, visited);
        if (left) return true;

        //down
        boolean down = searchHelper(board, word, ind+1, i+1, j, visited);
        if (down) return true;

        //up
        boolean up = searchHelper(board, word, ind+1, i-1, j, visited);
        if (up) return true;

        visited[i][j] = false;
        return false;
    }

    private static List<List<Integer>> permutations2(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        //build hashmap for the input array
        for (int elem: arr)
            map.put(elem, map.getOrDefault(elem, 0) + 1);

        permute(map, new ArrayList<Integer>(), list, arr.length);
        return list;
    }

    private static void permute(HashMap<Integer, Integer> map, ArrayList<Integer> temp, List<List<Integer>> list, int n) {
        if (temp.size() == n){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > 0){
                temp.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);

                permute(map, temp, list, n);
                temp.remove(temp.size()-1);
                entry.setValue(entry.getValue()+1);
            }
        }
    }


    private static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        helperCombinationSum2(arr, 0, 0, new ArrayList<Integer>(), target, list);
        return list;
    }

    private static void helperCombinationSum2(int[] arr, int curInd, int curSum, ArrayList<Integer> temp, int target, List<List<Integer>> list) {
        if (curSum > target)
            return;
        if (curSum == target){
            list.add(new ArrayList<>(temp));
            return;
        }


        for (int i = curInd; i < arr.length; i++) {
            if (i != curInd && arr[i] == arr[i-1])
                continue;

            temp.add(arr[i]);
            helperCombinationSum2(arr, i+1, curSum+arr[i], temp, target, list);

            temp.remove(temp.size()-1);
        }

    }

    private static List<List<Integer>> subsets2(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        helperSubsets2(arr, 0, new ArrayList<>(), list);
        return list;
    }

    private static void helperSubsets2(int[] arr, int curInd, ArrayList<Integer> temp, List<List<Integer>> list) {
        list.add(new ArrayList<>(temp));

        for (int i = curInd; i < arr.length; i++) {
            if (i != curInd && arr[i] == arr[i-1])
                continue; //skip this element

            temp.add(arr[i]);
            helperSubsets2(arr, i+1, temp, list);

            temp.remove(temp.size()-1);
        }

    }

    private static List<List<Integer>> permutations(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        helperPermutations(arr, new HashSet<Integer>(), new ArrayList<Integer>(), list);
        return list;
    }

    private static void helperPermutations(int[] arr, HashSet<Integer> set, ArrayList<Integer> temp, List<List<Integer>> list) {
//        base case
        if (temp.size() == arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }


        for (int elem : arr) {
            if (set.contains(elem))
                continue;

            set.add(elem);
            temp.add(elem);
            helperPermutations(arr, set, temp, list);

            temp.remove(temp.size() - 1);
            set.remove(elem);
        }

    }

    private static List<List<Integer>> combinations(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        List<List<Integer>> list = new ArrayList<>();
        helperCombinations(arr, 0, k, new ArrayList<>(), list);
        return list;
    }

    private static void helperCombinations(int[] arr, int curIndex, int k, List<Integer> temp, List<List<Integer>> list) {
//        base case
        if (temp.size() == k){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = curIndex; i < arr.length; i++) {
            temp.add(arr[i]);
            helperCombinations(arr, i+1, k, temp, list);

            temp.remove(temp.size()-1);
        }

    }


    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helperCombinationSum(arr, 0, 0, new ArrayList<>(), list, target);
        return list;
    }

    private static void helperCombinationSum(int[] arr, int curIndex, int curTotal, List<Integer> temp, List<List<Integer>> list, int target) {
//        base case
        if (curTotal > target)
            return;
        if (curTotal == target){
            list.add(new ArrayList<>(temp));
            return;
        }


        for (int i = curIndex; i < arr.length; i++) {
            temp.add(arr[i]);
            helperCombinationSum(arr, i, curTotal+arr[i], temp, list, target);

            temp.remove(temp.size()-1);
        }

    }

    private static List<List<Integer>> getSubsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        helperSubsets(arr, new ArrayList<>(), list, 0);
        return list;
    }

    private static void helperSubsets(int[] arr, List<Integer> temp, List<List<Integer>> list, int i) {
//        base case
        if (i == arr.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        // 2 Options:
        //1.take the current ith element
        temp.add(arr[i]);
        helperSubsets(arr, temp, list, i+1);

        //2.don't take
        temp.remove(temp.size()-1);
        helperSubsets(arr, temp, list, i+1);
    }
}
