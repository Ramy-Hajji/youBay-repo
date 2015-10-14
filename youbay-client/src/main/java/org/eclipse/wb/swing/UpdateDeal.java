package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.entities.Deal;
import tn.youbay.entities.Product;
import tn.youbay.entities.TypeDeal;
import tn.youbay.services.interfaces.IServiceDealRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JCalendar;

import javax.swing.JComboBox;

public class UpdateDeal extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textDiscount;
	private JTextField textName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeal frame = new UpdateDeal();
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
	public UpdateDeal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdDeal = new JLabel("id Deal");
		lblIdDeal.setBounds(29, 30, 46, 14);
		contentPane.add(lblIdDeal);
		
		JLabel lblStartingDate = new JLabel("Starting Date");
		lblStartingDate.setBounds(29, 66, 75, 14);
		contentPane.add(lblStartingDate);
		
		JLabel lblDeadline = new JLabel("deadline");
		lblDeadline.setBounds(29, 115, 62, 14);
		contentPane.add(lblDeadline);
		
		JLabel lblDiscount = new JLabel("discount");
		lblDiscount.setBounds(29, 157, 46, 14);
		contentPane.add(lblDiscount);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(29, 182, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblNomDuProduit = new JLabel("Nom du Produit");
		lblNomDuProduit.setBounds(29, 207, 75, 14);
		contentPane.add(lblNomDuProduit);
		
		textId = new JTextField();
		textId.setBounds(124, 27, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textDiscount = new JTextField();
		textDiscount.setBounds(124, 154, 86, 20);
		contentPane.add(textDiscount);
		textDiscount.setColumns(10);
		
		textName = new JTextField();
		textName.setBounds(124, 204, 86, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JDateChooser startingDateCalendar = new JDateChooser();
		startingDateCalendar.setBounds(123, 66, 87, 20);
		contentPane.add(startingDateCalendar);
		
		JDateChooser endDateCalendar = new JDateChooser();
		endDateCalendar.setBounds(123, 109, 87, 20);
		contentPane.add(endDateCalendar);
		
		JComboBox comboBoxState = new JComboBox();
		comboBoxState.setBounds(124, 179, 86, 20);
		contentPane.add(comboBoxState);
		comboBoxState.addItem("enabled");
		comboBoxState.addItem("disabled");
		comboBoxState.addItem("waiting");
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DelegateDeal delegateDeal= new DelegateDeal();
				
				ManageDealFrame md=new ManageDealFrame();
				
				Date dateDeb;
				Date dateFin;
				dateDeb=startingDateCalendar.getDate();
				dateFin=endDateCalendar.getDate();
				
				Deal d=new Deal(md.idDeal,dateDeb, dateFin, Float.parseFloat(textDiscount.getText()));
				switch (comboBoxState.getSelectedItem().toString()) 
				{
				case "enabled":
					d.setType(TypeDeal.enabled);
					break;
				case "disabled":
					d.setType(TypeDeal.disabled);
					break;
				default:
					d.setType(TypeDeal.waiting);
					break;
				}
				Product product=new Product();
				product.setName(md.name);
				d.setProduct(product);
				delegateDeal.updateDeal(d);
				
				JOptionPane.showMessageDialog(null, "votre deal a été mis à jour");
						
						
				
			}
			
			//JDateChooser
			
		});
		btnConfirm.setBounds(286, 235, 89, 23);
		contentPane.add(btnConfirm);
		
		ManageDealFrame md=new ManageDealFrame();
		textId.setText(md.idDeal+"");
		textDiscount.setText(md.discount+"");
		textName.setText(md.name);
		startingDateCalendar.setDate(md.startingDate);
		endDateCalendar.setDate(md.deadline);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageDealFrame manageDealFrame=new ManageDealFrame();
				hide();
				manageDealFrame.show();
			}
		});
		btnBack.setBounds(134, 235, 89, 23);
		contentPane.add(btnBack);
		
		textId.disable();
		textDiscount.enable();
		textName.disable();		
		startingDateCalendar.disable();
		
	}
}
