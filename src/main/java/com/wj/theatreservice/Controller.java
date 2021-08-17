package com.wj.theatreservice;

import com.wj.theatreservice.Exception.AlreadyPurchasedException;
import com.wj.theatreservice.Exception.SeatIsOutOfBoundsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Validated
public class Controller {

    TheatreRoom theatreRoom;

    Controller() {
        theatreRoom = new TheatreRoom();
    }

    @GetMapping("/seats")
    public TheatreRoom getTheatreRoomInfo(){
        return theatreRoom;
    }

    @PostMapping("/purchase")
    public Object getPurchasedSeat(@RequestBody @Valid Seat seatToPurchase) throws AlreadyPurchasedException, SeatIsOutOfBoundsException {

        if(seatToPurchase.getRow() > 0 && seatToPurchase.getRow() < 10 && seatToPurchase.getColumn() > 0 && seatToPurchase.getColumn() < 10) {

            if (theatreRoom.isSeatPurchased(seatToPurchase.getRow(),seatToPurchase.getColumn()))
                throw new AlreadyPurchasedException("{\"error\": \"The ticket has been already purchased!\"}");

            theatreRoom.markSeatPurchased(seatToPurchase.getRow(),seatToPurchase.getColumn());

            return theatreRoom.getAvailable_seats().stream()
                    .filter(seat -> seat.getColumn() == seatToPurchase.getColumn() && seat.getRow() == seatToPurchase.getRow())
                    .findFirst()
                    .get();
        }
        else{
          throw new SeatIsOutOfBoundsException(" \"error\": \"The number of a row or a column is out of bounds!\"");
        }
    }
}
