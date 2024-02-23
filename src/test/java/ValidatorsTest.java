import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tenniskata.validator.CharacterInputValidator;
import tenniskata.validator.EmptyInputStringValidator;
import tenniskata.validator.InputValidator;

@TestMethodOrder(MethodOrderer.Random.class)
class ValidatorsTest {

    private final String VALID_RESULT = "ABABABABAA";

    @Test
    @DisplayName("Test Input Valid")
    void testInputLengthValid() {
        Assertions.assertDoesNotThrow(() ->
                new InputValidator().execute(VALID_RESULT)
        );
    }

    @Test
    @DisplayName("Test Input Length Validator Invalid")
    void testInputLengthInvalid() {
        Assertions.assertThrows(RuntimeException.class, () ->
                new InputValidator().execute("AAABBBAB")
        );
    }

    @Test
    @DisplayName("Test Empty Input Validator Invalid")
    void testEmptyInputInvalid() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> new InputValidator().execute(""),
                new EmptyInputStringValidator().getException().getMessage()
        );
    }

    @Test
    @DisplayName("Test Null Input Validator Invalid")
    void testNullInputInvalid() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> new InputValidator().execute(null),
                new EmptyInputStringValidator().getException().getMessage()
        );
    }

    @Test
    @DisplayName("Test Character Input Validator Invalid")
    void testCharacterInputInvalid() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> new InputValidator().execute("ABCABABAB"),
                new CharacterInputValidator().getException().getMessage()
        );
    }

}