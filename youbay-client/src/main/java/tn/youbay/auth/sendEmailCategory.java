package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;


import javax.swing.JTextArea;

import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.entities.Accounts;
import tn.youbay.entities.Category;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sendEmailCategory extends JFrame {

	private JPanel contentPane;
	private JTextField nameAccount;
	JTextArea subject = new JTextArea();
	List<Accounts> accounts;
	List<Category> listeCat;
	List<String> listeSugg=new ArrayList();
	JList listCat;
	JList listSuggest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sendEmailCategory frame = new sendEmailCategory();
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
	public sendEmailCategory() {
		
		
		setTitle("Sending Email");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setBounds(41, 44, 92, 26);
		contentPane.add(lblTo);
		
		nameAccount = new JTextField();
		nameAccount.setBounds(139, 41, 462, 32);
		contentPane.add(nameAccount);
		nameAccount.setColumns(10);
		
		JLabel lblObject = new JLabel("Object :");
		lblObject.setBounds(41, 117, 92, 26);
		contentPane.add(lblObject);
		
		JLabel lblSuggestions = new JLabel("Categories available :");
		lblSuggestions.setBounds(46, 190, 217, 26);
		contentPane.add(lblSuggestions);
		
		accounts = manageCategories.accounts;
		List<String> to = new ArrayList() ;
		for (int i = 0; i < accounts.size(); i++) {
			to.add(accounts.get(i).getEmail());

		}
		
		for (int i = 0; i < to.size(); i++) {
			
			nameAccount.setText(nameAccount.getText()+to.get(i).toString()+";");
		}
		
		subject.setText("Dear provider , we plan to delete "+manageCategories.category.getName()+"\n You can choose to move your"
				+ " products in one of those listed below : ");
		
		DefaultListModel model = new DefaultListModel<>();
		DefaultListModel model1 = new DefaultListModel<>();
		listeCat = CategoryDelegate.dofindAllCategories();
		
		for (Category category : listeCat) {
			
			model.addElement(category.getName());
			
		}
		model.removeElement(manageCategories.category.getName());
		
		listCat = new JList(model);
		listCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model1.addElement(listCat.getSelectedValue().toString());
				
				
			}
		});
	
		model1.removeAllElements();
		listSuggest = new JList(model1);
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.stmp.user", "youbaySite@gmail.com");

				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Session session = Session.getDefaultInstance(props,
						new Authenticator() {
							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								String username = "youbaySite@gmail.com";
								String password = "youbaySiteInes";
								return new PasswordAuthentication(
										username, password);
							}
						});
				List<String> to = new ArrayList<String>();
				accounts = manageCategories.accounts;
				for (int i = 0; i < accounts.size(); i++) {
					to.add(accounts.get(i).getEmail());

				}
				
				String from = "youbaySite@gmail.com";
				String subject1 = "A category is going to be deleted";
				MimeMessage msg = new MimeMessage(session);
				try {

					msg.setFrom(new InternetAddress(from));
					InternetAddress[] addressTo = new InternetAddress[to
							.size()];
					for (int i = 0; i < to.size(); i++) {
						addressTo[i] = new InternetAddress(to.get(i)
								.toString());
					}
					msg.setRecipients(RecipientType.TO, addressTo);
					msg.setSubject(subject1);

					BodyPart messageBodyPart = new MimeBodyPart();
					String part1 = subject.getText();
					String part2 = "";
					messageBodyPart.setText(part1);
					for (int i = 0; i < model1.size(); i++) {
						
						listeSugg.add(model1.get(i).toString());
					}
					
					for (int i = 0; i < listeSugg.size(); i++) {
						
						part2 =part1+"\n"+part2+"\n"+listeSugg.get(i).toString();
					}
					messageBodyPart.setText(part2);

					Multipart multipart = new MimeMultipart();

					multipart.addBodyPart(messageBodyPart);

					msg.setContent(multipart);

					Transport transport = session.getTransport("smtp");
					transport.send(msg);

				} catch (Exception exc) {

				}
				JOptionPane.showMessageDialog(null, "Suggestion sent to concerned providers ");
				
			}
			
		});
		
		btnSend.setBounds(585, 496, 141, 35);
		contentPane.add(btnSend);
		
		
		listCat.setBounds(85, 237, 205, 209);
		contentPane.add(listCat);
		
		
		listSuggest.setBounds(417, 237, 217, 209);
		contentPane.add(listSuggest);
		
		JLabel lblSuggestedOnes = new JLabel("Suggested ones :");
		lblSuggestedOnes.setBounds(417, 190, 217, 26);
		contentPane.add(lblSuggestedOnes);
		
		
		subject.setBounds(139, 94, 462, 74);
		contentPane.add(subject);
	}
}
