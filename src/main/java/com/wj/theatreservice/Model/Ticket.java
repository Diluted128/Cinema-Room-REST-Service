package com.wj.theatreservice.Model;

public class Ticket {

    String token;
    Seat ticket;

    public Ticket(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Seat getTicket() {
        return ticket;
    }
}
