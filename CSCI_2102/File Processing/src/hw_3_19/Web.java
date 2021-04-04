package hw_3_19;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Web {
	public static void main(String[] args) throws MalformedURLException {
		
		// Open the file
		URL page = new URL("https","25livepub.collegenet.com","/calendars/all-university-events-from-25live.rss");
		
		// Create the Scanner object and scope to the entire main method
		Scanner in = null;
		
		try {
			// Try to open the file
			in = new Scanner(page.openStream());
			
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
			
		} catch (IOException e) {
			System.err.println("File Unavailable: " + e.getMessage());
		} 
		
	}
}
