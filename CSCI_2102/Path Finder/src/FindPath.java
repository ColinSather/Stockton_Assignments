import java.util.Arrays;

public class FindPath {
	static void printMat(int[][] mat) {
		for (int[] row : mat) {
			System.out.println(Arrays.toString(row));
		}
	}
	public static int moveRight(int[][] mat) {
		int count = 0;
		for (int[] row : mat) {
			for (int i = 0; i < row.length; i++) {
					if (row[i] != 0) {
						count += row[i];
						System.out.println(count);
					}
					
					else 
						System.out.println("Wall can't move this way | Count is : "+count);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// 2 = mat[0][0] is the starting point
		// 3 = mat[4][5] is the finishing point
		int[][] mat = { {2,1,0,0},
						{1,1,1,0},
						{0,1,1,1},
						{1,0,1,3} };
		printMat(mat);
		moveRight(mat);
	}

}
