package trees;

class Tree {

	Tree left;
	Tree middle;
	Tree right;
	int value;

	public Tree(int value) {
		this.value = value;
	}

	public Tree insert(Tree root, int x) {
		// If root is null, create a node with x
		if (root == null)
			root = new Tree(x);
		// if root's values is equal to x, insert value in the middle node
		else if (root.value == x)
			root.middle = insert(root.middle, x);
		// if root's value is greater than x, insert in left
		else if (root.value > x)
			root.left = insert(root.left, x);
		// if root's value is less than x, insert in right
		else if (root.value < x)
			root.right = insert(root.right, x);
		return root;
	}

	public int findMin(Tree root) {
		while (root.left != null)
			root = root.left;
		return root.value;
	}

	public Tree delete(Tree root, int x) {
		if (root != null) {
			// element should be in left
			if (root.value > x)
				root.left = delete(root.left, x);
			// element should be in right
			else if (root.value < x)
				root.right = delete(root.right, x);
			// element found
			else if (root.value == x) {
				// middle node's value will always be equal to x
				root.middle = null;
				// if there are no child nodes make root null
				if (root.left == null && root.right == null)
					root = null;
				// if only right child
				else if (root.left == null)
					root = root.right;
				// if only left child
				else if (root.right == null)
					root = root.left;
				// if there are both left and right childs
				else {
					// replace root's value with min value in right and delete
					// that node
					int temp = findMin(root.right);
					root.value = temp;
					root.right = delete(root.right, temp);
				}
			}
		}
		return root;

	}

}

public class Trinary {

	public static void main(String[] args) {
		Tree tree = new Tree(5);
		tree = tree.insert(tree, 4);
		tree = tree.insert(tree, 9);
		tree = tree.insert(tree, 5);
		tree = tree.insert(tree, 7);
		tree = tree.insert(tree, 2);
		tree = tree.insert(tree, 2);

		System.out.println(tree.value);
		System.out.println(tree.left.value);
		System.out.println(tree.left.left.value);
		System.out.println(tree.left.left.middle.value);

		System.out.println(tree.middle.value);

		System.out.println(tree.right.value);
		System.out.println(tree.right.left.value);

		tree = tree.delete(tree, 4);
		System.out.println(tree.left.middle.value);
		tree = tree.delete(tree, 5);
		System.out.println(tree.value);
		System.out.println(tree.right.value);

	}

}
