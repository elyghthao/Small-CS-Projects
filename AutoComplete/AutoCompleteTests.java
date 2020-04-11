import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class AutoCompleteTests {

    @Test
    public void testOne(){
        String[] wordBank = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        AutoComplete Google = new AutoComplete(wordBank);


        List<String> expected1 = new LinkedList<String>();
        expected1.add("hello");
        expected1.add("high");
        expected1.add("how");
        expected1.add("hollow");
        assertTrue(expected1.equals(Google.search("h")));


        List<String> expected2 = new LinkedList<String>();
        expected2.add("seatac");
        expected2.add("seattle");
        expected2.add("see");
        assertTrue(expected2.equals(Google.search("se")));

        List<String> expected3 = new LinkedList<String>();
        expected3.add("seatac");
        expected3.add("seattle");
        assertTrue(expected3.equals(Google.search("sea")));


        List<String> expected4 = new LinkedList<String>();
        expected4.add("how");
        assertTrue(expected4.equals(Google.search("how")));

        List<String> expected5 = new LinkedList<String>();
        assertTrue(expected5.equals(Google.search("xyz")));


    }


    @Test
    public void testTwo() {

    }
}
