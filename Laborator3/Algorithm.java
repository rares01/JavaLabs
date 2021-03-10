package com.company;

import java.util.List;

public  class Algorithm {
private TravelPlan travel;

    public Algorithm(TravelPlan travel) {
        this.travel = travel;
    }
    static final int V = 6;
    int minDistance(int dist[], Boolean sptSet[],List<Integer>preferences)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                if(dist[v]!=min)
                {min = dist[v];
                min_index = v;}
                else{
                        //if(this.travel.getOrder().get(this.travel.getOras().getNodes().get(v))<this.travel.getOrder().get(this.travel.getOras().getNodes().get(min_index)))
                        if(preferences.get(v) < preferences.get(min_index))
                        {
                            min=dist[v];
                            min_index=v;
                        }
                }
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[],int src,int arrive,int parents[])
    {
        //System.out.println("Vertex \t\t Distance from Source");

        System.out.println("Distana de la " + src  + " la " + arrive   + " este :"  + " " + dist[arrive]);
        src++;
        arrive ++;
        for(int i=src;i<arrive;i++)
        {
            if(parents[i-1]!=parents[i])
            {
                System.out.print(parents[i]+1 + "  ");
            }

        }
        System.out.println(arrive);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], Location loc1,Location loc2,List<Integer> preferences)
    {
        int ok1=0,ok2=0;
        for (Location locs : this.travel.getOras().getNodes()) {
            if (locs == loc1) ok1++;
            if( locs == loc2) ok2++;
        }
        int src=this.travel.getOras().getNodes().indexOf(loc1);
        int arrive=this.travel.getOras().getNodes().indexOf(loc2);
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;
        int [] parents = new int[V];
        parents[src]=-1;
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet,preferences);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                    parents[v]=u;
                }
        }

        // print the constructed distance array
        printSolution(dist,src,arrive,parents);
    }
}
