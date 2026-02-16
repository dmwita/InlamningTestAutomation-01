package InlamningAutomation;

import java.util.Scanner;

public class MorseCodeMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        MorseCodeConverter converter = new MorseCodeConverter();

        System.out.println("Choose option:");
        System.out.println("1 - Text to Morse");
        System.out.println("2 - Morse to Text");

        String choice = scanner.nextLine();

        System.out.println("Enter input:");
        String input = scanner.nextLine();

        if (choice.equals("1")) {

            String result = converter.textToMorse(input);
            System.out.println("Morse: " + result);

        } else if (choice.equals("2")) {

            String result = converter.morseToText(input);
            System.out.println("Text: " + result);

        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
