import java.util.Arrays;

public class MyArrayList {
    private int INIT_SIZE = 10;
    private int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int size = 0;

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public Object add(Object value) {
        if (size == array.length - 1)
            resize(array.length + INIT_SIZE); // увеличу в 2 раза, если достигли границ
        return array[size++] = value;
    }

    public Object remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size--;
        if (array.length > INIT_SIZE && size < array.length / CUT_RATE)
            resize(array.length / 2);
        return null;
    }

    public int clear() {

        for (int i = 0; i < array.length; i++)
            array[i] = null;
        size--;
        return size;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return array[index];
    }

    public void display() {
        for (Object elem : array) {
            System.out.print(elem + " ");
        }
    }
}
