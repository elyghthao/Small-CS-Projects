import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);



    }

    @Test
    public void remove() {
        // homework

        //empty dictionary
        //returns false
        ArrayDictionary test1 = new ArrayDictionary(5) ;
        assertFalse(test1.remove(7));

        //key exists in a dictionary that has no collision
        //returns true
        ArrayDictionary test2 = new ArrayDictionary(5);
        test2.add(0,45);
        test2.add(1,56);
        test2.add(2,3);
        test2.add(3,7);
        test2.add(4,1);
        assertTrue(test2.remove(2));

        //key does not exists in dictionary that has no collision
        //returns false
        ArrayDictionary test3 = new ArrayDictionary(5);
        test3.add(0,45);
        test3.add(1,56);
        test3.add(2,3);
        test3.add(3,7);
        test3.add(4,1);
        assertFalse(test2.remove(7));

        //key exists in a dictionary that has collision, key is in the collision
        //returns true
        ArrayDictionary test4 = new ArrayDictionary(5);
        test4.add(2,3);
        test4.add(7,25);
        assertTrue(test4.remove(7));

        //key exists in a dictionary that has collision, key is not in the collision
        //returns false
        ArrayDictionary test5 = new ArrayDictionary(5);
        test5.add(2,3);
        test5.add(7,25);
        assertFalse(test4.remove(12));

        //key does not exists in a dictionary that has collision
        //returns false
        ArrayDictionary test6 = new ArrayDictionary(5);
        test5.add(2,3);
        test5.add(7,25);
        assertFalse(test4.remove(1));

    }

    @Test
    public void contains() {
        // homework

        //set1
        ArrayDictionary test1 = new ArrayDictionary(5);
        assertFalse(test1.contains(-1));
        assertFalse(test1.contains(0));
        assertFalse(test1.contains(1));

        //set2
        ArrayDictionary test2 = new ArrayDictionary(1);
        test2.add(0,103);
        assertFalse(test2.contains(2));
        assertTrue(test2.contains(0));

        //set3
        ArrayDictionary test3 = new ArrayDictionary(2);
        test3.add(0,103);
        test3.add(1,105);
        assertTrue(test3.contains(0));
        assertTrue(test3.contains(1));
        assertFalse(test3.contains(2));
        assertFalse(test3.contains(3));

        //set4
        ArrayDictionary test4 = new ArrayDictionary(3);
        test4.add(0,103);
        test4.add(1,105);
        assertFalse(test4.contains(3));
        test4.add(2,206);
        assertTrue(test4.contains(1));

        //set5
        ArrayDictionary test5 = new ArrayDictionary(3);
        test5.add(0,103);
        test5.add(1,105);
        test5.add(2,206);
        test5.add(4,407);
        assertTrue(test5.contains(1));
        assertTrue(test5.contains(4));
        assertFalse(test5.contains(7));
        assertFalse(test5.contains(8));


    }
}