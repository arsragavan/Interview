/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

public class Power {

    public static long power(int a, int n, Long[] pow) {
        if (pow[n] != null) {
            return pow[n];
        }
        if (n == 0) {
            pow[0] = 1L;

        } else if (n == 1) {
            pow[1] = (long) a;

        } else {
            pow[n] = power(a, n / 2, pow) * power(a, n - n / 2, pow);
        }

        return pow[n];

    }
    public static long ipower(int a, int n) {
        long [] pow = new long[n+1];
        pow[0] = 1;
        pow[1] = a;
        for (int i = 2;i<=n;i++) {
            pow[i] = pow[i/2]*pow[i-i/2];
        }
        return pow[n];

    }

    public static void main(String args[]) {
        
        System.out.println(power(2, 7,new Long[8]));
        System.out.println(ipower(2,7));
    }
}
