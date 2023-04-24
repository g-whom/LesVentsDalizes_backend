package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean supports(Class<?> clazz) {
        //return false;
        return Member.class.equals(clazz) || Customer.class.equals(clazz) ;
    }

    /**
     * This methode is call {@link #validateEmail(String email, Errors errors)} to detect if the email is valid
     * @param target
     * @param errors
     */
    @Override
    public void validate(Object target, Errors errors) {

        switch(target.getClass().getSimpleName()){
            case "Member":
                Member member = (Member) target;
                validateEmail(member.getUsername(),errors);
                break;
            case "Customer":
                Customer customer = (Customer) target;
                validateEmail(customer.getUsername(),errors);
                break;
            default:  logger.info("Type d'objet non encore reconnu, (WIP: update EmailValidator)");
        }

    }


    /**
     * this method ceck that the email field is not empty
     * and that the email is valid
     * @param email :
     * @param errors
     */
    private void validateEmail(String email, Errors errors){
        try{
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required", "Le champ 'Email' doit être renseigné");

            if (!org.apache.commons.validator.EmailValidator.getInstance().isValid(email)) {
                logger.info("alors la mail ne dois pas etre valide hein !!");
                errors.rejectValue("email", "invalid.email", "L'adresse email n'est pas valide");
            }
        }catch(Exception e){
            logger.info("voici l'exception attrapée "+e.getMessage());
        }
    }
}
