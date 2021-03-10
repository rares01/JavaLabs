package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements Visitable{
    private LocalTime openingTime,closingTime;
    public Church() {
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
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
}
