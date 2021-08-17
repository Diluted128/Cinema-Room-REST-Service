package com.wj.theatreservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyPurchasedException extends Throwable{
    public AlreadyPurchasedException(String cause) {
        super(cause);
    }
}
