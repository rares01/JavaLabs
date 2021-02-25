package com.company;

import java.util.Random;

public class MainBonus {

    public static void main(String[] args) {
        // write your code here
        Random rand = new Random();
        String spacesr = new String("    ");
        String spacesc = new String("    ");
        int n = rand.nextInt(100); // numar de noduri
        System.out.println("    +Node1");
        String spaces = "    ";
        for (int i = 2; i <= n; i++) {
            int maximum = n - i;
            int child = rand.nextInt(maximum); //numar maxim de fii
            int k = i;
            tree(child, spacesc, spacesr, k);
        }

    }

    public static void tree(int child,String spacesc,String spacesr,int k)
    {
        String cspacesc= spacesc;
        cspacesc=cspacesc.concat("   ");
        Random rand = new Random();
            while(child!=0)
            {
                int kid= rand.nextInt(2);//daca poate fi parinte sau e frunza
                if(kid==0)
                {
                    System.out.println( spacesc + "-Node" + k);
                    k++;
                    child--;
                }
                else if(kid==1)
                {
                    String cspacesr =spacesr;
                    cspacesr=cspacesr.concat("   ");
                    int maximum=child-k;
                    int ck=k;
                    child--;
                    System.out.println( spacesr + "+Node" + k );
                    tree(maximum,cspacesc,cspacesr,ck);
                    k=ck;
                }
            }
            //i=i+child;


    }
}
