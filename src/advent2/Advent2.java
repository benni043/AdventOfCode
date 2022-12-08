package advent2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Advent2 {

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSOR = 3;

    private static final int WON = 6;
    private static final int DRAW = 3;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ressources/advent2.txt"));

        int sum1 = 0;
        int sum2 = 0;

        while (scanner.hasNextLine()) {
            String[] chars = scanner.nextLine().split(" ");
            sum1 += round(chars[0].charAt(0), chars[1].charAt(0));
            sum2 += chooseRound(chars[0].charAt(0), chars[1].charAt(0));
        }

        System.out.println(sum1);
        System.out.println(sum2);
    }

    // A -> Rock
    // B -> Paper
    // C -> Scissor
    // X -> Rock    / Lose
    // Y -> Paper   / Draw
    // Z -> Scissor / Win

    public static int chooseRound(char elfInput, char myInput) {
        switch (elfInput) {
            case 'A' -> {
                switch (myInput) {
                    case 'X' -> {
                        return SCISSOR;
                    }
                    case 'Y' -> {
                        return ROCK + DRAW;
                    }
                    case 'Z' -> {
                        return PAPER + WON;
                    }
                }
            }
            case 'B' -> {
                switch (myInput) {
                    case 'X' -> {
                        return ROCK;
                    }
                    case 'Y' -> {
                        return PAPER + DRAW;
                    }
                    case 'Z' -> {
                        return SCISSOR + WON;
                    }
                }
            }
            case 'C' -> {
                switch (myInput) {
                    case 'X' -> {
                        return PAPER;
                    }
                    case 'Y' -> {
                        return SCISSOR + DRAW;
                    }
                    case 'Z' -> {
                        return ROCK + WON;
                    }
                }
            }
        }
        return -1;
    }

    public static int round(char elfInput, char myInput) {
        switch (elfInput) {
            case 'A' -> {
                switch (myInput) {
                    case 'X' -> {
                        return ROCK + DRAW;
                    }
                    case 'Y' -> {
                        return PAPER + WON;
                    }
                    case 'Z' -> {
                        return SCISSOR;
                    }
                }
            }
            case 'B' -> {
                switch (myInput) {
                    case 'X' -> {
                        return ROCK;
                    }
                    case 'Y' -> {
                        return PAPER + DRAW;
                    }
                    case 'Z' -> {
                        return SCISSOR + WON;
                    }
                }
            }
            case 'C' -> {
                switch (myInput) {
                    case 'X' -> {
                        return ROCK + WON;
                    }
                    case 'Y' -> {
                        return PAPER;
                    }
                    case 'Z' -> {
                        return SCISSOR + DRAW;
                    }
                }
            }
        }
        return -1;
    }

}
