package com.company;

public class Source {
    private String names;
    public SourceType type;

    @Override
    public String toString() {
        return '{' + "names='" + names + '\'' +
                ", type=" + type +
                '}';
    }

    public Source(String names, SourceType type) {
        this.names = names;
        this.type = type;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setType(SourceType type) {
        this.type = type;
    }


    public String getNames() {
        return names;
    }

    public SourceType getType() {
        return type;
    }


}
