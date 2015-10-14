package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import tn.youbay.delegates.GestionAccountsDelegate;
import tn.youbay.entities.Accounts;
import tn.youbay.services.interfaces.IAccountsService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameField;
	private JButton btnLogin;
	public static Accounts ac;
	private JPasswordField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 930);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("Login ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionAccountsDelegate gdl = new GestionAccountsDelegate();
				ac=gdl.getUNADMIIN(UsernameField.getText(), PasswordField.getText());
				if(ac!=null)
				{
					JOptionPane.showMessageDialog(null, "Bienvenue");
					Accueil l = new Accueil();
					hide();
					l.show();
					
					
				}
				else 
				{
					
				}
//					Context context;
//					try {
//						context = new InitialContext();
//						IAccountsService remote;
//						remote=(IAccountsService) context.lookup("/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService");
//						ac=remote.getUnAdmin(UsernameField.getText(), PasswordField.getText());
//						//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//						if(ac!=null)
//								{
//								JOptionPane.showMessageDialog(null, "Bienvenue");
//								Accueil l = new Accueil();
//								hide();
//								l.setVisible(true);
//							
//								}
//						else if(ac==null)
//						{
//
//						}
//					} catch (NamingException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					
//				
//				System.out.println();
				
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\coo.png"));
		btnLogin.setBounds(564, 570, 135, 25);
		contentPane.add(btnLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(476, 473, 112, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(476, 390, 135, 30);
		contentPane.add(lblNewLabel);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(640, 398, 116, 22);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(640, 474, 116, 22);
		contentPane.add(PasswordField);
		
		JLabel label = new JLabel("");
		label.setBounds(17, 0, 1341, 980);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\rami.jpg"));
		contentPane.add(label);
	}
}
