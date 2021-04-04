
import java.util.*;

public class ArrayListMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 2 Numberz");
		int x = in.nextInt();
		x = (int)(1+Math.random()*100);
		int y = in.nextInt();
		y = (int)(1+Math.random()*100);
		in.close();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> mat1 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat2 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat3 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat4 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat5 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat6 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat7 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat8 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat9 = new ArrayList<Integer>(Arrays.asList(x,y));
        ArrayList<Integer> mat10 = new ArrayList<Integer>(Arrays.asList(x,y));
        matrix.add(mat1);
        matrix.add(mat2);
        matrix.add(mat3);
        matrix.add(mat4);
        matrix.add(mat5);
        matrix.add(mat6);
        matrix.add(mat7);
        matrix.add(mat8);
        matrix.add(mat9);
        matrix.add(mat10);
        System.out.println(matrix.toString());
	}
}