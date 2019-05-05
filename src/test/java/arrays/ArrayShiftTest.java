package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayShiftTest {
    @Test
    public void arrayShiftTest() {
        ArrayShift arrayShift = new ArrayShift();

        Object[] testIntInput = {1, 2, 3, 4, 5};
        Object[] testIntOutput = {1, 2, 100, 3, 4, 5};
        assertArrayEquals(arrayShift.arrayShift(testIntInput, 100), testIntOutput);

        Object[] testBooleanInput = {true, true, true, true};
        Object[] testBooleanOutput = {true, true, false, true, true};
        assertArrayEquals(arrayShift.arrayShift(testBooleanInput, false), testBooleanOutput);

        Object[] testStringInput = {"String", "string", "string"};
        Object[] testStringOutput = {"String", "here", "string", "string"};
        assertArrayEquals(arrayShift.arrayShift(testStringInput, "here"), testStringOutput);

        Object[] testVaryingDataTypesInput = {0, 'a', 2.5, true, "string", arrayShift};
        Object[] testVaryingDataTypesOutput = {0, 'a', 2.5, "middle", true, "string", arrayShift};
        assertArrayEquals(arrayShift.arrayShift(testVaryingDataTypesInput, "middle"), testVaryingDataTypesOutput);

        Object[] testEmptyInput = {};
        Object[] testEmptyOutput = {1};
        assertArrayEquals(arrayShift.arrayShift(testEmptyInput, 1), testEmptyOutput);

        Object[] testOneInput = {'a'};
        Object[] testOneOutput = {1, 'a'};
        assertArrayEquals(arrayShift.arrayShift(testOneInput, 1), testOneOutput);
    }
}