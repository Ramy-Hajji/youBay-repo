package tn.youbay.auth;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

import tn.youbay.delegates.GestionAccountsDelegate;
import tn.youbay.delegates.GestionClaimsDelegate;
import tn.youbay.entities.Accounts;
import tn.youbay.entities.Claims;
import tn.youbay.services.IAccountsService;
import tn.youbay.services.IClaimService;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ptests extends JPanel {
	List<Claims> clll;
	Claims one;
	static Accounts aco;
	private JTable table;
	private JTextField usern;
	GestionClaimsDelegate gdc = new GestionClaimsDelegate();


	/**
	 * Create the panel.
	 */
	public ptests() {
		clll=gdc.ListOfClaims();
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.spane.setViewportView(new ptests());

								
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\refresh.png"));
		button.setBounds(595, 24, 35, 25);
		panel.add(button);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				one=clll.get(table.getSelectedRow());

				System.out.println(one);
			}
		});
		table.setBounds(61, 123, 592, 278);
		panel.add(table);
		
		JButton button_1 = new JButton("Delete claim");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gdc.supprimerClaim(one);
				
//				Context context;
//				try {
//					context = new InitialContext();
//					IClaimService remote;
//					remote=(IClaimService) context.lookup("/youbay-ejb/ClaimService!tn.youbay.services.IClaimService");
//					Claims i = new Claims();
//					System.out.println(one.getContent());
//					i.setContent(one.getContent());
//					i.setIdClient(one.getIdClient());
//					i.setId(one.getId());
//					remote.DeleteClaiim(one);
//					//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//					
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		button_1.setBounds(407, 414, 117, 25);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Send Email");
		button_2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.out.println(one.getContent());
			GestionAccountsDelegate gdl = new GestionAccountsDelegate();
			aco=gdl.getCliientbyID(one.getAccount().getId());
				//System.out.println(one.getIdClient());
//				Context context;
//				try {
//					context = new InitialContext();
//					IAccountsService remote;
//					remote=(IAccountsService) context.lookup("/youbay-ejb/AccountsService!tn.youbay.services.IAccountsService");
//					//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//					aco=remote.getClientbyID(one.getAccount().getId());
//				} catch (NamingException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				MailSendForm msf = new MailSendForm();
				hide();

				msf.setVisible(true);
			}
		});
		button_2.setBounds(530, 414, 123, 25);
		panel.add(button_2);
		
		JLabel lblSearchByUsername = new JLabel("Search by username: ");
		lblSearchByUsername.setBounds(94, 59, 136, 16);
		panel.add(lblSearchByUsername);
		
		usern = new JTextField();
		usern.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				GestionClaimsDelegate dd = new GestionClaimsDelegate();
				clll=dd.RechercheClaim(usern.getText());
				initDataBindings();
			}
		});
		usern.setBounds(253, 56, 136, 22);
		panel.add(usern);
		usern.setColumns(10);
		setLayout(groupLayout);
		GestionClaimsDelegate gdc = new GestionClaimsDelegate();
		clll=gdc.ListOfClaims();
//		Context context;
//		try {
//			context = new InitialContext();
//			IClaimService remote;
//			remote=(IClaimService) context.lookup("/youbay-ejb/ClaimService!tn.youbay.services.IClaimService");
//			clll=remote.ListOfClaims();
//			//System.out.println(remote.getUnAdmin(UsernameField.getText(), "s"));
//			
//		} catch (NamingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Claims, List<Claims>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, clll, table);
		//
		BeanProperty<Claims, String> claimsBeanProperty = BeanProperty.create("content");
		jTableBinding.addColumnBinding(claimsBeanProperty).setColumnName("Content");
		//
		BeanProperty<Claims, String> claimsBeanProperty_1 = BeanProperty.create("account.username");
		jTableBinding.addColumnBinding(claimsBeanProperty_1).setColumnName("Username");
		//
		jTableBinding.bind();
	}
}
