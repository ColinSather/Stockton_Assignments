package hw_3_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileOpen {
	public static void main(String[] args) {
		
		Path currentRelativePath = Paths.get("Documents\\data.txt");
		String filename = currentRelativePath.toAbsolutePath().toString();
		
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
					// Do something with this String
					System.out.println(in.nextLine());
					
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
