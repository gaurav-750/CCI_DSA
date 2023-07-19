package Striver_SDE_Sheet.LinkedList;

import LinkedList.Linked_List;
import LinkedList.Node;

public class main {
    public static void main(String[] args) {

        Linked_List obj = new Linked_List();
//        Node<Integer> head = obj.takeInput();

//        todo https://leetcode.com/problems/reverse-linked-list/description/
//        reverseLinkedList(head);

//        todo https://leetcode.com/problems/middle-of-the-linked-list/
//        middleNode(head);

//        todo https://leetcode.com/problems/merge-two-sorted-lists/description/
//        Node<Integer> h2 = obj.takeInput();
//        mergeSortedLinkedList(head, h2);

//        todo https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//        removeNthFromEnd(head, 2);

//        todo https://leetcode.com/problems/add-two-numbers/
//        addTwoNumbers(head, h2);

//        todo https://leetcode.com/problems/intersection-of-two-linked-lists/
//        getIntersectionNode(head, h2);

//        todo https://leetcode.com/problems/linked-list-cycle/
//        hasCycle(head);

//        todo https://leetcode.com/problems/palindrome-linked-list/
//        System.out.println(isPalindrome(head));

//        todo https://leetcode.com/problems/linked-list-cycle-ii/description/
//        findStartingNodeOfCycle(head);

//        todo https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
//        flattenaLL(head);


//        todo https://leetcode.com/problems/rotate-list/description/
//        rotateRight(head, 2);

//        todo https://leetcode.com/problems/trapping-rain-water/description/
//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println("Total Trapped Water: "+
//                            totalTrappedRainWater(heights));

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println("k: " + removeDups(nums));

//        todo https://leetcode.com/problems/max-consecutive-ones/description/
        int[] nums = {1,1,0,1,1,1};
        findMaxConsecutiveOnes(nums);



    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsOnes = 0, curNumOfOnes;

        int i = 0;
        while (i < nums.length){
            curNumOfOnes = 0;

            while (i < nums.length && nums[i] == 1){
                curNumOfOnes += 1;
                i++;
            }

            maxConsOnes = Math.max(maxConsOnes, curNumOfOnes);
            i++;
        }
        return maxConsOnes;
    }

    private static int removeDups(int[] nums) {
        int l = 0, r = 0;

        while (r < nums.length){
            while (r < nums.length-1 && nums[r] == nums[r+1])
                r++;

            nums[l] = nums[r];
            l++;
            r++;
        }
        return l;
    }

    private static int totalTrappedRainWater(int[] heights) {
        int totalTrappedWater = 0;
        int lmax, rmax;

        for (int i = 0; i < heights.length; i++) {
            lmax = -1; rmax = -1;

            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, heights[j]);
            }

            for (int j = i+1; j < heights.length; j++) {
                rmax = Math.max(rmax, heights[j]);
            }

            int currentTrappedWater = (Math.min(lmax, rmax) - heights[i]);
            if (currentTrappedWater > 0)
                totalTrappedWater += currentTrappedWater;
        }
        return totalTrappedWater;
    }

    private static Node<Integer> rotateRight(Node<Integer> head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        //length of Linked List
        int length = lengthOfLL(head);
        k = k % length;

        Node<Integer> temp = head, tail = head;
        while (k != 0) {
            tail = tail.next;
            k--;
        }

        while (tail.next != null){
            tail = tail.next;
            temp = temp.next;
        }

        tail.next = head;
        Node<Integer> res = temp.next;
        temp.next = null;
        return res;
    }

    private static int lengthOfLL(Node<Integer> head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

//    private static Node<Integer> flattenaLL(Node<Integer> head) {
//        //base case
//        if (head == null || head.next == null)
//            return head;
//
//        head.next = flattenaLL(head.next);
//
//        //merge two LL and return them
//        return  merge(head, head.next);
//    }

//    private static Node<Integer> merge(Node<Integer> h1, Node<Integer> h2) {
//        Node<Integer> res = new Node<>(0), temp = res;
//
//        while (h1 != null && h2 != null){
//            if (h1.data <= h2.data){
//                temp.bottom = h1;
//                h1 = h1.bottom;
//            }else {
//                temp.bottom = h2;
//                h2 = h2.bottom;
//            }
//
//            temp = temp.bottom;
//        }
//
//        if (h1 != null)
//            temp.bottom = h1;
//        else
//            temp.bottom = h2;
//        return res.bottom;
//    }

    private static Node<Integer> findStartingNodeOfCycle(Node<Integer> head) {
        Node<Integer> slow = head,
                      fast = head,
                      initial = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){ // there's a cycle in LL
                while (slow != initial) {
                    initial = initial.next;
                    slow = slow.next;
                }
                return slow; //starting point of the cycle
            }
        }
        return null; //there's no cycle in LL
    }

    private static boolean isPalindrome(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;

        //find the middle of the Linked List
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;

        //reverse that
        Node<Integer> head2 = reverseLinkedList(slow);

        //Now check if palindrome
        while (head2 != null){
            if (head.data != head2.data)
                return false;

            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private static boolean hasCycle(Node<Integer> head) {
        if (head == null || head.next == null)
            return false;

        Node<Integer> slow = head, fast = head.next.next;
        while (fast != null && fast.next != null){
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    private static Node<Integer> getIntersectionNode(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> h1 = head1, h2 = head2;

        while (h1 != h2){
            h1 = h1 != null ? h1.next : head2;
            h2 = h2 != null ? h2.next : head1;
        }
        return h1;
    }

    private static Node<Integer> addTwoNumbers(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> dummy = new Node<>(0), cur = dummy;
        int sum, carry = 0;

        while (head1 != null || head2 != null){
            sum = 0; //initialize sum to 0

            if (head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null){
                sum += head2.data;
                head2 = head2.next;
            }

            //calculation
            sum += carry;
            carry = sum/10;
            sum = sum%10;

            cur.next = new Node<>(sum);
            cur = cur.next;
        }

        if (carry != 0)
            cur.next = new Node<>(carry);

        return dummy.next;
    }

    private static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        Node<Integer> slow = head, fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;

        if (fast == null) //edge case -> n == number of nodes in LL
            return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    private static Node<Integer> mergeSortedLinkedList(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node<Integer> mergedHead = new Node<>(0), temp = mergedHead;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else { // head1 > head2
                temp.next = head2;
                head2 = head2.next;
            }

            temp = temp.next;
        }

        //for remaining nodes
        Node<Integer> rem = head1 != null ? head1 : head2;
        while (rem != null){
            temp.next = rem;
            temp = temp.next;
            rem = rem.next;
        }
        return mergedHead.next;
    }

    private static Node<Integer> middleNode(Node<Integer> head) {
        Node<Integer> slow = head,
                      fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> past = null,
                      present = head,
                      future = head.next;

        while (present != null){
            present.next = past;
            past = present;
            present = future;

            if (future != null)
                future = future.next;
        }
        return past;
    }
}
