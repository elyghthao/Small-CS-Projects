public class KVEntry {
    int key;
    int value;

    KVEntry next; // chaining

    public KVEntry(int key, int value) {
        this.key = key;
        this.value = value;

    }
}
