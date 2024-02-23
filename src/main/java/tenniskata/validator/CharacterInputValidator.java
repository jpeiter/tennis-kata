package tenniskata.validator;

public class CharacterInputValidator implements IValidator {

    @Override
    public boolean validate(String input) {
        return input.toUpperCase().matches("^[AB]+$");
    }

    @Override
    public Exception getException() {
        return new RuntimeException("The input contain invalid characters! Please only use 'A' or 'B'");
    }
}
