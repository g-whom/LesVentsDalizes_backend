package fr.eql.ai113.LesVentsDalizes.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import fr.eql.ai113.LesVentsDalizes.exceptions.InvalidDateFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * Tthis class is a custom deserilizer for the date field
 *
 * @Author: J.VENT
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     *Expected date format yyyy-DD-MM
     *
     * Author: J.vENT
     * [*/
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * regex to check characters entered as well as the validity of the date if
     *
     * @Author: J.VENT
     */
    private static final String DATE_REGEX = "\\d{4}-\\d{2}-\\d{2}";

    /**
     *
     Intervale de 100
     Author : JVENT
     */
    private static final int MAX_DAYS_IN_PAST = 100;

    /**
     *
     * <h3><This deserialization method will allow to test the "birthday" field and detect if its<br/>
     * content or format is not valid</h3>
     * @param jsonParser
     * @param deserializationContext
     * @return
     * @throws IOException
     */
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

       String dateString = jsonParser.getValueAsString();// jsonParser.getText():


        if (!dateString.matches(DATE_REGEX)){
            throw new JsonParseException(jsonParser, "Format de date invalide");
        }

        try {

            LocalDate date = LocalDate.parse(dateString, DATE_FORMATTER);
            LocalDate today = LocalDate.now();
            LocalDate minDate = today.minusYears(MAX_DAYS_IN_PAST);

            if (date.isBefore(minDate) || date.isAfter(today)) {
                throw new JsonParseException(jsonParser, "Date en dehors de l'intervalle autorisé");
            }

            return date;

        }catch(DateTimeParseException e){
            logger.info("\"Format de date invalide. yo yo  Utilisez le format 'yyyy-MM-dd'.");
            //throw new JsonParseException(jsonParser,"Format de date  wesh invalide", e);
            throw new InvalidDateFormatException("");
        }
        // return null;
    }
}
