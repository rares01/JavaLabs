package com.company;

public class Main {
    /** Am creat 3 Source si 3 Destination, fiecare avand o lista specifica, o matrice pentru costuri */
    /** In clasa Problem se afla si o functie printMat care trasnforma elementele matricii in Stringuri pentru a le afisa cand avem nevoie */
    public static void main(String[] args) {
    Source s1= new Source ("S1", SourceType.FACTORY);
    Source s2= new Source ("S2",SourceType.WAREHOUSE);
    Source s3= new Source ("S3",SourceType.WAREHOUSE);
    Source [] sources ={s1,s2,s3};
    Destination d1= new Destination("D1");
    Destination d2= new Destination("D2");
    Destination d3= new Destination("D3");
    Destination [] destinations={d1,d2,d3};
    int[] exdemands={20,25,25};
    int[] exsupp={10,35,25};
    int [][] excosts={{2,3,1},{5,4,8},{5,6,8}};
    Problem p= new Problem(sources,destinations,excosts,exdemands,exsupp);
    System.out.println(p);
    }
}
