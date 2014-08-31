package linkedlist;

import java.util.Hashtable;

import trees.BST;

class SinglyLL {
    
    int data;
    SinglyLL next;
    
    public SinglyLL(int data) {
        this.data = data;
        this.next = null;
    }
    
    public void display() {
    	System.out.print("List :");
    	SinglyLL current = this;
        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println();
    }
    public SinglyLL insert(SinglyLL header,int pos, int value) {
        
        SinglyLL temp = new SinglyLL(value);
        if (header == null)
        	return temp;
        if (pos == 1) {
        	temp.next = header;
        	return temp;
        }
        SinglyLL prev = header;
        while(pos > 2 && prev.next != null) {
    		prev = prev.next;
    		pos--;
    	}
        temp.next = prev.next;
    	prev.next = temp;
    	return header;    	
    }
    
    public SinglyLL insertFirst(int value) {
        SinglyLL temp = new SinglyLL(value);
        temp.next = this;
        return temp;
    }
    public SinglyLL reverse() {
        SinglyLL prev = null;
        SinglyLL temp = this;
        SinglyLL header = this;
        while(temp != null) {
            header = temp;
            temp =temp.next;
            header.next = prev;
            prev = header;
        }
        return header;
    }
    public SinglyLL kreverse(int k) {
        SinglyLL prev = null;
        SinglyLL temp = this;
        SinglyLL header = this;
        SinglyLL firstHeader = null;
        SinglyLL prevHeader = null;
        int count=0,revCount = 0;
        while(temp!= null) {
        	header = temp;
        	temp =temp.next;
            header.next = prev;
            prev = header;
            count++;
            revCount++;
            if (count == k) {
            	if (prevHeader != null)
            		prevHeader.next = header;
            	if (revCount == k)
            		firstHeader = header;
            	while (count > 1) {
            		header = header.next;
            		count--;
            	}
            	prevHeader = header;
            	header.next = temp;
            	count = 0;
                prev = null;
            }
        }
        if (count != 0 && prevHeader != null)
        prevHeader.next = header;
        if (firstHeader != null)
        	return firstHeader;
        else
        	return header;
    }
    public SinglyLL rreverse(SinglyLL first) {
        SinglyLL rest = first.next;
        if (rest == null) {
            return first;
        }
        rest = rreverse(rest);
        first.next.next = first;
        first.next = null;
        return rest;
    }
    
    public void findIntersect(SinglyLL header1, SinglyLL header2) {
        Hashtable<SinglyLL,Integer> hashTable = new Hashtable<>();
        SinglyLL current = header1;
        int i = 1;
        while(current != null) {
            hashTable.put(current, i);
            i++;
            current = current.next;
        }
        current = header2;
        while(current != null) {
            if (hashTable.containsKey(current))
                System.out.println("Intersecting at "+current.data);
            current = current.next;
        }
    }
    
    public SinglyLL twoWayMerge (SinglyLL header1, SinglyLL header2) {
        SinglyLL header = header1;
        while(header2!= null) {
            SinglyLL temp = header2.next;
            header2.next = header1.next;
            header1.next = header2;
            header1 = header2.next;
            header2 = temp;
        }
        return header;
    }
    
    public void swapKthKthLast(SinglyLL header, int k) {
        SinglyLL temp = header;
        int n=1;
        while(n < k) {
            temp = temp.next;
            n++;
        }
        SinglyLL kthNode = temp;
        SinglyLL kthLastNode = header;
        while(temp.next != null) {
            kthLastNode = kthLastNode.next;
            temp = temp.next;
        }
        int tmp = kthNode.data;
        kthNode.data = kthLastNode.data;
        kthLastNode.data = tmp;        
    }
    public SinglyLL interweave(SinglyLL header) {
    	SinglyLL slow = header;
    	if (slow == null)
    		return header;
    	SinglyLL fast = header.next;
        while(fast != null){
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        SinglyLL header2 = slow.next;
        slow.next = null;
        header2 = header2.reverse();
        return twoWayMerge(header,header2);
    }
    
    public SinglyLL sumList(SinglyLL num1,SinglyLL num2) {
        
    	if (num1 == null)
        	return num2;
        if (num2 == null)
        	return num1;
    	
        num1 = num1.reverse();
        num2 = num2.reverse();
        
        int carryVal = 0;
        SinglyLL sum = null;
        while(num1 != null && num2 != null) {
            int sumVal = num1.data + num2.data + carryVal;
            carryVal = sumVal/10;
            sumVal %=10;
            if (sum == null)
            	sum = new SinglyLL(sumVal);
            else
            	sum = sum.insertFirst(sumVal);
            num1 = num1.next;
            num2 = num2.next;
        }
        if (num1 != null) {
            int sumVal = num1.data + carryVal;
            carryVal = sumVal/10;
            sumVal %=10;
            if (sum == null)
            	sum = new SinglyLL(sumVal);
            else
            	sum = sum.insertFirst(sumVal);
            num1 = num1.next;
        }
        else if (num2 != null) {
            int sumVal = num2.data + carryVal;
            carryVal = sumVal/10;
            sumVal %=10;
            if (sum == null)
            	sum = new SinglyLL(sumVal);
            else
            	sum = sum.insertFirst(sumVal);     
            num2 = num2.next;
        }
        if (carryVal != 0)
        	sum = sum.insertFirst(carryVal);
        return sum;
        
    }
    static SinglyLL headNode;
    public BST listToBST(int n) {
    
    	if (n<=0)
            return null;
        BST leftNode = listToBST(n/2);
        BST root = new BST(headNode.data);
        root.left = leftNode;
        headNode = headNode.next;
        BST rightNode = listToBST(n-(n/2)-1);
        root.right = rightNode;
        return root;
    }
}
public class Singlell {
     
    public static void main(String args[]) {
        SinglyLL header = new SinglyLL(9);
        header = header.insertFirst(5);
        header = header.insertFirst(1);
        header = header.insertFirst(5);
        
        SinglyLL.headNode = header;
        BST root = header.listToBST(3);
        root.inorder(root);
    }
}