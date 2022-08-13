public class MyQueue {
    private Node head;
    private int size;

    public MyQueue() {
        head = null;
    }

    public class Node {
        public Object value;
        public Node next;

        public Node(Object value) {
            this.value = value;
            next = null;
        }

        public Node() {

        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        Node headNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (headNode.next != null) {
                headNode = headNode.next;
            }
            headNode.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node newNode = new Node(index);
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("Can't be done");
        }
        int size = 1;
        Node temp = head;
        if (temp == newNode) {
            poll();
        }
        while (temp.next != null) {
            if (index == size++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        if (head != null) {
            Object result = head.value;
            head = head.next;
        }

    }

    public void clear() {
        if (head != null) {
            Object result = head;
            head = null;
            size--;
        }
    }

    public int size() {
        int size = 1;
        Node temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public Object peek() {
        return head.value;
    }

    public Object poll() {
        if (head != null) {
            Object result = head.value;
            head = head.next;
            size--;
            return result;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index greater than length");
        }
    }
}
    




