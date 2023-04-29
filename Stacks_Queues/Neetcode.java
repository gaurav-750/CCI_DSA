package Stacks_Queues;

import java.util.*;

class MyStack{
    Queue<Integer> queue;

//    constructor
    public MyStack(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.add(x);
//        shift all the elements behind x => so x will be at the top
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop(){
        if (queue.isEmpty())
            return -1;
        return queue.poll();
    }

    public int top(){
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}

class MinStack{

    ArrayList<Integer> list;
    int top, min;
    public MinStack(){
        list = new ArrayList<>();
        top = min = -1;
    }

    public void push(int x){
        if (min == -1) min = 0;

        list.add(x);
        if (list.get(min) > list.get(list.size()-1))
            min = list.size()-1;
    }

    public void pop(){
        if (min == list.size()-1){
            //adjust the min
            int m = 0;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(m) >= list.get(i))
                    m = i;
            }
            min = m;
        }

        list.remove(list.size()-1);
    }

    public int top(){
        return list.get(list.size()-1);
    }

    public int getMin() {
        return list.get(min);
    }

}

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/valid-parentheses/
//        System.out.println("Is Valid Parentheses: " + isValid("()[{}]"));

//        todo https://leetcode.com/problems/baseball-game/
//        String[] ops = {"5","-2","4","C","D","9","+","+"};
//        System.out.println("Total points: " + calPoints(ops));

//        todo https://leetcode.com/problems/implement-stack-using-queues
//        MyStack ms = new MyStack();

//        todo https://leetcode.com/problems/min-stack/
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(-0);
//        minStack.push(-3);
//
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());

//        todo https://leetcode.com/problems/evaluate-reverse-polish-notation/
//        String[] tokens = {"2","1","+","3","*"};
//        System.out.println("RPN ans: " + reversePolishNotation(tokens));

//        todo https://leetcode.com/problems/generate-parentheses/
//        System.out.println(generateParentheses(1));

//        todo https://leetcode.com/problems/asteroid-collision/
//        int[] arr = {-2,-1,1,-2};
//        System.out.println(Arrays.toString(asteroidCollisions(arr)));

//        todo https://leetcode.com/problems/daily-temperatures/description/
//        int[] temperatures = {73,74,75,71,69,72,76,73};
//        dailyTemperatures(temperatures);

//        todo https://leetcode.com/problems/simplify-path/
//        simplifyPath("/abc//.def/../");
//        System.out.println("Simplified Path: " + simplifyPath("/..hidden"));
//        System.out.println(simplifyPath("/../"));

//        todo https://leetcode.com/problems/decode-string/
        System.out.println("Decoded String: " + decodeString("3[a2[c]]"));

    }

    private static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ']')
                stack.push(c+"");
            else { // c == ']'
                String res = "";
                while (!stack.peek().equals("["))
                    res = stack.pop() + res;

                stack.pop(); //remove [ from stack
                String num = "";
                while (!stack.isEmpty() && isInteger(stack.peek()))
                    num = stack.pop() + num;

                int n = Integer.parseInt(num);
                String small = "";
                //multiply res * n and push into stack
                for (int j = 0; j < n; j++) {
                    small += res;
                }
                stack.push(small);
            }
        }

        return String.join("", stack);
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    private static String simplifyPath(String str) {
        Stack<String> stack = new Stack<>();
        String[] arr = str.split("/");
        System.out.println(Arrays.toString(arr));

        for (String s : arr){
            if (!stack.isEmpty() && s.equals(".."))
                stack.pop();
            else if (!Arrays.asList("", ".", "..").contains(s))
                stack.push(s);
        }

        return "/" + String.join("/", stack);
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = (n-1); i >= 0; i--) {
            int curTemp = temperatures[i];
//            remove temps which is less than the current temperature
            while (!stack.isEmpty() && temperatures[stack.peek()] <= curTemp)
                stack.pop();

//            we've greater temp than the current
            if (!stack.isEmpty())
                ans[i] = stack.peek() - i;

            stack.push(i);
        }
//        System.out.println(Arrays.toString(ans));
        return ans;
    }

//    Collision happens only when asteroid is -ve and stack's top is +ve
//    private static int[] asteroidCollisions(int[] asteroids) {
//        Stack<Integer> stack = new Stack<>();
//        for (int asteroid: asteroids){
//            if (asteroid > 0) { //+ve
//
//
//            }else { //-ve
//
//            }
//
//            System.out.println(stack);
//        }
//
////        return the result
//        return buildArrFromStack(stack);
//    }

    private static int[] buildArrFromStack(Stack<Integer> stack){
        int[] res = new int[stack.size()];
        int i = 0;

        for (Integer integer : stack) {
            res[i] = integer;
            i++;
        }
        return res;
    }

    static List<String> res = new ArrayList<>();
    private static List<String> generateParentheses(int n) {
        helper(0, 0, n, "");
        return res;
    }

    private static void helper(int open, int close, int n, String output) {
//        base case
        if (open == n && close == n) {
            res.add(output);
            return;
        }

        if (open < n){
            output += "(";
            helper(open+1, close, n, output);
            output = output.substring(0, output.length()-1);
        }

        if (close < open) {
            output += ")";
            helper(open, close + 1, n, output);
            output = output.substring(0, output.length()-1);
        }

    }

    private static int reversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String cur : tokens) {
            if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
//                pop two elements and push the result into the stack
                int val1 = stack.pop();
                int val2 = stack.pop();
                int ans;
                if (cur.equals("+"))
                    ans = val1 + val2;
                else if (cur.equals("-"))
                    ans = val2 - val1;
                else if (cur.equals("*"))
                    ans = val1 * val2;
                else
                    ans = val2 / val1;

                stack.push(ans);
            } else {
                stack.push(Integer.parseInt(cur));
            }
        }

        return stack.pop();
    }

    private static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for (String cur : ops) {
            if (cur.equals("C"))
                stack.pop();
            else if (cur.equals("D")) {
                int top = stack.peek();
                stack.push(top * 2);
            } else if (cur.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.peek();
                stack.push(val1);
                stack.push(val1 + val2);
            } else //it's a number 0-9
                stack.push(Integer.parseInt(cur));
        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        return sum;
    }

    private static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }else if (!stack.isEmpty() && c == ']') {
                if (stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }else //c == '}'
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
        }
        return stack.isEmpty();
    }
}
