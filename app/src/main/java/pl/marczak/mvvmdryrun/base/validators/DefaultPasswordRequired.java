package pl.marczak.mvvmdryrun.base.validators;

import android.view.View;
import android.widget.EditText;

public class DefaultPasswordRequired extends TextValidatorBase {

   private static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    public DefaultPasswordRequired(View view, String validationMessage) {
        super(view, validationMessage);
    }

    @Override
    protected boolean isValid(EditText editText) {
        return passwordIsValid(editText.getText().toString().trim());
    }

    private boolean passwordIsValid(String passwd) {
        return passwd.matches(pattern);
    }
}
