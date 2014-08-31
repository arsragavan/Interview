/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package QueueStack;

class Stackset {
    int [] [] stack;
    int stacknum;
    int tos;
    int size;
    public Stackset(int sizeOfEachStack) {
        stack = new int[10][sizeOfEachStack];
        size = sizeOfEachStack;
        tos = -1;
        stacknum = -1;
    }
    public void display() {
        int i;
        if (tos==0)
            i=size-1;
        else
            i= --tos;
        int num = stacknum;
        while(num >= 0) {
            while(i >= 0) {
                System.out.println(stack[num][i]);
                i--;
            }
            i=size-1;
            num--;
        }
    }
    public void push(int x) {
        if(stacknum == -1 || tos == size) {
            stacknum++;
            tos = 0;
        }
            
        stack[stacknum][tos++] = x;
    }
    public int pop() {
        if (tos == 0) {
            stacknum--;
            tos = size-1;
            return stack[stacknum][size-1];
        }
        return stack[stacknum][--tos];
    }
}
public class SetOfStacks {
    
    public static void main(String args[]) {
        Stackset stackset = new Stackset(5);
        int i = 1;
        while(i < 21) {
            stackset.push(i);
            i++;
        }
        stackset.push(21);
        
        while(i > 0) {
            System.out.println(stackset.pop());
            i--;
        }
        stackset.push(25);
        stackset.push(35);
        stackset.push(45);
        stackset.push(55);
        stackset.push(65);
        
        stackset.display();
    }
}
