package Stacks_Queues;

public class CustomStack {
    protected int[] data;
    private static int DEFAULT_SIZE = 10;

    private int ptr = -1;

    public CustomStack(){
        data = new int[DEFAULT_SIZE];
    }


    public void push(int item){
        if (isFull()){
            System.out.println("Stack is full!");
            return;
        }
        ptr++;
        data[ptr] = item;
    }

    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty! Cannot pop element");
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws Exception{
        if (isEmpty())
            throw new Exception("Stack is empty! Cannot pop element");
        return data[ptr];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length-1;
    }

}
