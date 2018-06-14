package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserDBModel;


public class RegisterFormData {
    public String name = "";

    public String email = "";

    public String password = "";

    public RegisterFormData() {
    }

    public List<ValidationError> validate() {

        List<ValidationError> errors = new ArrayList<>();

        if (UserDBModel.isUser(email, name))
        {
            errors.add(new ValidationError("email", ""));
            errors.add(new ValidationError("name", ""));
        }
//        if (!UserDBModel.isValid(email, password)) {
//            errors.add(new ValidationError("email", ""));
//            errors.add(new ValidationError("password", ""));
//        }

        return (errors.size() > 0) ? errors : null;
    }

}