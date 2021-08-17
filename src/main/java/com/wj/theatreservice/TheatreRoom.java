package com.wj.theatreservice;

import java.util.ArrayList;
import java.util.List;

public class TheatreRoom {
    private final int total_rows;
    private final int total_columns;
    private final List<Seat> available_seats;

    public TheatreRoom(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;

        available_seats = new ArrayList<>();

        for (int i = 1; i <= total_columns; i++) {
            for (int j = 1; j <= total_rows; j++)
                available_seats.add(new Seat(i, j));
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
}
