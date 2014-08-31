/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package QueueStack;

class StakImpl {
    int[] stackArray;
    int topOfStack;
    int size;
    
    public StakImpl(int size) {
        stackArray = new int[size];
        topOfStack = -1;
        this.size = size;
    }
    
    public void push(int x) {
        if (topOfStack+1 < size) {
            stackArray[++topOfStack] = x;
        }
    }
    
    public int pop() {
        if (topOfStack >= 0)
            return stackArray[topOfStack--];
        return Integer.MIN_VALUE;
    }
    public void display() {
        
        int i = topOfStack;
        while(i >= 0)
            System.out.println(stackArray[i--]);
    }
    public boolean isEmpty() {
        return (this.topOfStack == -1);
    }
    public int peek() {
        return (this.stackArray[topOfStack]);
    }
    public void sort() {
        StakImpl temp = new StakImpl(this.size);
        while(!this.isEmpty()) {
            temp.push(this.pop());
        }
        while(!temp.isEmpty()) {
            if (this.isEmpty() || temp.peek() < this.peek())
                this.push(temp.pop());
            else {
                int x = temp.pop();
                while(!this.isEmpty() && this.peek() < x)
                    temp.push(this.pop());
                this.push(x);
            }
        }
    }
    public void pushToBottom(int x) {
        if (this.isEmpty())
            this.push(x);
        else {
            int tmp = this.pop();
            pushToBottom(x);
            this.push(tmp);
        }
    }
    public void reverse() {
        if (!this.isEmpty()) {
            int x= this.pop();
            this.reverse();
            this.pushToBottom(x);
        }
    }
}

public class ImplStack {
    
    public static void main(String args[]) {
        StakImpl stack = new StakImpl(10);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        
        System.out.println("Reverse");
        stack.reverse();
        stack.display();
        
        System.out.println("Sort");
        stack.sort();
        stack.display();
        
        
        
    }
    

}
