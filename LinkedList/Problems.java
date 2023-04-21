package LinkedList;

public class Problems {
    public static void main(String[] args) {

        Linked_List linkedList = new Linked_List();
        Node<Integer> head = linkedList.takeInput();
        linkedList.printLL(head);

//        head = linkedList.insertRecursively(101, 3, head);
//        linkedList.printLL(head);

//        todo https://leetcode.com/problems/remove-duplicates-from-sorted-list/
        head = deleteDuplicates(head);
        linkedList.printLL(head);

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
