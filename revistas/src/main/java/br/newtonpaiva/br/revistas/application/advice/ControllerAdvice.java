package br.newtonpaiva.br.revistas.application.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.newtonpaiva.br.revistas.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

	public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        
		log.info(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: " + ex.getMessage());
		
    }	

	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        
		log.info(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		
    }
	
}
