package labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lab03 {
    public static void main(String[] args) {
        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };

        logValuesNotIncludedWithinRange(weeklyMonthTemperatures);
    }

    // Use the October Seattle weather data above. Iterate through
    // all of the data to find the min and max values. Use a
    // HashSet of type Integer to keep track of all the unique
    // temperatures seen. Finally, iterate from the min temp to
    // the max temp and print out any temperature not seen during
    // the month.
    public static void logValuesNotIncludedWithinRange(int[][] weatherData) {
        HashSet<Integer> uniqueValues = getUniqueValues(weatherData);
        int maximumValue = Collections.max(uniqueValues);
        int minimumValue = Collections.min(uniqueValues);
        List<Integer> missingValues = getMissingValuesFromRange(maximumValue, minimumValue, uniqueValues);

        System.out.println("High: " + maximumValue);
        System.out.println("Low: " + minimumValue);
        logMissingValues(missingValues);

    }

    public static HashSet<Integer> getUniqueValues(int[][] arrayOfArrays) {
        HashSet<Integer> uniqueValues = new HashSet<>();

        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                uniqueValues.add(arrayOfArrays[i][j]);
            }
        }

        return uniqueValues;
    }

    public static List<Integer> getMissingValuesFromRange(int maximumValue, int minimumValue, HashSet<Integer> values) {
        List<Integer> missingValues = new ArrayList<>();

        for (int i = minimumValue; i < maximumValue; i++) {
            if (!values.contains(i)) {
                missingValues.add(i);
            }
        }

        return missingValues;
    }

    public static void logMissingValues(List<Integer> missingValues) {
        Collections.sort(missingValues);

        for (int i = 0; i < missingValues.size(); i++) {
            System.out.println("Never saw temperature: " + missingValues.get(i));
        }
    }
}
