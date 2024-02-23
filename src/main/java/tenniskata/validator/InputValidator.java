package tenniskata.validator;

public class InputValidator {

    private final IValidator[] validators;

    public InputValidator() {
        this.validators = new IValidator[]{
                new EmptyInputStringValidator(),
                new CharacterInputValidator(),
                new MinimumLengthInputValidator(),
        };
    }

    public void execute(String input) throws Exception {
        for (IValidator validator : validators) {
            if (!validator.validate(input)) {
                throw validator.getException();
            }
        }
    }
}
