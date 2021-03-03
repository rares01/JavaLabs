package com.company;

import java.util.Objects;

public abstract class Source {
    protected String names;
    protected String type;

    @Override
    public String toString() {
        return '{' + "names='" + names + '\'' +
                ", type=" + type +
                '}';
    }

    public Source(String names, String type) {
        this.names = names;
        this.type = type;
    }

    public void setNames(String names) {
        this.names = names;
    }



    public String getNames() {
        return names;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Source)) return false;

        Source other = (Source) obj;
        return names.equals(other.names) && type == other.type;
    }

}
