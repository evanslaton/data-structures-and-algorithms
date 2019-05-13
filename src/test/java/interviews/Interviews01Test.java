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

    @Test
    public void testGetNthFibonacci() {
        assertEquals(0, Interviews01.getNthFibonacci(0));
        assertEquals(1, Interviews01.getNthFibonacci(1));
        assertEquals(1, Interviews01.getNthFibonacci(2));
        assertEquals(55, Interviews01.getNthFibonacci(10));
        assertEquals(1134903170, Interviews01.getNthFibonacci(45));
    }

    @Test
    public void testGetNthFibonacciRecursively() {
        assertEquals(0, Interviews01.getNthFibonacciRecursively(0));
        assertEquals(1, Interviews01.getNthFibonacciRecursively(1));
        assertEquals(1, Interviews01.getNthFibonacciRecursively(2));
        assertEquals(55, Interviews01.getNthFibonacciRecursively(10));
        assertEquals(1134903170, Interviews01.getNthFibonacciRecursively(45));
    }

}