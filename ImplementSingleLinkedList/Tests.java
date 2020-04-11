public class Tests {
    public static boolean assertEquals(int expected, int actual) {
        if (expected != actual) {
            System.out.println("assertEquals failed. Expected: " + expected + ", actual: " + actual);
            return false;
        }
        return true;
    }

    public static boolean assertTrue(boolean actual) {
        if (!actual) {
            System.out.println("assertEquals failed. Expected: " + true + ", actual: " + false);
            return false;
        }
        return true;
    }

    public static boolean assertFalse(boolean actual) {
        if (actual) {
            System.out.println("assertEquals failed. Expected: " + false + ", actual: " + true);
            return false;
        }
        return true;
    }

    public static boolean assertEquals(Item expected, Item actual) {
        if (!expected.equals(actual)) {
            System.out.println("assertEquals failed. Expected: " + expected + ", actual: " + actual);
            return false;
        }
        return true;
    }
}