package com.wj.theatreservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongPasswordException extends Throwable{
    public WrongPasswordException(String cause) {
        super(cause);
    }
}
