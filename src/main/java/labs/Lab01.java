package labs;

public class Lab01 {
    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(1);
    }

    // Write a function called pluralize that accepts a word and a
    // number and returns a string with the word pluralized with an
    // “s” if the number is zero, or greater than one.
    public static String pluralize(String noun, int count) {
        return count == 0 || count > 1 ? noun + "s" : noun;
    }

    // Write a function called flipNHeads that accepts an integer n
    // and flips coins until n heads are flipped in a row. Simulate
    // coin flipping by choosing a random number between 0 and 1.
    // Numbers below .5 are considered tails. Numbers at and above
    // .5 are considered heads. Print out heads or tails on one line
    // for each flip. Print It took FLIPS flips to flip N heads in a
    // row. once n heads have been in a row.
    public static void flipNHeads(int n) {
        int totalCoinFlips = 0;
        int consecutiveHeads = 0;

        while (consecutiveHeads < n) {
            totalCoinFlips++;

            if (coinFlip().equals("Heads")) {
                consecutiveHeads++;
                System.out.println("Heads");
            } else {
                consecutiveHeads = 0;
                System.out.println("Tails");
            }
        }

        System.out.println("It took " + totalCoinFlips + " flips to flip " + n + " heads in a row.");
    }

    public static String coinFlip() {
        return getRandomNumber() > 0.5 ? "Heads" : "Tails";
    }

    public static double getRandomNumber() {
        return Math.random();
    }
}