public class Matrix {
  private int nrows;
  private int ncols;
  private int value; 
  private boolean isSquare;
  
  public Matrix(int nR, int nC){
    nrows=nR;
    ncols=nC;
    for(int i=0; i<20;i++)
    	value = (int)(1+Math.random()*i); 
  }

  public Matrix(int n,boolean createSYM ){
    isSquare=createSYM;
  }
  public int getRows() {
	  return nrows;
  }
  public int getCols() {
	  return ncols;
  }
  Matrix addMat(Matrix mat) {
	  for(int i=0; i<nrows;i++) {
	    	 for(int j=0; j<ncols;j++) {
	    		 System.out.print(value+value+" "); 
	    	 }
	    	 System.out.println(" ");
	     }
	  return mat;
  }
  Matrix transpose(Matrix mat) {
	  for(int i=0; i<ncols;i++) {
	    	 for(int j=0; j<nrows;j++) {
	    		 System.out.print(value+" "); 
	    	 }
	    	 System.out.println(" ");
	     }
	  return mat;
  }
  Matrix display(Matrix mat) {
	    for(int i=0; i<nrows;i++) {
	    	 for(int j=0; j<ncols;j++) {
	    		 System.out.print(value+" "); 
	    	 }
	    	 System.out.println(" ");
	     }
	    return mat;
  }
   boolean isSymmetric(Matrix mat) {
	  if(nrows!=ncols) 
	   return false;
	  else
		  isSquare=true;
	  	  return true;
  } 
   int findTrace(Matrix mat) {
	   int trace = 0;
	   for(int i=0; i<nrows;i++) {
	    	 for(int j=0; j<ncols;j++) {
	    		 trace = trace +j;
	    	 }
	    	 trace = trace + i;
	     }
	   return trace;
   }
}