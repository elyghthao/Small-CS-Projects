/*
CSS143B homework 2, problem 1
by Elygh Thao
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("testColorSort " + (Tests.testColorSort() ? "PASSED" : "FAILED"));
    }

    //I got rid of unnecessary comments
    public static void colorSort(int[] nums) {
        int numOfTwos = 0;
        for (int i = 0; i < nums.length - numOfTwos; i++) {//searches for 2's and places them at the front
            if (nums[i] == 2 && i != nums.length - 1) {
                for (int shift = i; shift < nums.length - 1; shift++) {//I changed the variable responsible for shifting to "shift"
                    nums[shift] = nums[shift + 1];
                }
                nums[nums.length - 1] = 2;
                numOfTwos++;
                if (nums[i] == 2) {
                    i--;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {//searches for 0's and places them at the front
            if (nums[i] == 0 && i != 0) {
                for (int shift = i; shift > 0; shift--) {//I changed the variable responsible for shifting to "shift"
                    nums[shift] = nums[shift - 1];
                }
                nums[0] = 0;
                if (nums[i] == 0 && i != nums.length - 1) {
                    i--;
                }
                if (i == 0) {
                    i++;
                }
                if (i != nums.length - 1 && i != 0 && nums[i - 1] == 0 && nums[i + 1] == 0 && nums[i] == 0) {
                    i++;
                }
            }
        }
    }
}
