package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressWithUsernameDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * this class manages the validation of the AddressUsernameDto object which includes the
 * client's address and his "username" which is his authentication email
 */
@Component
public class AddressWithUsernameDtoValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());

    private AddressDtoValidator addressDtoValidator;
    private EmailValidator emailValidator;
    @Override
    public boolean supports(Class<?> clazz) {
        return  AddressWithUsernameDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.info("on est bien dans [AddressWithUsernameDtoValidator >> validate] ");

        AddressWithUsernameDto addressWithUsernameDto = (AddressWithUsernameDto) target;
        if(addressWithUsernameDto.getAddressDto() == null ){
            errors.reject("typeMismatch", "L'adresse semble être absente ");
        }else{
            addressDtoValidator.validate(addressWithUsernameDto, errors);
        }

        if(addressWithUsernameDto.getUsername()==null || addressWithUsernameDto.getUsername().trim().isEmpty()){
            errors.rejectValue(
                    "username",
                    "field.requirer",
                    "L'identifiant de connextion est absent");
        }else{
            logger.info(" on va aller dans emailValidator normalement ");
            emailValidator.validate(addressWithUsernameDto, errors);
        }

        ;
            /*
      if (addressDto.getRoad() ==null ||  addressDto.getRoad().trim().isEmpty()) {
            errors.rejectValue("road", "field.required", "Le nom de voie doit etre renseigné");
        }
             */

    }

    /// SETTER ///

    @Autowired
    public void setAddressDtoValidator(AddressDtoValidator addressDtoValidator) {
        this.addressDtoValidator = addressDtoValidator;
    }

    @Autowired
    public void setEmailValidator(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }
}
