import java.util.Scanner;
public class Prob5
{ 
    public static void main(String args[])  
    { 
       Scanner in =new Scanner(System.in);
       System.out.println("Enter the Matrix rows & columns:  ");
       int N = in.nextInt();
       in.close();
        int[][] h=new int[N][N]; 
        int[] Array = new int[(int)Math.pow(N, 2)-N];
        int counter =0;
        	for(int i = 0; i<N;i++){
                for(int j=0; j<N;j++){
                	
                  h[N][N]=(int)(Math.random()*100);
                }
              }
        	for(int i =0; i<N;i++) {
        		for(int j =0; i<N;j++) {
        			if(i==j) {
        				
        			}
        			else {
        				Array[counter]=h[i][j];
        				counter++;
        				System.out.println("Non-diagonal elements are "+Array[counter]);
        			}
        		}
        	}
       } 
        
                
    } 