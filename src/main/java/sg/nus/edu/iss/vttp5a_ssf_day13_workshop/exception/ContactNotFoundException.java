package sg.nus.edu.iss.vttp5a_ssf_day13_workshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String message){
        super(message);
    }
}
