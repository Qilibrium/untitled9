import static jdk.internal.org.jline.utils.Colors.s;

public class MyStack {


    private int size;
    private Object[] array;
    private int tailHead;

    public MyStack(int s) {

        Object size = s;
        array = new Object[s];
        tailHead = -1;
    }

    public Object push(Object value) {
        int i = ++tailHead;
        array[i] = value;
        return value;
    }

    public Object remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[index] = null;
        return null;
    }

    public int clear() {

        for (int i = 0; i < array.length; i++)
            array[i] = null;
        size++;
        return size;
    }

    public int size() {
        return tailHead + 1;
    }

    public Object peek() {
        if (tailHead == -1) {
            return 0;
        } else {
            return array[tailHead];
        }
    }

    public Object pop() {
        Object result = array[tailHead - 1];
        if (tailHead == -1) {
            return 0;
        } else {
            return array[tailHead--];

        }
    }
}
