/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class BFS {
	public static void bfs(int[][] adjacency) {
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> graph = new ArrayList<Integer>();
		int i = 0;
		while (i < adjacency.length)
			graph.add(i++);
		boolean[] visited = new boolean[graph.size()];
		queue.add(graph.get(0));
		visited[0] = true;
		while (!queue.isEmpty()) {
			System.out.println(queue);
			int temp = queue.remove();
			for (int j = 0; j < graph.size(); j++) {
				if (!visited[j] && adjacency[temp][j] == 1) {
					queue.add(j);
					visited[j] = true;
					graph.remove(j);
				}
			}
			System.out.print(temp + " ");
		}
	}
	public static void dfs(int[][] adjacency) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] graph = {0, 1, 2, 3, 4, 5};
		boolean[] visited = new boolean[graph.length];
		stack.push(graph[0]);
		visited[0] = true;
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			for (int j = 0; j < graph.length; j++) {
				if (!visited[j] && adjacency[temp][j] == 1) {
					stack.push(j);
					visited[j] = true;
				}
			}
			System.out.print(temp + " ");
		}
	}
	public static void main(String args[]) {
		int[][] adjacency = {{0, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 0, 0},
				{0, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1}, {0, 0, 0, 1, 1, 1}};
		bfs(adjacency);
		System.out.println("");
		dfs(adjacency);

	}

}
