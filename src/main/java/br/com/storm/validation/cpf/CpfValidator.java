package br.com.storm.validation.cpf;

import java.io.Serializable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CPF, String>, Serializable{
    @Override
    public void initialize(CPF constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {

        cpf = cpf.replace(".", "").replace("-", "");
        if(cpf.length() != 11){
            return false;
        }

        if(cpf.equals("00000000000")) {
            return false;
        }

        int multiplicador = 10;
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            char numeroChar = cpf.charAt(i);
            int numero = Character.getNumericValue(numeroChar);
            soma += (numero * multiplicador);
            multiplicador --;
        }

        int resto = (soma * 10) % 11;

        int digitoVerificador1 = Character.getNumericValue( cpf.charAt(9));

        if(resto == 10){
            if(digitoVerificador1 != 0){
                return false;
            }
        }else{
            if(digitoVerificador1 != resto) {
                return false;
            }
        }

        multiplicador = 11;
        soma = 0;
        for (int i = 0; i < 10; i++) {
            char numeroChar = cpf.charAt(i);
            int numero = Character.getNumericValue(numeroChar);
            soma += (numero * multiplicador);
            multiplicador --;
        }
        resto = (soma * 10) % 11;
        int digitoVerificador2 = Character.getNumericValue( cpf.charAt(10));

        if(resto == 10){
            if(digitoVerificador2 != 0){
                return false;
            }
        }else{
            if(digitoVerificador2 != resto) {
                return false;
            }
        }

        return true;
    }

}
