package com.wj.theatreservice;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TheatreRoom {
    private final int total_rows;
    private final int total_columns;

    private final List<Seat> available_seats;

    public TheatreRoom(){

        total_rows = 9;
        total_columns = 9;
        available_seats = new ArrayList<>();

        for (int i = 1; i <= total_columns; i++) {
            for (int j = 1; j <= total_rows; j++)
                if(i <= 4)
                    available_seats.add(new Seat(i, j, 10));
                else
                    available_seats.add(new Seat(i, j, 8));
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
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

    public boolean isSeatPurchased(int row, int column){
        return available_seats.stream()
                .filter(seat -> seat.getRow() == row && seat.getColumn() == column)
                .findFirst()
                .get()
                .isPurchased();
    }
}
