package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location>{
    private String name;
    private Map<Location, Integer> cost= new HashMap<>();

    public Location() {
    }

    public Map<Location, Integer> getMap() {
        return cost;
    }

    public void setMap(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node,int value)
    {
        cost.put(node,value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
    }
    public String printMap(Map<Location, Integer> cost)
    {
        String finalMap="";
        for (Map.Entry<Location,Integer> entry : cost.entrySet()) {
            finalMap=finalMap.concat((entry.getKey().getName()));
            finalMap=finalMap.concat("  ");
            String second = Integer.toString(entry.getValue());
            finalMap = finalMap.concat(second);
            finalMap = finalMap.concat("\n");
        }
        return finalMap;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
