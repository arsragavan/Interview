package matrix;

public class RowColumnSorted {
	
	static int [] [] matrix= {{1,5,6,7}
							 ,{2,8,11,12}
							 ,{3,9,13,15}
							 ,{4,10,14,16}};
	
	public static boolean search (int element, int rows, int cols) {
		int i = 0, j = cols-1;
		while (i < rows && j >= 0) {
			if (matrix[i][j] == element) {
				System.out.println("Element found at pos : "+(i+1)+" "+(j+1));
				return true;
			}
				
			if (matrix[i][j] < element)
				i++;
			else
				j--;
		}
		return false;
	}
	public static void main(String[] args) {
		search(12,matrix.length,matrix[0].length);
	}

}
