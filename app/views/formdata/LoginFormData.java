package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserDBModel;


public class LoginFormData {

    public String email = "";

    public String password = "";

    public LoginFormData() {
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<>();

        if (!UserDBModel.isValid(email, password)) {
            errors.add(new ValidationError("email", ""));
            errors.add(new ValidationError("password", ""));
        }

        return (errors.size() > 0) ? errors : null;
    }

}