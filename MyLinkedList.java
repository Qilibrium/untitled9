
public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    class Node {
        private Object value;
        private Node next;
        private Node prev;

        // private int data;
        public Node(Object value) {
            this.value = value;
        }

        public Node() {

        }
    }

    public void MyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(Object value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        temp.prev = tail;
        tail = temp;
        size++;
    }

    public void remove(int index) {
        if (index > size - 1) {
            throw new RuntimeException("Index greater than length");
        }
        if (index + 1 >= 0 && index + 1 <= size) {
            Node temp = head;
            if (index == 0) {
                if (head == null) {
                    throw new RuntimeException("IS EMPTY");
                }
                Node first = head;
                if (head.next == null) {
                    tail = null;
                } else {
                    head.next.prev = null;
                }
                head = head.next;
                size--;
            } else if (index == size - 1) {
                if (tail == null) {
                    throw new RuntimeException("IS EMPTY");
                }
                Node last = tail;
                if (head.next == null) {
                    head = null;
                } else {
                    tail.prev.next = null;
                }
                tail = tail.prev;
                size--;
            } else {
                for (int i = 0; i < index && temp.next != null; i++) {
                    temp = temp.next;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
            }
        }
    }

    public void clear() {
        Node temp = new Node();
        while (this.head != null) {
            temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
        System.out.println("All nodes are deleted successfully.");
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}

