import java.util.Arrays;

public class MyHashMap {
    private static final int SIZE = 16;

    private int size;

    private static Entry[] table = new Entry[SIZE];

    class Entry {
        private final Object key;
        private Object value;
        private Entry next;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    private int getBucket(Object key) {
        return key.hashCode() % SIZE;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int bucket = getBucket(key);
        Entry entry = table[bucket];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot add null key");
        }

        int bucket = getBucket(key);
        Entry entry = table[bucket];
        Entry newEntry = new Entry(key, value);

        if (entry == null) {
            table[bucket] = newEntry;
            size++;
        } else {
            while (!entry.getKey().equals(key)) {
                if (entry.next == null) {
                    entry.next = newEntry;
                    size++;
                    return;
                }
                entry = entry.next;
            }
            entry.value = value;
        }
    }

    public boolean remove(Object key) {
        if (key == null) {
            return false;
        }

        int bucket = getBucket(key);
        Entry entry = table[bucket];
        if (entry == null) {
            return false;
        }

        while (!entry.getKey().equals(key)) {
            if (entry.next == null) {
                return false;
            }
            entry = entry.next;
        }
        table[bucket] = entry.next;
        size--;
        return true;
    }

    public int clear() {

        for (int i = 0; i < table.length; i++)
            table[i] = null;
        return size();
    }

    public void display() {
        for (Object elem : table) {
            System.out.print(elem + " ");
        }
    }
}
