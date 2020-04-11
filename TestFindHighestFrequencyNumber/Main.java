/*
CSS143B homework 1, problem 3
by Elygh Thao
 */


import java.util.Arrays;

class Answer {
    private int val; //max number
    private boolean isValid; //boolean

    public Answer(int maxNumber, boolean foundAnswer) {
        this.val = maxNumber;
        this.isValid = foundAnswer;
    }

    public boolean equals(Answer anotherAnswer) {//this is comparing two answer classes; returns false if they do not equal each other
        return val == anotherAnswer.val &&
                isValid == anotherAnswer.isValid;
    }

    @Override
    public String toString() {
        return "MaxNumberAnswer{" +
                "maxNumber=" + val +
                ", foundAnswer=" + isValid +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("testFindHighestFrequencyNumber " + (testFindHighestFrequencyNumber() ? "PASSED" : "FAILED"));
    }

    public static Answer findHighestFrequencyNumber(int[] data) {
        int bigNum = 0;
        int bigNumFreq = 0;

        int currentNum = 0;
        int currentFreq = 0;
        for (int i = 0; i < data.length -1; i++) {
            currentNum = i;
            currentFreq =0;
            for (int j = 1; j <= data.length - 1; j++) {
                if (data[currentNum] == data[j]) {
                    currentFreq++;
                }
            }
            if (currentFreq > bigNumFreq) {
                bigNum = currentNum;
                bigNumFreq = currentFreq;
            }
        }

        int finalNumber = 0;
        boolean numberFound = false;
        if (data.length == 0 ) {
            finalNumber = -1;

        }else {
            finalNumber = data[bigNum];
            numberFound = true;
        }
        return new Answer(finalNumber, numberFound);
    }

    public static boolean testFindHighestFrequencyNumber() {
//        // prepare the answers
        int inputs[][] = {
                {},
                {7},
                {-1},
                {2, 2},
                {4, 4, 3},
                {6, 5, -1, 6},
                {7, 8, 9, 8, 8}};
        int values[] = {-1, 4, -1, 2, 4, 6, 8};
        Answer[] answers = new Answer[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            answers[i] = new Answer(values[i], (i == 0 ? false : true));
        }

        // compare answer. return false if any case fails. true otherwise
        for (int i = 0; i < inputs.length; i++) {

            Answer actual = findHighestFrequencyNumber(inputs[i]);
            Answer expected = answers[i];

            if (!expected.equals(actual)) {
                System.out.printf("Case %d: Expected %s, actual %s\n", i, expected, actual);
                return false;
            }
        }
        return true;
    }
}