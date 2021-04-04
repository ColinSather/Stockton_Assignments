
import java.util.Scanner;
public class Prob2
{ 
public static void main(String args[])  
{ 
   Scanner in = new Scanner(System.in);
   System.out.println("Enter the Matrix rows & columns:  ");
       int N = in.nextInt();
       in.close();
        int[][] h=new int[N][N]; 
        
 
        	for(int i = 0; i<N;i++){
                for(int j=0; j<N;j++){
                	
                  h[N][N]=(int)(Math.random()*100);
                }
              }
        	for(int i =0; i<N;i++) {
        		for(int j =0; i<N;j++) {
        			if(i==j) {
        				System.out.println("The Matrix is Symmetric ");
    			}
    			else {
    				System.out.println("The Matrix is not Symmetric ");
    				
    			}
    		}
    	}
   } 
                        
                        
} 