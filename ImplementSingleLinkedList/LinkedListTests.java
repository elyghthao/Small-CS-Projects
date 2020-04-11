import java.security.cert.CertificateParsingException;

public class LinkedListTests extends Tests {

    public static void testAll() {
        testCopyConstructor();
        testRemove();
        testReverseIterative();
        testMergeSorted();
//        testEmptyList();
//        testListWithMultipleElements();
    }

    public static void testCopyConstructor() {
        // homework
        SingleLinkedList a = new SingleLinkedList();
        a.add(1);
        SingleLinkedList a2 = new SingleLinkedList(a);

        SingleLinkedList b = new SingleLinkedList();
        b.add(1);
        b.add(2);
        SingleLinkedList b2 = new SingleLinkedList(b);

        SingleLinkedList c = new SingleLinkedList();
        c.add(4);
        c.add(4);
        SingleLinkedList c2 = new SingleLinkedList(c);

        SingleLinkedList d = new SingleLinkedList();
        d.add(6);
        d.add(7);
        d.add(9);
        SingleLinkedList d2 = new SingleLinkedList(d);

        if (a.toString().equals(a2.toString()) &&
            b.toString().equals(b2.toString()) &&
            c.toString().equals(c2.toString()) &&
            d.toString().equals(d2.toString())) {
            System.out.println("testCopyConstructor PASSED");
        }else {
            System.out.println("testCopyConstructor FAILED");
        }



    }

    public static void testRemove() {
        // homework
        SingleLinkedList a = new SingleLinkedList();
        a.add(1);
        a.add(2);
        a.add(3);

        SingleLinkedList b = new SingleLinkedList();
        b.add(1);
        b.add(2);
        b.add(4);
        b.add(2);

        SingleLinkedList c = new SingleLinkedList();
        c.add(1);
        c.add(1);
        c.add(4);
        c.add(2);

        SingleLinkedList d = new SingleLinkedList();
        d.add(3);
        d.add(3);
        d.add(3);
        d.add(3);

        SingleLinkedList e = new SingleLinkedList();
        e.add(1);
        e.add(1);
        e.add(4);
        e.add(2);

        if (1 == a.remove(3) &&
            2 == b.remove(2) &&
            2 == c.remove(1) &&
            4 == d.remove(3) &&
            0 == e.remove(5)) {
            System.out.println("testRemove PASSED");
        }else {
            System.out.println("testRemove FAILED");
        }

    }

    public static void testReverseIterative() {
        // homework
        SingleLinkedList a = new SingleLinkedList();
        a.add(1);
        SingleLinkedList a2 = new SingleLinkedList();
        a2.add(1);

        SingleLinkedList b = new SingleLinkedList();
        b.add(1);
        b.add(2);
        SingleLinkedList b2 = new SingleLinkedList();
        b2.add(2);
        b2.add(1);

        SingleLinkedList c = new SingleLinkedList();
        c.add(4);
        c.add(4);
        SingleLinkedList c2 = new SingleLinkedList();
        c2.add(4);
        c2.add(4);

        SingleLinkedList d = new SingleLinkedList();
        d.add(6);
        d.add(7);
        d.add(9);
        SingleLinkedList d2 = new SingleLinkedList();
        d2.add(9);
        d2.add(7);
        d2.add(6);

        SingleLinkedList e = new SingleLinkedList();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(4);
        e.add(5);
        SingleLinkedList e2 = new SingleLinkedList();
        e2.add(5);
        e2.add(4);
        e2.add(3);
        e2.add(2);
        e2.add(1);

        a.reverseIterative();
        b.reverseIterative();
        c.reverseIterative();
        d.reverseIterative();
        e.reverseIterative();

        if (a.toString().equals(a2.toString()) &&
                b.toString().equals(b2.toString()) &&
                c.toString().equals(c2.toString()) &&
                d.toString().equals(d2.toString()) &&
                e.toString().equals(e2.toString())) {
            System.out.println("testReverseIterative PASSED");
        }else {
            System.out.println("testReverseIterative FAILED");
        }
    }

    public static void testMergeSorted() {
        // homework
        SingleLinkedList a = new SingleLinkedList();
        a.add(7);
        a.add(8);
        a.add(9);
        SingleLinkedList a2 = new SingleLinkedList();
        a.mergeSorted(a2);
        SingleLinkedList expecteda = new SingleLinkedList();
        expecteda.add(7);
        expecteda.add(8);
        expecteda.add(9);


        SingleLinkedList b = new SingleLinkedList();
        b.add(1);
        b.add(3);
        SingleLinkedList b2 = new SingleLinkedList();
        b2.add(2);
        b2.add(4);
        b.mergeSorted(b2);
        SingleLinkedList expectedb = new SingleLinkedList();
        expectedb.add(1);
        expectedb.add(2);
        expectedb.add(3);
        expectedb.add(4);

        SingleLinkedList c = new SingleLinkedList();
        c.add(1);
        c.add(3);
        SingleLinkedList c2 = new SingleLinkedList();
        c2.add(4);
        c2.add(5);
        c.mergeSorted(c2);
        SingleLinkedList expectedc = new SingleLinkedList() ;
        expectedc.add(1);
        expectedc.add(3);
        expectedc.add(4);
        expectedc.add(5);

        SingleLinkedList d = new SingleLinkedList();
        d.add(6);
        d.add(7);
        d.add(8);
        SingleLinkedList d2 = new SingleLinkedList();
        d2.add(4);
        d2.add(5);
        d.mergeSorted(d2);
        SingleLinkedList expectedd = new SingleLinkedList() ;
        expectedd.add(4);
        expectedd.add(5);
        expectedd.add(6);
        expectedd.add(7);
        expectedd.add(8);


        SingleLinkedList e = new SingleLinkedList();
        e.add(3);
        e.add(3);
        e.add(8);
        SingleLinkedList e2 = new SingleLinkedList();
        e2.add(2);
        e2.add(5);
        e.mergeSorted(e2);
        SingleLinkedList expectede = new SingleLinkedList();
        expectede.add(2);
        expectede.add(3);
        expectede.add(3);
        expectede.add(5);
        expectede.add(8);

        if (a.toString().equals(expecteda.toString()) &&
            b.toString().equals(expectedb.toString()) &&
            c.toString().equals(expectedc.toString()) &&
            d.toString().equals(expectedd.toString()) &&
            e.toString().equals(expectede.toString())) {
            System.out.println("testMergeSorted PASSED");
        }else {
            System.out.println("testMergeSorted FAILED");
        }



    }

    private static void testListWithMultipleElements() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        // list as [-1, 1, 2]
        list.add(1);
        list.add(2);
        list.addFirst(-1);

        if (!assertEquals(list.size(), 3)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(1), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(2), new Item(2, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(3), invalidItem)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeLast();
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeFirst();
        if (!assertEquals(list.get(0), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }

        System.out.println("testListWithOneElement PASSED");
    }

    private static void testEmptyList() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        if (!assertEquals(list.size(), 0)) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getFirst())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getLast())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.get(0))) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        System.out.println("testEmptyList PASSED");
    }
}