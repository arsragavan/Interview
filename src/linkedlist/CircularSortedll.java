/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist;


class CircularlySortedLL {
    
    private int data;
    private CircularlySortedLL next;
    
    public CircularlySortedLL(int data) {
        this.data = data;
        this.next = this;
    }
    public void display() {
        CircularlySortedLL current = this;
         do {
        	 System.out.print(current.data+"->");
             current = current.next;            
        }while(current != this);
    }
    public CircularlySortedLL insert(int value) {
    	CircularlySortedLL header = this;
    	CircularlySortedLL temp = new CircularlySortedLL(value);
    	CircularlySortedLL current = this;
    	if (header.data > value) {
    		temp.next = header;
    		while (current.next != header)
    			current = current.next;
    		current.next = temp;
    		header = temp;
    	}
    	else {
    		CircularlySortedLL prev = header;
        	current = header.next;
    		while (value > current.data && current != header) {
    			prev = current;
    			current = current.next;
    		}
    		prev.next = temp;
    		temp.next = current;
    	}
    	return header;
    }
    public CircularlySortedLL delete(int value) {
    	CircularlySortedLL header = this;
    	CircularlySortedLL prev = header;
    	CircularlySortedLL current = header.next;
    	while (current.data != value && current != header) {
    		prev = current;
    		current = current.next;
    	}
    	if (current.data == value) {
    		if (current == header)
    			header = current.next;
    		prev.next = current.next;
    		current = null;
    	}
    	return header;
    }
}

public class CircularSortedll {
    
    public static void main(String args[]) {
        CircularlySortedLL header = new CircularlySortedLL(0);
        
        header = header.insert(3);
        header = header.insert(1);
        header = header.insert(8);
        header = header.insert(2);
        
        header = header.insert(-6);
        header = header.insert(-4);
        
        header.display();
        
        System.out.println();
        header = header.delete(3);
        
        header.display();
        System.out.println();
        header = header.delete(-6);        
        //header = header.insert(-6);
        header.display();
    }
   
}
