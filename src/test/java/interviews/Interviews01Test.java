package interviews;

import org.junit.Test;

import static org.junit.Assert.*;

public class Interviews01Test {
    @Test
    public void testGetSumsOfMatrix() {
        int[][] testMatrix = new int[3][];
        int[] firstRow = {1, 2, 3};
        int[] secondRow = {3, 5, 7};
        int[] thirdRow = {1, 7, 10};

        testMatrix[0] = firstRow;
        testMatrix[1] = secondRow;
        testMatrix[2] = thirdRow;

        int[] expectedOutput = {6, 15, 18};

        assertArrayEquals(expectedOutput, Interviews01.getSumsOfMatrix(testMatrix));
    }

}