package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tokenize> tokens= new ArrayList<>();
    private int n;

    public Board(int n) {
        this.n = n;
    }

    public synchronized  List<Tokenize> getTokens() {
        return tokens;
    }

    public void setTokens(List<Tokenize> tokens) {
        this.tokens = tokens;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setTokens()
    {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                if(i!=j)
                    this.getTokens().add(new Tokenize(i+1,j+1));
            }
    }








}
