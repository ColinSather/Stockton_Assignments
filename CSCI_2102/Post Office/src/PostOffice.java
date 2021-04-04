import java.util.Scanner;
import java.util.LinkedList;

public class PostOffice {
	// Sum of entered digits.
	public static int getSum(int zip) {
		int sum = 0;
		while(zip > 0) {
			sum = sum + zip % 10;
			zip = zip / 10;
		}
		return sum;
	}
	// Turns sum of digits into a multiple of 10.
	public static int digitChecker(int zip) {
		int sum = 0;
		while(zip > 0) 
		{
			sum = sum + zip % 10;
			zip = zip / 10;
		}
		while(sum % 10 != 0) {
			sum++;
		}
		return sum;
	}
	// Converts individual digits into binary.
	public static void converter(int digit) {
		String BarCode = "null";
		switch (digit) {
		case 1:
			BarCode = ":::||";
			break;
		case 2:
			BarCode = "::|:|";
			break;
		case 3:
			BarCode = "::||:";
			break;
		case 4:
			BarCode = ":|::|";
			break;
		case 5:
			BarCode = ":|:|:";
			break;
		case 6:
			BarCode = ":||::";
			break;
		case 7:
			BarCode = "|:::|";
			break;
		case 8:
			BarCode = "|::|:";
			break;
		case 9:
			BarCode = "|:|::";
			break;
		case 0:
			BarCode = "||:::";
			break;
		default:
			BarCode = "null";
		}
		System.out.print(BarCode);
	}
	// Main Method.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Zip Code...");
		int zip = in.nextInt();
		int CheckDigit = digitChecker(zip) - getSum(zip);
		LinkedList<Integer> digits = new LinkedList<>();
		
		System.out.println("The check digit is " + CheckDigit);
    	
    	int TempInt = 0;
    	for (int i = 0; i < 5; i++) {
			digits.push(zip % 10);
			zip = zip / 10;
    	}
    	System.out.print("|");
    	while (!digits.isEmpty()) {
    		TempInt = digits.pop();
        	converter(TempInt);
    	}
    	converter(CheckDigit);
    	System.out.print("|");
		in.close();
	}
}
