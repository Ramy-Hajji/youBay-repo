package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.delegates.DelegateProducts;
import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import tn.youbay.entities.PaymentWay;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListProducts extends JFrame {

	private JPanel contentPane;
	List<Product> products;
	private JTable table;
	
	static int idProduct;
	static String nomProduct;
	static String paymentWay;
	static float price;
	static int quantity;
	static String state;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListProducts frame = new ListProducts();
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
	public ListProducts() {
		
		DelegateProducts delegateProduct= new DelegateProducts();

		products = new ArrayList<Product>();
		products= delegateProduct.readAllProducts();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(51, 21, 328, 164);
		contentPane.add(table);
		
		JButton btnCreateDeal = new JButton("CREATE DEAL");
		btnCreateDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row2 = table.getSelectedRow();
				idProduct=Integer.parseInt(table.getModel().getValueAt(row2, 0).toString());
				nomProduct=table.getModel().getValueAt(row2, 1).toString();
				paymentWay=table.getModel().getValueAt(row2, 2).toString();
				price=Float.parseFloat(table.getModel().getValueAt(row2, 3).toString());
				quantity=Integer.parseInt(table.getModel().getValueAt(row2, 4).toString());
				state=table.getModel().getValueAt(row2, 5).toString();
				
				CreateDealOnProduct createDealOnProduct = new CreateDealOnProduct();
				hide();
				createDealOnProduct.show();
			}
		});
		btnCreateDeal.setBounds(160, 213, 116, 23);
		contentPane.add(btnCreateDeal);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Product, List<Product>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, products, table);
		//
		BeanProperty<Product, Integer> productBeanProperty = BeanProperty.create("idProduct");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("id Product");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("nom");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<Product, String> productBeanProperty_2 = BeanProperty.create("paymentWay");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("New Column");
		//
		BeanProperty<Product, Float> productBeanProperty_3 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("New Column");
		//
		BeanProperty<Product, Integer> productBeanProperty_4 = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty_4).setColumnName("New Column");
		//
		BeanProperty<Product, String> productBeanProperty_5 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(productBeanProperty_5).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
