package Recursion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        todo nth fibonacci number
//        System.out.println("Fibonacci Number: " + fibonnaci(8));

//        todo Binary search using Recursion
//        int[] arr = {15,17,21,27,28};
//        System.out.println("BS Index: " + binarySearchRec(arr, 0, arr.length-1, 177));

//        todo Print nums from n to 1
//        printNums(10);

//        todo Print nums from 1 to n
//        printNums2(10);

//        todo Factorial of a number
//        System.out.println("Factorial: " + fact(8));

//        todo Sum of digits
//        System.out.println("Sum of digits: " + sumOfDigits(1234));

//        todo Reverse the number
//        12345 -> 54321
//        System.out.println("Reverse: " + reverseNumber(12345));

//        todo Find count of zeroes in a number
//        countZeroes(100210);

//        todo https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
//        System.out.println("Number of steps: " + numberOfSteps(123));

//        todo Check if array is sorted
//        int[] arr = {1,2,4,5,17,9};
//        System.out.println("Is Array Sorted: " + isArraySorted(arr, 0));

//        todo Linear Search using Recursion
//        System.out.println("Index: " + linearSearch(arr, 0, 17));

//        todo Find multiple occurrences inside Array
//        int[] arr = {1,2,5,3,4,5,5};
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println("List: " + findMultipleOccurrences(arr, 0, 5, list));

//        todo Pattern1
//        pattern1(5, 0);
//        pattern2(0, 4);

//        todo bubble sort using Recursion
//        int[] arr = {4,3,2,5,1,9,8};
//        bubbleSort(arr, 0, arr.length-1);
//        bubbleSort2(arr, arr.length);
//        System.out.println(Arrays.toString(arr));

//        todo Selection Sort using Recursion
//        selectionSort(arr, 0);

//        todo Merge Sort
//        int[] arr = {8,3,4,12,5,6};
//        mergeSort(arr);

//        todo Quick Sort
//        int[] arr = {8,3,4,12,5,6};
//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

//        todo skip character
//        String str = "abcabc";
//        System.out.println("Skip: " + skipChar(str));

//        todo skip word
//        String str = "superhero";
//        System.out.println("Skip word: " + skipWord(str));

//        todo Print Subsets of a String
//        String str = "abc";
//        ArrayList<String> list = new ArrayList<>();
//        System.out.println("List: " + subsets(str, "", list));

//        todo Permutations of string
//        String str = "abc";
//        permutations(str, "");

//        todo https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//        String digits = "23";
//        letterCombinations(digits, "");


//        todo Target sum on dice
//        diceRoll("", 4);

//        todo Maze Problem: total paths
//        System.out.println("Total Paths: " + totalPaths(0, 0, 3));

//        todo Print the paths
//        printPaths(0, 0, 3, "");

//        todo Print the paths 2
//        printPaths2(0, 0, 3, "");

//        todo Paths with obstacles
//        int[][] pathArr = {
//                {1,1,1},
//                {1,0,1},
//                {1,1,1},
//        };
//        printPathWithObstacles(0, 0, 3, "", pathArr);

//        todo N Queens
//        int n = 4;
//        char[][] chessBoard = new char[n][n];
//        for (char[] arr: chessBoard){
//            Arrays.fill(arr, '.');
//        }
//        List<List<String>> list = new ArrayList<>();
//        nQueens(0, 0, n, chessBoard, list);
//        System.out.println(list);

//        todo Sudoku Solver
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','2','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        helper(board, 0, 0);
        

    }


    public static boolean helper(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }

        int nrow, ncol;

        if(col == board.length-1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if(board[row][col] != '.') {
            if(helper(board, nrow, ncol)) {
                return true;
            }
        } else {

            //fill the place
            for(int i=1; i<=9; i++) {
                if(canPlacei(row, col,(char) (i+'0'), board)) {
                    board[row][col] = (char)(i+'0');
                    if(helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private static boolean canPlacei(int row, int col, char i, char[][] board) {
//        check in the diagonal (row)
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == i)
                return false;
        }
        
//        check vertically (col)
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == i)
                return false;
        }

//        check in the 3*3 box
        int si = (row/3)*3, sj = (col/3)*3;
        for (int j = si; j <= (si+2); j++) {
            for (int k = sj; k <= (sj+2); k++) {
                if (board[j][k] == i)
                    return false;
            }
        }
        return true;
    }

    private static List<List<String>> nQueens(int row, int col, int n, char[][] chessBoard, List<List<String>> list) {
//        base case
        if (col >= n) return null;
        if (row == n){
            printChessBoard(chessBoard);
            return chessBoardString(chessBoard, list);
        }

//      check if queen can be placed here
        if (canQueenBePlacedHere(chessBoard, row, col)){
            chessBoard[row][col] = 'Q';
            nQueens(row+1, 0, n, chessBoard, list);
        }

        chessBoard[row][col] = '.';
        nQueens(row, col+1, n, chessBoard, list);
        return list;
    }

    private static List<List<String>> chessBoardString(char[][] chessBoard, List<List<String>> list) {
        List<String> smallList = new ArrayList<>();
        for (char[] arr : chessBoard){
            StringBuilder str = new StringBuilder();
            for (char c: arr)
                str.append(c);
            smallList.add(str.toString());
        }
        list.add(smallList);
        return list;
    }

    private static boolean canQueenBePlacedHere(char[][] chessBoard, int row, int col) {
//        check if there's any attack to the Queen if placed at chessBoard[row][col]
//        from up
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][col] == 'Q')
                return false;
        }

