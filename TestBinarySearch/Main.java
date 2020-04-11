/*
CSS143B homework 4, problem 1
by Elygh K. Thao
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("testBinarySearch " + (testBinarySearch() ? "PASSED" : "FAILED"));

    }

    // helper function
    public static int binarySearch(int[] data, int target, int start, int end) {
        // homework
        int mid = (((end - start) / 2) + start);
        if (end < start || mid == -1) {
            return -1;
        }
        if (data[mid] == target) {
            return mid;
        }
        if (data[mid] > target) {//scope changed to the bottom half
            return binarySearch(data, target, start, mid - 1);
        }
        if (data[mid] < target) {//scope changed to the top half
            return binarySearch(data, target, mid + 1, end);
        }
        return -1;

        //TODO When coding, I either don't listen to any music, or listen to a song in a language that I don't understand
        //TODO I get distracted when I can understand the lyrics
    }

    // binarySearch returns the index of the target location found in the array
    // returns -1 if target not found.
    public static int binarySearchRecursive(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    public static int binarySearchIterative(int[] data, int target) {
        // homework
        int top = data.length - 1;
        int bottom = 0;
        int mid;

        while (top >= bottom) {//loops until it goes through all indexes or finds the target number
            mid = (((top - bottom) / 2) + bottom);
            if (data[mid] == target) {//target number found
                return mid;
            }
            if (data[mid] > target) {//scope changed to the bottom half
                top = mid - 1;
            }
            if (data[mid] < target) {//scope changed to the top half
                bottom = mid + 1;
            }
        }
        return -1;
    }

    public static boolean testBinarySearch() {
        int inputs[][] = {
                {},
                {3},
                {3},
                {1, 3},
                {1, 3},
                {4, 6, 8},
                {4, 6, 8},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
                {3, 5, 7, 9, 20},
        };
        int targets[] = {9, 1, 3, 1, 3, 4, 6, 8, 3, 9};
        int answer[] = {-1, -1, 0, 0, 1, 0, 1, 2, 0, 3};

        for (int i = 0; i < inputs.length; i++) {
            int iterativeAnswer = binarySearchIterative(inputs[i], targets[i]);
            int recursiveAnswer = binarySearchRecursive(inputs[i], targets[i]);
            int expected = answer[i];
            if (iterativeAnswer != expected || recursiveAnswer != expected) {
                System.out.printf("testBinarySearch: case %d, expected %d, iterativeAnswer %d, recursiveAnswer %d\n",
                        i, expected, iterativeAnswer, recursiveAnswer);
                return false;
            }
        }

        return true;
    }
}