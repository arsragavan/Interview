/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

public class MatrixPaths {
    
    public static int dpCountPath(int m, int n) {
        int [] [] count = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (i == 0 || j == 0)
                    count[i][j] = 1;
                else
                    count[i][j] = count[i-1][j]+count[i][j-1]+count[i-1][j-1];
            }
        }
        return count[m-1][n-1];
    }
    
    public static void main(String args[]) {
        System.out.println(dpCountPath(3, 3));       
        
        
    }
}
