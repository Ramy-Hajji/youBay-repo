package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.entities.Deal;
import tn.youbay.services.interfaces.IServiceDealRemote;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.util.Date;

import tn.youbay.entities.TypeDeal;

import org.jdesktop.beansbinding.ObjectProperty;

import tn.youbay.entities.Product;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuccessfullDeals extends JFrame {

	private JPanel contentPane;
	List<Deal>listeDealsSuccessful;
	private JTable table;
	private JTable table_1;
	private JButton btnStatistiques;
	private JButton btnPdf;
	private JButton btnEnvoyerMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccessfullDeals frame = new SuccessfullDeals();
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
	public SuccessfullDeals() {
		DelegateDeal delegateDeal= new DelegateDeal();
		
		listeDealsSuccessful = new ArrayList<Deal>();
		listeDealsSuccessful = delegateDeal.readAllSuccessfulDeals();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(237, 113, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(10, 11, 362, 171);
		contentPane.add(table_1);
		
		btnStatistiques = new JButton("Statistiques");
		btnStatistiques.setBounds(21, 216, 89, 23);
		contentPane.add(btnStatistiques);
		
		btnPdf = new JButton("PDF");
		btnPdf.setBounds(149, 216, 89, 23);
		contentPane.add(btnPdf);
		
		btnEnvoyerMail = new JButton("Envoyer mail");
		btnEnvoyerMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_1.getSelectedRow();
				String[] to ={table_1.getModel().getValueAt(selectedRow, 7).toString()};
				delegateDeal.mail(to);
				System.out.println("mail envoyé avec succés");
			}
		});
		btnEnvoyerMail.setBounds(265, 216, 123, 23);
		contentPane.add(btnEnvoyerMail);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Deal, List<Deal>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listeDealsSuccessful, table_1);
		//
		BeanProperty<Deal, Integer> dealBeanProperty = BeanProperty.create("idDeal");
		jTableBinding.addColumnBinding(dealBeanProperty).setColumnName("New Column");
		//
		BeanProperty<Deal, Date> dealBeanProperty_1 = BeanProperty.create("startingDate");
		jTableBinding.addColumnBinding(dealBeanProperty_1).setColumnName("New Column");
		//
		BeanProperty<Deal, Date> dealBeanProperty_2 = BeanProperty.create("deadline");
		jTableBinding.addColumnBinding(dealBeanProperty_2).setColumnName("New Column");
		//
		BeanProperty<Deal, Float> dealBeanProperty_3 = BeanProperty.create("discount");
		jTableBinding.addColumnBinding(dealBeanProperty_3).setColumnName("New Column");
		//
		BeanProperty<Deal, TypeDeal> dealBeanProperty_4 = BeanProperty.create("type");
		jTableBinding.addColumnBinding(dealBeanProperty_4).setColumnName("New Column");
		//
		BeanProperty<Deal, Product> dealBeanProperty_5 = BeanProperty.create("product");
		jTableBinding.addColumnBinding(dealBeanProperty_5).setColumnName("New Column");
		//
		BeanProperty<Deal, Integer> dealBeanProperty_6 = BeanProperty.create("noteClient");
		jTableBinding.addColumnBinding(dealBeanProperty_6).setColumnName("New Column");
		//
		BeanProperty<Deal, String> dealBeanProperty_7 = BeanProperty.create("provider.email");
		jTableBinding.addColumnBinding(dealBeanProperty_7).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
