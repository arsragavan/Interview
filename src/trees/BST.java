package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

	int value;
	public BST left;
	public BST right;
	BST parent;
	BST sibling;
	static int preIndex;
	static int postIndex;
	static boolean printed;
	static int count;

	public BST(int value) {
		this.value = value;
	}

	public void klargest(BST root, int k) {
		if (root != null) {
			klargest(root.right, k);
			count++;
			if (count == k) {
				System.out.println(root.value);
			}
			klargest(root.left, k);
		}
	}

	public void ksmallest(BST root, int k) {
		if (root != null) {
			ksmallest(root.left, k);
			count++;
			if (count == k) {
				System.out.println(root.value);
			}
			ksmallest(root.right, k);
		}
	}

	public String inorderCommas(BST root, String inOrder) {
		if (root != null) {
			inOrder = inorderCommas(root.left, inOrder);
			if (inOrder.length() > 0)
				inOrder = inOrder.substring(0, inOrder.length() - 1) + ",";
			inOrder = inOrder + root.value + ".";
			inOrder = inorderCommas(root.right, inOrder);
		}
		return inOrder;
	}

	public void inorder(BST root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.value + "->");
			inorder(root.right);
		}
	}

	public BST insert(BST root, int x) {
		if (root == null) {
			root = new BST(x);
		} else if (x < root.value) {
			root.left = insert(root.left, x);
		} else if (x > root.value) {
			root.right = insert(root.right, x);
		}
		return root;
	}

	public BST find_min(BST root) {
		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public BST delete(BST root, int x) {
		if (root == null) {
			return null;
		} else if (x < root.value) {
			root.left = delete(root.left, x);
		} else if (x > root.value) {
			root.right = delete(root.right, x);
		} else {
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				BST temp = find_min(root.right);
				root.value = temp.value;
				root.right = delete(root.right, temp.value);
			}
		}
		return root;
	}

	public boolean isBST(BST root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.value > min && root.value < max
				&& isBST(root.left, min, root.value)
				&& isBST(root.right, root.value, max)) {
			return true;
		}
		return false;
	}

	public int height(BST root) {
		if (root == null) {
			return -1;
		}
		return (1 + Math.max(height(root.left), height(root.right)));
	}

	public boolean isBalanced(BST root) {
		if (root == null) {
			return true;
		}
		if (isBalanced(root.left) && isBalanced(root.right)
				&& (Math.abs(height(root.left) - height(root.right)) <= 1)) {
			return true;
		}
		return false;
	}

	public void levelTraversal(BST root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.value + "->");
		} else {
			levelTraversal(root.left, level - 1);
			levelTraversal(root.right, level - 1);
		}
	}

	public void levelOrder(BST root, int level, int height) {
		if (root == null) {
			return;
		}
		Queue<BST> queue = new LinkedList<BST>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BST temp = queue.remove();
			System.out.print(temp.value + "->");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	// zig-zag traversal
	public void spiralOrder(BST root) {
		if (root == null)
			return;
		Stack<BST> s1 = new Stack<>(); // prints right to left
		Stack<BST> s2 = new Stack<>(); // prints left to right
		s1.push(root);
		BST temp;
		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				temp = s1.pop();
				System.out.print(temp.value + "->");
				if (temp.right != null)
					s2.push(temp.right);
				if (temp.left != null)
					s2.push(temp.left);
			}
			while (!s2.isEmpty()) {
				temp = s2.pop();
				System.out.print(temp.value + "->");
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);

			}
		}
	}

	static int maxLevel = -1;

	public void leftView(BST root, int level) {
		if (root != null) {
			System.out.println(root.value + " " + level + " " + maxLevel);
			if (level > maxLevel) {
				System.out.println(root.value);
				maxLevel = level;
			}
			leftView(root.left, level + 1);
			leftView(root.right, level + 1);
		}
	}

	public BST lca(BST root, int a, int b) {
		if (root == null)
			return null;
		if (root.value == a || root.value == b)
			return root;
		BST left = lca(root.left, a, b);
		BST right = lca(root.right, a, b);
		if (left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else if (right != null)
			return right;
		else
			return null;
	}

	public void printLeaves(BST root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.print(root.value + "->");
		} else {
			printLeaves(root.left);
			printLeaves(root.right);
		}
	}

	public boolean isLeaf(BST root) {
		return (root != null && (root.left == null || root.right == null));
	}

	public boolean isLeft(BST root, BST node) {
		if (root == null) {
			return false;
		}
		return (root.left == node || isLeft(root.left, node) || isLeft(
				root.right, node));
	}

	public boolean isDeep(BST root, BST node, int height) {
		if (root == null || node == null) {
			return false;
		}
		return ((height == 1 && (root.left == node || root.right == node))
				|| (isDeep(root.left, node, height - 1)) || (isDeep(root.right,
					node, height - 1)));
	}

	public boolean isDeepest(BST root, BST node) {
		return (isDeep(root, node, height(root)));
	}

	public void iterativeInorder(BST root) {
		Stack<BST> stack = new Stack<>();
		while (root != null || !(stack.isEmpty())) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.value + "->");
				root = root.right;
			}
		}
	}

	public void iterativePreorder(BST root) {
		Stack<BST> stack = new Stack<BST>();
		while (root != null || !(stack.isEmpty())) {
			if (root != null) {
				stack.push(root);
				System.out.print(root.value + "->");
				root = root.left;
			} else {
				root = stack.pop();
				root = root.right;
			}
		}
	}

	public void iterativePostorder(BST root) {
		Stack<BST> stack = new Stack<BST>();
		BST lastVisited = null;
		BST temp;
		while (root != null || !(stack.isEmpty())) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.peek().right != null
						&& stack.peek().right != lastVisited) {
					root = stack.peek().right;
				} else {
					temp = stack.pop();
					System.out.print(temp.value + "->");
					lastVisited = temp;
				}
			}
		}
	}

	public void iterativePostorderWith2Stacks(BST root) {
		Stack<BST> stack1 = new Stack<BST>();
		Stack<BST> stack2 = new Stack<BST>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			BST temp = stack1.pop();
			stack2.push(temp);
			if (temp.left != null)
				stack1.push(temp.left);
			if (temp.right != null)
				stack1.push(temp.right);
		}
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().value);
		}
	}

	public BST buildPrePost(int[] preOrder, int[] postOrder, int postStart,
			int postEnd, int n) {
		if (postStart > postEnd || preIndex >= n) {
			return null;
		}
		BST root = new BST(preOrder[preIndex++]);
		int i = 0;
		if (postStart == postEnd) {
			return root;
		}
		for (i = postStart; i <= postEnd; i++) {
			if (postOrder[i] == preOrder[preIndex]) {
				break;
			}
		}
		root.left = buildPrePost(preOrder, postOrder, postStart, i, n);
		root.right = buildPrePost(preOrder, postOrder, i + 1, postEnd - 1, n);

		return root;
	}

	public BST buildPreIn(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		BST root = new BST(preOrder[preIndex++]);
		if (inStart == inEnd) {
			return root;
		}
		int i = 0;
		for (i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == root.value) {
				break;
			}
		}
		root.left = buildPreIn(preOrder, inOrder, inStart, i - 1);
		root.right = buildPreIn(preOrder, inOrder, i + 1, inEnd);
		return root;
	}

	public BST buildPostIn(int[] postOrder, int[] inOrder, int inStart,
			int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		BST root = new BST(postOrder[postIndex--]);
		if (inStart == inEnd) {
			return root;
		}
		int i = 0;
		for (i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == root.value) {
				break;
			}
		}
		root.right = buildPostIn(postOrder, inOrder, i + 1, inEnd);
		root.left = buildPostIn(postOrder, inOrder, inStart, i - 1);
		return root;
	}

	public int diffOddEven(BST root, int diff) {
		if (root == null) {
			return diff;
		}
		if (root.value % 2 == 0) {
			diff += root.value;
		} else {
			diff -= root.value;
		}
		diff = diffOddEven(root.left, diff);
		diff = diffOddEven(root.right, diff);
		return diff;
	}

	public BST removeRange(BST root, int min, int max) {
		if (root == null) {
			return null;
		}
		root.left = removeRange(root.left, min, max);
		root.right = removeRange(root.right, min, max);
		if (root.value < min) {
			return root.right;
		}
		if (root.value > max) {
			return root.left;
		}

		return root;
	}

	public BST convertToDll(BST root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			BST leftNode = convertToDll(root.left);
			while (leftNode.right != null) {
				leftNode = leftNode.right;
			}
			leftNode.right = root;
			root.left = leftNode;
		}
		if (root.right != null) {
			BST rightNode = convertToDll(root.right);
			while (rightNode.left != null) {
				rightNode = rightNode.left;
			}
			rightNode.left = root;
			root.right = rightNode;
		}
		return root;
	}

	public BST buildTree(ArrayList<Integer> preOrder) {
		if (preOrder.isEmpty()) {
			return null;
		}
		BST root = new BST(preOrder.get(0));
		ArrayList<Integer> lessPre = new ArrayList<Integer>();
		ArrayList<Integer> greatPre = new ArrayList<Integer>();
		int i = 1;

		while (i < preOrder.size() && preOrder.get(i) < root.value) {
			lessPre.add(preOrder.get(i++));
		}

		while (i < preOrder.size()) {
			greatPre.add(preOrder.get(i++));
		}
		root.left = buildTree(lessPre);
		root.right = buildTree(greatPre);
		return root;
	}

	public BST mirror(BST root) {
		if (root == null) {
			return null;
		}
		BST temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
		return root;
	}

	public boolean isMirror(BST root1, BST root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return ((root1.left == root2.right || root1.left.value == root2.right.value)
				&& (root1.right == root2.left || root1.right.value == root2.left.value)
				&& (isMirror(root1.left, root2.right)) && (isMirror(
					root1.right, root2.left)));

	}

	public int totalSumTree(BST root) {
		if (root == null) {
			return 0;
		}
		root.value += totalSumTree(root.left) + totalSumTree(root.right);
		return root.value;
	}

	public int sumTree(BST root, int sum) {
		if (root == null) {
			return sum;
		}
		sum = sumTree(root.right, sum);
		root.value += sum;
		sum = sumTree(root.left, root.value);
		return (sum);
	}

	public BST inorderSuccessor(BST node) {
		if (node.right != null) {
			return find_min(node.right);
		}
		BST parentNode = node.parent;
		while (parentNode != null && parentNode.right == node) {
			node = parentNode;
			parentNode = parentNode.parent;
		}
		return parentNode;
	}

	public BST createSibling(BST root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left.sibling = root.right;
		}
		if (root.right != null) {
			if (root.sibling != null) {
				root.right.sibling = root.sibling.left;
			}
		}
		createSibling(root.left);
		createSibling(root.right);
		return root;
	}

	public int inorderPredecessor(BST root, int x, int pre) {
		if (root != null) {
			pre = inorderPredecessor(root.left, x, pre);
			if (root.value == x) {
				System.out.println("Predecessor = " + pre);
				return pre;
			}
			pre = inorderPredecessor(root.right, x, root.value);
		}
		return pre;
	}

	static boolean succ;

	public void inorderSuccessor(BST root, int x) {
		if (root != null) {
			inorderSuccessor(root.left, x);
			if (root.value == x) {
				succ = true;
			} else if (succ) {
				System.out.println("Successor = " + root.value);
				succ = false;
				return;
			}
			inorderSuccessor(root.right, x);
		}
	}

	public void nodeToLeaf(BST root, String path, int sum) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(path + root.value + ":" + (sum + root.value));
		} else {
			nodeToLeaf(root.left, path + root.value + " ", sum + root.value);
			nodeToLeaf(root.right, path + root.value + " ", sum + root.value);
		}
	}

	public void allLevelsPrint(BST root) {
		if (root != null) {
			nodeToLeaf(root, "", 0);
			allLevelsPrint(root.left);
			allLevelsPrint(root.right);
		}
	}

	// Binary tree

	public int kDistanceAboveNode(BST root, BST node, int k) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		if (root == node) {
			return 0;
		}
		int lD = kDistanceAboveNode(root.left, node, k) + 1;
		int rD = kDistanceAboveNode(root.right, node, k) + 1;
		if (lD == k || rD == k) {
			System.out.println("Kth distance above node = " + root.value);
		}
		return Math.max(lD, rD);
	}

	public int kDistanceFromLeaf(BST root, int k) {
		if (root == null) {
			return -1;
		}
		int lDistance = 1 + kDistanceFromLeaf(root.left, k);
		int rDistance = 1 + kDistanceFromLeaf(root.right, k);
		int maxVal = Math.max(lDistance, rDistance);
		if (k == 0) {
			if (lDistance == k && rDistance == k) {
				System.out.println(root.value);
			}
		} else {
			if (lDistance == k || rDistance == k) {
				System.out.println(root.value);
			}
		}
		return maxVal;
	}

	public int closestValue(BST root, int k) {
		int closest = Integer.MAX_VALUE;
		while (root != null) {
			int distance = Math.abs(k - root.value);
			if (distance < Math.abs(closest - k)) {
				closest = root.value;
			}

			if (root.value == k)
				return k;
			else if (root.value > k)
				root = root.left;
			else
				root = root.right;
		}
		return closest;
	}

	static int currentIndex;

	public BST sortedArraytoBalancedBST(int[] a, int n) {
		if (n <= 0)
			return null;
		BST leftNode = sortedArraytoBalancedBST(a, n / 2);
		BST root = new BST(a[currentIndex++]);
		root.left = leftNode;
		BST rightNode = sortedArraytoBalancedBST(a, n - 1 - n / 2);
		root.right = rightNode;
		return root;
	}
}
