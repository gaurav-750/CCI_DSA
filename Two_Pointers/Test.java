package Two_Pointers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {

        // arr = [1,2,3,4,5,6,7,8,9]
        //k = 3
        //kth largest element
        int[] arr = {3,4,2,1,9,8,7,5,6};
        System.out.println("Kth Largest: " +
                kThLargestElement(arr, 3));



    }

    private static int kThLargestElement(int[] arr, int k) {
//        Arrays.sort(arr);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //first add the first k elements to the heap
        for (int i = 0; i < k; i++)
            minHeap.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (!minHeap.isEmpty() && arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
//            System.out.println(minHeap);
        }

        return !minHeap.isEmpty() ? minHeap.peek() : -1;
    }
}
