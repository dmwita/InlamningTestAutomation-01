**For my reference and whoever  wanntts to contribute**

# Morse Code Converter
A Java-based application that translates text to International Morse Code and vice versa. 
This project was developed following Test-Driven Development (TDD) principles.

## Getting Started
**Prerequisites**
- Java Development Kit (JDK) 11 or higher.
- A Java IDE (IntelliJ IDEA, Eclipse) or Maven for running tests.

**Installation**
Clone this repository: git clone https://github.com/dmwita/InlamningTestAutomation.git
## Requirements Met

- **Bidirectional Conversion:** Translates English (A-Z) to Morse and Morse signals to English.
- **Architecture:** Divided into a Logic class, a Main class (UI), and a Test class.
- **TDD Approach:** Developed using JUnit 5.
- **AAA Testing Structure:** All tests follow the Arrange–Act–Assert pattern.
- **Error Handling:** Implements two mechanisms using IllegalArgumentException to catch invalid text characters and unrecognized Morse signals.
- **Standard Compliance:** Uses the International Morse Code standard (A–Z).

---

## Testing Strategy (AAA Pattern)

The test suite is written using JUnit 5 and follows the Arrange-Act-Assert pattern for maximum clarity:

### Arrange
Set up the test objects and input data.

### Act
Call the method under test.

### Assert
Verify that the result matches the expected output.

------

### Example

##```java
// Arrange
String input = "A";

// Act
String result = converter.textToMorse(input);

// Assert
assertEquals(".-", result);

##````

This structure:
- Improves readability
- Makes debugging easier
- Follows industry testing standards
- Supports maintainable automation practices


## Project Structure

The project is organized into the following classes within the `automation.morse` package:

###  MorseCodeConverter.java (Logic Class)

Contains the `HashMap` dictionaries and core translation logic.

- `textToMorse(String input)`
    - Converts English text to Morse.
    - Handles case-insensitivity.
    - Removes spaces according to assignment requirements.
    - Throws `IllegalArgumentException` for unsupported characters.

- `morseToText(String input)`
    - Converts space-separated Morse code into English text.
    - Validates Morse sequences before translation.

---

###  MorseCodeMain.java (Main Class)

- Entry point of the application.
- Uses `Scanner` to read user input.
- Provides a simple menu interface.
- Uses `try-catch` for user-friendly error handling.

---

### 3. MorseCodeTest.java (Test Class)

JUnit 5 test suite that:

- Tests single and multiple character conversions.
- Verifies case-insensitivity.
- Ensures proper exception handling for:
    - Invalid English characters (`!`, `1`, etc.).
    - Invalid Morse sequences.
- Follows the AAA testing structure.

---

## Error Handling

The system includes two defensive layers:

1. **English/input Validation**
    - Detects characters outside A–Z.
    - Throws informative `IllegalArgumentException`.

2. **Code/Morse Validation**
    - Ensures dot/dash sequences exist in the dictionary.
    - Prevents undefined output.

    
---

## Running Tests

In IntelliJ:
- Right-click `MorseCodeTest`
- Select **Run**

---
**Future Improvements**

This project can be extended in several ways:

- Introduce parameterized tests to increase coverage.

- Add support for numbers and punctuation.

- Improve architecture using interfaces and dependency injection.

- Implement logging instead of console output.

- Add CI/CD pipeline integration.

- Measure and improve performance for large inputs.

- Expand validation and edge-case handling.

Project developed as part of a Java / Software Testing assignment.