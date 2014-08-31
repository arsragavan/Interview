/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package linkedlist;


class DoublyLL {
    private int data;
    public DoublyLL left;
    private DoublyLL right;

    public DoublyLL(int data) {
        this.data = data;
    }
    
    public void display() {
        System.out.print("DLL :");
    	DoublyLL current = this;
        while(current != null) {
            System.out.print(current.data+"->");
            current = current.right;
        }
        System.out.println();
    }
    public void revdisplay() {
        DoublyLL current = this;
        while(current.right != null)
                current = current.right;
        while(current != null) {
            System.out.print(current.data+"->");
            current = current.left;
        }
    }
    public DoublyLL insertFirst(int value) {
        DoublyLL temp = new DoublyLL(value);
        temp.right = this;
        if (this != null)
            this.left = temp;
        return temp;
    }
    
    public DoublyLL reverse() {
        DoublyLL prev = null;
        DoublyLL temp = this;
        DoublyLL header = this;
        while(temp != null) {
            header = temp;
            header.left = null;
            temp = temp.right;
            header.right = prev;
            if (prev != null) {
                prev.left = header;
            }
            prev = header;
        }
        return header;
    }
    
    public DoublyLL rreverse(DoublyLL first) {
        DoublyLL rest = first.right;
        if (rest == null) {
            first.left = null;
            return first;
        }
        rest = rreverse(rest);
        rest.right = first;
        first.right = null;
        first.left = rest;
        return first;
    }
    
}


public class Doublell {
    public static void main(String args[]) {
        DoublyLL header = new DoublyLL(7);
        header = header.insertFirst(5);
        header = header.insertFirst(3);
        header = header.insertFirst(1);
        
        header.display();
        
        header = header.rreverse(header);
        while(header.left != null)
        	header = header.left;
        header.display();
        
    }
}
