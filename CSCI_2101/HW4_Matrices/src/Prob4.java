// Problem 4 HW4.
import java.util.Scanner;
public class Prob4
{
    public static void main(String args[]){
    	Scanner s = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        final String sentence = s.nextLine();
        System.out.println("Letter Count: "+counter(sentence));
        s.close();
    }
    public static int counter(String sentence) {
    	final String onlyLetters = sentence.replaceAll("[^\\p{L}]","");
    	return onlyLetters.length();
    }
}