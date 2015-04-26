/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

public class MedianSorted {

    //O(m+n)
    public static float medianMergeArrays(int[] a, int[] b) {
        int i = 0, j = 0;
        int an = a.length;
        int bn = b.length;
        int n1,n2;

        int m = (an + bn-2) / 2;
        
        while (m > 0) {
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
            m--;
        }
        if (a[i] < b[j]) {
            n1= a[i];
            if (i < an-1 && a[i+1] < b[j])
                n2 = a[i+1];
            else
                n2=b[j];
        }
        else {
            n1= b[j];
            if (j < bn-1 && b[j+1] < a[i])
                n2 = b[j+1];
            else
                n2 = a[i];
        }
        return (float)(n1 + n2) / 2;
    }
    public static float median (int [] a, int start, int end) {
        int len = end-start+1;
        if (len%2 == 0)
            return (a[(start+len)/2]+a[(start+len)/2+1])/2;
        else
            return(a[(start+len)/2]);
    }
    //O(log min(n1,n2))
    public static float medianSplit(int []a, int aStart, int aEnd, int []b, int bStart, int bEnd) {
        if (aEnd == aStart || bEnd == bStart) {
            int [] newArr = new int[aEnd-aStart+1+bEnd-bStart+1];
            while(aStart <= aEnd) {
                newArr[aStart] = a[aStart]; 
                aStart++;
            }
            while(bStart <= bEnd) {
                newArr[bStart] = b[bStart]; 
                bStart++;
            }
            Arrays.sort(newArr);
            return median(newArr,0,newArr.length-1);
        }
            
        System.out.println(aStart+"a"+aEnd);
        float m1 = median(a,aStart,aEnd);
        System.out.println(bStart+"b"+bEnd);
        float m2 = median(b,bStart,bEnd);
        if(m1 == m2)
            return m1;
        else if (m1 < m2) 
            return medianSplit(a, aStart+aEnd/2, aEnd, b, bStart, bEnd/2);
        else
            return medianSplit(a, aStart, aEnd/2, b, bStart+bEnd/2, bEnd);
    }
    public static void main(String args[]) {
        int [] a = {10, 20, 30, 40, 50};
        int [] b = {1, 2, 3, 4, 5};
        System.out.println(medianMergeArrays(a, b));
        System.out.println(medianSplit(a, 0,4,b,0,4));
    }
}
