package Stacks_Queues;

public class CustomQueue {
    protected int[] data;
    private static int DEFAULT_SIZE = 10;

    private int end = 0;

    public CustomQueue(){
        data = new int[DEFAULT_SIZE];
    }

    public void insert(int item){
        if (isFull()){
            System.out.println("Queue is Full!");
            return;
        }

        data[end++] = item;
    }

    public int remove(){
        if (isEmpty()){
            System.out.println("Queue is Empty!");
            return Integer.MIN_VALUE;
        }

        end--;
        int removed = data[0];
        for (int i = 1; i < data.length; i++) {
            data[i-1] = data[i];
        }
        return removed;
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    private boolean isEmpty() {
        return end == 0;
    }

    private boolean isFull() {
        return end == data.length;
    }


}
