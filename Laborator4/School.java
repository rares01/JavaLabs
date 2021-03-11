package com.company;

public class School implements Comparable<School>{
    private String name;
    private int capacity;

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(School other) {
       if(other==null)
            throw new NullPointerException();
      if(this.name.compareTo(other.name)==0)
      {
          return this.capacity - other.capacity;
      }
      else return this.name.compareTo(other.name);
    }


}
