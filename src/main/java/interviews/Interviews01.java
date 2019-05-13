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
}
