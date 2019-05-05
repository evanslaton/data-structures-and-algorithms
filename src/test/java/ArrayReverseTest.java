import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayReverseTest {
    @Test
    public void testArrayReverse() {
        ArrayReverse arrayReverse = new ArrayReverse();

        Object[] testIntInput = {1, 2, 3, 4, 5};
        Object[] testIntOutput = {5, 4, 3, 2, 1};
        assertArrayEquals(arrayReverse.reverseArray(testIntInput), testIntOutput);

        Object[] testBooleanInput = {true, true, false, false, true, false};
        Object[] testBooleanOutput = {false, true, false, false, true, true};
        assertArrayEquals(arrayReverse.reverseArray(testBooleanInput), testBooleanOutput);

        Object[] testStringInput = {"This is", "a string", "array."};
        Object[] testStringOutput = {"array.", "a string", "This is"};
        assertArrayEquals(arrayReverse.reverseArray(testStringInput), testStringOutput);

        Object[] testVaryingDataTypesInput = {0, 'a', 2.5, true, "string", arrayReverse};
        Object[] testVaryingDataTypesOutput = {arrayReverse, "string", true, 2.5, 'a', 0};
        assertArrayEquals(arrayReverse.reverseArray(testVaryingDataTypesInput), testVaryingDataTypesOutput);

        Object[] testEmptyInput = {};
        Object[] testEmptyOutput = {};
        assertArrayEquals(arrayReverse.reverseArray(testEmptyInput), testEmptyOutput);
    }
}