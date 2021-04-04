import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import Accounts.Account;
import Accounts.Client;
import Accounts.Portfolio;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class FormWindow {

	protected JFrame frame;
	
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phoneNumber;
	
	/*****************************************************
	 * Instance Variables
	 *  + Client person
	 *  + ListModel clientDetail
	 */
	
	private Client person;
	private DefaultListModel<String> clientDetail = new DefaultListModel<String>();

	public FormWindow(Client person) {
		this.person = person;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollDetail = new JScrollPane();
		scrollDetail.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDetail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDetail.setBounds(10, 10, 546, 116);
		frame.getContentPane().add(scrollDetail);
		
		JList<String> clientList = new JList<String>(clientDetail);
		clientList.setEnabled(false);
		
		scrollDetail.setViewportView(clientList);
		
		firstName = new JTextField(person.getFirstName());
		firstName.setBounds(662, 10, 120, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField(person.getLastName());
		lastName.setColumns(10);
		lastName.setBounds(662, 41, 120, 20);
		frame.getContentPane().add(lastName);
		
		phoneNumber = new JTextField(person.getPhoneNumber());
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(662, 72, 120, 20);
		frame.getContentPane().add(phoneNumber);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(566, 13, 86, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(566, 44, 86, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setBounds(566, 75, 86, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 137, 320, 425);
		frame.getContentPane().add(scrollPane_1);
		
		DefaultMutableTreeNode portfolios = new DefaultMutableTreeNode("Portfolio(s)");
		JTree portfolioTree = new JTree(portfolios);
		scrollPane_1.setViewportView(portfolioTree);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(340, 137, 442, 425);
		frame.getContentPane().add(scrollPane_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane_2.setViewportView(editorPane);
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				person.setFirstName(firstName.getText());
				person.setLastName(lastName.getText());
				person.setPhoneNumber(phoneNumber.getText());
				editorPane.setText(editorPane.getText() + "Updating client: " + person.getLastName() + ", " + person.getFirstName() + "\n");
				repaintForm();
			}
		});

		btnUpdateClient.setBounds(566, 103, 216, 23);
		frame.getContentPane().add(btnUpdateClient);
				
		editorPane.setText(editorPane.getText() + "Adding client: " + person.getLastName() + ", " + person.getFirstName() + "\n");
		
		// Parse each portfolio
		for (Portfolio portfolio : person.getPortfolios()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(portfolio.getName() + " ($" + portfolio.getValue() + ")\n");
			portfolios.add(node);
			editorPane.setText(editorPane.getText() + "Adding portfolio: " + portfolio.getName() + " ($" + portfolio.getValue() + ")\n");
			
			// Parse each account
			for (Account account : portfolio.getPortfolioAccounts()) {
				DefaultMutableTreeNode value = new DefaultMutableTreeNode(account.getDescription() + " ($" + account.getBalance() + ")\n");
				node.add(value);				
				editorPane.setText(editorPane.getText() + "Adding account: " + account.getDescription() + " ($" + account.getValue() + ")\n");
			}
			
		}
		
		// Expand tree
		for (int i=0; i<portfolioTree.getRowCount(); i++) {
			portfolioTree.expandRow(i);	
		}
		
		// Repaint Form
		repaintForm();
				
	}
	
	void repaintForm() {
		clientDetail.clear();
		clientDetail.addElement("Lastname: " + person.getLastName());
		clientDetail.addElement("Firstname: " + person.getFirstName());
		clientDetail.addElement("Phone Num: " + person.getPhoneNumber());
		clientDetail.addElement("Total Value: $" + person.getClientPortfolioValue());
		clientDetail.addElement("Portfolio Count: " + person.getPortfolioCount());
		clientDetail.addElement("Portfolio Names: " + person.getClientPortfolioNames());
		
		for (Portfolio portfolio : person.getPortfolios()) {
			clientDetail.addElement(portfolio.getName() + ": " + portfolio.getDescription() + " ($" + portfolio.getValue() + ")");
			
			for (Account account : portfolio.getPortfolioAccounts()) {
				clientDetail.addElement(account.getType() + ": " + account.getDescription() + " ($" + account.getValue() + ")");	
			}
			
		}
		
	}
	
}
