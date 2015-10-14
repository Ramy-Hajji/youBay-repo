package tn.youbay.auth;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;




import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.entities.Category;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class categorySuggestions extends JPanel {
	private JTable table;
	List<Category> categories;
	private JScrollPane scrollPane;
	Category category;
	

	/**
	 * Create the panel.
	 */
	public categorySuggestions() {
		setLayout(null);
		categories = new ArrayList<Category>();
		categories = CategoryDelegate.dofindAllCategoriesNotApproved();
		if(categories.size() == 0)
			JOptionPane.showMessageDialog(null,"No suggestions available by now ");
		JPanel panel = new JPanel();
		panel.setBounds(21, 127, 380, 358);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id_category=categories.get(table.getSelectedRow()).getId_category();
				category = CategoryDelegate.dofindCategoryById(id_category);
			}
		});
		scrollPane.setBounds(21, 21, 338, 316);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JCheckBox chckbxAppro = new JCheckBox("Approve");
		chckbxAppro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_category=categories.get(table.getSelectedRow()).getId_category();
				category = CategoryDelegate.dofindCategoryById(id_category);
				String name = category.getName();
				Boolean trouve=false;
				List<Category> liste = CategoryDelegate.dofindAllCategories();
				for (Category category : liste) {
					if(category.getName().equalsIgnoreCase(name))
						trouve=true;
				}
				if(trouve==false){
						category.setState(true);
						if(CategoryDelegate.doupdateCategory(category)){
							JOptionPane.showMessageDialog(null,"Category approved ");
							categories = CategoryDelegate.dofindAllCategoriesNotApproved();
							if(categories.size() == 0)
								JOptionPane.showMessageDialog(null,"No other suggestions received by now ");
							else
								initDataBindings();
						}
				}
				if(trouve==true)
					JOptionPane.showMessageDialog(null, "A category with the same name already exists","Error", JOptionPane.ERROR_MESSAGE);
			
			}
		});
		chckbxAppro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chckbxAppro.setBounds(444, 265, 173, 35);
		add(chckbxAppro);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Reject");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_category=categories.get(table.getSelectedRow()).getId_category();
				category = CategoryDelegate.dofindCategoryById(id_category);
				
				if(CategoryDelegate.dodeleteCategory(category)){
						JOptionPane.showMessageDialog(null,"Category rejected ");
						categories = CategoryDelegate.dofindAllCategoriesNotApproved();
						if(categories.size() == 0)
							JOptionPane.showMessageDialog(null,"No other suggestions received by now ");
						else
							initDataBindings();
					}
				
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chckbxNewCheckBox.setBounds(444, 327, 173, 35);
		add(chckbxNewCheckBox);
		
		JLabel lblActions = new JLabel("Actions :");
		lblActions.setBounds(444, 192, 92, 26);
		add(lblActions);
		
		JLabel lblTheCategoriesSuggested = new JLabel("The categories suggested by some consumers :");
		lblTheCategoriesSuggested.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTheCategoriesSuggested.setBounds(32, 67, 622, 39);
		add(lblTheCategoriesSuggested);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Category, List<Category>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, categories, table);
		//
		BeanProperty<Category, String> categoryBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(categoryBeanProperty).setColumnName("Name of the category");
		//
		jTableBinding.bind();
	}
}
