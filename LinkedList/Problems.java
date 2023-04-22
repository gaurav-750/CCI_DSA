package LinkedList;

public class Problems {
    public static void main(String[] args) {

        Linked_List linkedList = new Linked_List();
        Node<Integer> head = linkedList.takeInput();
        linkedList.printLL(head);

//        head = linkedList.insertRecursively(101, 3, head);
//        linkedList.printLL(head);

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//        head = deleteDuplicates(head);
//        linkedList.printLL(head);
        
//        todo https://leetcode.com/problems/merge-two-sorted-lists/description/
//        Node<Integer> head1 = linkedList.takeInput();
//        Node<Integer> head2 = linkedList.takeInput();
//        linkedList.printLL(mergeTwoLinkedLists(head1, head2));

//        todo https://leetcode.com/problems/linked-list-cycle/
//        System.out.println("Has Cycle: " + hasCycle(head));

//        todo Length of cycle in LL
//        System.out.println("Length of Cycle: " + lengthOfCycle(head));
        
//        todo https://leetcode.com/problems/middle-of-the-linked-list/
//        middleOfLinkedList(head);

//        todo https://leetcode.com/problems/sort-list/
//        linkedList.printLL(sortLinkedList(head));

//        todo https://leetcode.com/problems/reverse-linked-list/description/
//        linkedList.printLL(reverseLL(head));
        linkedList.printLL(reverseLLIteratively(head));


    }

    private static Node<Integer> reverseLLIteratively(Node<Integer> head) {
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

    private static Node<Integer> reverseLL(Node<Integer> head) {
//        base case
        if (head == null || head.next == null)
            return head;

        Node<Integer> ans = reverseLL(head.next);
        Node<Integer> temp = ans;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head;
        head.next = null;

        return ans;
    }

    private static Node<Integer> sortLinkedList(Node<Integer> head) {
//        Linked_List l = new Linked_List();
//        l.printLL(head);
//        base case
        if (head == null || head.next == null)
            return head;

        Node<Integer> mid = getMid(head);
        Node<Integer> left = sortLinkedList(head);
        Node<Integer> right = sortLinkedList(mid);
        return mergeTwoLinkedLists(left, right);
    }

    private static Node<Integer> getMid(Node<Integer> head) {
        Node<Integer> midPrev = null;
        while (head != null && head.next != null){
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        Node<Integer> mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private static Node<Integer> middleOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static int lengthOfCycle(Node<Integer> head) {
        if (head == null || head.next == null) return 0;
        Node<Integer> slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
//                that means there is a cycle in the Linked List
                int len = 0;
                do {
                    slow = slow.next;
                    len++;
                } while (slow != fast);
                return len;
            }
        }
        return 0;
    }

    private static boolean hasCycle(Node<Integer> head) {
        if (head == null || head.next == null) return false;
        Node<Integer> slow = head, fast = head.next.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    private static Node<Integer> mergeTwoLinkedLists(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node<Integer> mergeHead = new Node<>(0), temp = mergeHead;

        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){ // h1 <= h2
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            }else { // h1 > h2
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }
//        for remaining nodes:
        Node<Integer> rem = head1 != null ? head1 : head2;
        while (rem != null){
            temp.next = rem;
            temp = rem;
            rem = rem.next;
        }
        return mergeHead.next;
    }

    private static Node<Integer> deleteDuplicates2(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp.next != null){
            if (temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }

        return head;
    }

    private static Node<Integer> deleteDuplicates(Node<Integer> head) {
        Node<Integer> finalHead = head, temp = head, x = head;

        while (x != null){
            int data = head.data;
            while (x != null  && temp.data == data){
                temp = temp.next;
                x = x.next;
            }
            head.next = temp;
            head = temp;
        }
        return finalHead;
    }
}
