package com.company;

import java.time.LocalTime;
import java.util.Map;

public class Restaurant extends Location implements Visitable,Classifiable{

    private int rank;
    private LocalTime openingTime,closingTime;

    public Restaurant() {
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

    @Override
    public void setRank(int rank) {
        this.rank=rank;
    }

    @Override
    public int getRank() {
        return rank;
    }
}
