package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random rand = new Random();
        String spacesr= new String("    ");
        String spacesc= new String("    ");
        int n=rand.nextInt(10); // numar de noduri
        System.out.println("    +Node1");
        String spaces="    ";
        for(int i=1;i<n;i++)
        {
                  Tree(n,spacesr,spacesc);
        }

    }

    public static void Tree(int n,String spacesr,String spacesc)
    {
        Random rand = new Random();
        spacesc=spacesc.concat("   ");
        int root = rand.nextInt(n);
        for(int i=1;i<root;i++) {
            int child= rand.nextInt(2);
            if (child == 1) {
                root=root-1;
                n=n-1;
                System.out.println( spacesc + "-Node" +i );
            }
            else if (child==0)
            {
                n=n-root;
                spacesr=spacesr.concat("   ");
                System.out.println( spacesr + "+Node" +i );
                Tree(n,spacesr,spacesc);
            }
        }
    }
}
// fac o functie recursiva  ( cauta strcat din java maine dim), apeleaza recurisv tree pentru fiecare nod parinte, nu uita sa scazi n-ul