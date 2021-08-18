package com.wj.theatreservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheatreRoom {

    private final int total_rows;
    private final int total_columns;

    private final List<Seat> available_seats;
    private final List<Ticket> purchasedTickets;


    public TheatreRoom(){

        total_rows = 9;
        total_columns = 9;
        available_seats = new ArrayList<>();
        purchasedTickets =  new ArrayList<>();

        for (int i = 1; i <= total_columns; i++) {
            for (int j = 1; j <= total_rows; j++)
                if(j <= 4)
                    available_seats.add(new Seat(j, i, 10));
                else
                    available_seats.add(new Seat(j, i, 8));
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    @JsonIgnore
    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void addPurchasedTicket(Ticket ticket){
        purchasedTickets.add(ticket);
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void markSeatPurchased(int row, int column){
        for(Seat seat : available_seats){
            if(seat.getRow() == row && seat.getColumn() == column)
                seat.setIsPurchased(true);
        }
    }

    public Seat getSeatByRowAndColumn(int row, int column){
        return available_seats.stream()
                .filter(seat -> seat.getRow() == row && seat.getColumn() == column)
                .findFirst()
                .get();
    }

    public void returnPurchasedTicket(String Token){
        int index = 0;
        for (int i=0; i<purchasedTickets.size(); i++){
            if(purchasedTickets.get(i).getToken().equals(Token)) {
                index = i;
                break;
            }
        }
        purchasedTickets.remove(index);
    }
}
