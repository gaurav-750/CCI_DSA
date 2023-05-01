package LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class Neetcode {
    public static void main(String[] args) {

        Linked_List ll = new Linked_List();
        Node<Integer> head = ll.takeInput();
        ll.printLL(head);

//        todo https://leetcode.com/problems/reverse-linked-list/
//        reverseLL(head);

//        todo https://leetcode.com/problems/palindrome-linked-list/
//        System.out.println("Is Palindrome: " + isPalindrome(head));

//        todo https://leetcode.com/problems/remove-linked-list-elements/
//        ll.printLL(removeElements(head, 6));

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//        deleteDuplicates(head);

//        todo https://leetcode.com/problems/intersection-of-two-linked-lists/
//        Node<Integer> head1 = ll.takeInput();
//        Node<Integer> head2 = ll.takeInput();
//        getIntersectionNode(head1, head2);
//        getIntersectionNodeOptimized(head1, head2);
        
//        todo https://leetcode.com/problems/reorder-list/
//        ll.printLL(reOrderLList(head));

//        todo https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
        maximumTwinSum(head);

    }

    private static int maximumTwinSum(Node<Integer> head) {
        if (head == null) return 0;
        Node<Integer> middle = getMiddleOfLL(head);
        Node<Integer> rHead = reverseLL(middle);

        int max = -1;
        while (head.next != null){
            max = Math.max(max, head.data+rHead.data);
            head = head.next;
            rHead = rHead.next;
        }
        return max;
     }

    private static Node<Integer> reOrderLList(Node<Integer> head) {
        if (head == null || head.next == null) return head;
//        get the middle of LL
        Node<Integer> middle = getMiddleOfLL(head);

        Node<Integer> rHead = reverseLL(middle);
        Node<Integer> temp = new Node<>(0), finalHead = temp;

        while (true){
            temp.next = head;
            temp = temp.next;
            head = head.next;

            temp.next = rHead;
            temp = temp.next;
            rHead = rHead.next;

            if (head == rHead) {
                temp.next = rHead;
                temp = temp.next;
                break;
            }

            if (temp == head) break;
        }

        temp.next = null;
        return finalHead.next;
    }

    private static Node<Integer> getMiddleOfLL(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is the middle
        return slow;
    }

    private static Node<Integer> getIntersectionNodeOptimized(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> a = head1, b = head2;

        while (a != b){
            a = (a != null) ? a.next : head2;
            b = (b != null) ? b.next : head1;
        }
        return a;
    }

    private static Node<Integer> getIntersectionNode(Node<Integer> head1, Node<Integer> head2) {
        HashSet<Node<Integer>> set = new HashSet<>();
        while (head1 != null){
            set.add(head1);
            head1 = head1.next;
        }

        while (head2 != null){
            if (set.contains(head2)) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }

    private static Node<Integer> deleteDuplicates(Node<Integer> head) {
        Node<Integer> t1 = head, t2 = head;
        while (t2 != null){
            while (t2 != null && t2.data == t1.data)
                t2 = t2.next;

            t1.next = t2;
            t1 = t2;
        }
        return head;
    }

    private static Node<Integer> removeElements(Node<Integer> head, int x) {
//        base case
        if (head == null)
            return null;

        Node<Integer> smallHead = removeElements(head.next, x);
        if (head.data == x){
            return smallHead;
        }else {
            head.next = smallHead;
            return head;
        }
    }

    private static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) return true;
        Node<Integer> slow = head, fast = head, past = null;
//        go till the middle
        while (fast != null && fast.next != null){
            past = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        past.next = null;

        Node<Integer> head2 = reverseLL(slow);
        while (head != null && head2 != null){
            if (head.data != head2.data)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return head == null && head2 == null;
    }

    private static Node<Integer> reverseLL(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> past = null, present = head, future = head.next;
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
