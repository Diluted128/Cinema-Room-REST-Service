package com.wj.theatreservice.Controller;


import com.wj.theatreservice.Exception.AlreadyPurchasedException;
import com.wj.theatreservice.Exception.SeatIsOutOfBoundsException;
import com.wj.theatreservice.Exception.WrongTokenException;
import com.wj.theatreservice.Model.Seat;
import com.wj.theatreservice.Model.Ticket;
import com.wj.theatreservice.Service.DataAccess;
import com.wj.theatreservice.Model.TheatreRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class Controller {

    @Autowired
    DataAccess dataAccess;

    @GetMapping("/seats")
    public TheatreRoom getTheatreRoomInfo() {
        return dataAccess.getTheatreRoomInfo();
    }

    @PostMapping("/purchase")
    public Ticket purchaseSeat(@RequestBody @Valid Seat seatToPurchase) throws AlreadyPurchasedException, SeatIsOutOfBoundsException {
        return dataAccess.getPurchasedTicket(seatToPurchase);
    }

    @PostMapping("/return")
    public Object getReturnedTicket(@RequestBody String token) throws WrongTokenException {
        return dataAccess.getReturnedTicket(token);
    }
}
