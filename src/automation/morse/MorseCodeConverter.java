package automation.morse;

import java.util.HashMap;

/**
 Contains the core translation logic between
 English text and International Morse Code.
 */
public class MorseCodeConverter {

    // Lookup maps for fast translation in both directions
    //Declare private to prevent external modification
    //Final to ensure dictionary reference remains imutable after initialization
    private final HashMap<String, String> letterToMorse = new HashMap<>();
    private final HashMap<String, String> morseToLetter = new HashMap<>();

    // Constructor initializes Morse dictionary
    public MorseCodeConverter() {
        initialiseMaps();
    }

    // Populates A–Z mappings
    private void initialiseMaps() {
        String[][] alphabet = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"}, {"Z", "--.."}
        };

        for (String[] pair : alphabet) {
            letterToMorse.put(pair[0], pair[1]);
            morseToLetter.put(pair[1], pair[0]);
        }
    }

    // Converts English text to Morse signals
    public String textToMorse(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
    // Requirements: Handle multiple letters, ignore word separation
        input = input.toUpperCase().replace(" ", "");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));

            // Validate character
            if (!letterToMorse.containsKey(letter)) {
                throw new IllegalArgumentException("Invalid character: " + letter);
            }

            result.append(letterToMorse.get(letter));
            if (i < input.length() - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    //  Converts Morse code to English text.
    public String morseToText(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        // Split input by space to process individual Morse signals
        String[] parts = input.trim().split(" ");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            //Error: Check for un recognized Morse sequence
            if (!morseToLetter.containsKey(part)) {
                throw new IllegalArgumentException("Invalid Morse code: " + part);
            }
            result.append(morseToLetter.get(part));
        }
        return result.toString();
    }
}