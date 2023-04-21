package LinkedList;
import java.util.*;

public class Linked_List {

    public Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        Node<Integer> head = null, tail = null;
        while (data != -1){
            Node<Integer> currentNode = new Node<>(data);

            if (head == null){
                head = currentNode;
            }else {
                tail.next = currentNode;
            }
            tail = currentNode;
            data = sc.nextInt();
        }

        return head;
    }

    public void printLL(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node<Integer> insert(int value, int index, Node<Integer> head){
        if (index == 0){
            return insertFirst(value, head);
        }

        Node<Integer> temp = head;
        int i = 0;
        while (i < index - 1){
            temp = temp.next;
            i++;
        }

        Node<Integer> newNode = new Node<>(value);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    private Node<Integer> insertFirst(int value, Node<Integer> head) {
        Node<Integer> firstNode = new Node<>(value);
        firstNode.next = head;
        head = firstNode;
        return head;
    }

    public Node<Integer> deleteLast(Node<Integer> head){
        if (head == null || head.next == null)
            return null;

        Node<Integer> temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public Node<Integer> insertRecursively(int val, int ind, Node<Integer> head) {
//        base case
        if (ind == 0) return insertFirst(val, head);
        if (ind == 1){
            Node<Integer> newNode = new Node<>(val);
            newNode.next = head.next;
            head.next = newNode;
            return head;
        }

        head.next = insertRecursively(val, ind-1, head.next);
        return head;
    }
}
