public class Main {
    public static void main(String[] args) {
        System.out.println("testMinStackEmpty " + (MinStackTest.testMinStackEmpty() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeOne " + (MinStackTest.testMinStackSizeOne() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeTwo " + (MinStackTest.testMinStackSizeTwo() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeThree " + (MinStackTest.testMinStackSizeThree() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeFour " + (MinStackTest.testMinStackSizeFour() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeFive " + (MinStackTest.testMinStackSizeFive() ? "PASSED" : "FAILED"));
        System.out.println("testMinStackSizeSix " + (MinStackTest.testMinStackSizeSix() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackEmptyQueue " + (ArrayStackTests.testArrayStackEmpty() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackQueueOfSizeOne " + (ArrayStackTests.testArrayStackOfSizeOne() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackQueueOfSizeTwo " + (ArrayStackTests.testArrayStackOfSizeTwo() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackOfSizeThree " + (ArrayStackTests.testArrayStackOfSizeThree() ? "PASSED" : "FAILED"));
        System.out.println("ValidParentheses.testIsValid " + (ValidParentheses.testIsValid() ? "PASSED" : "FAILED"));
    }
}
