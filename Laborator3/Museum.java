package com.company;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Payable, Visitable{

private String name;
private int ticketPrice;
private LocalTime openingTime,closingTime;

    public Museum() {
        this.opening();
        this.closing();
    }

    @Override
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public void setPrice(int ticketPrice) {
            this.ticketPrice=ticketPrice;
    }

    @Override
    public int getPrice() {
        return ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
}
