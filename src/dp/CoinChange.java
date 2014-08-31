/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.HashMap;


public class CoinChange {
    
    //O(2^n)
	public static int change(int[]coin,int coins, int totalVal) {
        if (totalVal == 0)
            return 1;
        if (totalVal < 0)
            return 0;
        if (coins <=0 && totalVal > 0)
        	return 0;
        return (change(coin,coins-1, totalVal)+change(coin, coins, totalVal-coin[coins-1]));
    }
	//O(coins*totalVal)
    public static int dpChange(int[]coin,int coins, int totalVal, Integer ways[][]) {
    	if (totalVal < 0)
            return 0;
        if (coins <=0 && totalVal > 0)
            return 0;
    	if (ways[coins-1][totalVal] != null)
    		return ways[coins-1][totalVal];        	
    	if (totalVal == 0)
    		ways[coins-1][totalVal] = 1;
    	else
    		ways[coins-1][totalVal] = dpChange(coin,coins-1,totalVal,ways)+dpChange(coin, coins, totalVal-coin[coins-1],ways);
        return ways[coins-1][totalVal];
    }
    public static void main(String args[]) {
        int [] coin = {1,2,3,5};
        System.out.println(change(coin, coin.length, 1000));
        System.out.println(dpChange(coin, coin.length, 1000, new Integer[coin.length][1000+1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
    }

}
