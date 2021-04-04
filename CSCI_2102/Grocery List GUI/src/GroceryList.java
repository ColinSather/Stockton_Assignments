import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
//import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.io.ObjectInputStream.GetField;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class GroceryList {

	private JFrame frame;
	private JTextField txtAddItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroceryList window = new GroceryList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GroceryList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAddItem = new JTextField();
		txtAddItem.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddItem.setText("Enter Item");
		txtAddItem.setBounds(148, 78, 128, 36);
		frame.getContentPane().add(txtAddItem);
		txtAddItem.setColumns(10);
		
		// List of Grocery Items.
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		// Add from Text Field to JList.
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(txtAddItem.getText());
			}
		});
		btnAddItem.setBounds(148, 125, 128, 36);
		frame.getContentPane().add(btnAddItem);
		
		// Button Method to Add 100 random variations of BEC.
		JButton btnNewButton = new JButton("Add 100 Rand");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] stuff = {"Bacon","eggs","cheese"};
				Random generator = new Random();
				for (int i = 0; i <= 100; i++) {
					int select = generator.nextInt(stuff.length);
					listModel.addElement(stuff[select]);
				}	
			}
		});
		btnNewButton.setBounds(148, 172, 128, 36);
		frame.getContentPane().add(btnNewButton);
		
		// Spinner to select index for removal.
				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(0, 0, 200, 1));
				spinner.setBounds(299, 78, 125, 36);
				frame.getContentPane().add(spinner);
				
		// Button to Remove index entered in JTextField.
		JButton btnRemoveIndex = new JButton("Remove Index");
		btnRemoveIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rmv = (int) spinner.getValue();
				listModel.removeElementAt(rmv);
			}
		});
		btnRemoveIndex.setBounds(296, 125, 128, 36);
		frame.getContentPane().add(btnRemoveIndex);
		
		// Reset Button, clears listModel.
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
			}
		});
		btnNewButton_1.setBounds(295, 172, 129, 36);
		frame.getContentPane().add(btnNewButton_1);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 128, 208);
		frame.getContentPane().add(scrollPane);
		JList<String> list = new JList<>(listModel);
		list.setBackground(Color.BLACK);
		list.setForeground(Color.GREEN);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Grocery List App");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 26, 276, 41);
		frame.getContentPane().add(lblNewLabel);
		
	}
}