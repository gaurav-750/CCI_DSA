package LinkedList;

public class MyLinkedList {
    int val;
    MyLinkedList next;

    private static MyLinkedList head = null;
    private static int len = 0;
    private MyLinkedList temp;

//    constructor
    public MyLinkedList(int val) {
        this.val = val;
    }

    public MyLinkedList() {

    }

    public int get(int index){
        if (index >= len)
            return -1;

        temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    public void addToHead(int val){
        MyLinkedList headNode = new MyLinkedList(val);
        headNode.next = head;
        head = headNode;
        len += 1;
    }

    public void addToTail(int val){
        MyLinkedList tailNode = new MyLinkedList(val);
        if (head == null){
            tailNode.next = null;
            head = tailNode;
            len += 1;
            return;
        }

        int i = 0;
        temp = head;
        while (i < len-1){
            temp = temp.next;
            i++;
        }

        temp.next = tailNode;
        tailNode.next = null;
        len += 1;
    }

    public void addAtIndex(int index, int val){
        if (index > len) return;
        if (index == 0) {
            addToHead(val);
            return;
        }

        temp = head;
        while (index != 1){
            temp = temp.next;
            index--;
        }

        MyLinkedList nextNode = temp.next;
        MyLinkedList newNode = new MyLinkedList(val);
        temp.next = newNode;
        newNode.next = nextNode;
        len += 1;
    }

    public void deleteAtIndex(int index){
        if (index >= len) return;

        if (index == 0){
            head = head.next;
        }else { //index >= 1
            temp = head;
            while (index != 1){
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
        }

        len -= 1; //decrement the length by 1
    }

    public void print(){
        temp = head;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
