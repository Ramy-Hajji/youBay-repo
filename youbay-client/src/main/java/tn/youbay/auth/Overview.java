package tn.youbay.auth;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.delegates.ProductDelegate;
import tn.youbay.delegates.SubCategoryDelegate;
import tn.youbay.entities.Category;
import tn.youbay.entities.Product;
import tn.youbay.entities.SubCategory;


public class Overview extends JPanel {
	List<Category> listeCat;
	List<SubCategory> listeSubCat;
	List<Product> listeProd;
	JList listCat;
	JList listSubCat;
	JList listProd;
	Category category;
	DefaultListModel model = new DefaultListModel<>();
	DefaultListModel model1 = new DefaultListModel<>();
	DefaultListModel model2 = new DefaultListModel<>();
	/**
	 * Create the panel.
	 */
	public Overview() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 39, 969, 430);
		add(panel);
		listeCat = CategoryDelegate.dofindAllCategories();
		for (Category category : listeCat) {
			
			model.addElement(category.getName());
		}
		
		
		listCat = new JList(model);
		
		listCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model1.removeAllElements();
				
				int id = listCat.getSelectedIndex()+1;
				category = CategoryDelegate.dofindCategoryById(id);
				listeSubCat = SubCategoryDelegate.dofindSubCategoriesByCategory(category);
				if(listeSubCat.size()==0){
					model1.addElement("This Category does not contain subcategories");
				}else{
				for (SubCategory sub : listeSubCat) {
					
					model1.addElement(sub.getName());
					
				}
				}
				
			}
		});
		
		listSubCat = new JList(model1);
		listSubCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model2.removeAllElements();
				
				int id = listSubCat.getSelectedIndex()+1;
				SubCategory sub = SubCategoryDelegate.dofindSubCategoryById(id);
				listeProd = ProductDelegate.dofindProductsBySubCategory(sub);
				if(listeProd.size()==0){
					model2.addElement("This SubCategory does not contain products");
				}else{
				for (Product p : listeProd) {
					
					model2.addElement(p.getBrand());
					
				}
				}
			}
		});
		listProd = new JList(model2);
		JLabel lblCategoriesList = new JLabel("Categories List :");
		
		JLabel lblSubcategoriesList = new JLabel("SubCategories List :");
		
		
		
		JLabel lblProductsList = new JLabel("Products List :");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCategoriesList)
						.addComponent(listCat, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(listSubCat, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubcategoriesList))
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(listProd, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProductsList))
					.addContainerGap(226, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategoriesList)
						.addComponent(lblSubcategoriesList)
						.addComponent(lblProductsList))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(listCat, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addComponent(listSubCat, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(listProd, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
}
