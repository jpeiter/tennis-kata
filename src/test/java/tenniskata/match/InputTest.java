package tenniskata.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tenniskata.handler.InputHandler;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.Random.class)
class InputTest {

    @Test
    @DisplayName("Test File input")
    void testFileInput() throws IOException {
        String input = new InputHandler().handle("src/test/resources/input.txt");
        Assertions.assertEquals("AAABBBAA", input);
    }

    @Test
    @DisplayName("Test CMD input")
    void testCmdInput() throws IOException {
        String input = new InputHandler().handle("ABABABABABABABABABABAA");
        Assertions.assertEquals("ABABABABABABABABABABAA", input);
    }

}