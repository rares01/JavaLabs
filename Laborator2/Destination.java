package com.company;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj instanceof Destination)) return false;
        Destination other = (Destination) obj;
        return names.equals(other.names);
    }

}
