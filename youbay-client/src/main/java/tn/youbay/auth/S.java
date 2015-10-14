package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import tn.youbay.delegates.GestionAccountsDelegate;
import tn.youbay.delegates.GestionClaimsDelegate;
import tn.youbay.entities.Accounts;
import tn.youbay.entities.Claims;
import tn.youbay.services.interfaces.IAccountsService;
import tn.youbay.services.interfaces.IClaimService;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class S extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Claims> clll;
	Claims one;
	static Accounts aco;
	private JButton btnDeleteClaim;
	private JButton btnRefresh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S frame = new S();
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
	public S() {
		setTitle("List of claims");
		Context context;
		try {
			context = new InitialContext();
			IClaimService remote;
			remote=(IClaimService) context.lookup("/youbay-ejb/ClaimService!tn.youbay.services.IClaimService");
			clll=remote.ListOfClaims();
			//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(23, 70, 537, 274);
		table.addKeyListener(new KeyAdapter() {
			
			
		});
		table.addMouseListener(new MouseAdapter() {
		
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				one=clll.get(table.getSelectedRow());

				System.out.println(one);

			}
		});
		contentPane.setLayout(null);
		contentPane.add(table);
		
		JButton btnSend = new JButton("Send Email");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(one.getContent());
				System.out.println(one.getAccount().getId());
				GestionAccountsDelegate glc = new GestionAccountsDelegate();
				aco=glc.getCliientbyID(one.getAccount().getId());

//				Context context;
//				try {
//					context = new InitialContext();
//					IAccountsService remote;
//					remote=(IAccountsService) context.lookup("/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService");
//					//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//					aco=remote.getClientbyID(one.getAccount().getId());
//
//					
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
				
				
				MailSendForm msf = new MailSendForm();
				hide();

				msf.setVisible(true);
			}
		});
		btnSend.setBounds(463, 357, 97, 25);
		contentPane.add(btnSend);
		
		btnDeleteClaim = new JButton("Delete claim");
		btnDeleteClaim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionClaimsDelegate glc = new GestionClaimsDelegate();
			glc.supprimerClaim(one);
				
//				Context context;
//				try {
//					context = new InitialContext();
//					IClaimService remote;
//					remote=(IClaimService) context.lookup("/youbay-ejb/ClaimService!tn.youbay.services.IClaimService");
//					Claims i = new Claims();
//					System.out.println(one.getContent());
//					i.setContent(one.getContent());
////					i.setIdClient(one.getAccount().getId());
//					remote.DeleteClaiim(one);
//					//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//					
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
		btnDeleteClaim.setBounds(334, 357, 117, 25);
		contentPane.add(btnDeleteClaim);
		
		btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\refresh.png"));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
				S aaa= new S();
				aaa.setVisible(true);
			}
		});
		btnRefresh.setBounds(272, 32, 35, 25);
		contentPane.add(btnRefresh);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Claims, List<Claims>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, clll, table);
		//
		BeanProperty<Claims, String> claimsBeanProperty = BeanProperty.create("content");
		jTableBinding.addColumnBinding(claimsBeanProperty).setColumnName("Content");
		//
		BeanProperty<Claims, Integer> claimsBeanProperty_1 = BeanProperty.create("idClient");
		jTableBinding.addColumnBinding(claimsBeanProperty_1).setColumnName("Client-ID");
		//
		jTableBinding.bind();
	}
}
