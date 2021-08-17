package com.wj.theatreservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {

    @ExceptionHandler(AlreadyPurchasedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private String handleMessage(AlreadyPurchasedException e) {
        return "{\"error\": \"The ticket has been already purchased!\"}";
    }

    @ExceptionHandler(SeatIsOutOfBoundsException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private String handleMessage(SeatIsOutOfBoundsException e) {
        return "{\"error\": \"The number of a row or a column is out of bounds!\"}";
    }
}
