package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.entities.Deal;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;
import tn.youbay.entities.TypeDeal;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class CreateDealOnProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textIdDeal;
	private JTextField textDiscount;
	private JTextField textProduct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDealOnProduct frame = new CreateDealOnProduct();
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
	public CreateDealOnProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdDeal = new JLabel("id Deal");
		lblIdDeal.setBounds(22, 21, 46, 14);
		contentPane.add(lblIdDeal);
		
		JLabel lblStartingDate = new JLabel("Starting Date");
		lblStartingDate.setBounds(22, 58, 75, 14);
		contentPane.add(lblStartingDate);
		
		JLabel lblDeadline = new JLabel("deadline");
		lblDeadline.setBounds(22, 99, 46, 14);
		contentPane.add(lblDeadline);
		
		JLabel lblDiscount = new JLabel("discount");
		lblDiscount.setBounds(22, 144, 46, 14);
		contentPane.add(lblDiscount);
		
		JLabel lblType = new JLabel("state");
		lblType.setBounds(22, 186, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(22, 222, 46, 14);
		contentPane.add(lblProduct);
		
		textIdDeal = new JTextField();
		textIdDeal.setBounds(95, 18, 86, 20);
		contentPane.add(textIdDeal);
		textIdDeal.setColumns(10);
		
		textDiscount = new JTextField();
		textDiscount.setBounds(95, 141, 86, 20);
		contentPane.add(textDiscount);
		textDiscount.setColumns(10);
		
		textProduct = new JTextField();
		textProduct.setBounds(95, 219, 86, 20);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		JDateChooser dateDebut = new JDateChooser();
		dateDebut.setBounds(94, 58, 87, 20);
		contentPane.add(dateDebut);
		
		JDateChooser dateFin = new JDateChooser();
		dateFin.setBounds(94, 99, 87, 20);
		contentPane.add(dateFin);
		
		JComboBox comboBoxState = new JComboBox();
		comboBoxState.setBounds(95, 183, 86, 20);
		contentPane.add(comboBoxState);
		comboBoxState.addItem("enabled");
		comboBoxState.addItem("disabled");
		comboBoxState.addItem("waiting");
		
		JButton btnCreateDeal = new JButton("CREATE DEAL");
		btnCreateDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DelegateDeal delegateDeal= new DelegateDeal();
				ListProducts listProducts=new ListProducts();
				
				Product product= new Product();
				product.setId_product(ListProducts.idProduct);
				product.setName(listProducts.nomProduct);
				product.setPayment_way(PaymentWay.valueOf(listProducts.paymentWay));
				product.setPrice(listProducts.price);
				product.setQuantity(listProducts.quantity);
				product.setState(listProducts.state);
				
				Deal deal=new Deal();
				deal.setIdDeal(Integer.parseInt(textIdDeal.getText()));
				deal.setDeadline(dateFin.getDate());
				deal.setDiscount(Float.parseFloat(textDiscount.getText()));
				deal.setProduct(product);
				deal.setStartingDate(dateDebut.getDate());
				
				switch (comboBoxState.getSelectedItem().toString()) 
				{
				case "enabled":
					deal.setType(TypeDeal.enabled);
					break;
				case "disabled":
					deal.setType(TypeDeal.disabled);
					break;
				default:
					deal.setType(TypeDeal.waiting);
					break;
				}
				delegateDeal.creeOffreSurProduit(product, deal);
				JOptionPane.showMessageDialog(null, "Vous avez maintenant ajouté votre deal avec succès");
			}
		});
		btnCreateDeal.setBounds(228, 250, 127, 23);
		contentPane.add(btnCreateDeal);
		
		ListProducts listProducts=new ListProducts();
		textProduct.setText(listProducts.idProduct+"");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProducts listProducts= new ListProducts();
				hide();
				listProducts.show();
			}
		});
		btnBack.setBounds(95, 250, 89, 23);
		contentPane.add(btnBack);
		
		
	}
}
