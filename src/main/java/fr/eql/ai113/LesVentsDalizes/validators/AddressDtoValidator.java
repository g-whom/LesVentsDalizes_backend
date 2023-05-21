package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressWithUsernameDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * this class manages the validation of the fields of an addressDto object
 *
 * @Author : J.VENT
 */
@Component
public class AddressDtoValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * This regex represents the allowed characters for numberRoad
     *
     *@Aauthor J.VENT
     */
    private static final String NUMBER_ID_REGEX = "^(1[0-9]*|[2-9][0-9]*|null)$";

    /**
     * <p>This regex represents the characters allowed in the address.
     * It accepts upper and lower case letters, numbers, spaces, as well as the following
     * special characters </p>: <br/> , . - _ ' / \ + # [ ] { } & $ € £.
     *
     * @Aauthor J.VENT
     */
    private static final String VALIDE_CHARACTER_FOR_ADDRESS_REGEX ="^[a-zA-Z0-9\\\\s,.\\\\-_'/\\\\+#\\\\[\\\\]{}&$€£]+$";



    @Override
    public boolean supports(Class<?> clazz) {
        return AddressDto.class.equals(clazz)
                || AddressWithUsernameDto.class.equals(clazz)
                || CustomerDto.class.equals((clazz));
    }
    /**
     * This method checks the type of the valid object in order to control the fields of type AddressDto.
     */
    @Override
    public void validate(Object target, Errors errors) {
        logger.info("on entre bien dans >> validate [AddressDtoValidator]");
        AddressDto addressDto;

        switch (target.getClass().getSimpleName()){
            case "AddressDto":
                addressDto = (AddressDto) target;
                validateAddressDto(addressDto, errors);
                break;
            case "AddressWithUsernameDto":
                logger.info("le types est bien reconnue a savvoir : AddressWithUsernameDto");
                AddressWithUsernameDto addressWithUsernameDto =  (AddressWithUsernameDto) target;
                addressDto = addressWithUsernameDto.getAddressDto();
                logger.info("Affichons le contenu de l'addresse : "+addressDto.toString());
                validateAddressDto(addressDto, errors);
                break;
            case "CustomerDto":
                CustomerDto customerDto = (CustomerDto) target;
                validateAddressDto(customerDto.getAddress().convertAddressToAdressDto(), errors);
                break;

            default:
                logger.info("Type d'objet non encore reconnu comme Adresse (WIP : AdresseDtoValidator)");
                logger.info("Le type semble etre : " + target.getClass().getSimpleName());
                errors.reject("typeMismatch", "La valeur récupérée n'est pas reconnue");
                break;
        }
    }


    /**
     * <p>This method checks if all the fields of the address are filled in<br/>
     *      *The 'id' field can be null otherwise its value must be an Long greater than zero</p>
     * @param addressDto
     * @param errors
     *
     * @Autor : J.VENT
     */
    private void validateAddressDto(AddressDto addressDto, Errors errors){


        Long numberId = addressDto.getId();

        //This field is optional
        if (numberId != null){
            if (numberId.toString().trim().isEmpty()) {
                errors.rejectValue("id", "field.required", "L'id de l'adresse est manquant");
            } else if (!Pattern.matches(NUMBER_ID_REGEX, numberId.toString())) {
                errors.rejectValue("id", "id.invalid", "L'id de l'adresse semble invalide");
            }
        }

        if (addressDto.getNumberRoad()==null || addressDto.getNumberRoad().trim().isEmpty()) {
            errors.reject("typeMismatch", "Le numéro de voie doie etre renseigné");
        }else if (!addressDto.getNumberRoad().matches(VALIDE_CHARACTER_FOR_ADDRESS_REGEX) ){
            errors.reject("typeMismatch", "Le numéro de voie semble invalide");
        }

        if (addressDto.getRoad() ==null ||  addressDto.getRoad().trim().isEmpty()) {
            errors.reject("typeMismatch", "La voie doie etre renseignée");
        }else if (!addressDto.getNumberRoad().matches(VALIDE_CHARACTER_FOR_ADDRESS_REGEX) ){
            errors.reject("typeMismatch", "La voies emble invalide");
        }

        if (addressDto.getZipCode() ==null ||  addressDto.getZipCode().isEmpty()) {
            errors.reject("typeMismatch", "Le code postal doie etre renseigné");
        }else if (!addressDto.getNumberRoad().matches(VALIDE_CHARACTER_FOR_ADDRESS_REGEX) ){
            errors.reject("typeMismatch", "Le code postal semble invalide");
        }

        if (addressDto.getCity()==null || addressDto.getCity().trim().isEmpty()) {
            errors.reject("typeMismatch", "La ville voie doie etre renseignée");
        }else if (!addressDto.getNumberRoad().matches(VALIDE_CHARACTER_FOR_ADDRESS_REGEX) ){
            errors.reject("typeMismatch", "La ville semble invalide");
        }

        if (addressDto.getCountry()==null ||  addressDto.getCountry().trim().isEmpty()) {
            errors.reject("typeMismatch", "Le pays doie etre renseigné");
        }else if (!addressDto.getNumberRoad().matches(VALIDE_CHARACTER_FOR_ADDRESS_REGEX) ){
            errors.reject("typeMismatch", "Le pays semble invalide");
        }
    }
}
