package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class CustomerValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());
    EmailValidator emailValidator;

    PasswordValidator passwordValidator;
    @Override
    public boolean supports(Class<?> clazz) {
       return Member.class.equals(clazz) || Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("On entre dans validate de CustomerValidator");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required",
                "Le nom doit etre renseigné");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required"
        ,"Le prénom doit etre renseigné");


        Customer customer = (Customer) target;
        if (!StringUtils.hasText(customer.getEmail())) {
            errors.rejectValue("email", "field.required", "L'email doit être renseigné");

            //if (!org.apache.commons.validator.EmailValidator.getInstance().isValid(email))
        //} else if (!EmailValidator.getInstance().isValid(client.getEmail())) {
        } else {
            //logger.info("On va controler l'email de maniere approfoncie");
            emailValidator.validate(customer, errors);
//            {errors.rejectValue("email", "field.invalid"); }
        }

        if (!StringUtils.hasText(customer.getEmail())){
            errors.rejectValue("password", "Le mot de passe doit être renseigné");

        }else{
            passwordValidator.validate(customer, errors);
        }
    }


    /// SETTER ///

    @Autowired
    public void setEmailValidator(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @Autowired
    public void setPasswordValidator(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }
}
