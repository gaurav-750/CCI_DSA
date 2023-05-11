package Priority_Queue;
import java.util.*;

class Dist {
    double dist;
    int idx;

    public Dist(double dist, int idx) {
        this.dist = dist;
        this.idx = idx;
    }
}

public class Neetcode {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/last-stone-weight/
//        int[] stones = {2,7,4,1,8,1};
//        System.out.println("Last stone weight: " + lastStoneWeight(stones));

//        todo https://leetcode.com/problems/k-closest-points-to-origin/
        int[][] points = {{1,3},{-2,2}};
//        System.out.println("Kth closest element to (0,0): " +
//                Arrays.deepToString(kClosestToTheOrigin(points, 1)));
//        System.out.println("Kth closest element to (0,0): " +
//                Arrays.deepToString(kClosestToTheOrigin2(points, 1)));
        


    }

    private static int[][] kClosestToTheOrigin2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(
                (a[0]*a[0] + a[1]*a[1]),
                (b[0]*b[0] + b[1]*b[1])
        )); //comparing 2 arrays

        //add the points to priority queue
        pq.addAll(Arrays.asList(points));

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            res[i] = cur;
        }
        return res;
    }

    //return k points closest to the origin: sqrt(x^2+y^2)
    private static int[][] kClosestToTheOrigin(int[][] points, int k) {
        //min Heap
        PriorityQueue<Dist> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.dist, o2.dist));
        for (int i = 0; i < points.length; i++){
            int[] point = points[i];
            double dist = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            pq.add(new Dist(dist, i));
        }

        int[][] res = new int[k][2]; //resultant array
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Dist obj = pq.poll();
            res[i] = points[obj.idx];
        }
        return res;
    }

    private static int lastStoneWeight(int[] stones) {
        //initializing 'max' priority queue
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int elem: stones)
            pq.add(elem);

        while (pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            if (x != y)
                pq.add(y-x);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
