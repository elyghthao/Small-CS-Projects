/*
CSS143B homework 1, problem 2
by Elygh Thao
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("testBubbleSort " + (testBubbleSort() ? "PASSED" : "FAILED"));
    }


    public static void bubbleSort(int[] data) {

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

    public static boolean testBubbleSort() {
        int input[][] =
                {{151,84,2,5,6,1851,843,854,5218,66,4,845,8,41,3,5},            //list 0
                {-456,-89,-999,-1851651681,-584585,7,-181,4456,-89898989},      //list 1
                {4545,78,6,98,454,-98,-4,-989},                                 //list 2
                {-345,45,9,9,9,0,0,0,98,14,15,3},
                {}
        };
        int expectedAnwser[][] = {
                {2, 3, 4, 5, 5, 6, 8, 41, 66, 84, 151, 843, 845, 854, 1851, 5218},
                {-1851651681, -89898989, -584585, -999, -456, -181, -89, 7, 4456},
                {-989, -98, -4, 6, 78, 98, 454, 4545},
                {-345, 0, 0, 0, 3, 9, 9, 9, 14, 15, 45, 98},
                {}
        };

        for (int i = 0; i < input.length; i++) {//go through each list
            bubbleSort(input[i]);
            for (int j = 0; j < input[i].length; j++) {//go through each value
                if (input[i][j] != expectedAnwser[i][j]) {
                    System.out.printf("Case %d: Expected %s, actual %s\n", i, expectedAnwser[i][j], input[i][j]);
                    return false;
                }
            }
        }


        return true;
    }
}