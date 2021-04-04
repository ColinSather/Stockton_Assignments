package hw_3_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Writer {
	public static void main(String[] args) {
		
		JFileChooser picker = new JFileChooser();
		ArrayList<String> fileContents = new ArrayList<>();
		
		if(picker.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			System.out.println("No file was found... exiting");
			System.exit(0); 
		}
		// Open the file
		File file = new File(picker.getSelectedFile().toString());
		System.out.println("Opening..."+picker.getSelectedFile().toString());
		
		// Create the Scanner object and scope to the entire main method
		Scanner in = null;
		
		try {
			// Try to open the file
			in = new Scanner(file);
			
			try {
				// Read in the data one line at a time
				while(in.hasNextLine()) {
					// Do something with this String
					fileContents.add(in.nextLine());
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
		try {
			if (picker.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
				System.out.println("No file was found... exiting");
				System.exit(0);
			}
			//create the file
			PrintWriter out = new PrintWriter(new File(picker.getSelectedFile().toString()));
			System.out.println("Opening... "+picker.getSelectedFile().toString());
			//write the file
			for (String line : fileContents) {
				System.out.println(line);
				out.println(line);
			}
			out.close();
		}catch (FileNotFoundException e) {
			System.err.println("File Access Error: "+e.getMessage());
		}
	}
}
