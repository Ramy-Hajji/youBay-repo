package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;





import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import tn.youbay.delegates.DelegateAccount;
import tn.youbay.entities.Account;

import java.sql.Date;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListAccount extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
    private List<Account> listA ;
    Context context ;
	DelegateAccount d = new DelegateAccount();
	static Account ac ;
	static Account ac2;
	private JTextField textField;
	
	static int id ;
	static String firstName ;
	static String lastName ;
	static Date dateCreation ;
	static String codeBank ;
	static String Adresse ;
	static Date dateOfBirth ;
    static String mail ;
	static String state ;
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAccount frame = new ListAccount();
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
	public ListAccount() {
		
		
	
		
	
		listA = d.DisplayAccount();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 471);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				
				
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Search");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Edit Account");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ac = listA.get(table.getSelectedRow());
				ac2 = listA.get(table.getSelectedRow());
				
			}
		});
		table.setBounds(70, 73, 669, 285);
		contentPane.add(table);
		
		JButton btnNewButton_1 = new JButton("Unban user");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int row = table.getSelectedRow();
			       
					int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					System.out.println(id);
				d.UnBann(id);
					
					
				d.DisplayAccount();
			}
		});
		btnNewButton_1.setBounds(161, 369, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Validate account");
		btnNewButton_2.setBounds(270, 369, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("send secret code");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			 String[] t = {ac.getEmail()} ;
				d.mail(t);
				System.out.println("The mail is successfuly sended");
				
				
				
				
			}
		});
		btnNewButton_3.setBounds(408, 369, 115, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit account");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				 firstName = ac.getFirstName();
				 
				
				
				 lastName = ac.getLastName() ;
				 
				dateCreation = (Date) ac.getDate();
				
				codeBank = ac.getCode_bank();
				 Adresse = ac.getAddress();
				dateOfBirth = (Date) ac.getDateofBirth();
			    mail = ac.getEmail();
				
				state = ac.getState();
				
				
				/*****************************************************************************/
				EditAccount ed = new EditAccount();
				hide();
				ed.setVisible(true);
				
				
			}
		});
		btnNewButton_4.setBounds(543, 369, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Ban user");
		btnNewButton.setBounds(56, 369, 75, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				listA = d.SearchState(textField.getText());
				initDataBindings();
				
			}
		});
		textField.setBounds(228, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					System.out.println(id);
					
					d.Bann(id);
			 
					d.DisplayAccount();
			 		ListAccount l = new ListAccount();
			 		hide();
			 	l.setVisible(true);
				
				
			}
		});
		initDataBindings();
	}
	protected void initDataBindings() {
		org.jdesktop.swingbinding.JTableBinding<tn.youbay.entities.Account, java.util.List<tn.youbay.entities.Account>, javax.swing.JTable> jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, listA, table);
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty = org.jdesktop.beansbinding.BeanProperty.create("username");
		jTableBinding.addColumnBinding(accountBeanProperty).setColumnName("Username");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_1 = org.jdesktop.beansbinding.BeanProperty.create("codeBank");
		jTableBinding.addColumnBinding(accountBeanProperty_1).setColumnName("Code bank");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.sql.Date> accountBeanProperty_2 = org.jdesktop.beansbinding.BeanProperty.create("dateCreation");
		jTableBinding.addColumnBinding(accountBeanProperty_2).setColumnName("Date of creation");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.sql.Date> accountBeanProperty_3 = org.jdesktop.beansbinding.BeanProperty.create("dateOfBirth");
		jTableBinding.addColumnBinding(accountBeanProperty_3).setColumnName("Date of birth");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_4 = org.jdesktop.beansbinding.BeanProperty.create("firstName");
		jTableBinding.addColumnBinding(accountBeanProperty_4).setColumnName("First name");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_5 = org.jdesktop.beansbinding.BeanProperty.create("adresse");
		jTableBinding.addColumnBinding(accountBeanProperty_5).setColumnName("Adresse");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_6 = org.jdesktop.beansbinding.BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(accountBeanProperty_6).setColumnName("Last name");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_7 = org.jdesktop.beansbinding.BeanProperty.create("secretNumber");
		jTableBinding.addColumnBinding(accountBeanProperty_7).setColumnName("Secret number");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_8 = org.jdesktop.beansbinding.BeanProperty.create("state");
		jTableBinding.addColumnBinding(accountBeanProperty_8).setColumnName("state");
		//
		org.jdesktop.beansbinding.BeanProperty<tn.youbay.entities.Account, java.lang.String> accountBeanProperty_9 = org.jdesktop.beansbinding.BeanProperty.create("mail");
		jTableBinding.addColumnBinding(accountBeanProperty_9).setColumnName("Mail");
		//
		jTableBinding.bind();
	}
}
