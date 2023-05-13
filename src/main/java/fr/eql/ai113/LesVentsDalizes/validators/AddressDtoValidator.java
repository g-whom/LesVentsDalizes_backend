package fr.eql.ai113.LesVentsDalizes.validators;

import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressDto;
import fr.eql.ai113.LesVentsDalizes.entity.dto.AddressWithUsernameDto;
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
 */
@Component
public class AddressDtoValidator implements Validator {

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final String NUMBER_ID_REGEX = "^(1[0-9]*|[2-9][0-9]*|null)$";

    /*
            AddressDto
        private Long id;
        private String numberRoad;
        private String road;
        private String zipCode;
        private String city;
        private String country;
        private List<Customer> customerList = new ArrayList<>();
     */

    @Override
    public boolean supports(Class<?> clazz) {
        return AddressDto.class.equals(clazz) || AddressWithUsernameDto.class.equals(clazz);
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

            default:
                logger.info("Type d'objet non encore reconnu comme Adresse");
                errors.reject("typeMismatch", "La valeur récupérée n'est pas reconnue");
                break;


        }

/*

        if (target.getClass().getSimpleName() == "AddressWithUsernameDto"){
            addressDto = ((AddressWithUsernameDto) target).getAddressDto();
        }else {
            addressDto= (AddressDto) target;
        }
*/



    }


    /**
     * <p>This method checks if all the fields of the address are filled in<br/>
     *      *The 'id' field can be null otherwise its value must be an Long greater than zero</p>
     * @param addressDto
     * @param errors
     */
    private void validateAddressDto(AddressDto addressDto, Errors errors){
        Long numberId = addressDto.getId();

        //This field is optional
        if (numberId != null){
            if (numberId.toString().trim().isEmpty()) {
                errors.rejectValue("id", "field.required", "L'id de l'adresse est manquant");
            } else if (!Pattern.matches(NUMBER_ID_REGEX, numberId.toString())) {
                errors.rejectValue("id", "id.invalid", "L'id de l'adresse est invalide");
            }
        }

        if (addressDto.getNumberRoad()==null || addressDto.getNumberRoad().trim().isEmpty()) {
            errors.rejectValue("numberRoad", "field.required", "Le numero de voie doit etre renseigné");
        }

        if (addressDto.getRoad() ==null ||  addressDto.getRoad().trim().isEmpty()) {
            errors.rejectValue("road", "field.required", "Le nom de voie doit etre renseigné");
        }

        if (addressDto.getZipCode() ==null ||  addressDto.getZipCode().isEmpty()) {
            errors.rejectValue("zipCode", "field.required", "Le code postal doit etre renseigné");
        }

        if (addressDto.getCity()==null || addressDto.getCity().trim().isEmpty()) {
            errors.rejectValue("city", "field.required", "La ville doit etre renseignée");
        }

        if (addressDto.getCountry()==null ||  addressDto.getCountry().trim().isEmpty()) {
            errors.rejectValue("country", "field.required", "Le pays doit etre renseigné");
        }
    }
}
