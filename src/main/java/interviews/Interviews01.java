package interviews;

public class Interviews01 {

    // Given a matrix, find the sum of each row.
    public static int[] getSumsOfMatrix(int[][] input) {
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            output[i] = getSumOfRow(input[i]);
        }

        return output;
    }

    public static int getSumOfRow(int[] row) {
        int rowSum = 0;

        for (int i = 0; i < row.length; i++) {
            rowSum += row[i];
        }

        return rowSum;
    }

    // Generate the nth Fibonacci number, 2 different ways.
    public static int getNthFibonacci(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        int placeHolder;

        if (n < 1) {
            return firstNumber;
        }

        for (int i = 0; i < n - 2; i++) {
            placeHolder = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = placeHolder;
        }

        return secondNumber;
    }
}
