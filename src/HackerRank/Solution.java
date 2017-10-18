package HackerRank;

import java.util.Scanner;

/**
 * Created by Darien on 4/30/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String _a;
        _a = in.nextLine();
        String _b;
        _b = in.nextLine();
        ArrayGen arrayGen = new ArrayGen(_b.split(" "));
        long[] input = arrayGen.getInput();
        long[] maxSumsMap = arrayGen.getMaxes();
        while(in.hasNext()){
            String[] inputValues = in.nextLine().split(" ");
            int a = Integer.parseInt(inputValues[0]);
            int b = Integer.parseInt(inputValues[1]);
            long finalSum = 0;
            for(int z = a; z <= b; z++){
                finalSum += input[z-1] + maxSumsMap[b-1] - maxSumsMap[z-1];
            }
            System.out.println(finalSum);
        }
    }

    private static int[] generateMaxMap(int[] input) {
        int[] maxes = new int[input.length];
        int max = -1;
        for(int i = 1; i<input.length; i++){
            if(input[i] > max)
                max = input[i];
            maxes[i] = maxes[i-1] + max;
        }
        return maxes;
    }

    private static class ArrayGen{
        private static long[] input;
        private static long[] maxes;

        ArrayGen(String[] input) {
            generateMaxMap(input);
        }

        private static void generateMaxMap(String[] inputStrings) {
            input = new long[inputStrings.length];
            maxes = new long[inputStrings.length];
            long max = -1;
            input[0] = Long.parseLong(inputStrings[0]);
            for(int i = 1; i<input.length; i++){
                long inputValue = Long.parseLong(inputStrings[i]);
                if(inputValue > max)
                    max = inputValue;
                maxes[i] = maxes[i-1] + max;
                input[i] = inputValue;
            }
        }

        long[] getMaxes() {
            return maxes;
        }

        long[] getInput() {
            return input;
        }
    }

}
