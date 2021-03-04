package com.company;

import com.company.Classifiable;
import com.company.Payable;
import com.company.Visitable;

import java.util.ArrayList;
import java.util.List;

public class City  {
    private List<Location> nodes = new ArrayList<>();

    public City(){
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node)
    {
        nodes.add(node);
    }
    @Override
    public String toString() {
        return "City\n" + nodes ;
    }
}
