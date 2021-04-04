package Graph.Samples;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Graph.GraphData.HistogramData;
import Graph.GraphElements.Histogram;

public class HistogramTester {

	public static void main(String[] args) throws MalformedURLException {
		// Create a new histogram chart
		Histogram histogram = new Histogram();
		histogram.setTitle("Country Comparison: Military Expenditures");
		histogram.setHorzAxis("Percentage of Annual GDP Spent per Country");
		histogram.setVertAxis("GDP %");
				
		// Create an empty list of data elements
		ArrayList<HistogramData> data = new ArrayList<>();
		
		String filename = "military_expenditures.txt";
		File file  = new File(filename);
		Scanner in = null;
		try {
			// Try to open the file
			in = new Scanner(file);
			
			try {
				// Read in all the data add to above lists
				int count = 0;
				while(count < 5) {
					String[] info = in.nextLine().split(",");
					String country = info[0];
					double gdp = Double.parseDouble(info[1]);
					String year = info[2];
					// Create and add data elements to the list
					histogram.getDataset().addValue(gdp,year,country);
					data.add(new HistogramData(gdp,year,country));
					++count;
				}

				// Contains txt lines 6 - END file
				ArrayList<String> countries = new ArrayList<String>();
				ArrayList<Double> gdps = new ArrayList<>();
				ArrayList<String> years = new ArrayList<String>();
				
				while(in.hasNextLine()) {
					String[] dataHub = in.nextLine().split(","); 
					countries.add(dataHub[0]);
					gdps.add(Double.parseDouble(dataHub[1]));
					years.add(dataHub[2]);
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
		// Add each data element to the chart
		for (HistogramData element : data) {
			histogram.getDataset().addValue(element.getValue(), element.getRowKey(), element.getColKey());
		}
		
		// Initialize and display the chart
		histogram.displayChart();
	}
	
}
