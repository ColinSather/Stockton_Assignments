// BAR GRAPH
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import Graph.GraphElements.Histogram;
import Graph.GraphContainer.PluggableGraph;
import Graph.GraphData.HistogramData;

public class PluggableGraphTesterHistogram {
	
	public static void main(String[] args) {
				
				// Create a new histogram chart
				Histogram histogram = new Histogram();
				histogram.setTitle("Country Comparison: Military Expenditures");
				histogram.setHorzAxis("Military Expenditures by Country");
				histogram.setVertAxis("Annual GDP Percentage");
				histogram.initializeChart();
				
				// Application Window Components
				PluggableGraph window = new PluggableGraph(histogram);
				window.setPanelComponent(histogram.getChartPanel());
				
				// Display Shape Data in a JList ---------------------------------------------------------------------------------------
				DefaultListModel<HistogramData> listModel = new DefaultListModel<>();
				JScrollPane scrollPane_1 = new JScrollPane();
				
				JList<HistogramData> list = new JList<>(listModel);
				scrollPane_1.setViewportView(list);
				scrollPane_1.setBounds(600, 32, 325, 505);
				window.getFrame().getContentPane().add(scrollPane_1);	
				JLabel label = new JLabel("Top GDP Expenditures by Country");
				scrollPane_1.setColumnHeaderView(label);
				
				// Create an empty list of data elements
				ArrayList<HistogramData> data = new ArrayList<>();
				
				// filename contains all gdp data
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
						histogram.getDataset().addValue(element.getValue(), element.getRowKey(), element.getColKey());
						listModel.addElement(element);
						++count;
					}
				}
				
				// Add a menu to the pluggable application window
				JMenu mnScatter = new JMenu("File");
				window.getMenuBar().add(mnScatter);
				
				
				JMenu search = new JMenu("Search");
				window.getMenuBar().add(search);
				
				// Search function
				JTextField textField = new JTextField();
				search.add(textField);
				textField.setColumns(10);
				
				
				JMenuItem enter = new JMenuItem("Find");
				search.add(enter);
				
				search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TO DO
						// Search through list 1 for text field for desired String ex:"United Sts".
						String textValue = textField.getText();
						int count = 1;
						listModel.clear();
						for (HistogramData elem : data) {
							if (textValue == elem.getColKey()) {
								histogram.getDataset().addValue(elem.getValue(), elem.getRowKey(), elem.getColKey());
							}
							System.err.println("didn't find on try "+count);
							count++;
						}
						
					}
				});
				mnScatter.add(search);
				
				// Add Data Sub-Menu of File Menu
				JMenu topX = new JMenu("Add Data From Index");
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
							histogram.getDataset().addValue(element.getValue(), element.getRowKey(), element.getColKey());
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
