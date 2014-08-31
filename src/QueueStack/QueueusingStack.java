/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package QueueStack;

import java.util.Stack;
class Queue2Stacks {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> supporting = new Stack<>();
    
    public Queue2Stacks() {
        mainStack = new Stack<>();
        supporting = new Stack<>();
    }
    
    public void enqueu(int x) {
        mainStack.push(x);
    }
    public void dequeue() {
        while (!mainStack.isEmpty()) {
            supporting.push(mainStack.pop());
        }

        if (!supporting.isEmpty())
            supporting.pop();
        while(!supporting.isEmpty()) {
            mainStack.push(supporting.pop());
        }
    }
    public void print() {
        disp(mainStack);
    }
    public void disp(Stack<Integer> mainStack) {
        if(mainStack.isEmpty())
            return;
        else {
            Integer x = mainStack.pop();
            disp(mainStack);
            mainStack.push(x);
            System.out.print(x+" ");
        }
            
    }
    
}

public class QueueusingStack {
    
    public static Stack<Integer> enqueue(Stack s1,int x) {
        s1.push(x);
        return s1;
    }
    public static Stack<Integer> dequeue(Stack s1, Stack s2) {
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s2.pop();
        while(!s2.isEmpty())
            s1.push(s2.pop());
        return (s1);
    }
    public static void display(Stack<Integer> s1) {
        int x;
        if (!s1.isEmpty()) {
            x = s1.pop();
            display(s1);
            System.out.print(x+" ");
        }
    }
    public static void main(String args[]) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        enqueue(s1, 1);
        enqueue(s1, 2);
        enqueue(s1, 3);
        enqueue(s1, 4);
        enqueue(s1, 5);
        enqueue(s1, 6);
        
        s1 = dequeue(s1, s2);
        
        display(s1);
        System.out.println("Queue 2");
        Queue2Stacks queue = new Queue2Stacks();
        queue.enqueu(1);
        queue.enqueu(2);
        queue.enqueu(3);
        queue.enqueu(4);
        queue.enqueu(6);
        queue.print();
        System.out.println("Insertion");
        queue.dequeue();
        System.out.println("After deleting");
        queue.print();
        queue.enqueu(5);
        System.out.println("Insertion");
        queue.print();
        
        
        
    }

}
