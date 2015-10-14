package tn.youbay.auth;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

import tn.youbay.delegates.DelegateProduct;
import tn.youbay.entities.PaymentWay;
import tn.youbay.entities.Product;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProducts extends JPanel {
	private JTextField name;
	private JTextField brand;
	private JTextField qt;
	private JTextField price;
	private JTextField state;
	private JTextField desc;
	JComboBox comboBox = new JComboBox();


	/**
	 * Create the panel.
	 */
	public EditProducts() {
		setLayout(null);
		
		name = new JTextField();
		name.setText((String) null);
		name.setColumns(10);
		name.setBounds(162, 41, 227, 20);
		add(name);
		
		JLabel label = new JLabel("Name");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label.setBounds(42, 41, 89, 20);
		add(label);
		
		JLabel label_1 = new JLabel("Brand");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_1.setBounds(42, 81, 89, 20);
		add(label_1);
		
		brand = new JTextField();
		brand.setText((String) null);
		brand.setColumns(10);
		brand.setBounds(162, 81, 227, 20);
		add(brand);
		
		JLabel label_2 = new JLabel("Payment");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_2.setBounds(42, 125, 89, 20);
		add(label_2);
		
		JLabel label_3 = new JLabel("Quantity");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_3.setBounds(42, 166, 89, 20);
		add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(-86, -32, 723, 422);
		add(label_4);
		
		qt = new JTextField();
		qt.setText("0");
		qt.setColumns(10);
		qt.setBounds(162, 168, 227, 20);
		add(qt);
		
		JLabel label_5 = new JLabel("Price");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_5.setBounds(42, 208, 89, 20);
		add(label_5);
		
		price = new JTextField();
		price.setText("0.0");
		price.setColumns(10);
		price.setBounds(162, 210, 227, 20);
		add(price);
		
		state = new JTextField();
		state.setText((String) null);
		state.setColumns(10);
		state.setBounds(162, 252, 227, 20);
		add(state);
		
		JLabel label_6 = new JLabel("State");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_6.setBounds(42, 252, 89, 20);
		add(label_6);
		
		JLabel label_7 = new JLabel("Description");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		label_7.setBounds(42, 297, 89, 20);
		add(label_7);
		
		desc = new JTextField();
		desc.setText((String) null);
		desc.setColumns(10);
		desc.setBounds(162, 297, 227, 20);
		add(desc);
		
		JButton button = new JButton("Back");
		button.setBounds(182, 330, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		button_1.addMouseListener(new MouseAdapter() {
			
		});
		button_1.setBounds(288, 330, 89, 23);
		add(button_1);
		
		comboBox.setBounds(162, 125, 109, 22);
		add(comboBox);
		ListProductsJP l = new ListProductsJP();
		name.setText(l.name);
		brand.setText(l.brand);
		price.setText(l.price + "");
		state.setText(l.state);
		qt.setText(l.qt + "");
		comboBox.addItem("Check");
		comboBox.addItem("CreditCard");


	}

}
