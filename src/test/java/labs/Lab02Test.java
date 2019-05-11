package labs;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lab02Test {

    @Test
    public void testCalculateAverage() {
        int[] testArray = {66, 64, 58, 65, 71, 57, 60};
        int[] testArray1 = {57, 65, 65, 70, 72, 65, 51};
        int[] testArray2 = {55, 54, 60, 53, 59, 57, 61};
        int[] testArray3 = {65, 56, 55, 52, 55, 62, 57};

        assertEquals(63.0, Lab02.calculateAverage(testArray), 0);
        assertEquals( 63.57142857142857, Lab02.calculateAverage(testArray1),0);
        assertEquals(57.0, Lab02.calculateAverage(testArray2), 0);
        assertEquals( 57.42857142857143, Lab02.calculateAverage(testArray3), 0);
    }


    @Test
    public void testGetLowestAverage() {
        int[][] weeklyMonthTemperatures = {
            {66, 64, 58, 65, 71, 57, 60},
            {57, 65, 65, 70, 72, 65, 51},
            {55, 54, 60, 53, 59, 57, 61},
            {65, 56, 55, 52, 55, 62, 57}
        };

        assertArrayEquals(Lab02.getLowestAverage(weeklyMonthTemperatures), weeklyMonthTemperatures[2]);
    }

}