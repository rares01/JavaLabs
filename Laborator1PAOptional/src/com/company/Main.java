package com.company;


import java.util.Random;


public class Main {

    public static void main(String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch(NumberFormatException e){
            System.out.println("This is not a number!");
            System.exit(-1);
        }
        if (n!=0 && n<10000) {
            Random rand = new Random();
            int graph[][] = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (i != j && i < j) {
                        graph[i][j] = rand.nextInt(2);
                        graph[j][i] = graph[i][j];
                    }
                }

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++)
                    System.out.print(graph[i][j] + " ");
                System.out.print("\n");
            }
            boolean[] visited = new boolean[graph.length];
            int count = 0;
            int k=0;
            int matrix[][]=new int[n][n];
            int dads[]=new int [n];
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    System.out.print("\nComponent : ");
                    dfs(i,graph, visited,matrix);
                    count++;
                }
            }

            System.out.println("\n");
            if (count == 1) {
                System.out.println("The graph is connected.");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++)
                        System.out.print(matrix[i][j] + " ");
                    System.out.print("\n");
                }

            }
            if (count > 1) {
                System.out.println("The graph is not connected.");
            }



        }
        else if( n >= 10000){
            long startTime = System.nanoTime();
            Random rand = new Random();
            int graph[][] = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (i != j && i < j) {
                        graph[i][j] = rand.nextInt(2);
                        graph[j][i] = graph[i][j];
                    }
                }
            boolean[] visited = new boolean[graph.length];
            int count = 0;
            int k=0;
            int matrix[][]=new int[n][n];
            int dads[]=new int [n];
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    System.out.print("\nComponent : ");
                    dfs(i,graph, visited,matrix);
                    count++;
                }
            }
            if (count == 1) {
                System.out.println("The graph is connected.");
            }
            if (count > 1) {
                System.out.println("The graph is not connected.");
            }
            long endTime = System.nanoTime();
            long timeDifference = endTime - startTime;
            System.out.println("Time in nanoseconds "  + timeDifference );
        }


    }

    public static void dfs(int i, int[][] graph, boolean[] visited,int matrix[][]) {
        visited[i] = true; // Mark node as "visited"
        System.out.print(i+1 + " ");

        for (int j = 0; j < graph[i].length; j++) {
            if (graph[i][j]==1 && !visited[j]) {
                matrix[i][j]=1;
                matrix[j][i]=1;
                dfs(j, graph, visited,matrix); // Visit node
            }
        }
    }
}





