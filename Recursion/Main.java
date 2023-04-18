package Recursion;

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
