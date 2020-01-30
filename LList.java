import linkedLists.LinkedList;

class LinkedListNode {

    LinkedListNode next;
    int data;

    public LinkedListNode(int x) {

        this.data = x;
        this.next = null;
    }

}

public class linkedLists1 {

    LinkedListNode head;


    public void append(int x) {
        LinkedListNode newNode = new LinkedListNode(x);
        if (head == null) {
            head = newNode;
            return;
        }

        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    public void prepend(int x) {
        LinkedListNode newNode = new LinkedListNode(x);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(LinkedListNode prev, int x) {
        LinkedListNode newNode = new LinkedListNode(x);
        newNode.next = prev.next;
        prev.next = newNode;


    }

    public void printAll() {

        LinkedListNode current = head;
        while (current != null) {

            System.out.print(current.data + "=> ");


            current = current.next;
        }
    }

    public void removeAt(int pos) {

        LinkedListNode temp = head, prev = null;
        if (head == null) {
            return;
        }
        if (pos == 0) {
            head = temp.next;
        }
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        LinkedListNode next = temp.next.next;
        temp.next = next;

    }

    public void removeNode(int key) {
        LinkedListNode temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
        }
        while (temp != null && temp.data != key) {

            prev = temp;

            temp = temp.next;


        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    public int getNthNode(int index) {

        LinkedListNode current = head;

        int count = 0;

        while (current != null) {

            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        assert (false);
        return 0;
    }

    public void getNthNodeFromLast(int index) {

        LinkedListNode current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        if (len < index) {
            return;
        }
        current = head;
        for (int i = 1; i < len - index + 1; i++) {
            current = current.next;
        }
        System.out.println(current.data);

    }

    public static void main(String[] args) {

        linkedLists1 node = new linkedLists1();

        node.append(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.printAll();

        node.insertAfter(node.head.next.next, 32);
        System.out.println();
        System.out.println("adding node 32");

        node.printAll();
        System.out.println();
        System.out.println("removing node 32");
        node.removeNode(32);
        node.printAll();
        System.out.println();
        System.out.println("find node");
        System.out.println(node.getNthNode(2));
        System.out.println();
        System.out.println("get nth node from last");
        node.getNthNodeFromLast(2);

    }

}
