package tn.youbay.auth;

import java.util.ArrayList;
import java.util.Iterator;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;










import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jdesktop.beansbinding.ELProperty;

import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import tn.youbay.delegates.AccountDelegate;
import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.delegates.ProductDelegate;
import tn.youbay.delegates.SubCategoryDelegate;
import tn.youbay.entities.Accounts;
import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;

import java.awt.Component;

public class manageCategories extends JPanel {
	private JTable table;
	List<Category> categories;
	static Category category;
	SubCategory sub;
	private JTextField nameCategory;
	private JComboBox<String> comboBox;
	private JLabel lblNameCategory;
	private JLabel lblSubcategories;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnAddNewSubcategory;
	List<SubCategory> subcategories = new ArrayList<>();
	private JLabel warn;
	JScrollPane scrollPane;
	JPanel panel;
	static List<Accounts> accounts = new ArrayList<>();
	List<Product> products;

	/**
	 * Create the panel.
	 */
	public manageCategories() {

		setBackground(new Color(240, 240, 240));
		categories = new ArrayList<Category>();
		categories = CategoryDelegate.dofindAllCategories();
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(21, 100, 993, 466);
		add(panel);

		scrollPane = new JScrollPane();

		nameCategory = new JTextField();
		nameCategory.setColumns(10);

		comboBox = new JComboBox();

		lblNameCategory = new JLabel("Category Name :");
		lblNameCategory.setFont(new Font("Tahoma", Font.BOLD, 21));

		lblSubcategories = new JLabel("Subcategories :");
		lblSubcategories.setFont(new Font("Tahoma", Font.BOLD, 21));

		warn = new JLabel("This category has no subcategories");
		warn.setForeground(Color.RED);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id_category = categories.get(table.getSelectedRow())
						.getId_category();
				category = CategoryDelegate.dofindCategoryById(id_category);
				subcategories = SubCategoryDelegate
						.dofindSubCategoriesByCategory(category);

				if (subcategories.size() == 0) {
					if (CategoryDelegate.dodeleteCategory(category)) {
						JOptionPane
								.showMessageDialog(null, "Category deleted ");
						categories = CategoryDelegate.dofindAllCategories();
						initDataBindings();
					}
				} else {
					products = ProductDelegate.findProductsByCategory(category);
					for (Product product : products) {
						accounts.add(product.getAccount());
					}
					System.out.println("size account" + accounts.size());

					sendEmailCategory sEC = new sendEmailCategory();
					sEC.setVisible(true);
					JOptionPane
							.showMessageDialog(
									null,
									"This category contains subcategories, it can not be deleted",
									"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameCategory.getText();
				Boolean trouve = false;
				List<Category> liste = CategoryDelegate.dofindAllCategories();
				for (Category category : liste) {
					if (category.getName().equalsIgnoreCase(name))
						trouve = true;
				}
				if (name != "") {
					if (trouve == false) {
						String texte = "Dear providers , the category with name : "
								+ category.getName()
								+ " has changed to category name : " + name;

						category.setName(name);
						accounts = AccountDelegate.dofindAllAccounts();

						if (CategoryDelegate.doupdateCategory(category)) {

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
							String subject = "A Category modified";
							MimeMessage msg = new MimeMessage(session);
							try {

								msg.setFrom(new InternetAddress(from));
								InternetAddress[] addressTo = new InternetAddress[to
										.size()];
								for (int i = 0; i < to.size(); i++) {
									addressTo[i] = new InternetAddress(to
											.get(i).toString());
								}
								msg.setRecipients(RecipientType.TO, addressTo);
								msg.setSubject(subject);

								BodyPart messageBodyPart = new MimeBodyPart();

								messageBodyPart.setText(texte);

								Multipart multipart = new MimeMultipart();

								multipart.addBodyPart(messageBodyPart);

								msg.setContent(multipart);

								Transport transport = session
										.getTransport("smtp");
								transport.send(msg);

							} catch (Exception exc) {

							}
							JOptionPane.showMessageDialog(null,
									"Category modified successfully");
							categories = CategoryDelegate.dofindAllCategories();
							nameCategory.setText("");
							initDataBindings();
						}
					}
					if (trouve == true)
						JOptionPane.showMessageDialog(null,
								"A category with the same name already exists",
								"Error", JOptionPane.ERROR_MESSAGE);
				}if(name.equals(""))
					JOptionPane.showMessageDialog(null,
							"You should mention the new name ", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});

		btnAddNewSubcategory = new JButton("Create new SubCategory");
		btnAddNewSubcategory.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				addSubCategory_1 aS = new addSubCategory_1();
				aS.setVisible(true);
			}
		});
		warn.hide();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int id_category = categories.get(table.getSelectedRow())
						.getId_category();
				category = CategoryDelegate.dofindCategoryById(id_category);
				subcategories = SubCategoryDelegate
						.dofindSubCategoriesByCategory(category);

				nameCategory.setText(category.getName());

				comboBox.removeAllItems();
				if (subcategories.size() != 0) {
					lblSubcategories.show();
					comboBox.show();
					warn.hide();
					for (SubCategory subCategory : subcategories) {

						comboBox.addItem(subCategory.getName());

					}

				} else {
					warn.show();
					lblSubcategories.hide();
					comboBox.hide();

				}
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 21));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name of the category" }));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(21)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 306,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createParallelGroup(
																Alignment.LEADING)
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(5)
																				.addGroup(
																						gl_panel.createParallelGroup(
																								Alignment.LEADING)
																								.addGroup(
																										gl_panel.createSequentialGroup()
																												.addGap(7)
																												.addComponent(
																														lblNameCategory)
																												.addGap(9)
																												.addComponent(
																														nameCategory,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE))
																								.addGroup(
																										gl_panel.createSequentialGroup()
																												.addGap(49)
																												.addComponent(
																														warn))
																								.addGroup(
																										gl_panel.createSequentialGroup()
																												.addComponent(
																														lblSubcategories)
																												.addGap(21)
																												.addComponent(
																														comboBox,
																														GroupLayout.PREFERRED_SIZE,
																														232,
																														GroupLayout.PREFERRED_SIZE)))
																				.addGap(36))
																.addGroup(
																		gl_panel.createSequentialGroup()
																				.addGap(66)
																				.addComponent(
																						btnDelete,
																						GroupLayout.PREFERRED_SIZE,
																						156,
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(117)
																				.addComponent(
																						btnUpdate,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGap(171)))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(150)
																.addComponent(
																		btnAddNewSubcategory,
																		GroupLayout.PREFERRED_SIZE,
																		296,
																		GroupLayout.PREFERRED_SIZE)
																.addContainerGap()))));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(12)
																.addComponent(
																		scrollPane,
																		GroupLayout.PREFERRED_SIZE,
																		382,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(45)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(3)
																								.addComponent(
																										lblNameCategory))
																				.addComponent(
																						nameCategory,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(12)
																.addComponent(
																		warn)
																.addGap(12)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(3)
																								.addComponent(
																										lblSubcategories))
																				.addComponent(
																						comboBox,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(50)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						btnUpdate,
																						GroupLayout.PREFERRED_SIZE,
																						59,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						btnDelete,
																						GroupLayout.PREFERRED_SIZE,
																						60,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		btnAddNewSubcategory,
																		GroupLayout.PREFERRED_SIZE,
																		58,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(72)));
		panel.setLayout(gl_panel);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { btnUpdate, btnAddNewSubcategory, btnDelete,
						scrollPane, table, warn, lblSubcategories, comboBox,
						lblNameCategory, nameCategory }));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				panel, btnDelete, btnUpdate, btnAddNewSubcategory, scrollPane,
				table, warn, lblSubcategories, comboBox, lblNameCategory,
				nameCategory }));
		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<Category, List<Category>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, categories, table);
		//
		BeanProperty<Category, String> categoryBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(categoryBeanProperty).setColumnName(
				"Name of the category");
		//
		jTableBinding.bind();
	}
}
