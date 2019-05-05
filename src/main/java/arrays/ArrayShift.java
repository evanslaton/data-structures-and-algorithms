package arrays;

/* Write a function called insertShiftArray which takes in an array and *
 * the value to be added. Without utilizing any of the built-in methods *
 * available to your language, return an array with the new value added *
 * at the middle index.                                                 */

public class ArrayShift {
    public Object[] arrayShift(Object[] arr, Object valueToInsert) {
        Object[] output = new Object[arr.length + 1];
        int middle = arr.length / 2;

        for (int i = 0; i < output.length; i++) {
            if (i < middle) {
                output[i] = arr[i];
            } else if (i > middle) {
                output[i] = arr[i - 1];
            } else {
                output[i] = valueToInsert;
            }
        }

        return output;
    }
}
