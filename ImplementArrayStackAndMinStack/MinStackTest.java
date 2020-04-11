public class MinStackTest {
    public static boolean testMinStack() {
        // homework
        return false; // placeholder
    }


    public static boolean testMinStackEmpty() {
        int expectedMinNum = -1;
        MinStack a = new MinStack(5);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }


    }
    public static boolean testMinStackSizeOne() {
        int expectedMinNum = 49;
        MinStack a = new MinStack(1);
        a.push(98);
        a.pop();
        a.push(49);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    public static boolean testMinStackSizeTwo() {
        int expectedMinNum = 24;

        MinStack a = new MinStack(2);
        a.push(65);
        a.push(7000);
        a.pop();
        a.push(24);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    public static boolean testMinStackSizeThree() {
        int expectedMinNum = 432;
        MinStack a = new MinStack(3);
        a.push(890);
        a.push(432);
        a.push(89);
        a.pop();
        a.push(980);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    public static boolean testMinStackSizeFour() {
        int expectedMinNum = 8;

        MinStack a = new MinStack(4);
        a.push(23);
        a.push(43);
        a.pop();
        a.push(89);
        a.pop();
        a.push(83);
        a.push(8);
        a.push(200);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    public static boolean testMinStackSizeFive() {
        int expectedMinNum = 32;
        MinStack a = new MinStack(5);
        a.push(90);
        a.push(32);
        a.push(34);
        a.pop();
        a.push(321);
        a.push(3245);
        a.push(45);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    public static boolean testMinStackSizeSix() {
        int expectedMinNum = 45;
        MinStack a = new MinStack(6);
        a.push(9087);
        a.pop();
        a.pop();
        a.push(435);
        a.push(345);
        a.push(45);
        a.push(564657);
        a.push(456);
        a.push(1245);
        if (a.getMin().getData() != expectedMinNum) {
            printFailMessage("Empty", "Not Expected Value", String.valueOf(expectedMinNum), String.valueOf(a.getMin().getData()));
            return false;
        }
        else  {
            return true;
        }
    }
    private static void printFailMessage(String testName, String message, String expected, String actual) {
        System.out.println(testName + " : " + message +
                ", expected: " + expected +
                ", actual: " + actual);
    }

}
