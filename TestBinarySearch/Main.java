/*
CSS143B homework 1, problem 1
by Elygh Thao
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("testBinarySearch " + (testBinarySearch() ? "PASSED" : "FAILED"));
    }

    public static int binarySearch(int[] data, int target) {//This code i used was heavily influenced by https://www.geeksforgeeks.org/binary-search/
        int top = data.length - 1;
        int bottom = 0;
        int mid;
        while (top >= bottom) {//loops until it goes through all indexes or finds the target number
            mid = (((top - bottom) / 2) + bottom);
            if (data[mid] == target) {//target number found
                return mid;
            }
            if (data[mid] > target) {//scope changed to the bottom half
                top = mid-1;
            }
            if (data[mid] < target) {//scope changed to the top half
                bottom = mid + 1;
            }
        }
        return -1;
    }

    public static boolean testBinarySearch() {

        //******Please just edit targetNum  when choosing the target number******//
        int targetNum = 9;
        int indexFound;


        int inputs[][] = {//im assuming numbers are in order from least to greatest
                {},                                     //list 0
                {1, 3, 6, 8, 9},                        //list 1
                {1, 3, 6, 9, 99},                       //list 2
                {1, 9, 76, 98, 111, 123, 135, 453}};    //list 3
        int expectedAnwser[] =  {-1, 4, 3, 1};//these are the answers assuming the target number is 9

        for (int i = 0; i < inputs.length; i++) {
            indexFound = binarySearch(inputs[i], targetNum);
            if (indexFound != expectedAnwser[i]) {
                System.out.printf("Case %d:  Target Number %s:  Expected %s:  Actual %s:\n", i, targetNum, expectedAnwser[i], indexFound);
                return false;
            }
        }
        return true;
    }
}