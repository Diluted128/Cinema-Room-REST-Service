package com.wj.theatreservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongTokenException extends Throwable{
    public WrongTokenException(String cause) {
        super(cause);
    }
}
