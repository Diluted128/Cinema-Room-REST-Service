package com.wj.theatreservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatIsOutOfBoundsException extends Throwable{
    public SeatIsOutOfBoundsException(String cause) {
        super(cause);
    }
}
