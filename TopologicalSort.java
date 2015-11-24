package pkg;
import java.io.*;
import java.util.*;

class Graph
{
	 private int V;   // No. of vertices
	 private LinkedList<Integer> adj[]; // Adjacency List
	 Graph(int v)
	 {
	     V = v;
	     adj = new LinkedList[v];
	     for (int i=0; i<v; ++i)
	         adj[i] = new LinkedList();
	 }
	void addEdge(int v,int w) 
	{ 
		 adj[v].add(w); 
	}
	
	 void topologicalSortUtil(int v, Boolean visited[],Stack stack)
	 {
		 visited[v] = true;
		 Integer i;
	     System.out.print(v + " ");
		 Iterator<Integer> it = adj[v].iterator();
		 while (it.hasNext())
		 {
		     i = it.next();
		     if (!visited[i])
		         topologicalSortUtil(i, visited, stack);
		 }	
		 // Push current vertex to stack which stores result
	     stack.push(new Integer(v));
	 }
	
	 void topologicalSort()
	 {
	     Stack stack = new Stack();
	
		 Boolean visited[] = new Boolean[V];
		 for (int i = 0; i < V; i++)
		     visited[i] = false;
		
		 for (int i = V-1; i >= 0; i--)
		     if (visited[i] == false)
		         topologicalSortUtil(i, visited, stack);
		
		 // Print contents of stack 
		 System.out.println("\nTOPOLOGICAL SORTING");
		 while (stack.empty()==false)
		     System.out.print(stack.pop() + " ");
	 }
	
	 public static void main(String args[])
	 {
	     // Create a graph given in the above diagram
		 Graph g = new Graph(6);
		 g.addEdge(5, 2);
		 g.addEdge(5, 0);
		 g.addEdge(4, 0);
		 g.addEdge(4, 1);
		 g.addEdge(2, 3);
		 g.addEdge(3, 1);
		
		 System.out.println("Following is a Topological sort of the given graph");
		 g.topologicalSort();
	 }
}
