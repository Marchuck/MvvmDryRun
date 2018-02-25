package pl.marczak.mvvmdryrun.base;


import java.io.InvalidClassException;
import java.util.ArrayList;

public class ValidationContext {
    private ArrayList<Validator> _validators = new ArrayList<>();

    public void addValidator(Validator validator) {
        _validators.add(validator);
    }

    public ArrayList<Validator> getValidators() {
        return _validators;
    }

    public boolean validate() {
        boolean hasValidationErrors = false;
        for (Validator validator : _validators) {
            try {
                boolean validationResult = validator.validate();
                if (!validationResult) {
                    hasValidationErrors = true;
                }
            } catch (InvalidClassException ex) {
                return false;
            }
        }

        return !hasValidationErrors;
    }
}
