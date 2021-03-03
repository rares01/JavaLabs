package com.company;

import java.util.ArrayList;

public class Main {
    /** Am creat 3 Source si 3 Destination, fiecare avand o lista specifica, o matrice pentru costuri */
    /** In clasa Problem se afla si o functie printMat care trasnforma elementele matricii in Stringuri pentru a le afisa cand avem nevoie */
    public static void main(String[] args) {
    ArrayList<Source> sources= new ArrayList<Source>();
    Source s1 =new Factory("S1","Factory");
    Source s2 =new Warehouse("S2","Warehouse");
    Source s3 =new Warehouse("S3","Warehouse");
    sources.add(s1);
    sources.add(s2);
    sources.add(s3);
    Destination d1= new Destination("D1");
    Destination d2= new Destination("D2");
    Destination d3= new Destination("D3");
    ArrayList<Destination> destinations= new ArrayList<Destination>();
    destinations.add(d1);
    destinations.add(d2);
    destinations.add(d3);
    int[] exdemands={20,25,25};
    int[] exsupp={10,35,25};
    int [][] excosts={{2,3,1},{5,4,8},{5,6,8}};
    Problem p= new Problem(sources,destinations,excosts,exdemands,exsupp);
    Solution sol= new Solution(excosts,exdemands,exsupp);
    System.out.println(p);
    System.out.print("The total cost is: ");
    sol.algorithm(excosts,exdemands,exsupp);
   // Source s4=s1;
   // System.out.println(s1.equals(s4));
    }
}
