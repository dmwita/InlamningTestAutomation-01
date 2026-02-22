package automation.morse;

import java.util.Scanner;

/**
 * Entry point of the application.
 * Handles user interaction and delegates translation to MorseCodeConverter.
 */
public class MorseCodeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MorseCodeConverter converter = new MorseCodeConverter();

        // Display menu
        System.out.println("--- Morse Code Translator ---");
        System.out.println("1: English to Morse");
        System.out.println("2: Morse to English");

        String choice = scanner.nextLine();

        System.out.println("Enter your input:");
        String input = scanner.nextLine();

        try {
            // Call appropriate method based on user choice
            if (choice.equals("1")) {
                System.out.println("Result: " + converter.textToMorse(input));
            } else if (choice.equals("2")) {
                System.out.println("Result: " + converter.morseToText(input));
            } else {
                System.out.println("Error: Please choose 1 or 2.");
            }

        } catch (IllegalArgumentException e) {
            // Display validation errors from logic class
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}