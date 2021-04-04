
import org.jfree.chart.ChartPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PluggableFunction extends ApplicationFrame {

   public PluggableFunction( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","GDP in Trillions USD",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 400 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( ) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      
      int count = 0;
		// filename contains all gdp data
		String filename = "line-graph-data.txt";
		File file  = new File(filename);
		Scanner in = null;
		
		try {
			// Try to open the file
			in = new Scanner(file);
			
			try {
				// Read in all the data add to above lists
				while(in.hasNextLine()) {
					String[] dataHub = in.nextLine().split(","); 
					String year = (dataHub[0]);
					double gdp = Double.parseDouble(dataHub[1]);
					if (count < 10) {
						dataset.addValue(gdp,"USA", year);
						
					}
					if (count > 10) {
						dataset.addValue(gdp, "China", year);
					}
					count++;
						
				}
			}
			
			// Fix anything that broke and clean up
			catch (NoSuchElementException e) {
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
      return dataset;
   }
   
   public static void main( String[ ] args ) {
      PluggableFunction chart = new PluggableFunction(
         "Pluggable Grapher" ,
         "Nominal GDP Graph");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );

   }
}