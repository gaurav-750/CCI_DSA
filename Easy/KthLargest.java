package Easy;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        //minHeap with k largest elements:
        for (int num: nums)
            minHeap.add(num);

        //pop until priority queue size is k
        while (minHeap.size() > k)
            minHeap.poll();
    }

    public int add(int val) {
        minHeap.add(val);
        minHeap.poll();
        return minHeap.peek();
    }

}
