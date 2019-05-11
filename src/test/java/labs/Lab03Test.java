package labs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Lab03Test {
    // https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testLogValuesNotIncludedWithinRange() {
        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };

        Lab03.logValuesNotIncludedWithinRange(weeklyMonthTemperatures);

        String testString =
                "High: 72\r\n" +
                "Low: 51\r\n" +
                "Never saw temperature: 63\r\n" +
                "Never saw temperature: 67\r\n" +
                "Never saw temperature: 68\r\n" +
                "Never saw temperature: 69\r\n";

        assertEquals(testString, outContent.toString());
    }

    @Test
    public void testTally() {
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");

        assertEquals("Bush", Lab03.tally(votes));

        System.out.println(Lab03.tally(votes) + " received the most votes!");
        assertEquals(Lab03.tally(votes) + " received the most votes!\r\n", outContent.toString());
    }
}