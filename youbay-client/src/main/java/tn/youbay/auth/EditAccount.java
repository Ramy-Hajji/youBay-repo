package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTable;



import javax.swing.JButton;

import tn.youbay.delegates.DelegateAccount;
import tn.youbay.delegates.DelegateProduct;
import tn.youbay.entities.Account;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditAccount extends JFrame {

	private JPanel contentPane;
	 private List<Account> list ;
	  Context context ;
		DelegateAccount d = new DelegateAccount();
	
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JDateChooser dateChooser;
		private JDateChooser dateChooser_1;
		
		ListAccount la = new ListAccount() ;
		
		
	
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					
					
					
					
					EditAccount frame = new EditAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(33, 22, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(33, 53, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(33, 84, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(33, 115, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
	  dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(141, 22, 87, 20);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDate(la.dateOfBirth);
		dateChooser.setBounds(32, 218, 87, 20);
		contentPane.add(dateChooser);
		dateChooser.setDate(la.dateCreation);
		
		textField_4 = new JTextField();
		textField_4.setBounds(33, 156, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(33, 187, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DelegateAccount da = new DelegateAccount();
				
				
					Account a1 = new Account(
			                 la.id,
			                 textField.getText(),
			                 textField_1.getText(),
			                 textField_2.getText(),
			                 textField_3.getText(),
			                 
			                 textField_4.getText(),
			                 textField_5.getText(),
			                dateChooser.getDate(),
			                dateChooser_1.getDate()
			               
			               
			                 
			                 );

			da.edit(a1);	
				
			}
		});
		btnNewButton.setBounds(189, 112, 89, 23);
		contentPane.add(btnNewButton);
		
		textField.setText(la.firstName);
		textField_1.setText(la.lastName);
		textField_2.setText(la.mail);
		textField_3.setText(la.state);
		textField_4.setText(la.codeBank);
		textField_5.setText(la.Adresse);
		dateChooser.setDate(la.dateCreation);
		dateChooser_1.setDate(la.dateOfBirth);
		
		
		
		
		
		
		
	}
}
