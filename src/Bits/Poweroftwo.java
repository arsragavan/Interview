/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package Bits;

public class Poweroftwo {
	public static void main(String args[]) {
		int n = 64;
		if ((n & n - 1) == 0) {
			System.out.println("Yes");
			// position of bit set
			System.out.println(Math.log(n) / Math.log(2) + 1);

		}

	}
}
