package fr.eql.ai113.LesVentsDalizes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Identifiant déjà pris !")
public class AccountExistsException extends Exception{
}
