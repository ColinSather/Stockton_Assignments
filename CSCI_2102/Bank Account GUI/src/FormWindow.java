import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class FormWindow {

	private JFrame frame;
	private ArrayList<Account> accounts; 
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Account> accounts = new ArrayList<>();
					FormWindow window = new FormWindow(accounts);
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
	public FormWindow(ArrayList<Account> accounts) {
		this.accounts = accounts;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 663, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmount = new JLabel("Select Account");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAmount.setBounds(434, 39, 134, 21);
		frame.getContentPane().add(lblAmount);
		
		// Deposit Radio.
		JRadioButton deposit = new JRadioButton("Deposit");
		deposit.setBackground(SystemColor.inactiveCaption);
		deposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deposit.setBounds(402, 302, 89, 34);
		frame.getContentPane().add(deposit);
		
		// Withdraw Radio.
		JRadioButton withdraw = new JRadioButton("Withdraw");
		withdraw.setBackground(SystemColor.inactiveCaption);
		withdraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		withdraw.setBounds(517, 302, 89, 34);
		frame.getContentPane().add(withdraw);
		
		// Group radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(deposit);
		group.add(withdraw);
		
		// input amount.
		textField = new JTextField();
		textField.setBounds(402, 266, 204, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		// Display Data.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 363, 416);
		frame.getContentPane().add(scrollPane);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.GREEN);
		scrollPane.setViewportView(textArea);
		
		// Process button withdraw or deposit.
		JButton btnNewButton = new JButton("Process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amt;
				double dollas = Double.valueOf(textField.getText());
				if (withdraw.isSelected()) {
					for(Account account : accounts) {
						amt = " - Withdrew $" + account.withdraw(dollas);
						amt += " from Account #" + account.getAcctId();
						amt += "\n";
						textArea.append(amt);
					}
				}
				if (deposit.isSelected()) {
					for(Account account : accounts) {
						amt = "+ Deposited $" + account.deposit(dollas);
						amt += " into Account #" + account.getAcctId();
						amt += "\n";
						textArea.append(amt);
					}
				}
				
			}
		});
		btnNewButton.setBounds(402, 344, 89, 41);
		frame.getContentPane().add(btnNewButton);
		
		// Get Balance Button.
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Account account : accounts) {
					String line;
					line = " Balance = $";
					line += account.getBalance();
					line +="\n";
					textArea.append(line);
				}
			}
		});
		btnBalance.setBounds(517, 344, 89, 41);
		frame.getContentPane().add(btnBalance);
		
		Account a = new Account("Jane Doe",20000);
		Account b = new Account("Joe Smith",10000);
		Account c = new Account("Kim Davidson",200);
		
		// ComboBox that will display available accounts
		JComboBox<String> comboBox = new JComboBox<>();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBox.getSelectedItem();
				
				if(selected.toString().equals("#1000")) {
					accounts.clear();
					accounts.add(a);
                }
                
                else if(selected.toString().equals("#1001")) {
                	accounts.clear();
                	accounts.add(b);
					
                }
                else if(selected.toString().equals("#1002")) {
                	accounts.clear();
                	accounts.add(c);
                }
				

			}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem(" ");
		comboBox.addItem("#1000");
		comboBox.addItem("#1001");
		comboBox.addItem("#1002");
		
		comboBox.setBounds(402, 71, 204, 29);
		frame.getContentPane().add(comboBox);
		
		// Find Account Button.
		JButton btnNewButton_1 = new JButton("Show Account Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Account account : accounts) {
					String line;
					line = " ID: #" + account.getAcctId();
					line += "\n"; 
					line += " Name: " + account.getName();
					line += "\n"; 
					line += " Balance: $" + account.getBalance();
					line += "\n";
					line += " "+account.getLastUpdate();
					line += "\n"; 
					textArea.append(line);
				}
			}
		});
		btnNewButton_1.setBounds(402, 121, 204, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("Enter Amount");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(434, 234, 134, 21);
		frame.getContentPane().add(label);
		
		JButton btnRefreshAccountInfo = new JButton("Refresh Account Info");
		btnRefreshAccountInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.removeAll();
			}
		});
		btnRefreshAccountInfo.setBounds(402, 167, 204, 34);
		frame.getContentPane().add(btnRefreshAccountInfo);

	}
}