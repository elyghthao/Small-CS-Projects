import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSort();
    }

    private static int partition(int arr[], int low, int high) {
        // homework
        int placeholder;
        int mid = high;
        int pivot = arr[mid];
        for (int i = low; i<=high;i++) {

                if (arr[i] < pivot) {//values less than pivot
                    placeholder = arr[i];
                    for (int shift = i; shift > low; shift--) {//I changed the variable responsible for shifting to "shift"
                        arr[shift] = arr[shift - 1];
                    }
                    arr[low] = placeholder;
                    if (mid < i) {
                        mid++;
                    }
                }

                if (arr[i] > pivot) {//values greater than or equal to pivot
                    placeholder = arr[i];
                    for (int shift = i; shift < high; shift++) {//I changed the variable responsible for shifting to "shift"
                        arr[shift] = arr[shift + 1];
                    }
                    arr[high] = placeholder;
                    if(mid >=i && mid != 0) {
                        i --;
                        mid--;
                } else if(arr[mid] > arr[i]) {
                        i--;
                        mid--;
                    }
                }
        }

        return mid; // place holder
    }

    private static void quickSort(int data[], int low, int high) {
        // homework
        if (low < high) {
            int pivotIndex = partition (data,low,high);

            quickSort(data, low, pivotIndex-1);//bottom half
            quickSort(data, pivotIndex +1 , high);//top half
        }
    }

    public static void bubbleSort(int data[]) {
        // use code from homework 1
        int apple;
        for (int i = 0; i < data.length - 1;i++ ) {//loops through each index
            int j = i;
            while (data[j] > data[j + 1]) {//loops until number is in correct spot
                apple = data[j];
                data[j] = data[j + 1];
                data[j + 1] = apple;
            }
            if (j != 0) {//checks to see if the number before is greater than, if so loop goes back
                if (data[j] < data[j - 1]) {
                    i = j - 2;
                }
            }
        }
    }

    public static void quickSort(int data[]) {
        quickSort(data, 0, data.length - 1);
    }

    public static void testSort() {
        // homework
        // compare both
        // 1. bubble sort and quick sort result match
        // 2. both result match the result of Arrays.sort()
        //System.out.println("testSort FAILED"); // placeholder\
        boolean passed = true;


        int input[][] = {
                        {getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000)},

                        {getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000)},

                        {getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000)},

                        {getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000)},

                        {getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),
                                getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000),getRandomNumberInRange(-1000,1000)}
                };
        int[][] expectedArraySortAnswer = new int [input.length][];
        int[][] expectedBubbleSortAnswer = new int [input.length][];
        getCorrectAnswers(input, expectedArraySortAnswer);
        getCorrectAnswersBubble(input,expectedBubbleSortAnswer);

        for (int i = 0; i < input.length; i++) {//go through each list
            quickSort(input[i]);
            for (int j = 0; j < input[i].length; j++) {//go through each value
                if (input[i][j] != expectedArraySortAnswer[i][j] || input[i][j] != expectedBubbleSortAnswer[i][j]) {
                    passed = false;
                }
            }
        }

        System.out.println("testSort " + (passed ? "PASSED" : "FAILED"));


    }

    //https://mkyong.com/java/java-generate-random-integers-in-a-range/
    // generate a random number between min and max
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    private static void getCorrectAnswers(int[][] inputs, int[][]expects) {
        for (int i = 0; i < inputs.length; i++) {
            expects[i] = inputs[i].clone();
            Arrays.sort(expects[i]);
        }
    }
    private static void getCorrectAnswersBubble(int[][] inputs, int[][]expects) {
        for (int i=0; i<inputs.length; i++) {
            expects[i] = inputs[i].clone();
            bubbleSort(expects[i]);
        }
    }
}