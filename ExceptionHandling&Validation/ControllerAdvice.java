package Exceptions1.ControllerAdvices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Exceptions1.Exceptionss.StudentNotFound;

@RestControllerAdvice
public class AppExceptions {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidPaylodData(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err -> {
			errors.put(err.getField(), err.getDefaultMessage());
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(StudentNotFound.class)
	public Map<String, String> studentNotFound(StudentNotFound ex) {
		Map<String, String> errorMsg = new HashMap<>();
		errorMsg.put("Error ", ex.getMessage());
		return errorMsg;
	}

}
