/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package arrays;

public class Multiplication {
    
    public static void multi(int n) {
        int [][] table = new int[n+1][n+1];
        
        
        int i = 0;
        while(i <= n) {
            table[0][i] = i;
            table[i][0] = i;
            i++;
        }
        for(i=1;i<=n;i++) {
            for(int j=i;j<=n;j++) {
                table[i][j] = i*j;
                table[j][i] = i*j;
            }
        }
        for(i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println("");
        }
            
    }
    public static void main(String args[]) {
        multi(5);
        
    }

}
