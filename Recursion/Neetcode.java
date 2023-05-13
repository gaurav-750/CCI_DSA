package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        int[] arr = {1,2,3};
        System.out.println("Permutations: " + permutations(arr));



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
