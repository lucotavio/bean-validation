package br.com.storm.validation.email;

import java.io.Serializable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String>, Serializable {
    @Override
    public void initialize(Email constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        StringBuilder expressaoRegular = new StringBuilder();

        expressaoRegular.append("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.")
                .append("[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]")
                .append("+\\.)+[a-zA-Z]{2,6}$");

        return email.matches(expressaoRegular.toString());
    }
}
