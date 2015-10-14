package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;






import tn.youbay.delegates.CategoryDelegate;
import tn.youbay.delegates.SubCategoryDelegate;
import tn.youbay.entities.Category;
import tn.youbay.entities.SubCategory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class addSubCategory_1 extends JFrame {

	private JPanel contentPane;
	private JTextField nameSub;
	SubCategory sub;
	Category category = new Category();
	manageCategories mC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSubCategory_1 frame = new addSubCategory_1();
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
	public addSubCategory_1() {
		setTitle("Add Subcategory");
		setBounds(100, 100, 873, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Name of the new SubCategory :");
		label.setBounds(62, 97, 313, 26);
		panel.add(label);
		
		nameSub = new JTextField();
		nameSub.setColumns(10);
		nameSub.setBounds(414, 94, 186, 32);
		panel.add(nameSub);
		
		JLabel label_1 = new JLabel("This subcategory will be added under ");
		label_1.setBounds(80, 221, 383, 26);
		panel.add(label_1);
		
		JLabel nameCat = new JLabel("New label");
		nameCat.setBounds(508, 221, 92, 26);
		panel.add(nameCat);
		nameCat.setText(manageCategories.category.getName());
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub=new SubCategory();
				String name=nameSub.getText();
				boolean trouve=false;
				List<SubCategory> liste = SubCategoryDelegate.dofindAllSubCategories();
				
				for (SubCategory subCategory : liste) {
					if(subCategory.getName().equalsIgnoreCase(name)){
						trouve=true;
					}
				}
				if(name.equals(""))
					JOptionPane.showMessageDialog(null,
							"You should input the name of the new Subcategory",
							"Error", JOptionPane.ERROR_MESSAGE);
				if(trouve==false && !name.equals("")){
					
					category = CategoryDelegate.dofindCategoryById(manageCategories.category.getId_category());
					sub.setName(name);
					sub.setCategory(category);
					if(SubCategoryDelegate.doaddSubCategory(sub)){
						JOptionPane.showMessageDialog(null,"SubCategory was added to "+category.getName());
						nameSub.setText("");
					}	
				}
				if(trouve==true)
					JOptionPane.showMessageDialog(null, "Error this subcategory already belongs to another category","Error", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		button.setBounds(583, 342, 141, 61);
		panel.add(button);
	}

}
