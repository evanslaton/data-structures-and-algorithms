package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArray2 = {5, 8, 7, 10, 9, 2, 1, 4, 3, 6};

        assertEquals(4, BinarySearch.binarySearch(testArray, 5));
        assertEquals(-1, BinarySearch.binarySearch(testArray, 50));
        assertEquals(-1, BinarySearch.binarySearch(testArray2, 5));
    }

}