package tenniskata.validator;

public class MinimumLengthInputValidator implements IValidator {

    @Override
    public boolean validate(String input) {
        long aCount = input.chars().filter(c -> c == 'A').count();
        long bCount = input.chars().filter(c -> c == 'B').count();
        return aCount >= 4 && aCount - bCount >= 2 ||
                bCount >= 4 && bCount - aCount >= 2;
    }

    @Override
    public Exception getException() {
        return new RuntimeException("The input won't result in endgame!");
    }
}
