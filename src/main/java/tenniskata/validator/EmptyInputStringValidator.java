package tenniskata.validator;

public class EmptyInputStringValidator implements IValidator {

    @Override
    public boolean validate(String input) {
        return input != null && !input.isEmpty();
    }

    @Override
    public Exception getException() {
        return new RuntimeException("The input cannot be empty!");
    }
}
