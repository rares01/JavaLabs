package com.company;

import com.company.Classifiable;
import com.company.Payable;
import com.company.Visitable;

import java.util.*;

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

    /** https://www.infoworld.com/article/3323403/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html */
    public void visitNoPay(){
        List<Location> locs =new ArrayList<>();
        for(int i=0;i<nodes.size();i++) {
            if ((nodes.get(i) instanceof Visitable) && !(nodes.get(i) instanceof Payable)) {
                locs.add(nodes.get(i));
            }
        }
            Collections.sort(locs, (Location loc1, Location loc2) -> {
                if(loc1 instanceof  Visitable && loc2 instanceof Visitable)
                    return((Visitable) loc1).getOpeningTime().compareTo(((Visitable) loc2).getOpeningTime());
            else
                return 0;
            });
            for(int i=0;i<locs.size();i++)
            {
                System.out.println(locs.get(i).getName() + " it's opening at: " + ((Visitable) locs.get(i)).getOpeningTime());
            }

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
