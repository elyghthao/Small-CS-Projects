import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void reverseStack() {
        // homework
        Main d = new Main();
        List<Stack<Integer>> tests = new ArrayList<Stack<Integer>>();
        List<Stack<Integer>> expectedAnswer = new ArrayList<Stack<Integer>>();


        Stack<Integer> test1 = new Stack<Integer>();
        tests.add(test1);
        Stack<Integer> test2 = new Stack<Integer>();
        test2.push(0);
        tests.add(test2);
        Stack<Integer> test3 = new Stack<Integer>();
        test3.push(1);
        test3.push(0);
        tests.add(test3);
        Stack<Integer> test4 = new Stack<Integer>();
        test4.push(2);
        test4.push(1);
        test4.push(0);
        tests.add(test4);
        Stack<Integer> test5 = new Stack<Integer>();
        test5.push(3);
        test5.push(2);
        test5.push(2);
        test5.push(1);
        tests.add(test5);


        Stack<Integer> expectedTest1 = new Stack<Integer>();
        expectedAnswer.add(expectedTest1);
        Stack<Integer> expectedTest2 = new Stack<Integer>();
        expectedTest2.push(0);
        expectedAnswer.add(expectedTest2);
        Stack<Integer> expectedTest3 = new Stack<Integer>();
        expectedTest3.push(0);
        expectedTest3.push(1);
        expectedAnswer.add(expectedTest3);
        Stack<Integer> expectedTest4 = new Stack<Integer>();
        expectedTest4.push(0);
        expectedTest4.push(1);
        expectedTest4.push(2);
        expectedAnswer.add(expectedTest4);
        Stack<Integer> expectedTest5 = new Stack<Integer>();
        expectedTest5.push(1);
        expectedTest5.push(2);
        expectedTest5.push(2);
        expectedTest5.push(3);
        expectedAnswer.add(expectedTest5);


        for (int i =0; i<expectedAnswer.size();i++) {
            d.ReverseStack(tests.get(i));
            assertEquals(tests.get(i), expectedAnswer.get(i));
        }

    }
}