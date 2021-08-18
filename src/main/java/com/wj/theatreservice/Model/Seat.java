package com.wj.theatreservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private final int row;
    private final int column;
    private final int price;
    private transient boolean isPurchased;

    public Seat(){
        row = 1;
        column = 1;
        price = 1;
        isPurchased = false;
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        isPurchased = false;
    }

    public int getPrice() { return price; }

    public int getRow() { return row; }

    public int getColumn() {
        return column;
    }

    @JsonIgnore
    public boolean isPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(boolean state){
        this.isPurchased = state;
    }
}
