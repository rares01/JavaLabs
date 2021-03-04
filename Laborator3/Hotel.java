package com.company;

import java.util.Map;

public class Hotel extends Location implements Classifiable{
    private int rank;

    public Hotel() {
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
