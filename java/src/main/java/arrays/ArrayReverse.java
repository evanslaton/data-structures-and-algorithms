package arrays;

/* Write a function called reverseArray which takes an array as an argument. *
 * Without utilizing any of the built-in methods available to your language, *
 * return an array with elements in reversed order.                          */

public class ArrayReverse {
    public Object[] reverseArray(Object[] arr) {
        int middle = arr.length / 2;
        Object temp;

        if (arr.length <= 1) return arr;

        for (int i = 0; i < middle; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i -1] = temp;
        }

        return arr;
    }
}
