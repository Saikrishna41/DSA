package linkedList;


public class LList {


    class Nodess {

        Nodess next;
        int data;

        public Nodess(int x) {

            this.data = x;
        }
    }
    Nodess head;

    public void append(int x) {

        Nodess newNode = new Nodess(x);

        if(head == null) {

            head = newNode;
            return;
        }
        Nodess current = head;
        while (current.next != null) {
            current = current.next;

        }
        current.next = newNode;
    }

    public void prepend(int x) {

        Nodess newNode = new Nodess(x);
        if(head == null) {
            head = newNode;
            return;
        }
        else {
            newNode.next = head;
            head = newNode;
            return;
        }
    }

    public void insertAfter(Nodess prev, int x) {

        Nodess newNode = new Nodess(x);
        if(prev == null) {
            System.out.println("previous node cannot be null");
        }
        else {

            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public void removeVal(int key) {

        Nodess temp = head, prev = null;
        if(temp != null && temp.data == key) {
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

    public void removeValAtPos(int pos) {
        Nodess temp = head;
        if(pos == 0) {
            head = temp.next;
        }
        for(int i = 0; i < pos - 1 && temp != null ; i++) {
            temp = temp.next;
        }
        if(temp == null) {
            return;
        }
        Nodess next = temp.next.next;
        temp.next = next;
    }

    public void printList() {

        Nodess currnt = head;
        while (currnt != null) {
            if(currnt.next != null) {
                System.out.print(currnt.data+"->");

            }
            else {

                System.out.print(currnt.data);
            }
            currnt = currnt.next;

        }

    }

    public void getNthElementfromlast(int n) {

       int len = 0;

       Nodess temp = head;

       while (temp != null) {

           temp = temp.next;
           len++;
       }
       if(len < n) {
           return;
       }
       temp = head;

       for(int i = 1; i < len - n + 1; i++) {

           temp = temp.next;

       }
        System.out.println(temp.data);
    }



    public static void main(String[] args) {

        LList l = new LList();
        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(5);
        l.printList();
        System.out.println();
        l.insertAfter(l.head.next.next.next,22);
        l.printList();
        System.out.println();
        l.removeVal(22);
        l.printList();
        System.out.println();
        l.removeValAtPos(4);
        System.out.println();
        l.printList();
        System.out.println();
        l.getNthElementfromlast(2);


    }
}