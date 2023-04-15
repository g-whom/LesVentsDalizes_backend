package fr.eql.ai113.LesVentsDalizes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Identifiant erroné !")
public class NonExistentRoleException extends Exception{

}
