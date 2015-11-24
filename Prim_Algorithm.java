package pkg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Prim_Algorithm {


    public static void main(String args[]) throws IOException 
    {
         int verticeCount;
    	 int edgeCount;
    	 int nodeA, nodeB, weight;
    	 int current;
    	 int total;
    	 int mincost;

        // Instantiate the graph based on input
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter number of vertices: ");
        verticeCount = Integer.parseInt(buf.readLine());

        System.out.print("\nEnter number of edges: ");
        edgeCount = Integer.parseInt(buf.readLine());
        
        
        int weightArray[][] = new int[verticeCount+1][verticeCount+1];
        int visited[] = new int [verticeCount+1];
        int d[] = new int[verticeCount+1];
        int p[] = new int[verticeCount+1];

        
        
        for (int i = 1; i <= verticeCount; i++) 
        {
            for(int j = 1; j <= verticeCount; j++) 
            {
                weightArray[i][j] = 0;
            }
        }

       for (int i = 1; i <= verticeCount; i++) 
       {
           p[i] = visited[i] = 0;
           d[i] = Integer.MAX_VALUE;
        }

		Scanner in = new Scanner(System.in);
        for (int i = 1; i <= edgeCount; i++) 
        {
            System.out.print("\nEnter edge nodeA, nodeB and weightArray weight: ");
            nodeA=Integer.parseInt(in.nextLine());
            nodeB=Integer.parseInt(in.nextLine());
            weight=Integer.parseInt(in.nextLine());
            weightArray[nodeA][nodeB] = weightArray[nodeB][nodeA] = weight;
        }
        // End of graph instantiation

        current = 1;
        d[current] = 0;
        total = 1;
        visited[current] = 1;
        while( total != verticeCount) 
        {
            for (int i = 1; i <= verticeCount; i++) 
            {
                if ( weightArray[current][i] != 0) 
                {
                    if( visited[i] == 0) 
                    { 
                        if (d[i] > weightArray[current][i]) 
                        {
                            d[i] = weightArray[current][i];
                            p[i] = current;
                        }
                    }
                }
            }
            
            // Find the min wt edge from current node using d[]
            mincost=Integer.MAX_VALUE;
            for (int i = 1 ; i <= verticeCount; i++) 
            {
                if (visited[i] == 0) 
                {
                    if (d[i] < mincost)
                    {
                        mincost = d[i]; // minimum edge from current to its adj V
                        current = i;    // next explore from this min edge node
                    }
                }
            }
            visited[current]=1;
            total++;
        }

        mincost=0;
        for(int i=1;i<=verticeCount;i++)
        	mincost=mincost+d[i];
        System.out.println("Minimum cost="+mincost);
        
        System.out.print("\nMinimum Spanning tree is\n");
        for(int i=1;i<=verticeCount;i++)
        	if(p[i]==0 && i!=1)
        		System.out.println("vertex[" +i+"] can not connect to MST");
        	else
        		System.out.println("vertex[" +i+"] is connected to vertex:["+p[i]+"]");
    }
}
