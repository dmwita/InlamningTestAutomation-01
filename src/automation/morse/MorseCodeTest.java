package automation.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseCodeTest {

    private MorseCodeConverter converter;

    @BeforeEach
    void setUp() {
        // Arrange - Instantiate converter before each test
        converter = new MorseCodeConverter();
    }

    @Test
    void testSingleLetterToMorse() {
        // Arrange
        String input = "A";
        // Act
        String result = converter.textToMorse(input);
        // Assert
        assertEquals(".-", result);
    }

    @Test
    void testMultipleLettersToMorse() {
        // Arrange
        String input = "HEJ";
        // Act
        String result = converter.textToMorse(input);
        // Assert
        assertEquals(".... . .---", result);
    }

    @Test
    void testMorseToText() {
        // Arrange
        String input = ".... . .-.. .-.. ---";
        // Act
        String result = converter.morseToText(input);
        // Assert
        assertEquals("HELLO", result);
    }

    @Test
    void testInvalidCharacterErrorHandling() {
        // Arrange
        String input = "HELLO!";
        // Act & Assert combined for Exception handling
        assertThrows(IllegalArgumentException.class, () -> converter.textToMorse(input));
    }

    @Test
    void testInvalidMorseErrorHandling() {
        // Arrange
        String input = "........";
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> converter.morseToText(input));
    }
}
