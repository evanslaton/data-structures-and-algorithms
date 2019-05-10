package labs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lab02 {
    public static void main(String[] args) {
        int[] rolls = roll(4);
        System.out.println(Arrays.toString(rolls));

        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println(containsDuplicates(intArray));

        int[] intArray2 = {1, 2, 3, 4, 4};
        System.out.println(containsDuplicates(intArray2));
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

    // Write a method called containsDuplicates that returns true
    // or false depending on whether the array contains duplicate
    // values.
    public static boolean containsDuplicates(int[] arr) {
        Set<Integer> set = arrayToSet(arr);
        return set.size() == arr.length ? false : true;
    }

    public static Set<Integer> arrayToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set;
    }
}