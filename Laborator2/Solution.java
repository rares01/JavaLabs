package com.company;
//import java.util.*;
/** In aceasta clasa avem un algortim de tip least cell cost care este greedy. El va reparcuge matricea atata timp cat demandurile adunate  nu sunt 0. */
/** Se cauta  minimul din matricea de costuri ( si sa fie diferit de -1)  si acesta va fi initializat cu -1 pentru a-l nu-l mai lua in calcul. Se vor salva coloana si linia.  */
/** Folosindu-ne de coloana si linia minimului verificam daca demandul este mai mare decat supplyul sau invers ( sau egal) si in functie de asta vom pune -1 pe linie sau coloana ( sau ambele). */
/** La final adunam demandurile ramase.  */
public class Solution {

    private int matrix[][];
    private int[] demand;
    private int[] supply;

    public Solution(int[][] matrix, int[] demand, int[] supply) {
        this.matrix = matrix;
        this.demand = demand;
        this.supply = supply;
    }

    public  void  algorithm(int matrix[][], int[] demand , int [] supply) {

        int minim;
        int sum=0;
        int d=-1;
        while (d!=0) {
            d=0;
            int pozi = 0;
            int pozj = 0;
            minim=Integer.MAX_VALUE;
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++) {
                    if (minim > matrix[i][j] && matrix[i][j] != -1) {
                        minim = matrix[i][j];
                        pozi = i;
                        pozj = j;
                    }
                }
            matrix[pozi][pozj] = -1;
            if (demand[pozj] > supply[pozi] && demand[pozj] != 0 && supply[pozi] != 0) {
                sum = sum+ minim * supply[pozi];
                demand[pozj] =demand[pozj] - supply[pozi];
                supply[pozi] = 0;
                for (int j = 0; j < matrix[pozi].length; j++)
                    matrix[pozi][j] = -1;

            } else if (demand[pozj] < supply[pozi] && demand[pozj] != 0 && supply[pozi] != 0) {
                sum += minim * demand[pozj];
                supply[pozi] = supply[pozi] - demand[pozj];
                demand[pozj] = 0;
                for (int i = 0; i < matrix.length; i++)
                    matrix[i][pozj] = -1;
            } else if (demand[pozj] == supply[pozi] && demand[pozj] != 0 && supply[pozi] != 0) {
                sum += minim * supply[pozi];
                demand[pozj] = 0;
                demand[pozi] = 0;
                for (int i = 0; i < matrix.length; i++)
                    matrix[i][pozj] = -1;
                for (int j = 0; j < matrix.length; j++)
                    matrix[pozi][j] = -1;
            }

            for (int i = 0; i < demand.length; i++) {
                d += demand[i];
            }

        }
        System.out.println(sum);
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


}
