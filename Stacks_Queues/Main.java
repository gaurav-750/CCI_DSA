package Stacks_Queues;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

//        Stack<Integer> stack = new Stack<>();
//        CustomStack stack = new CustomStack();
        DynamicStack stack = new DynamicStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(199);
        stack.push(101);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
