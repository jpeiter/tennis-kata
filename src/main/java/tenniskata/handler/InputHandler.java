package tenniskata.handler;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputHandler {

    public String handle(String input) throws IOException {
        File file = Path.of(input).toFile();
        if (file.exists() && file.isFile()) {
            return handleFileInput(input);
        }
        return input;
    }

    private String handleFileInput(String input) throws IOException {
        Path path = Paths.get(input);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return allLines.get(0);
    }


}
