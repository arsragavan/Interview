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

class DoublyLL<E> {
	private E data;
	public DoublyLL<E> left;
	private DoublyLL<E> right;

	public DoublyLL(E data) {
		this.data = data;
	}

	public void display() {
		System.out.print("DLL :");
		DoublyLL<E> current = this;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.right;
		}
		System.out.println();
	}

	public void revdisplay() {
		DoublyLL<E> current = this;
		while (current.right != null)
			current = current.right;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.left;
		}
	}

	public DoublyLL<E> insertFirst(E value) {
		DoublyLL<E> temp = new DoublyLL<E>(value);
		temp.right = this;
		if (this != null)
			this.left = temp;
		return temp;
	}

	public DoublyLL<E> reverse() {
		DoublyLL<E> prev = null;
		DoublyLL<E> temp = this;
		DoublyLL<E> header = this;
		while (temp != null) {
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

	public DoublyLL<E> rreverse(DoublyLL<E> first) {
		DoublyLL<E> rest = first.right;
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
		DoublyLL<Integer> header = new DoublyLL<>(7);
		header = header.insertFirst(5);
		header = header.insertFirst(3);
		header = header.insertFirst(1);

		header.display();

		header = header.rreverse(header);
		while (header.left != null)
			header = header.left;
		header.display();

	}
}
