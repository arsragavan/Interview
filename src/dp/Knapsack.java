/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;


public class Knapsack {
    
    //O(2^n)
	public static int sack(int [] w, int [] c, int capacity,int n) {
        if (n == 0 || capacity == 0)
            return 0;
        if (w[n-1] <= capacity)
            return Math.max(c[n-1]+sack(w,c,capacity-w[n-1],n-1), sack(w,c,capacity,n-1));
        else
            return sack(w,c,capacity,n-1);
    }
	
	//O(n*capacity)
    public static int dpSack(int [] w, int [] c, int capacity,int n) {
        int [][] sack = new int [n+1][capacity+1];
    	for(int i = 0;i<=n;i++){
            for (int j = 0;j<=capacity;j++) {
                if (i==0 || j==0)
                    sack[i][j] = 0;
                else if (w[i-1] <= j)
                	sack[i][j] = Math.max(c[i-1]+sack[i-1][j-w[i-1]], sack[i-1][j]);
                else
                	sack[i][j] = sack[i-1][j];
            }
        }
        return sack[n][capacity];
    }
    
    public static void main(String args[]) {
        int [] w = {1, 1, 1};
        int [] c = {30, 20, 10};
        System.out.println(sack(w, c, 2, w.length));
        System.out.println(dpSack(w, c, 2, w.length));
    }

}
