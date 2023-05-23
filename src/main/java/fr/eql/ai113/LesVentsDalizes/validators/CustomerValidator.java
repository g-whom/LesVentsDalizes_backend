package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.Customer;
import fr.eql.ai113.LesVentsDalizes.entity.Member;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;


/**
 * this class manages the validation of the fields of an Customer, Member, CustomerDto, MemberDto object
 *
 * @Author : J.VENT
 */
@Component
public class CustomerValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * This regex represents the allowed characters for the name or the first name
     *
     * @Author : J.VENT
     */
    private static final String NAME_OR_SURNAME_REGEX ="^(?=.*[a-zA-Z])[a-zA-Z\\\\s-]+$";

    /**
     * This regex represents the characters allowed for a phone number in the system
     *
     * @Author J.VENT
     */
    private static final String PHONENUMBER_REGEX ="^(?=.*[a-zA-Z])[\\\\d\\\\s()+*-]+$";

    /**
     * this regex represents the valid date format
     *
     * @Author : J.VENT
     */
    private static final String BIRTHDATE_REGER = "^\\d{4}[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12][0-9]|3[01])$";


    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private EmailValidator emailValidator;
    private PasswordValidator passwordValidator;
    private AddressDtoValidator addressDtoValidator;
    @Override
    public boolean supports(Class<?> clazz) {
       return Member.class.equals(clazz) || Customer.class.equals(clazz) ||   CustomerDto.class.equals(clazz) ;
    }
 ;

    /**
     * <h3>This method allows to know if the object is valid by browsing all the fields <br/>
     * according to the object : </h3>
     * <ul>
     *     <li>Customer</li>
     *     <li>CustomerDto</li>
     *     <li>Member</li>
     *     <li>MemberDto</li>
     * </ul>
     *
     * @param target
     * @param errors
     *
     * @Author : J.VENT
     */
    @Override
    public void validate(Object target, Errors errors) {
        logger.info("On entre dans validate de CustomerValidator");
        logger.info("Voici le type d'object ciblé : "+target.getClass().getSimpleName());

        switch (target.getClass().getSimpleName()){
            case "Customer":
                Customer customer = (Customer) target;
                validateName(customer.getName().trim(),errors);
                validateSurname(customer.getSurname(), errors);
                validatePhoneNumber(customer.getPhoneNumber(), errors);
                emailValidator.validate(customer, errors);
                passwordValidator.validate(customer, errors);

                if (customer.getAddress() == null){
                    errors.reject("typeMismatch", "L'adress est absente ");
                }else {
                    addressDtoValidator.validate(customer, errors);
                }
                break;


            case "Member":

                break;
            case "CustomerDto":
                CustomerDto customerDto = (CustomerDto) target;
                validateName(customerDto.getName(), errors);
                validateSurname(customerDto.getSurname(),errors);
                validatePhoneNumber(customerDto.getPhoneNumber(),errors);
                emailValidator.validate(customerDto, errors);
                passwordValidator.validate(customerDto, errors);
               // validateBirthdateFormate(customerDto.getBirthdate(), errors);

               if (customerDto.getAddress() == null){
                    logger.info("  --- >>>>>>>>>>>>>>>>>  NULL OR WHAT >>>>>>>>>>>>>> --------");
                    errors.reject("typeMismatch", "L'adress est absente ");
                }else {
                    addressDtoValidator.validate(customerDto, errors);
                }



                break;
            default:
                logger.info("Type d'objet non encore reconnu par [CustomerValidator] ");
                logger.info("Le type semble etre : " + target.getClass().getSimpleName());
                errors.reject("typeMismatch", "La valeur récupérée n'est pas reconnue");
        }

    }


    /**
     * <h3>this method verifies name is valid</h3>
     * @param name
     * @param errors
     *
     * @Author J.VENT
     */
    private void validateName(String name, Errors errors){
        logger.info("regex - (validateNAme)");

        if (name == null || name.isEmpty()){
            errors.reject("typeMismatch", "Nom doit etre renseigné");
        } else if (!name.matches(NAME_OR_SURNAME_REGEX)) {
            errors.reject("typeMismatch", "Nom invalide");
        }
    }

    /**
     * <h3>this method verifies surname is valid</h3>
     * @param surname
     * @param errors
     *
     * @Author J.VENT
     */
    private void validateSurname(String surname, Errors errors){
        logger.info("regex - (ValidateSurname) ");

        if (surname == null || surname.isEmpty()){
            errors.reject("typeMismatch", "Le prénom doit etre renseigné");
        } else if (!surname.matches(NAME_OR_SURNAME_REGEX)) {
            errors.reject("typeMismatch", "prénom invalide");
        }
    }


    /**
     * <h3>this method verifies the phone number is valid</h3>
     * @param phoneNumber
     * @param errors
     *
     * @Athor J.VENT
     */
    private void validatePhoneNumber(String phoneNumber , Errors errors){
        logger.info("regex - (ValidatePhoneNumber) ");
        if (phoneNumber == null || phoneNumber.isEmpty()){
            errors.reject("typeMismatch", "Le numéro de téléphone doit etre renseigné");
        } else if (phoneNumber.matches(PHONENUMBER_REGEX)) {
            errors.reject("typeMismatch", "numéro de téléphone  invalide");
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

    @Autowired
    public void setAddressDtoValidator(AddressDtoValidator addressDtoValidator) {
        this.addressDtoValidator = addressDtoValidator;
    }
}
