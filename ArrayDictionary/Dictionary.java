public interface Dictionary {

    boolean isEmpty();
    boolean add(int key, int value);
    boolean remove(int key);
    Integer get(int key);
    boolean contains(int key);
}
