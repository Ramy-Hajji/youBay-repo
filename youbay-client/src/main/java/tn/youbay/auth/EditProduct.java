package tn.youbay.auth;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.youbay.delegates.DelegateProduct;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;
import tn.youbay.services.IServiceProduit;
import javax.swing.JComboBox;

public class EditProduct extends JFrame {
	Context context;
	IServiceProduit remote;
	private JPanel contentPane;
	private JTextField name;
	private JTextField brand;
	private JTextField state;
	private JTextField qt;
	private JTextField price;
	private JButton Edit2;
	private JButton Back;
	private JLabel lblNom;
	private JLabel lblBrand;
	private JLabel lblPayment;
	private JLabel lblQuantity;
	private JLabel lblPrice;
	private JLabel lblState;
	private JLabel lblDescription;
	private JTextField desc;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProduct frame = new EditProduct();
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

	public EditProduct() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(248, 73, 227, 20);
		contentPane.add(name);
		name.setColumns(10);

		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(248, 113, 227, 20);
		contentPane.add(brand);

		state = new JTextField();
		state.setColumns(10);
		state.setBounds(248, 284, 227, 20);
		contentPane.add(state);

		qt = new JTextField();
		qt.setColumns(10);
		qt.setBounds(248, 200, 227, 20);
		contentPane.add(qt);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(248, 242, 227, 20);
		contentPane.add(price);

		Edit2 = new JButton("Edit");

		Edit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DelegateProduct d = new DelegateProduct();
				ListProductFrame l1 = new ListProductFrame();
				
					Product p1 = new Product(
			                 l1.a,
			                 name.getText(),
			                 brand.getText(),
			                 PaymentWay.valueOf(comboBox.getSelectedItem().toString()),
			                 Double.parseDouble(price.getText()),
			                 state.getText(),
			                 Integer.parseInt(qt.getText()),
			                 desc.getText()
			                 );
	d.Edit(p1);

				
//				else
//				{
//					Product p1 = new Product(
//			                 l1.a,
//			                 name.getText(),
//			                 brand.getText(),
//			                 PaymentWay.CreditCard,
//			                 Double.parseDouble(price.getText()),
//			                 state.getText(),
//			                 Integer.parseInt(qt.getText()),
//			                 desc.getText()
//			                 );
//	d.Edit(p1);
//	
//				}
				System.out.println(PaymentWay.valueOf(comboBox.getSelectedItem().toString()));


			}
		});
		Edit2.setBounds(374, 362, 89, 23);
		contentPane.add(Edit2);

		Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListProductFrame e = new ListProductFrame();
				hide();
				e.show();
			}
		});
		Back.setBounds(268, 362, 89, 23);
		contentPane.add(Back);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblDescription.setBounds(128, 329, 89, 20);
		contentPane.add(lblDescription);
		
		desc = new JTextField();
		desc.setText((String) null);
		desc.setColumns(10);
		desc.setBounds(248, 329, 227, 20);
		contentPane.add(desc);

		lblNom = new JLabel("Name");
		lblNom.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblNom.setForeground(Color.WHITE);
		lblNom.setBounds(128, 73, 89, 20);
		contentPane.add(lblNom);

		lblBrand = new JLabel("Brand");
		lblBrand.setForeground(Color.WHITE);
		lblBrand.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblBrand.setBounds(128, 113, 89, 20);
		contentPane.add(lblBrand);

		lblPayment = new JLabel("Payment");
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblPayment.setBounds(128, 157, 89, 20);
		contentPane.add(lblPayment);

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity
				.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblQuantity.setBounds(128, 198, 89, 20);
		contentPane.add(lblQuantity);

		lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblPrice.setBounds(128, 240, 89, 20);
		contentPane.add(lblPrice);

		lblState = new JLabel("State");
		lblState.setForeground(Color.WHITE);
		lblState.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblState.setBounds(128, 284, 89, 20);
		contentPane.add(lblState);

		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(
				"D:\\esprit 3A2\\pdev\\PiDEV\\Pidev Image\\fond d'ecran anarchiste.png"));
		label.setBounds(0, 0, 720, 422);
		contentPane.add(label);

		ListProductFrame l = new ListProductFrame();
		name.setText(l.name);
		brand.setText(l.brand);
		price.setText(l.price + "");
		state.setText(l.state);
		qt.setText(l.qt + "");
		
		comboBox = new JComboBox();
		comboBox.setBounds(258, 157, 99, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Check");
		comboBox.addItem("CreditCard");

	}
}
