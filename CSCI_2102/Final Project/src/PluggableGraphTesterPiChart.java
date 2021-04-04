
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import Graph.GraphContainer.PluggableGraph;
import Graph.GraphData.HistogramData;
import Graph.GraphElements.PieChart;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//PIE CHART
public class PluggableGraphTesterPiChart {

	public static void main(String[] args) {
		
		PieChart chart = new PieChart();
		chart.setTitle("Percentage of GDP Spent on Military");
		chart.initializeChart();
		chart.setResizable(true);
		
		// Application Window Components
		PluggableGraph window = new PluggableGraph(chart);
		window.setPanelComponent(chart.getChartPanel());
		
		// Display Shape Data in a JList ---------------------------------------------------------------------------------------
		DefaultListModel<HistogramData> listModel = new DefaultListModel<>();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JList<HistogramData> list = new JList<>(listModel);
		scrollPane_1.setViewportView(list);
		scrollPane_1.setBounds(600, 32, 325, 505);
		window.getFrame().getContentPane().add(scrollPane_1);	
		JLabel label = new JLabel("Top Military GDP Expenditures by Country");
		scrollPane_1.setColumnHeaderView(label);
		
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
				while(in.hasNextLine()) {
					String[] dataHub = in.nextLine().split(","); 
					String country = dataHub[0];
					double gdp = Double.parseDouble(dataHub[1]);
					String year = dataHub[2];
					data.add(new HistogramData(gdp,year,country));
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
		int count = 0;
		// Add 5 data elements to the chart
		for (HistogramData element : data) {
			if (count<5) {
				chart.getDataset().setValue(element.getColKey(), element.getValue());
				listModel.addElement(element);
				++count;
			}
		}
		
		// Add a menu to the pluggable application window
		JMenu mnScatter = new JMenu("File");
		window.getMenuBar().add(mnScatter);
		
		// Add Data Sub-Menu of File Menu
		JMenu topX = new JMenu("Add Data");
		mnScatter.add(topX);
		
		// Spinner value = top x gdps
		JSpinner spinner = new JSpinner();
		topX.add(spinner);
		spinner.setValue(6);
		
		//add next highest military gdp  
		JMenuItem mntmAddFunction3 = new JMenuItem("See More");
		mntmAddFunction3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				int value = (Integer)spinner.getValue();
				listModel.clear();
				for (HistogramData element : data) {
					if (count < value) {
					chart.getDataset().setValue(element.getColKey(),element.getValue());
					listModel.addElement(element);
					++count;
					}
				}
			}
		});
		topX.add(mntmAddFunction3);
		
		//exit function -- 
		JMenuItem mntmAddFunction2 = new JMenuItem("Exit Application");
		mntmAddFunction2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		mnScatter.add(mntmAddFunction2);
		window.setVisible(true);
	}


}
