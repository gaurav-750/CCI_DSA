package AdvanceJava;

public class Stack {
    private int[] array;
    private int top;

    public Stack(int capacity){
        array = new int[capacity];
        top = -1;
    }


    public synchronized boolean push(int element){
        if (isFull())
            return false;
        top += 1;

        try { Thread.sleep(1000);} catch (Exception e) {
            System.out.println(e);
        }

        array[top] = element;
        return true;
    }

    public synchronized int pop(){
        if (isEmpty())
            return Integer.MIN_VALUE;

        int ans = array[top];
        array[top] = Integer.MIN_VALUE;

        try {Thread.sleep(1000);} catch (Exception e){
            System.out.println(e);
        }

        top -= 1;
        return ans;
    }

    private boolean isEmpty(){
        return top < 0;
    }

    private boolean isFull(){
        return top >= array.length-1;
    }

}
