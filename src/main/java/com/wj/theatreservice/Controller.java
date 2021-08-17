package com.wj.theatreservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/seats")
    public TheatreRoom getTheatreRoomInfo(){
        return new TheatreRoom(9,9);
    }
}
