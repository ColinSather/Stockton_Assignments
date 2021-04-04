package hw_3_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class DialogOpen {
public static void main(String[] args) {
		JFileChooser picker = new JFileChooser();
		if(picker.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			System.out.println("No file was found");
			System.exit(0);
		}
		
		// Open the file
		File file = new File(picker.getSelectedFile().toString());
		
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
