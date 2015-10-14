package tn.youbay.auth;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;








import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;


import org.jdesktop.beansbinding.ObjectProperty;

import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.delegates.ProductDelegate;
import tn.youbay.delegates.SubCategoryDelegate;
import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageSubcategories extends JPanel {
	List<SubCategory> subcategories;
	List<Product> products;
	SubCategory subCategory;
	private JTextField nameSub;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField nameCat;
	JLabel lblMoveToCategory;
	JComboBox comboBoxListeCat;

	/**
	 * Create the panel.
	 */
	public manageSubcategories() {

		subcategories = new ArrayList<SubCategory>();
		subcategories = SubCategoryDelegate.dofindAllSubCategories();
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 45, 993, 501);
		add(panel);

		scrollPane = new JScrollPane();

		JLabel lblSubcategoryName = new JLabel("SubCategory Name :");
		lblSubcategoryName.setFont(new Font("Tahoma", Font.BOLD, 21));

		nameSub = new JTextField();
		nameSub.setColumns(10);

		JLabel lblThisSubcategoryHas = new JLabel(
				"This subcategory has no products");
		lblThisSubcategoryHas.setForeground(Color.RED);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				int idCat = 0;
				String name = nameSub.getText();
				Boolean trouve = false;
				String cat = comboBoxListeCat.getSelectedItem().toString();
				List<Category> listeC = CategoryDelegate.dofindAllCategories();
				for (Category category : listeC) {
					if (category.getName().equalsIgnoreCase(cat))
						idCat = category.getId_category();
				}
				Category c = new Category();
				c = CategoryDelegate.dofindCategoryById(idCat);
				List<SubCategory> liste = SubCategoryDelegate
						.dofindAllSubCategories();
				for (SubCategory subcategory : liste) {
					if (subcategory.getName().equalsIgnoreCase(name))
						trouve = true;
				}
			
				if (trouve == false && !name.equals("") && !cat.equals("")) {
					subCategory.setName(name);
					subCategory.setCategory(c);
					if (SubCategoryDelegate.doupdateSubCategory(subCategory)) {
						JOptionPane.showMessageDialog(null,
								"SubCategory modified successfully");
						subcategories = SubCategoryDelegate
								.dofindAllSubCategories();
						initDataBindings();
					}
				}
				if (trouve == true)
					JOptionPane.showMessageDialog(null,
							"A Subcategory with the same name already exists",
							"Error", JOptionPane.ERROR_MESSAGE);

			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_sub = subcategories.get(table.getSelectedRow())
						.getId_subCategory();
				subCategory = SubCategoryDelegate.dofindSubCategoryById(id_sub);
				products = ProductDelegate
						.dofindProductsBySubCategory(subCategory);

				if (products.size() == 0) {
					if (SubCategoryDelegate.dodeleteSubCategory(subCategory)) {
						JOptionPane.showMessageDialog(null,
								"SubCategory deleted ");
						subcategories = SubCategoryDelegate
								.dofindAllSubCategories();
						initDataBindings();
					}
				} else
					JOptionPane
							.showMessageDialog(
									null,
									"This subcategory contains products, it can not be deleted",
									"Error", JOptionPane.ERROR_MESSAGE);

			}
		});

		JLabel lblCategoryName = new JLabel("Category Name :");
		lblCategoryName.setFont(new Font("Tahoma", Font.BOLD, 24));

		nameCat = new JTextField();
		nameCat.setFont(new Font("Tahoma", Font.BOLD, 25));
		nameCat.setColumns(10);

		lblMoveToCategory = new JLabel("Move to Category :");
		lblMoveToCategory.setFont(new Font("Tahoma", Font.BOLD, 23));

		comboBoxListeCat = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(28)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 289,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(57)
																								.addGroup(
																										gl_panel.createParallelGroup(
																												Alignment.LEADING)
																												.addComponent(
																														lblSubcategoryName)
																												.addComponent(
																														lblCategoryName)
																												.addComponent(
																														lblMoveToCategory)))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(148)
																								.addComponent(
																										btnUpdate)))
																.addGap(24)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.TRAILING)
																				.addGroup(
																						gl_panel.createParallelGroup(
																								Alignment.LEADING,
																								false)
																								.addComponent(
																										comboBoxListeCat,
																										0,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										nameCat,
																										0,
																										0,
																										Short.MAX_VALUE)
																								.addGroup(
																										gl_panel.createSequentialGroup()
																												.addGap(1)
																												.addComponent(
																														nameSub,
																														GroupLayout.PREFERRED_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.PREFERRED_SIZE)))
																				.addComponent(
																						btnDelete)))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(115)
																.addComponent(
																		lblThisSubcategoryHas)))
								.addGap(385)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(39)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														scrollPane,
														GroupLayout.PREFERRED_SIZE,
														382,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						lblSubcategoryName)
																				.addComponent(
																						nameSub,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		lblThisSubcategoryHas)
																.addGap(30)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						lblCategoryName)
																				.addComponent(
																						nameCat,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(80)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						lblMoveToCategory)
																				.addComponent(
																						comboBoxListeCat,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		ComponentPlacement.RELATED,
																		60,
																		Short.MAX_VALUE)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.BASELINE)
																				.addComponent(
																						btnDelete,
																						GroupLayout.PREFERRED_SIZE,
																						44,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						btnUpdate,
																						GroupLayout.PREFERRED_SIZE,
																						44,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(29)))
								.addContainerGap(62, Short.MAX_VALUE)));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id_subCategory = subcategories.get(table.getSelectedRow())
						.getId_subCategory();
				subCategory = SubCategoryDelegate
						.dofindSubCategoryById(id_subCategory);
				List<Category> listeCat = CategoryDelegate
						.dofindAllCategories();
				for (Category category : listeCat) {

					comboBoxListeCat.addItem(category.getName());

				}
				nameSub.setText(subCategory.getName());
				Category c = new Category();
				c = subCategory.getCategory();
				nameCat.setText(c.getName());
				nameCat.setEnabled(false);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name of the SubCategory" }));
		scrollPane.setRowHeaderView(table);
		panel.setLayout(gl_panel);

		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<SubCategory, List<SubCategory>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, subcategories, table);
		//
		BeanProperty<SubCategory, String> subCategoryBeanProperty = BeanProperty
				.create("name");
		jTableBinding.addColumnBinding(subCategoryBeanProperty).setColumnName(
				"Name of the SubCategory");
		//
		jTableBinding.bind();
	}
}
