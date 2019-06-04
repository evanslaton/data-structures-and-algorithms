package labs;

import java.util.*;

public class Lab03 {
    public static void main(String[] args) {

        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");;

        String winner = tally(votes);
        System.out.println(winner + " received the most votes!");
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
        List<Integer> missingValues = getMissingValuesFromRange(maximumValue,
                                                                minimumValue,
                                                                uniqueValues);

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

    public static List<Integer> getMissingValuesFromRange(int maximumValue,
                                                          int minimumValue,
                                                          HashSet<Integer> values) {
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

    // Write a function called tally that accepts a List of Strings
    // representing votes and returns one string to show what got
    // the most votes.
    public static String tally(List<String> votes) {
        HashMap votesPerCandidate = tallyVotes(votes);
        return getWinner(votesPerCandidate);
    }

    public static HashMap<String, Integer> tallyVotes(List<String> votes) {
        HashMap<String, Integer> votesPerCandidate = new HashMap<>();
        Integer INITIAL_VOTE = 1;

        for (String vote : votes) {
            if (votesPerCandidate.containsKey(vote)) {
                votesPerCandidate.put(vote, votesPerCandidate.get(vote) + 1);
            } else {
                votesPerCandidate.put(vote, INITIAL_VOTE);
            }
        }

        return votesPerCandidate;
    }

    public static String getWinner(HashMap<String, Integer> votesPerCandidate) {
        String winner = "";
        Integer candidatesVotes;
        Integer mostVotes = -1;

        for (String candidate : votesPerCandidate.keySet()) {
            candidatesVotes = votesPerCandidate.get(candidate);

            if (candidatesVotes > mostVotes) {
                winner = candidate;
                mostVotes = candidatesVotes;
            } else if (candidatesVotes.equals(mostVotes)) {
                winner = winner + " and " + candidate;
            }
        }

        return winner;
    }
}
