package Stacks_Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/valid-parentheses/
//        System.out.println("Is Valid Parentheses: " + isValid("()[{}]"));

//        todo https://leetcode.com/problems/baseball-game/
//        String[] ops = {"5","-2","4","C","D","9","+","+"};
//        System.out.println("Total points: " + calPoints(ops));

//        todo https://leetcode.com/problems/implement-stack-using-queues


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
