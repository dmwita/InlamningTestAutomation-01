package InlamningAutomation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseCodeTest {

    @Test
    void convertsSingleLetterToMorse() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();
        String input = "A";

        // Act
        String result = converter.textToMorse(input);

        // Assert
        assertEquals(".-", result);
    }

    @Test
    void convertsMultipleLettersToMorse() {

        // Arrange
        MorseCodeConverter  converter = new MorseCodeConverter();
        String input = "HELLO";

        // Act
        String result = converter.textToMorse(input);

        // Assert
        assertEquals(".... . .-.. .-.. ---", result);
    }

    @Test
    void convertsSingleMorseToText() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();
        String input = ".-";

        // Act
        String result = converter.morseToText(input);

        // Assert
        assertEquals("A", result);
    }

    @Test
    void convertsMultipleMorseToText() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();
        String input = ".... . .-.. .-.. ---";

        // Act
        String result = converter.morseToText(input);

        // Assert
        assertEquals("HELLO", result);
    }

    @Test
    void handlesLowercaseInput() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();
        String input = "hello";

        // Act
        String result = converter.textToMorse(input);

        // Assert
        assertEquals(".... . .-.. .-.. ---", result);
    }

    @Test
    void throwsExceptionForInvalidTextCharacter() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> converter.textToMorse("HELLO1"));
    }

    @Test
    void throwsExceptionForInvalidMorseCode() {

        // Arrange
        MorseCodeConverter converter = new MorseCodeConverter();

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> converter.morseToText(".... . .-.. .-.. --- ..--"));
    }
}

