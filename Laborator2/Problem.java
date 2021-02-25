package com.company;

import java.sql.Array;
import java.util.Arrays;

public class Problem {
public Source [] sources;
public Destination[] destinations;
private int matrix [][];
private int[] demand;
private int[] supply;


    public Problem(Source[] sources, Destination[] destinations, int[][] matrix, int[] demand, int[] supply) {
        if((sources.length==supply.length) && (destinations.length==demand.length) &&  (matrix.length* matrix.length== demand.length* supply.length))
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

    public Source[] getSources() {
        return sources;
    }

    public void setSources(Source[] sources) {
        this.sources = sources;
    }

    public Destination[] getDestinations() {
        return destinations;
    }

    public void setDestinations(Destination[] destinations) {
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
                "sources=" + Arrays.toString(sources) + '\n' +
                "destinations=" + Arrays.toString(destinations)  + "\nCost matrix" + printMat(matrix) +
                 "\ndemand=" + Arrays.toString(demand)  +
                "\nsupply=" + Arrays.toString(supply) ;
    }
}
