package com.wj.theatreservice.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wj.theatreservice.Exception.AlreadyPurchasedException;
import com.wj.theatreservice.Exception.SeatIsOutOfBoundsException;
import com.wj.theatreservice.Model.Seat;
import com.wj.theatreservice.Model.TheatreRoom;
import com.wj.theatreservice.Model.Ticket;
import com.wj.theatreservice.Exception.WrongTokenException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataAccess {

    TheatreRoom theatreRoom;

    DataAccess() {
        theatreRoom = new TheatreRoom();
    }

    public TheatreRoom getTheatreRoomInfo() {
        return theatreRoom;
    }

    public Ticket getPurchasedTicket(Seat seatToPurchase) throws SeatIsOutOfBoundsException, AlreadyPurchasedException {

        if (seatToPurchase.getRow() > 0 && seatToPurchase.getRow() < 10 && seatToPurchase.getColumn() > 0 && seatToPurchase.getColumn() < 10) {

            if (theatreRoom.getSeatByRowAndColumn(seatToPurchase.getRow(), seatToPurchase.getColumn()).isPurchased())
                throw new AlreadyPurchasedException("{\"error\": \"The ticket has been already purchased!\"}");

            theatreRoom.markSeatPurchased(seatToPurchase.getRow(), seatToPurchase.getColumn());

            Ticket currentTicket = new Ticket(UUID.randomUUID().toString(), theatreRoom.getSeatByRowAndColumn(seatToPurchase.getRow(), seatToPurchase.getColumn()));

            theatreRoom.addPurchasedTicket(currentTicket);

            return currentTicket;
        }
        else throw new SeatIsOutOfBoundsException("{\"error\": \"The number of a row or a column is out of bounds!\"}");
    }

    public Object getReturnedTicket(@RequestBody String token) throws WrongTokenException {

        JsonElement a = JsonParser.parseString(token);
        String Token = a.getAsJsonObject().get("token").getAsString();

        Optional<Ticket> optionalTicket = theatreRoom.getPurchasedTickets().stream()
                .filter(ticket -> ticket.getToken().equals(Token))
                .findFirst();

        if (optionalTicket.isPresent()) {

            Map<String, Object> jsonMap =  new HashMap<>();
            jsonMap.put("returned_ticket",optionalTicket.get().getTicket());
            return jsonMap;
        }
        else throw new WrongTokenException("{\"error\": \"Wrong token!\"}");
    }

}
