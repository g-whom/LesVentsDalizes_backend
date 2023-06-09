package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressWithUsernameDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    @Override
    public boolean supports(Class<?> clazz) {
        //return false;
        return Member.class.equals(clazz)
                || Customer.class.equals(clazz)
                || CustomerDto.class.equals(clazz)
                || AddressWithUsernameDto.class.equals(clazz);
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
            case "CustomerDto":
                logger.info("le type  (CustomerDto) bien detecteé ");
                CustomerDto customerDto = (CustomerDto) target;
                validateEmail(customerDto.getUsername(),errors);
                break;
            case "AddressWithUsernameDto":
                logger.info("le type  (AddressWithUsernameDto) bien detecteé ");
                AddressWithUsernameDto addressWithUsernameDto = (AddressWithUsernameDto) target;
                validateEmail(addressWithUsernameDto.getUsername(), errors);
                break;

            default:
                logger.info("Type d'objet non encore reconnu, (WIP: update EmailValidator*)");
                logger.info("Le type semble etre : " + target.getClass().getSimpleName());
                errors.reject("typeMismatch", "La valeur récupérée n'est pas reconnue");
        }

    }


    /**
     * this method check that the email field is valid
     * and that the email is valid
     * @param email :
     * @param errors
     *
     * @version 2
     * @Author J.Vent
     */
    private void validateEmail(String email, Errors errors){
        logger.info("regex - (validateEmail)");

        if (email == null || email.isEmpty()){
            errors.reject("typeMismatch", "Email doit etre renseiné");
        }else if (!email.matches(EMAIL_REGEX)){
            errors.reject("typeMismatch", "Email semble invalide");
        }

    }
}
