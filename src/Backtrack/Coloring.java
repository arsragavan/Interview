/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Backtrack;


public class Coloring {
    
    static int[][] adjacency = {{0,1,1}
                               ,{1,0,1}
                               ,{1,1,0}};
                              // ,{1,0,1,0}};
    static int[] color = new int[adjacency.length];
    
    public static boolean coloring(int vertex, int maxColors) {
        if (vertex >= adjacency.length)
            return true;
        for(int i = 1; i<=maxColors;i++)
            if(isSafe(vertex, i)) {
                color[vertex] = i;
                if (coloring(vertex+1,maxColors))
                    return true;
                color[vertex] = 0;
            }
        return false;
    }
    public static boolean isSafe(int edge, int c) {
        for(int i = 0; i<adjacency[edge].length;i++)
            if (adjacency[edge][i]==1 && color[i] == c)
                return false;
        return true;
    }
    
    public static void main(String args[]) {
        if (coloring(0, 3))
            for(int i=0;i<adjacency.length;i++)
                System.out.println((i+1)+":"+color[i]);
    }
}
