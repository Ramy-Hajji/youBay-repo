package tn.youbay.auth;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTable;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import tn.youbay.delegates.DelegateProduct;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListProductsJP extends JPanel {
	private JTextField search;
	private JTable table;
	List<Product> Products;
	List<Product> Products2;
	static String description;
	
	 static String name;
	 static String state;
	 static String brand;
	 static String pay;
	 static double price;
	 static int qt;
	 static int a;


	/**
	 * Create the panel.
	 */
	public ListProductsJP() {
		 DelegateProduct d = new DelegateProduct();
         
			Products = new ArrayList<Product>();
			Products = d.FindAll();
		setLayout(null);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				Products=d.Search(search.getText());
				initDataBindings();

			}
		});
		search.setColumns(10);
		search.setBounds(161, 104, 183, 23);
		add(search);
		
		JLabel label = new JLabel("Search");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(52, 105, 83, 17);
		add(label);
		
		JButton button = new JButton("Rech");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Products=d.Search(search.getText());
				initDataBindings();
			}
		});
		button.setBounds(360, 104, 89, 23);
		add(button);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
		});
		table.setBounds(100, 174, 448, 198);
		add(table);
		
		JButton button_1 = new JButton("Pdf");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row1 = table.getSelectedRow();
				a = Integer.parseInt(table.getModel()
						.getValueAt(row1, 0).toString());
				price = Double.parseDouble((table.getModel()
						.getValueAt(row1, 4).toString()));
				qt = Integer.parseInt(table.getModel()
						.getValueAt(row1, 5).toString());
				brand = (table.getModel()
						.getValueAt(row1, 1).toString());
				name = (table.getModel()
						.getValueAt(row1, 2).toString());
				pay = (table.getModel()
						.getValueAt(row1, 3).toString());
				state = (table.getModel()
						.getValueAt(row1, 6).toString());
				
					
				
				PdfClass c= new PdfClass();

					c.PdfProduct(a,name, brand, PaymentWay.valueOf(pay), price, state, qt);
					System.out.println("ok");
			}
		});
		button_1.setBounds(88, 385, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				DelegateProduct d = new DelegateProduct();

					int id = Integer.parseInt(table.getModel()
							.getValueAt(row1, 0).toString());
					System.out.println(id);

					d.delete(id);

			}
		});
		button_2.setBounds(222, 385, 98, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Activate");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				DelegateProduct d = new DelegateProduct();

					int id = Integer.parseInt(table.getModel()
							.getValueAt(row1, 0).toString());
					System.out.println(id);

					d.activate(id);
			}
		});
		button_3.setBounds(360, 385, 89, 23);
		add(button_3);
		
		JButton button_4 = new JButton("Edit Product");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				a = Integer.parseInt(table.getModel()
						.getValueAt(row1, 0).toString());
				price = Double.parseDouble((table.getModel()
						.getValueAt(row1, 4).toString()));
				qt = Integer.parseInt(table.getModel()
						.getValueAt(row1, 5).toString());
				brand = (table.getModel()
						.getValueAt(row1, 1).toString());
				name = (table.getModel()
						.getValueAt(row1, 2).toString());
				pay = (table.getModel()
						.getValueAt(row1, 3).toString());
				state = (table.getModel()
						.getValueAt(row1, 6).toString());
				Accueil.spane.setViewportView(new EditProducts());
				System.out.println(a+" "+price);
//		EditProduct ee = new EditProduct();
//		
//		
//				hide();
//				ee.show();
			}
		});
		button_4.setBounds(476, 385, 108, 23);
		add(button_4);
		
		JButton button_5 = new JButton("Load");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil.spane.setViewportView(new ListProductsJP());
			}
		});
		button_5.setBounds(586, 46, 89, 23);
		add(button_5);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, Products, table);
		//
		BeanProperty<Product, Integer> productBeanProperty = BeanProperty.create("id_product");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("id_product");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("brand");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Brand");
		//
		BeanProperty<Product, String> productBeanProperty_2 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("Name");
		//
		BeanProperty<Product, PaymentWay> productBeanProperty_3 = BeanProperty.create("payment_way");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("payment way");
		//
		BeanProperty<Product, Double> productBeanProperty_4 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_4).setColumnName("Price");
		//
		BeanProperty<Product, Integer> productBeanProperty_5 = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty_5).setColumnName("Quantity");
		//
		BeanProperty<Product, String> productBeanProperty_6 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(productBeanProperty_6).setColumnName("State");
		//
		jTableBinding.bind();
	}
}
