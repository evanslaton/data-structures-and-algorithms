public class ArrayReverse {
    public Object[] reverseArray(Object[] input) {
        int middle = input.length / 2;
        Object temp;

        if (input.length <= 1) return input;

        for (int i = 0; i < middle; i++) {
            temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i -1] = temp;
        }

        return input;
    }
}
