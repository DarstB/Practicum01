import java.util.Scanner;
import java.util.regex.*;

public class SafeInput {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        String prompt;
        int low, high;
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t

        do {
            System.out.print(prompt); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt;
        String trash;

        do {
            System.out.print(prompt);

            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Try again!\n");
                System.out.print(prompt);
                trash = pipe.nextLine();
            }

            retInt = pipe.nextInt();
            pipe.nextLine();
        } while (String.valueOf(retInt).length() == 0);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble;
        String trash;

        do {
            System.out.print(prompt);

            while (!pipe.hasNextDouble()) {
                System.out.println("Invalid input. Try again!\n");
                System.out.print(prompt);
                trash = pipe.nextLine();
            }

            retDouble = pipe.nextDouble();
            pipe.nextLine();
        } while (String.valueOf(retDouble).length() == 0);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retRangedInt;
        String trash;

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");

            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Try again!\n");
                System.out.print(prompt + "[" + low + " - " + high + "]: ");
                trash = pipe.nextLine();
            }

            retRangedInt = pipe.nextInt();
            pipe.nextLine();

            if (retRangedInt < low || retRangedInt > high) {
                System.out.println("Input must be between " + low + " and " + high + ". Try again!\n");
            }

        } while (retRangedInt < low || retRangedInt > high);

        return retRangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retRangedDouble;
        String trash;

        do {
            System.out.print(prompt + "[" + low + " - " + high + "]: ");

            while (!pipe.hasNextDouble()) {
                System.out.println("Invalid input. Try again!\n");
                System.out.print(prompt + "[" + low + " - " + high + "]: ");
                trash = pipe.nextLine();
            }

            retRangedDouble = pipe.nextDouble();
            pipe.nextLine();

            if (retRangedDouble < low || retRangedDouble > high) {
                System.out.println("Input must be between " + low + " and " + high + ". Try again!\n");
            }

        } while (retRangedDouble < low || retRangedDouble > high);

        return retRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retYNConfirm;
        String answer;

        do {
            System.out.print(prompt);
            answer = pipe.nextLine();
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));

        if (answer.equalsIgnoreCase("Y")) {
            retYNConfirm = true;
        }
        else {
            retYNConfirm = false;
        }

        return retYNConfirm;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retRegEx, trash;
        Pattern pattern = Pattern.compile(regEx);

        do {
            System.out.print(prompt);
            retRegEx = pipe.nextLine();
        } while (!pattern.matcher(retRegEx).matches());

        return retRegEx;
    }

    public static void prettyHeader(String msg) {
        int remainingSpace = 60 - 6 - msg.length();

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");
        int spacesOnLeft = remainingSpace / 2;
        int spacesOnRight = remainingSpace - spacesOnLeft;
        for (int i = 0; i < spacesOnLeft; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < spacesOnRight; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
    }
}
