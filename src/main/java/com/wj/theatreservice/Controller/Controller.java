package com.wj.theatreservice.Controller;

import com.wj.theatreservice.Exception.AlreadyPurchasedException;
import com.wj.theatreservice.Exception.SeatIsOutOfBoundsException;
import com.wj.theatreservice.Exception.WrongPasswordException;
import com.wj.theatreservice.Exception.WrongTokenException;
import com.wj.theatreservice.Model.Seat;
import com.wj.theatreservice.Model.Ticket;
import com.wj.theatreservice.Service.DataAccess;
import com.wj.theatreservice.Model.TheatreRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    DataAccess dataAccess;

    @GetMapping("/seats")
    public TheatreRoom getTheatreRoomInfo() {
        return dataAccess.getTheatreRoomInfo();
    }

    @PostMapping("/purchase")
    public Ticket purchaseSeat(@RequestBody  Seat seatToPurchase) throws AlreadyPurchasedException, SeatIsOutOfBoundsException {
        return dataAccess.getPurchasedTicket(seatToPurchase);
    }

    @PostMapping("/return")
    public Object getReturnedTicket(@RequestBody String token) throws WrongTokenException {
        return dataAccess.getReturnedTicket(token);
    }

    @PostMapping("/stats")
    public Object getStatistics(@RequestParam(value = "password") String password) throws WrongPasswordException {
        return dataAccess.getTheatreRoomStatistics(password);
    }
}
