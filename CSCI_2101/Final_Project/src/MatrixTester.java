import java.util.Scanner;
public class MatrixTester {
  public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Enter amount of Rows");
	 int a;
	 int b;
	 a = in.nextInt();
	 System.out.println("Enter amount of Columns");
	 b = in.nextInt();
	 Matrix TestMat_1 = new Matrix(a,b);
	 Matrix TestMat_2 = new Matrix(a,b);
	 // displays rows and columns
	 System.out.println("Rows: "+TestMat_1.getRows());
	 System.out.println("Columns: "+TestMat_1.getCols());
	 // displays TestMat_1. (TestMat_1 = TestMat_2).
	 System.out.println("TestMat_1: ");
	 Matrix O = TestMat_1.display(TestMat_1);
	 System.out.println("TestMat_1 + TestMat_2 ");
	 // performs addition.
	 Matrix R = TestMat_1.addMat(TestMat_2);
	 //Transposes. 
	 System.out.println("Transposed TestMat_1 ");
	 Matrix T = TestMat_1.transpose(TestMat_1); 
	 System.out.println("is symmetric = "+O.isSymmetric(TestMat_1));
	 // check if TestMat_2 (R) is symmetric .
	 System.out.println("is symmetric = "+R.isSymmetric(TestMat_2));
	 if(O==T) {
	 	System.out.println("Trace of TestMat_1 = "+O.findTrace(O));	
	 }
	 // B = A+A^t
	 System.out.println("TestMat_1 + Transposed TestMat_1 = ");
	 Matrix B = TestMat_1.addMat(T);
	 // Check if A and A^t have equal traces.
	 if(O.findTrace(O)==B.findTrace(B))
		 System.out.println("TestMat_1 has the same trace as transposed TestMat_1 ");
	 else
		 System.out.println("Does not have an equal trace to its transpose ");
	 in.close();
  }
}