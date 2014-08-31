package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

	static int [] [] graphAdjacency   = {{0, 1, 0, 1},
										 {1, 0, 1, 0},
										 {0, 1, 0, 1},
										 {1, 0, 1, 0}};
	
	//O(n^2) -> n = no of vertices
	public static boolean isBipartite() {
		
		char [] colors = new char[graphAdjacency.length];
		//queue to maintain adjacent nodes
		Queue<Integer> queue = new LinkedList<>();
		//coloring the first vertex 'R'
		int i = 0;
		queue.add(i);
		colors [i] = 'R';
		while(!queue.isEmpty()) {
			//take one vertex
			int temp = queue.remove();
			//traverse all the adjacent vertices
			for (int j = 0;j<graphAdjacency.length;j++) {
				//if the vertex is adjacent
				if (graphAdjacency[temp][j] == 1) {
					//if the current vertex color is 'R'
					if (colors[temp] == 'R') {
						//adjacent vertex is also 'R' so not a bi-partite graph
						if (colors[j] == 'R')
							return false;
						// if the adjacent vertex is not colored so far color it 'B' and add to queue
						else if (colors[j] != 'B') {
							colors[j] = 'B';
							queue.add(j);
						}							
					}
					//if the current vertex color is 'R'
					else {
						//adjacent vertex is also 'B' so not a bi-partite graph
						if (colors[j] == 'B')
							return false;
						// if the adjacent vertex is not colored so far color it 'R' and add to queue
						else if (colors[j] != 'R') {
							colors[j] = 'R';
							queue.add(j);
						}							
					}					
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
		System.out.println(isBipartite());
		
		
	}
}
