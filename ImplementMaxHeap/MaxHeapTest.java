import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MaxHeapTest {
    // homework
    @Test
    public void MaxHeapTests() {
        Integer[]data = {16,12,3,23,210,45,65,8999,12,144,741,54,56,98,1,2,3,4,5,456};
        MaxHeap test1 = new MaxHeap(data.length);
        MaxHeap test2 = new MaxHeap(data.length);

        test1.MaxHeapN(data);
        test2.MaxHeapLogN(data);
        assertArrayEquals(new Integer[]{8999, 741, 65, 98, 456, 56, 16, 23, 12, 210, 12, 54, 45, 3, 1, 2, 3, 4, 5, 144},test1.data);
        assertArrayEquals(new Integer[]{8999, 741, 65, 98, 456, 56, 16, 23, 12, 210, 12, 54, 45, 3, 1, 2, 3, 4, 5, 144},test2.data);

        assertEquals(8999, (int) test1.get());
        assertEquals(8999, (int) test2.get());

        assertEquals(8999, (int) test1.pop());
        assertEquals(741, (int) test1.pop());
        assertEquals(8999, (int) test2.pop());
        assertEquals(741, (int) test2.pop());
        assertArrayEquals(new Integer[]{456, 144, 210, 98, 54, 23, 12, 56, 65, 45, 16, 3, 1, 2, 3, 4, 5, 12, null, null},test1.data);
        assertArrayEquals(new Integer[]{456, 144, 210, 98, 54, 23, 12, 56, 65, 45, 16, 3, 1, 2, 3, 4, 5, 12, null, null},test2.data);

        test1.add(5000);test1.add(6000);
        test2.add(7000);test2.add(8000);
        assertArrayEquals(new Integer[]{6000, 5000, 210, 456, 144, 23, 12, 56, 98, 54, 16, 3, 1, 2, 3, 4, 5, 12, 65, 45},test1.data);
        assertArrayEquals(new Integer[]{8000, 7000, 210, 456, 144, 23, 12, 56, 98, 54, 16, 3, 1, 2, 3, 4, 5, 12, 65, 45},test2.data);
    }

}