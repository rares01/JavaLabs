package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
/**In constructor avem 2 liste: una de destinatii si una de source. Si verificam daca avem o sursa sau o destinatie de 2 ori.*/
public class Problem {
public ArrayList<Source>  sources;
public ArrayList<Destination> destinations;
private int matrix [][];
private int[] demand;
private int[] supply;


    public Problem(ArrayList<Source> sources, ArrayList<Destination> destinations, int[][] matrix, int[] demand, int[] supply) {
        int oksource=1;
        int okdestin=1;
        for(int i=0;i<sources.size()-1;i++)
            for(int j=i+1;j<sources.size();j++)
                if(sources.get(i).equals(sources.get(j)))
                {
                    System.out.println("Exita minim 2 surse la fel!");
                    oksource=0;
                }
        for(int i=0;i<destinations.size()-1;i++)
            for(int j=i+1;j<destinations.size();j++)
                if(destinations.get(i).equals(destinations.get(j)))
                {
                    System.out.println("Exita minim 2 destinatii la fel!");
                   okdestin=0;
                }
        if(okdestin == 0 || oksource==0)
        {
            System.exit(-1);
        }
        if((sources.size()==supply.length) && (destinations.size()==demand.length) &&  (matrix.length* matrix.length== demand.length* supply.length))
        {
            this.sources = sources;
            this.destinations = destinations;
            this.matrix = matrix;
            this.demand = demand;
            this.supply = supply;
        }
        else{
            System.out.println("Nu este o instanta corecta!");
            System.exit(-1);
        }
    }

    public void setSources(ArrayList<Source> sources) {
        this.sources = sources;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }
    public String printMat(int [][] matrix)
    {
        String finalmat="\0";
        for(int i=0;i< matrix.length;i++) {
                finalmat=finalmat.concat("\n");
                for (int j = 0; j < matrix.length; j++) {
                    String element = Integer.toString(matrix[i][j]);
                    finalmat=finalmat.concat(element);
                    finalmat=finalmat.concat(" ");
                }
        }

        return finalmat;
    }
    @Override
    public String toString() {
        return
                "sources=" + sources + '\n' +
                "destinations=" + destinations  + "\nCost matrix" + printMat(matrix) +
                 "\ndemand=" + Arrays.toString(demand)  +
                "\nsupply=" + Arrays.toString(supply) ;
    }

}
