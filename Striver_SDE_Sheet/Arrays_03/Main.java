package Striver_SDE_Sheet.Arrays_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/search-a-2d-matrix/
//        int[][]  matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int target = 3;
//        System.out.println("In Matrix: " + searchIn2D(matrix, target));

//        todo https://leetcode.com/problems/powx-n/
//        double x = 2.00000; int n = -2;
//        System.out.println(myPow(x, n));

//        todo https://leetcode.com/problems/majority-element/
//        int[] nums = {2,2,1,1,1,2,2};
//        System.out.println("Majority Element: " + majorityElement(nums));

//        todo https://leetcode.com/problems/majority-element-ii/description/
//        int[] nums = {1,1,1,1,3,2,2,2};
//        majorityElement2(nums);




    }

    private static List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int reqFreq = nums.length/3 + 1;

        List<Integer> list = new ArrayList<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == reqFreq)
                list.add(num);
        }

        return list;
    }

    private static int majorityElement(int[] nums) {
        int elem = 0, count = 0;

        for (int curElem: nums){
            if (count == 0)
                elem = curElem;

            if (curElem == elem)
                count++;
            else
                count--;
        }
        return elem;
    }

    private static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;


        while (nn > 0){
            if (nn%2 == 0){
                x = x * x;
                nn /= 2;
            }else {
                ans = ans * x;
                nn -= 1;
            }
        }

        if (n < 0)
            ans = 1.0/ans;
        return ans;
    }

    private static boolean searchIn2D(int[][] matrix, int target) {
        //find the row to search in
        int cols = matrix[0].length;
        int top = 0, bottom = cols-1;

        while (top <= bottom){
            int row = (top+bottom)/2;
            if (target > matrix[row][cols-1])
                top = row+1;
            else if (target < matrix[row][0])
                bottom = row-1;
            else
                break;
        }

        if (top > bottom)
            return false;

        //we've found the row to search in: apply Binary Search
        int row = (top+bottom)/2;
        int l = 0, r = cols-1;
        while (l <= r){
            int mid = (l+r)/2;
            if (target == matrix[row][mid])
                return true;

            if (target > matrix[row][mid])
                l = mid+1;
            else //target < matrix[row][mid]
                r = mid-1;
        }
        return false;
    }
}
