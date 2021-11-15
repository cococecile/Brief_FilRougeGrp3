package group3.gestionpersonnel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception appears when a request is made but the request's body contains no valid object.
 * @author Caroline (group3)
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class NullBodyException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor invoked when exception is thrown
     * This exception appears when a request is made but the request's body contains no valid object.
     * @param msg the message of the exception.
     */
    public NullBodyException(String msg){
        super(msg);
    }
    
}
