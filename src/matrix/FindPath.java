package matrix;

public class FindPath {

	static int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0},
			{1, 1, 1, 1}};
	static int[][] path = new int[maze.length][maze[0].length];

	public static Integer findPath(int startX, int startY, int endX, int endY) {
		if (startX == endX && startY == endY)
			return 0;
		if (endX > 0 && maze[endX - 1][endY] == 1 && endY > 0
				&& maze[endX][endY - 1] == 1)
			return 1 + Math.min(findPath(startX, startY, endX - 1, endY),
					findPath(startX, startY, endX, endY - 1));
		if (endX > 0 && maze[endX - 1][endY] == 1)
			return 1 + findPath(startX, startY, endX - 1, endY);
		if (endY > 0 && maze[endX][endY - 1] == 1)
			return 1 + findPath(startX, startY, endX, endY - 1);
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) {

		System.out.println(findPath(0, 0, 3, 3));

	}

}
