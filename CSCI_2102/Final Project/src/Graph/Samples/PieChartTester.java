package Graph.Samples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Graph.GraphData.HistogramData;
import Graph.GraphElements.PieChart;

public class PieChartTester {
	
	public static void main(String[] args) {
		PieChart chart = new PieChart();
		chart.setTitle("Percentage of GDP Spent on Military");
		
		// Create an empty list of data elements
				ArrayList<HistogramData> data = new ArrayList<>();
				
				String filename = "military_expenditures.txt";
				File file  = new File(filename);
				Scanner in = null;
				int count = 0;
				try {
					// Try to open the file
					in = new Scanner(file);
					
					try {
						// Read in the data one line at a time until lines = 5
						while(count < 5) {
							String[] info = in.nextLine().split(",");
							String country = info[0];
							double gdp = Double.parseDouble(info[1]);
							String year = info[2];//year is not used
							
							// Create and add data elements to the list
							chart.getDataset().setValue(country, gdp);
							chart.displayChart();
							count++;
							
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
