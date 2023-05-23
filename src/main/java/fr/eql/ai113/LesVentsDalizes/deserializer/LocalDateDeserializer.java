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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

        dateString= convertPotentialLocalDateToString(dateString);
        dateString = convertPotentialLocalDateTimeToString(dateString);
        dateString = normaliseLocalDateTimeWithHeightDigit(dateString);

        if (!dateString.matches(DATE_REGEX)){
            throw new JsonParseException(jsonParser, "--Format de date invalide");
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


    /**
     * <h3>this method converts the variable taken in parameter into String if it is of type localDate</h3>
     * @param variable
     * @return
     *
     * @Author J.VENT
     */
    private String convertPotentialLocalDateToString(Object variable){
        if (variable instanceof LocalDate){
            logger.info("On a bien detecteé un type LocalDate");
            LocalDate localDate = (LocalDate) variable;

            logger.info("le type en sortie sera : "+variable.toString());
            return variable.toString();
        }
        logger.info("c'est d'office le bon type MAsh halla : "+variable);
        return (String) variable;

    }


    /**
     * <h3>This method converts a potential LocalDateTime to a string</h3>
     * @param variable
     * @return
     *
     * @Author J.VENT
     */
    private String convertPotentialLocalDateTimeToString(Object variable){
        String dateFormatted="";
        if (variable instanceof LocalDateTime){
            logger.info("On a bien detecteé un type LocalDate");
            LocalDateTime localDateTime = (LocalDateTime) variable;

            logger.info("le type en sortie sera : "+variable.toString());

             dateFormatted = normaliseLocalDateTimeWithHeightDigit(variable.toString());
            return dateFormatted;
        }
        logger.info("c'est d'office le bon type MAsh halla (v2) : "+variable);

        dateFormatted = normaliseLocalDateTimeWithHeightDigit( (String) variable);
        return dateFormatted;
    }


    /**
     * <h3>This method normalizes a string (LocalDateTime) and LocalDate</h3>
     * <P>the time offset is taken into account</P>
     * @param inputDateTime
     * @return
     *
     * @Version 2
     * @Author J.VENT
     */
    private String normaliseLocalDateTimeWithHeightDigit(String inputDateTime){



        if(inputDateTime.length()>10){
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(inputDateTime, DateTimeFormatter.ISO_DATE_TIME);
            ZonedDateTime convertedDateTime = zonedDateTime.withZoneSameInstant(ZonedDateTime.now().getZone());
            LocalDate localDate = convertedDateTime.toLocalDate();

            return localDate.toString();
        }


        return inputDateTime;
    }
}
