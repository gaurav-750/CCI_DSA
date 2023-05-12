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

class Task{
    int proc_time;
    int index;

    public Task(int proc_time, int index) {
        this.proc_time = proc_time;
        this.index = index;
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

//        todo https://leetcode.com/problems/kth-largest-element-in-an-array/
//        int[] arr = {3,2,3,1,2,4,5,5,6};
//        System.out.println("Kth largest element in the array: " +
//                kthLargestElementinArray(arr, 4));

//        todo https://leetcode.com/problems/single-threaded-cpu/
//        int[][] tasks = {{1,2},{3,2},{2,4},{4,1}};
//        int[][] tasks = {{7,10},{7,12},{7,5},{7,4},{7,2}};
//        int[][] tasks = {{5,2},{7,2},{9,4},{6,3},{5,10},{1,1}};
//        int[][] tasks = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
//        int[][] tasks = {{100,100},{1000000000,1000000000}};
//        getOrderOfTasks(tasks);

//        todo https://leetcode.com/problems/seat-reservation-manager/
//        SeatManager sm = new SeatManager(5);
//        System.out.println(sm.reserve());
//        System.out.println(sm.reserve());
//        sm.unreserve(2);
//        System.out.println(sm.reserve());
//        System.out.println(sm.reserve());
//        System.out.println(sm.reserve());
//        System.out.println(sm.reserve());
//        sm.unreserve(5);

//        todo https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
//        String[] nums = {"3","6","7","10"};
//        System.out.println("Kth Largest Element: " + kthLargestNumber(nums, 3));

//        todo https://leetcode.com/problems/reorganize-string/
//        reorganizeString("aaabc");




    }

    private static String reorganizeString(String s) {
        if (s.length() == 0) return "";
        //build a map
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Max Priority Queue - to get the char with maximum frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) ->
            b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet()); //add map to pq

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> temp1 = pq.poll();
            //if the last char is not the same as this one
            if (res.isEmpty() || res.charAt(res.length()-1) != temp1.getKey()){
                res.append(temp1.getKey());
                temp1.setValue(temp1.getValue()-1); //decrement the freq.of the char by 1
            }else { // prev character is same
                Map.Entry<Character, Integer> temp2 = pq.poll();
                if (temp2 == null) //that means temp1 was the only char in heap and there's no way to avoid adjacent temp1. So no answer is possible
                    return "";

                //add this character
                res.append(temp2.getKey());
                temp2.setValue(temp2.getValue()-1);

                if (temp2.getValue() != 0)
                    pq.add(temp2);
            }

            if (temp1.getValue() != 0)
                pq.add(temp1); //add temp1 back to PQ
        }
        return res.toString();
    }

    private static String kthLargestNumber(String[] nums, int k) {
        //Max Heap
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b,a));

        for (String num: nums){
            long n = Long.parseLong(num);
            pq.add(n);
        }

        //return the kth largest
        long ans = 0;
        while (k != 0){
            ans = pq.poll();
            k--;
        }
        return Long.toString(ans);
    }

    private static int[] getOrderOfTasks(int[][] tasks) {
        //preserve the original index
        for (int i = 0; i < tasks.length; i++) {
            int[] arr = new int[3];
            arr[0] = tasks[i][0];
            arr[1] = tasks[i][1];
            arr[2] = i;
            tasks[i] = arr;
        }

        //sort
        Arrays.sort(tasks, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1] == t2[1])
                    return t1[2] - t2[2];
                return t1[1] - t2[1];
            }
        }
        );
        int t = tasks[0][0], i = 0, k = 0;
        int[] res = new int[tasks.length];
        while (i < tasks.length){

            //add task to pq if task[0] <= t
            while (i < tasks.length && tasks[i][0] <= t){
                pq.add(tasks[i]);
                i++;
            }

            //add to the result
            if (!pq.isEmpty()) {
                int[] completed_Task = pq.poll();
                t += completed_Task[1];
                res[k] = completed_Task[2];
                k++;
            }else {
                t = tasks[i][0];
            }
        }

        //for remaining tasks in the heap
        while (!pq.isEmpty()){
            res[k] = pq.poll()[2];
            k++;
        }
        return res;
    }

    //return the kth largest element from the array
    private static int kthLargestElementinArray(int[] arr, int k) {
        //max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int elem: arr)
            pq.add(elem);

        int cur = arr[0];
        while (k != 0 && !pq.isEmpty()) {
            cur = pq.poll();
            k--;
        }
        return cur;
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
