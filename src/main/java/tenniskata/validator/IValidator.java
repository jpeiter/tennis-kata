package tenniskata.validator;

public interface IValidator {

    boolean validate(String input);

    Exception getException();

}
