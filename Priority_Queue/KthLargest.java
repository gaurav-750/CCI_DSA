package Priority_Queue;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        //add all elements of the array to PQ
        for (int num: nums)
            minHeap.add(num);

        //humko sirf k size ka Heap hona
        while (minHeap.size() > k)
            minHeap.poll();
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();
    }
}
