package InlamningAutomation;

import java.util.HashMap;

public class MorseCodeConverter {
    //Map: English to Morse
    private HashMap<String, String> letterToMorse = new HashMap<>();

    //Map: Morse to English
    private HashMap<String, String> morseToLetter = new HashMap<>();

    //Create a constructor that runs when an object is created
    public MorseCodeConverter(){
        initialiseMaps();
    }
    //Create a method that initialise/fills our dictionary
    private void initialiseMaps(){

        letterToMorse.put("A", ".-");
        letterToMorse.put("B", "-...");
        letterToMorse.put("C", "-.-.");
        letterToMorse.put("D", "-..");
        letterToMorse.put("E", ".");
        letterToMorse.put("F", "..-.");
        letterToMorse.put("G", "--.");
        letterToMorse.put("H", "....");
        letterToMorse.put("I", "..");
        letterToMorse.put("J", ".---");
        letterToMorse.put("K", "-.-");
        letterToMorse.put("L", ".-..");
        letterToMorse.put("M", "--");
        letterToMorse.put("N", "-.");
        letterToMorse.put("O", "---");
        letterToMorse.put("P", ".--.");
        letterToMorse.put("Q", "--.-");
        letterToMorse.put("R", ".-.");
        letterToMorse.put("S", "...");
        letterToMorse.put("T", "-");
        letterToMorse.put("U", "..-");
        letterToMorse.put("V", "...-");
        letterToMorse.put("W", ".--");
        letterToMorse.put("X", "-..-");
        letterToMorse.put("Y", "-.--");
        letterToMorse.put("Z", "--..");

        // Build reverse map automatically
        for (String key : letterToMorse.keySet()) {
            String value = letterToMorse.get(key);
            morseToLetter.put(value, key);
        }
    }
    // English → Morse
    public String textToMorse(String input) {

        input = input.toUpperCase();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            String letter = String.valueOf(input.charAt(i));

            String morse = letterToMorse.get(letter);

            result.append(morse);

            if (i < input.length() - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    // Morse → English
    public String morseToText(String input) {

        String[] parts = input.split(" ");

        StringBuilder result = new StringBuilder();

        for (String part : parts) {

            String letter = morseToLetter.get(part);

            result.append(letter);
        }

        return result.toString();
    }
}
