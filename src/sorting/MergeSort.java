/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;


public class MergeSort {
    
    public static void merge(int [] a, int lstart, int lend, int rstart, int rend) {
        int tempIterator = lstart;
        int n = rend-lstart+1;
        int [] temp = new int[rend+1];
        while(lstart<=lend && rstart <= rend) {
            if(a[lstart] < a[rstart])
                temp[tempIterator++] = a[lstart++];
            else
                temp[tempIterator++] = a[rstart++];
        }
        while(lstart<=lend)
            temp[tempIterator++] = a[lstart++];
        while(rstart<=rend)
            temp[tempIterator++] = a[rstart++];
        while(n>0) {
            a[rend] = temp[rend];
            rend--;
            n--;
        }
            
        
    }
    public static void msort(int []a,int left, int right) {
        if (left<right) {
            int mid = (left+right)/2;
            msort(a,left,mid);
            msort(a,mid+1,right);
            merge(a,left,mid,mid+1,right);
        }
    }
    public static void main(String args[]) {
        int [] a = {7,0,5,8,3,2,1,9};
        msort(a, 0, a.length-1);
        
        for(int i = 0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }

}
