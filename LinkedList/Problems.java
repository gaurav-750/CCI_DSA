package LinkedList;

public class Problems {
    public static void main(String[] args) {

        Linked_List linkedList = new Linked_List();
//        Node<Integer> head = linkedList.takeInput();
//        linkedList.printLL(head);

//        head = linkedList.insertRecursively(101, 3, head);
//        linkedList.printLL(head);

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//        head = deleteDuplicates(head);
//        linkedList.printLL(head);
        
//        todo https://leetcode.com/problems/merge-two-sorted-lists/description/
        Node<Integer> head1 = linkedList.takeInput();
        Node<Integer> head2 = linkedList.takeInput();
        linkedList.printLL(mergeTwoLinkedLists(head1, head2));

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
