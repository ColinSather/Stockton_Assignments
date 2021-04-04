// Problem 1 Homework 4.
import java.util.Scanner;
public class Prob1 {
  public static void main (String args[]){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the Matrix rows & columns:  "); 
    int a;
    int b;
    a = in.nextInt();
    b = in.nextInt();
    in.close();
    int[][] m = new int[a][b];
    for(int i = 0; i<a;i++){
        for(int j=0; j<b;j++){
          m[i][j]=(int)(Math.random()*100);
        }
      }
      for(int i =0; i<a;i++){
        for(int j =0; j<b;j++){
          System.out.print(m[i][j]+" ");
        }
        System.out.println("  ");
       }
    System.out.println("Transposed Matrix...  ");
    for(int i =0; i<a;i++){
        for(int j =0; j<b;j++){
          System.out.print(m[j][i]+" ");
        }
        System.out.println("  ");
      }
    }
  }