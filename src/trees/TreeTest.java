package trees;

public class TreeTest {

	public static void main(String[] args) {

		BST root = new BST(4);
		root.insert(root, 2);
		root.insert(root, 1);
		root.insert(root, 3);
		root.insert(root, 6);
		root.insert(root, 5);
		root.insert(root, 7);

		// root.leftView(root, 0);

		BST lca = root.lca(root, 2, 1);

		System.out.println(lca.value);

		// root.iterativePostorderWith2Stacks(root);

	}
}
