package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tn.youbay.delegates.DelegateProducts;
import tn.youbay.entities.Deal;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;
import tn.youbay.entities.Provider;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateProductOnProvider extends JFrame {

	private JPanel contentPane;
	private JTextField textProvider;
	private JTextField textName;
	private JTextField textPaymentWay;
	private JTextField textPrice;
	private JTextField textQuantity;
	private JTextField textState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateProductOnProvider frame = new CreateProductOnProvider();
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
	public CreateProductOnProvider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdProvider = new JLabel("id Provider");
		lblIdProvider.setBounds(35, 22, 74, 14);
		contentPane.add(lblIdProvider);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(33, 97, 76, 14);
		contentPane.add(lblProductName);
		
		JLabel lblPaymentWay = new JLabel("payment way");
		lblPaymentWay.setBounds(35, 138, 65, 14);
		contentPane.add(lblPaymentWay);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(36, 175, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("quantity");
		lblQuantity.setBounds(35, 212, 46, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblState = new JLabel("state");
		lblState.setBounds(35, 247, 46, 14);
		contentPane.add(lblState);
		
		JButton btnAddProduct = new JButton("add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelegateProducts delegateProduct=new DelegateProducts();
				
				Provider provider = new Provider();
				provider.setId(Integer.parseInt(textProvider.getText()));
				provider.setNom("Nadine");
				
				
				Product product=new Product();
				product.setName(textName.getText());
				product.setPayment_way(PaymentWay.valueOf(textPaymentWay.getText()));
				product.setPrice(Float.parseFloat(textPrice.getText()));
				product.setProvider(provider);
				product.setQuantity(Integer.parseInt(textQuantity.getText()));
				product.setState(textState.getText());
				
				delegateProduct.addProductOnProvider(product, provider);
				//JOptionPane.showMessageDialog(null, "vous avez ajouté votre produit avec succés");
				FindAllProductsByProviderId findAllProductsByProviderId=new FindAllProductsByProviderId(Integer.parseInt(textProvider.getText()));
				//Integer.parseInt(textProvider.getText())
				hide();
				findAllProductsByProviderId.show();
			}
		});
		btnAddProduct.setBounds(212, 272, 116, 23);
		contentPane.add(btnAddProduct);
		
		textProvider = new JTextField();
		textProvider.setBounds(117, 19, 86, 20);
		contentPane.add(textProvider);
		textProvider.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(117, 94, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textPaymentWay = new JTextField();
		textPaymentWay.setBounds(117, 135, 86, 20);
		contentPane.add(textPaymentWay);
		textPaymentWay.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setBounds(117, 172, 86, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(117, 209, 86, 20);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
		
		textState = new JTextField();
		textState.setBounds(117, 244, 86, 20);
		contentPane.add(textState);
		textState.setColumns(10);
	}
}
