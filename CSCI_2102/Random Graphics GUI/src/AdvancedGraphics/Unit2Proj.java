package AdvancedGraphics;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JSpinner;

public class Unit2Proj {
	private JFrame frame;
	private NodePlot plot;
	private boolean change = false;
	/**

	 * Create the application.

	 */
	public Unit2Proj() {

		initialize();

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
// Canvas for shapes ---------------------------------------------------------------------------------------------------
		frame = new JFrame("Advanced Graphics");
		plot = new NodePlot();
		frame.setResizable(true);
		frame.setBounds(100, 100, 888, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(plot);
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(119, 8, 403, 403);
		frame.getContentPane().add(scrollPane);

// Display Shape Data in a JList ---------------------------------------------------------------------------------------
		DefaultListModel<Node> listModel = new DefaultListModel<>();
		JScrollPane scrollPane_1 = new JScrollPane();
		JList<Node> list = new JList<>(listModel);
		scrollPane_1.setViewportView(list);
		scrollPane_1.setBounds(537, 8, 325, 403);
		frame.getContentPane().add(scrollPane_1);		
		
// Add New Shape -------------------------------------------------------------------------------------------------------
		JButton addShape = new JButton("S SHAPE");
		addShape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewShape(1);
				listModel.clear();//reset list each iteration
				for (Node elem : plot.getList()) {
					listModel.addElement(elem);
				}
			}
			
		});
		addShape.setBounds(12, 162, 97, 23);
		frame.getContentPane().add(addShape);

// Add Grid-------------------------------------------------------------------------------------------------------------				
		JButton btnGrid = new JButton("Add Grid");
		btnGrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plot.addItem(new NodeGrid());
				listModel.clear();//reset list each iteration
				for (Node elem : plot.getList()) {
					listModel.addElement(elem);
				}
			}

		});
		btnGrid.setBounds(12, 26, 97, 23);
		frame.getContentPane().add(btnGrid);
		
// Add Origin-----------------------------------------------------------------------------------------------------------
		JButton btnOrigin = new JButton("Add Origin");
		btnOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plot.addItem(new NodeOrigin());
				listModel.clear();//reset list each iteration
				for (Node elem : plot.getList()) {
					listModel.addElement(elem);
				}
			}

		});
		btnOrigin.setBounds(12, 60, 97, 23);
		frame.getContentPane().add(btnOrigin);
		
// Draws 10 random shapes-----------------------------------------------------------------------------------------------
		JButton btnAddRandom = new JButton("Add 10");
		btnAddRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawRandomShapes(10);
				listModel.clear();//reset list each iteration
				for (Node elem : plot.getList()) {
					listModel.addElement(elem);
				}
			}

		});
		btnAddRandom.setBounds(12, 94, 97, 23);
		frame.getContentPane().add(btnAddRandom);
		
// Draws 1000 random shapes---------------------------------------------------------------------------------------------
		JButton btnAdd = new JButton("Add 1000");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawRandomShapes(1000);
				listModel.clear();//reset list each iteration
				for (Node elem : plot.getList()) {
					listModel.addElement(elem);
				}
			}

		});
		btnAdd.setBounds(12, 128, 97, 23);
		frame.getContentPane().add(btnAdd);		

// Spinner that selects index for removal.------------------------------------------------------------------------------
		JSpinner spinner = new JSpinner();
		spinner.setBounds(12, 234, 97, 28);
		frame.getContentPane().add(spinner);
		
// Clear Button---------------------------------------------------------------------------------------------------------
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plot.clear();
				listModel.clear();
			}
		});
		btnClear.setBounds(12, 307, 97, 23);
		frame.getContentPane().add(btnClear);
		
// Button that removes shape from index----------------------------------------------------------------------------------
		JButton btnNewButton_1 = new JButton("Index RMV");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rmv = (int) spinner.getValue();
				listModel.removeElementAt(rmv);
				plot.removeItem(rmv);
			}
		});
		btnNewButton_1.setBounds(12, 273, 97, 23);
		frame.getContentPane().add(btnNewButton_1);

// Button that changes all shapes' color--------------------------------------------------------------------------------
		JButton btnNewButton = new JButton("New Color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change = !change;
				Random generator = new Random();
				int rand = generator.nextInt(128)+128;
				int rand1 = generator.nextInt(128)+128;
				int rand2 = generator.nextInt(128)+128;
				Color x = new Color(rand,rand1,rand2);
				if (change = true) {
					listModel.clear();
					for (Node elem : plot.getList()) {
						listModel.addElement(elem);
						elem.c = x;
						plot.repaint();
					}
					
				}
			}
		});
		btnNewButton.setBounds(12, 196, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
// Menu-----------------------------------------------------------------------------------------------------------------		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		JMenuItem menuItem = new JMenuItem("Exit");
		mnNewMenu.add(menuItem);
	}
	
// Method that Accepts Data from TXT File to Create a New Shape--------------------------------------------------------------
		private void createNewShape(int count) {
			String filename = "shapes.txt";
			File file  = new File(filename);
			Scanner in = null;
			
			
			try {
				// Try to open the file
				in = new Scanner(file);
				
				try {
					// Read in the data one line at a time
					while(in.hasNextLine()) {
						// Do something with this String
						String[] data = in.nextLine().split(",");
						String name = data[0];
						int x1 = Integer.parseInt(data[1]);
						int y1 = Integer.parseInt(data[2]);
						int x2 = Integer.parseInt(data[3]);
						int y2 = Integer.parseInt(data[4]);
						// Colors rgb.
						int r = Integer.parseInt(data[5]);
						int g = Integer.parseInt(data[6]);
						int b = Integer.parseInt(data[7]);
					
						Color clr = new Color(r,g,b); 
						Node grf = new NodeGraphiti(name,x1,y1,x2,y2,clr);
						plot.addItem(grf);
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
		
// Use this method to help you create a shape loader--------------------------------------------------------------------	
	private void drawRandomShapes(int count) {
		Random generator = new Random();

		for (int i=0; i<count; i++) {
			String R = "Rectangle";
			String C = "Circle";
			// Create random X and Y locations
			int x = generator.nextInt(601)-200;
			int y = generator.nextInt(601)-200;
			// Set a random radius or height/width
			int r = generator.nextInt(201);
			int w = generator.nextInt(401);
			int h = generator.nextInt(401);
			// Create random color components (0-255)
			int red = generator.nextInt(128)+128;
			int green = generator.nextInt(128)+128;
			int blue = generator.nextInt(128)+128;
			
			Color c = new Color(red,green,blue);
			
			if (generator.nextBoolean()) {
				plot.addItem(new NodeCircle(C,x,y,r,c));
				

			} else {
				plot.addItem(new NodeRectangle(R,x,y,w,h,c));

			}
		}
	}
		
	public void setVisible(boolean b) {
		if (b) {
			frame.setVisible(true);

		} else {
			frame.setVisible(false);
		}
	}
}