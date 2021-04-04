public class PerfSquare {
	public static void main(String[] args){
      for (int i = 1; i <= 1000; i++){
		int num = i;
        double root = Math.sqrt(num);
        if(root == Math.ceil(root)){
          	System.out.println(num + " is a perfect square.");
        }
    }	
  }
}