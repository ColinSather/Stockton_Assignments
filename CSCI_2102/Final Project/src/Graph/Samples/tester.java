package Graph.Samples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class tester {
	
	public static void main(String[] args) {
		
		// Set the relative file path
		String filename = "military_expenditures24.txt";
		
		// Open the file
		File file = new File(filename);
		
		// Create the Scanner object and scope to the entire main method
		Scanner in = null;
		
		try {
			// Try to open the file
			in = new Scanner(file);
			
			try {
				// Read in the data one line at a time
				while(in.hasNextLine()) {
					String[] info = in.nextLine().split(",");
					String country = info[0];
					double gdp = Double.parseDouble(info[1]);
					int year = Integer.parseInt(info[2]);
					for (String elem : info)
						System.out.println(elem);
				}
				
				
			// Fix anything that broke and clean up
			} catch (NoSuchElementException e) {
				System.err.println("Record Error: " + e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Parse Error: " + e.getMessage());
			} catch (NumberFormatException e) {
				System.err.println("Data Error: " + e.getMessage());
			} finally {
				in.close();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File Unavailable: " + e.getMessage());
		} 
		
	}
}
