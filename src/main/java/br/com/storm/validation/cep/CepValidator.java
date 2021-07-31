package br.com.storm.validation.cep;

import java.io.Serializable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CepValidator implements ConstraintValidator<CEP, String>, Serializable{

    @Override
    public void initialize(CEP constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext cvc) {      
        return cep.matches("[0-9]{5}-[0-9]{3}");
    }

}
