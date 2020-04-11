public class Main {

    public static void play() {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println(list.get(0));

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.toString());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(-1));

        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);

        System.out.println(list.toString());

        list.removeFirst();
        System.out.println(list.toString());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.removeLast();
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        LinkedListTests.testAll();
    }
}