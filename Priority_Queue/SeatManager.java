package Priority_Queue;
import java.util.PriorityQueue;

public class SeatManager {
    //min heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatManager(int n){
        //add 1 to n numbers in minheap
        for (int i = 1; i <= n; i++)
            pq.add(i);
    }

    public int reserve(){
        return !pq.isEmpty() ? pq.poll() : -1;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }

}
