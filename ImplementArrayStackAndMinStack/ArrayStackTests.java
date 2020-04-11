public class ArrayStackTests {
    public static boolean testArrayStackEmpty() {
        ArrayStack stack = new ArrayStack(5);
        String testName = "testArrayStack";
        if (stack.size() != 0) {
            printFailMessage(testName, "size wrong", String.valueOf(0), String.valueOf(stack.size()));
            return false;
        }
        if (stack.pop()) {
            printFailMessage(testName, "pop wrong", String.valueOf(false), String.valueOf(true));
            return false;
        }
        return true;
    }

    public static boolean testArrayStackOfSizeOne() {
        int expectedNum = 4;
        ArrayStack stack = new ArrayStack(1);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.push(6);
        if (stack.peek().getData() == expectedNum) {
            return true;
        }else {
            printFailMessage("testArrayStackOfSizeOne", "not expected value", String.valueOf(expectedNum), String.valueOf(stack.peek().getData()));
            return false;
        }
    }

    public static boolean testArrayStackOfSizeTwo() {
        int expectedNum = 1;

        ArrayStack stack = new ArrayStack(2);
        stack.push(1);
        stack.push(5);
        stack.pop();
        if (stack.peek().getData() == expectedNum) {
            return true;
        }else {
            printFailMessage("testArrayStackOfSizeTwo", "not expected value", String.valueOf(expectedNum), String.valueOf(stack.peek().getData()));
            return false;
        }
    }

    public static boolean testArrayStackOfSizeThree() {
        int expectedNum = 7;

        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(5);
        stack.push(6);
        stack.pop();
        stack.pop();
        stack.push(7);
        if (stack.peek().getData() == expectedNum) {
            return true;
        }else {
            printFailMessage("testArrayStackOfSizeThree", "not expected value", String.valueOf(expectedNum), String.valueOf(stack.peek().getData()));
            return false;
        }
    }

    private static void printFailMessage(String testName, String message, String expected, String actual) {
        System.out.println(testName + " : " + message +
                ", expected: " + expected +
                ", actual: " + actual);
    }
}