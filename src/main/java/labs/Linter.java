package labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Linter {
    public static void main(String[] args) {
        Path p = Paths.get("resources/gates.js");
        logLinterErrors(p);
    }


    public static void logLinterErrors(Path path) {
        BufferedReader fileToLinter = getBufferedReader(path);
        String currentLine = "";
        int lineNumber = 0;

        while (currentLine != null) {
            if (isMissingSemiColon(currentLine)) {
                System.out.format("Line %d needs a semi-colon\n", lineNumber);
            }

            try {
                currentLine = fileToLinter.readLine();
                lineNumber++;
            } catch (IOException error) {
                System.err.format("IOException: %s%n", error);
            }
        }
    }

    public static BufferedReader getBufferedReader(Path path) {
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            return bufferedReader;
        } catch (IOException error) {
            System.err.format("IOException: %s%n", error);
            return null;
        }
    }

    public static boolean isMissingSemiColon(String currentLine) {
        if (!currentLine.isEmpty() &&
                !currentLine.contains("if") &&
                !currentLine.contains("else") &&
                !currentLine.endsWith("{") &&
                !currentLine.endsWith("}") &&
                !currentLine.endsWith(";")) {
            return true;
        } else {
            return false;
        }
    }
}
