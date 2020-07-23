package br.com.vuttr.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.vuttr.domain.service.exception.ObjectNotFoundException;
import br.com.vuttr.domain.util.VuttrUtilDate;

/**
 * Classe auxiliar que intercepta as excessoes  e exibi de modo formatado para o cliente da API
 * @author felipe
 *
 */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception,
			HttpServletRequest request){
		
		StandardError standardError = new StandardError();
		VuttrUtilDate utilDate = new VuttrUtilDate();
		
		standardError.setStatus(HttpStatus.NOT_FOUND.value());
		standardError.setMensage(exception.getMessage());
		standardError.setDateTime(utilDate.getZoneDateTime());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
		
		
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<StandardError> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
			HttpServletRequest request){
		
		StandardError standardError = new StandardError();
		VuttrUtilDate utilDate = new VuttrUtilDate();
		
		standardError.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		standardError.setMensage(exception.getMessage());
		standardError.setDateTime(utilDate.getZoneDateTime());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(standardError);
		
		
	}

}
