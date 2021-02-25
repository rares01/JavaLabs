package com.company;

public class Destination {
   private String names;

    @Override
    public String toString() {
        return "names='" + names + '\'' ;
    }

    public Destination(String names) {
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }


}
