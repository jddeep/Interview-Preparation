/*
The aim of the Dijkstra's algorithm is to find the shortest weighed paths from a source vertex
to all the vertices in the graph.
We specify the distance of all possible next source vertices(src vertex is given distance 0 to start things off i.e, dist[src]=0),
run the minDistance function to return the vertex to be chosen which has the minimum weighed path. This process gets iterated over for all vertices.
TC - O(n^2)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
    
    int vertices;
    
    public Graph(int v){
        this.vertices = v;
    }
    
    int minDistance(int[] dist, boolean[] sptSet){
        
        int min = Integer.MAX_VALUE; int min_index = -1;
        for(int v = 0; v<this.vertices; v++){
            if(!sptSet[v] && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    
    void printSolution(int src, int[] dist){
        System.out.println("Distance from source: " + src);
        
        for(int i=0;i<this.vertices;i++){
            System.out.println(i + " " + dist[i]);
        }
    }
    
    public void dijkstra(int[][] graph, int src){
        
        int[] dist = new int[graph.length];
        
        boolean[] sptSet = new boolean[graph.length];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);
        
        dist[src] = 0;
        
        for(int i = 0;i<this.vertices;i++){
            
            int u = minDistance(dist, sptSet);
            
            sptSet[u] = true;
            
            for(int v = 0;v<this.vertices; v++){
                
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                && dist[v] > dist[u] + graph[u][v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        
        printSolution(src, dist);
    }
}

class Solution
{
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Graph gr = new Graph(9);
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        gr.dijkstra(graph, 0); // source vertex = 0
		
	}
}
