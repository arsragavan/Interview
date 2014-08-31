/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

public class Quicksort {
    
    
    public static int partition(int[] a, int start, int end) {
        
        int pivot = end;//Use randomized partition for avoiding O(n2) complexity
        int pIndex = start;
        for (int i = start;i<end;i++) {
            if (a[i] <= a[pivot]) {
                int temp = a[pIndex];
                a[pIndex] = a[i];
                a[i] = temp;
                pIndex++;
            }
        }
        int temp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp;
        return pIndex;
    }
    
    public static void quicksort(int[]a,int start, int end) {
        if (start < end) {
            int pIndex = partition(a,start,end);
            quicksort(a,start,pIndex-1);
            quicksort(a,pIndex+1,end);
        }
    }
    
    public static void main(String args[]) {
        int [] a = {5,7,6,4,3};
        quicksort(a, 0, a.length-1);
        for(int i = 0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    
}