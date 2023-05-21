package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.PasswordDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class PasswordValidator implements Validator {
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  WIP:
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        //return false;
        return Member.class.equals(clazz)
                || Customer.class.equals(clazz)
                || CustomerDto.class.equals(clazz)
                || PasswordDto.class.equals(clazz);
    }

    /**
     * This methode is used {@link #validatePassword(String password, Errors errors)} to detect
     * if the password is valid
     *
     * @param target
     * @param errors
     * @
     */
    @Override
    public void validate(Object target, Errors errors) {
        switch(target.getClass().getSimpleName()){
            case "Member":
                Member member = (Member) target;
                validatePassword(member.getPassword().trim(),errors);
                break;
            case "Customer":
                Customer customer = (Customer) target;
                validatePassword(customer.getPassword().trim(),errors);
                break;
            case "CustomerDto":
                CustomerDto customerDto = (CustomerDto) target;
                validatePassword(customerDto.getPassword(), errors);
                isIdenticalPassword(customerDto.getPassword(), customerDto.getConfirmPassword(), errors);
                break;
            case "PasswordDto":
                PasswordDto passwordDto = (PasswordDto) target;
                validatePassword(passwordDto.getPasswordNew(),errors);
                validatePassword(passwordDto.getPasswordNewBis(),errors);
                // validatePassword(passwordDto.getPassword().trim(),errors);
                isIdenticalPassword(passwordDto.getPasswordNew(), passwordDto.getPasswordNewBis(), errors);
                break;
            default:
                logger.info("Type d'objet non encore reconnu, (WIP: update EmailValidator)");
                logger.info("Le type semble etre : " + target.getClass().getSimpleName());
                errors.reject("typeMismatch", "La valeur récupérée n'est pas reconnue");
        }

    }

    /**
     * this method will determine if at least one of the password criteria is not respected:
     *
     * <ul>
     * <li>At least 8 characters</li>
     * <li>At least 1 capital letter</li>
     * <li>At least 1 lower case</li>
     * <li>At least one number</li>
     * <li>At least 1 special character</li>
     * <li>At least 1 accented character</li>
     * </ul>
     * 
     * @param password : 
     * @param errors : 
     * @return void              
     */
    private void validatePassword(String password, Errors errors){
        //----------------------
        if (password.length() < 8) {
            errors.rejectValue("password", "password.length",
                    "Le mot de passe doit comporter au moins 8 caractères");
        }

        if (!password.matches(".*[A-Z].*")) {
            errors.rejectValue("password", "password.uppercase",
                    "Le mot de passe doit comporter au moins une lettre majuscule");
        }

        if (!password.matches(".*[a-z].*")) {
            errors.rejectValue("password", "password.lowercase",
                    "Le mot de passe doit comporter au moins une lettre minuscule");
        }

        if (!password.matches(".*\\d.*")) {
            errors.rejectValue("password", "password.digit",
                    "Le mot de passe doit comporter au moins un chiffre");
        }

        if (!password.matches(".*[àâäéèêëîïôöùûü].*")) {
            errors.rejectValue("password", "password.accent",
                    "Le mot de passe doit comporter au moins un caractère accentué");
        }

        if (!password.matches(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
            errors.rejectValue("password", "password.special",
                    "Le mot de passe doit comporter au moins un caractère spécial");
        }

    }


    /**
     * This method checks if the two passwords are identical
     * @param passwordOne
     * @param passwordTwo
     * @param errors
     *
     * @Author: J.VENT
     */
    private void isIdenticalPassword(String passwordOne, String passwordTwo, Errors errors){


        if (!passwordOne.equals(passwordTwo) ) {
            logger.info("LEs deux mots de passe ne sont pas identique !!!");
            errors.reject("typeMismatch", "Une anomalie détectée pour les identifiants ");

        };



    }
}
