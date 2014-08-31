/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :
package trees;



public class BinarySearchTree {

    public static void main(String args[]) {
        BST root = new BST(1);
        //root.left = new BST(2);
        root.right = new BST(3);
        //root.left.left = new BST(7);
        //root.left.right = new BST(6);
        root.right.left = new BST(5);
        root.right.right = new BST(4);
        
        root.spiralOrder(root);
        
        //root.kDistanceFromLeaf(root, 2);
        

        
    }
}