//        from left diagonal
        int i = row-1, j = col-1;
        while (i >= 0 && j >= 0){
            if (chessBoard[i][j] == 'Q')
                return false;
            i--; j--;
        }

//        from right diagonal
        i = row-1; j = col+1; int n = chessBoard.length-1;
        while (i >= 0 && j <= n){
            if (chessBoard[i][j] == 'Q')
                return false;
            i--; j++;
        }
        return true;
    }

    private static void printChessBoard(char[][] chessBoard) {
        int n = chessBoard.length;
        for (char[] chars : chessBoard) {
            for (int j = 0; j < n; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printPathWithObstacles(int row, int col, int n, String path, int[][] pathArr) {
//        base case
        if (row >= n || col >= n) return; //out of bounds
//        check if there is an obstacle
        if (pathArr[row][col] == 0) return;

        if (row == n-1 && col == n-1) {//target reached
            System.out.println(path);
            return;
        }

//        down
        printPathWithObstacles(row+1, col, n, path+"D", pathArr);
//        right
        printPathWithObstacles(row, col+1, n, path+"R", pathArr);
    }

    private static void printPaths2(int row, int col, int n, String path) {
//        base case
        if (row >= n || col >= n) return; //out of bounds
        if (row == n-1 && col == n-1) {//target reached
            System.out.println(path);
            return;
        }

//        down
        printPaths2(row+1, col, n, path+"D");
//        diagonal
        printPaths2(row+1, col+1, n, path + "\\");
//        right
        printPaths2(row, col+1, n, path+"R");
    }

    private static void printPaths(int row, int col, int n, String path) {
//        base case
        if (row >= n || col >= n) return; //out of bounds
        if (row == n-1 && col == n-1) {//target reached
            System.out.println(path);
            return;
        }

//        down
        printPaths(row+1, col, n, path+"D");
//        right
        printPaths(row, col+1, n, path+"R");
    }

    private static int totalPaths(int row, int col, int n) {
//        base case
        if (row >= n || col >= n) return 0; //out of bounds
        if (row == n-1 && col == n-1)//target reached
            return 1;

//        down
        int down = totalPaths(row+1, col, n);
//        right
        int right = totalPaths(row, col+1, n);
        return down+right;
    }

    private static void diceRoll(String output, int target) {
//        base case
        if (target == 0){
            System.out.println(output);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceRoll(output+i, target-i);
        }
    }

//    private static void letterCombinations(String digits, String output) {
////        base case
//        if (digits.isEmpty()) {
//            System.out.println(output);
//        }
//
//
//
//    }

    private static void permutations(String str, String output) {
//        base case
        if (str.isEmpty()){
            System.out.println(output);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0, i) + str.substring(i+1);
            permutations(newStr , output+str.charAt(i));
        }
    }

    //    Take it (or) Leave it
    private static void subsets(String str, String output, ArrayList<String> list) {
//        base case
        if (str.isEmpty()) {
            list.add(output);
            return;
        }

//        take it
        subsets(str.substring(1), output + str.charAt(0), list);
//        leave it
        subsets(str.substring(1), output, list);
    }

    private static String skipWord(String str) {
//        base case
        if (str.isEmpty())
            return "";

        if (str.startsWith("super"))
            return skipWord(str.substring(5));
        else
            return str.charAt(0) + skipWord(str.substring(1));
    }

    private static String skipChar(String str) {
//        base case
        if (str.isEmpty())
            return "";

        String smallStr = skipChar(str.substring(1));
        return str.charAt(0) == 'c' ? smallStr : str.charAt(0) + smallStr;
    }

    private static void quickSort(int[] arr, int si, int ei) {
//        base case
        if (si >= ei)
            return;

        int pivotIndex = partition(arr, si, ei);

        quickSort(arr, si, pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivotElement = arr[si], smallNumCount = 0, k = si+1;
        while (k <= ei){ // finding count of numbers smaller than pivotElement
            if (arr[k] < pivotElement){
                smallNumCount++;
            }
            k++;
        }

        // placing pivotElement into its correct position
        int temp = arr[si + smallNumCount];
        arr[si + smallNumCount] = pivotElement;
        arr[si] = temp;

        int i = si, j = ei;

        // in this loop, we make sure that every element left to pivotElement is '<' pivotElement
        // also every element right to pivotElement is  pivotElement '<='
        while (i < j){
            if (arr[i] < pivotElement){
                i++;
            }else if (arr[j] >= pivotElement){
                j--;
            }else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallNumCount;
    }

    private static int[] mergeSort(int[] arr) {
//        base case
        if (arr.length == 1)
            return arr;

        int mid = (arr.length)/2;
        int[] firstHalf = Arrays.copyOfRange(arr, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(arr, mid, arr.length);

        int[] arr1 = mergeSort(firstHalf);
        int[] arr2 = mergeSort(secondHalf);
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

    private static void selectionSort(int[] arr, int start) {
//        base case
        if (start == arr.length-1) return;

        int minIndex = getMinIndex(arr, start);
        swap(arr, minIndex, start);
        selectionSort(arr, start+1);
    }

    private static int getMinIndex(int[] arr, int start) {
        int mIndex = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[mIndex])
                mIndex = i;
        }
        return mIndex;
    }

    private static void bubbleSort2(int[] arr, int last) {
//        base case
        if (last == 0) return;
        for (int i = 0; i < last-1; i++) {
            if (arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }

        bubbleSort2(arr, last-1);
    }

    private static void bubbleSort(int[] arr, int cur, int last) {
//        base case
        if (last == 0) return;
        if (cur == last) {
            bubbleSort(arr, 0, last - 1);
            return;
        }

        if (arr[cur] > arr[cur+1])
            swap(arr, cur, cur+1);

        bubbleSort(arr, cur+1, last);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void pattern2(int cur, int row) {
//        base case
        if (cur == row) return;

        for (int i = 0; i <= cur; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
        pattern2(cur+1, row);
    }

    private static void pattern1(int row, int col) {
//        base case
        if (row == 0) return;

        if (row > col) {
            System.out.print("*" + " ");
            pattern1(row, col + 1);
        }else {
            System.out.println();
            pattern1(row-1, 0);
        }
    }

    private static ArrayList<Integer> findMultipleOccurrences(int[] arr, int ind, int x, ArrayList<Integer> list) {
        System.out.println(ind + ", " + list);
//        base case
        if (arr.length == ind)
            return list;

        if (arr[ind] == x)
            list.add(ind);

        return findMultipleOccurrences(arr, ind+1, x, list);
    }

    private static int linearSearch(int[] arr, int ind, int x) {
//        base case
        if (arr.length == ind)
            return -1;

        if (arr[ind] == x) return ind;
        return linearSearch(arr, ind+1, x);
    }

    private static boolean isArraySorted(int[] arr, int ind) {
//        base case
        if (arr.length-1 == ind)
            return true;

        if (arr[ind] > arr[ind+1])
            return false;
        return isArraySorted(arr, ind+1);
    }

    private static int numberOfSteps(int n) {
//        base case
        if (n == 0)
            return 0;

        if (n % 2 == 0)
            return numberOfSteps(n/2)+1;
        else //odd
            return numberOfSteps(n-1)+1;
    }

    private static void countZeroes(int num) {
        if (num == 0)
            System.out.println(1);

        System.out.println("Number of Zeroes: " + helperZeroes(num, 0));
    }

    private static int helperZeroes(int num, int count) {
//        base condition
        if (num == 0)
            return count;

        int rem = num%10;
        if (rem == 0)
            return helperZeroes(num/10, count+1);
        else
            return helperZeroes(num/10, count);
    }

    //    static int res = 0;
    private static int reverseNumber(int num) {
//        base condition
        if (num < 10)
            return num;

        int smallOutput = reverseNumber(num/10);
        int power = (int) Math.log10(smallOutput) + 1;
        return (int) (num%10 * Math.pow(10, power)) + smallOutput;
//        res = res * 10 + num%10;
//        reverseNumber(num/10);
    }

    private static int sumOfDigits(int num) {
//        base condition
        if (num < 10)
            return num;

        return num%10 + sumOfDigits(num/10);
    }

    private static int fact(int n) {
//        base condition
        if (n == 0 || n == 1)
            return 1;

        return n * fact(n-1);
    }

    private static void printNums2(int n) {
//        base condition
        if (n < 1)
            return;

        printNums2(n-1);
        System.out.println(n);
    }

    private static void printNums(int n) {
        if (n < 1)
            return;

        System.out.println(n);
        printNums(n-1);
    }

    private static int binarySearchRec(int[] arr, int s, int e, int x){
//        base condition
        if (s > e)
            return -1;

        int mid = (s+e)/2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return binarySearchRec(arr, s, mid-1, x);
        else
            return binarySearchRec(arr, mid+1, e, x);
    }

    private static int fibonnaci(int num) {
//        base condition
        if (num == 0 || num == 1)
            return num;

        return fibonnaci(num-1) + fibonnaci(num-2);
    }

}
