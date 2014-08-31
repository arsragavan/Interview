/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
public class BFS {
    public static void bfs(int[][] adjacency) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int [] graph = {0,1,2,3,4,5};
        boolean [] visited = new boolean[graph.length];
        queue.add(graph[0]);
        visited [0] = true;
        while(!queue.isEmpty()) {
            int temp = queue.remove();
            for(int j = 0;j<graph.length;j++) {
                if (!visited[j] && adjacency[temp][j] == 1) {
                    queue.add(j);
                    visited[j]= true;
                }
                    
            }
                
            System.out.print(temp+" ");
        }
    }
    public static void dfs(int[][] adjacency) {
        Stack<Integer> stack = new Stack<Integer>();
        int [] graph = {0,1,2,3,4,5};
        boolean [] visited = new boolean[graph.length];
        stack.push(graph[0]);
        visited [0] = true;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int j = 0;j<graph.length;j++) {
                if (!visited[j] && adjacency[temp][j] == 1) {
                    stack.push(j);
                    visited[j]= true;
                }
            }
            System.out.print(temp+" ");
        }
    }
    public static void main(String args[]) {
        int [][] adjacency = {{0,1,0,1,0,0},{1,0,1,0,0,0},{0,1,0,1,0,0},{1,0,1,0,1,1},{0,0,0,1,1,0}};
        bfs(adjacency);
        System.out.println("");
        dfs(adjacency);
        
        
        
    }

}
