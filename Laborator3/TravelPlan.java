package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    City oras;
    private Map<Location,Integer> order=new HashMap<>();

    public TravelPlan() {
    }

    public TravelPlan(City oras) {
        this.oras = oras;
    }

    public City getOras() {
        return oras;
    }

    public void setOras(City oras) {
        this.oras = oras;
    }

    public Map<Location, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Location, Integer> order) {
        this.order = order;
    }

    public void addOrder(Location node, int value)
    {
        order.put(node,value);
    }
    public void transform(List<Integer>pref){
        for (Integer url : this.order.values())
        {
            pref.add(url);
        }
    }

}
