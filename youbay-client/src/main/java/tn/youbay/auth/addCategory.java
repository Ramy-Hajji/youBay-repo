package tn.youbay.auth;

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
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;






import tn.youbay.delegates.AccountDelegate;
import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.entities.Account;
import tn.youbay.entities.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class addCategory extends JPanel {
	private JTextField nameCategory;
	List<Category> categories;
	List<Account> accounts;
	Category category;

	/**
	 * Create the panel.
	 */
	public addCategory() {
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(204, 51, 0));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Add a Category", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(204, 51, 51)));
		setLayout(null);

		JLabel lblNameOfThe = new JLabel("Name of the new category :");
		lblNameOfThe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNameOfThe.setBounds(242, 127, 390, 52);
		add(lblNameOfThe);

		nameCategory = new JTextField();
		nameCategory.setFont(new Font("Tahoma", Font.PLAIN, 26));
		nameCategory.setBounds(198, 213, 399, 69);
		add(nameCategory);
		nameCategory.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = new Category();
				String name = nameCategory.getText();
				Boolean trouve = false;
				List<Category> liste = CategoryDelegate.dofindAllCategories();
				for (Category category : liste) {
					if (category.getName().equalsIgnoreCase(name))
						trouve = true;
				}
				if(name.equals(""))
						JOptionPane.showMessageDialog(null,
								"You should input the name of the new category",
								"Error", JOptionPane.ERROR_MESSAGE);
				if (trouve == false && !name.equals("")) {
					category.setState(true);
					category.setName(name);
					accounts = AccountDelegate.dofindAllAccounts();

					String texte = "Dear providers , A new category is now available ! Come on and check !";
					if (CategoryDelegate.doAddCategory(category)) {
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

						for (int i = 0; i < accounts.size(); i++) {
							to.add(accounts.get(i).getEmail());

						}

						String from = "youbaySite@gmail.com";
						String subject = "New Category added";
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
							msg.setSubject(subject);

							BodyPart messageBodyPart = new MimeBodyPart();

							messageBodyPart.setText(texte);

							Multipart multipart = new MimeMultipart();

							multipart.addBodyPart(messageBodyPart);

							msg.setContent(multipart);

							Transport transport = session.getTransport("smtp");
							transport.send(msg);

						} catch (Exception exc) {

						}

						JOptionPane.showMessageDialog(null,
								"Category added successfully ");
						nameCategory.setText("");

					} else
						JOptionPane.showMessageDialog(null, "Error", "Error",
								JOptionPane.ERROR_MESSAGE);

				}
				if (trouve == true )
					JOptionPane.showMessageDialog(null,
							"A category with the same name already exists",
							"Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAdd.setBounds(650, 416, 141, 52);
		add(btnAdd);

	}

}
