package labs;

import java.util.Arrays;
import java.util.Random;

public class Lab02 {
    public static void main(String[] args) {
        int[] rolls = roll(4);
        System.out.println(Arrays.toString(rolls));
    }

    // Write a method called roll that accepts an integer n and
    // rolls a six-sided dice n times. The method should return
    // an array containing the values of the rolls.
    public static int[] roll(int n) {
        int[] rolls = new int[n];

        for (int i = 0; i < n; i++) {
            rolls[i] = rollDie();
        }

        return rolls;
    }

    public static int rollDie() {
        int MINIMUM_NUMBER = 1;
        int MAXIMUM_NUMBER = 6;
        Random random = new Random();
        return random.nextInt( MAXIMUM_NUMBER - MINIMUM_NUMBER + 1) + MINIMUM_NUMBER;
    }
}
