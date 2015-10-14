package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.entities.Deal;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;
import tn.youbay.entities.TypeDeal;
import javax.swing.JButton;

public class consultDealProduct extends JFrame {

	private JPanel contentPane;
	List<Deal>listeDeals;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultDealProduct frame = new consultDealProduct();
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
	public consultDealProduct() {
		
		DelegateDeal delegateDeal= new DelegateDeal();

		listeDeals = new ArrayList<Deal>();
		listeDeals = delegateDeal.readAllDeals();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(197, 177, -110, -127);
		contentPane.add(table);
		
		JButton btnParticiperAuDeal = new JButton("Participer au deal");
		btnParticiperAuDeal.setBounds(165, 215, 149, 23);
		contentPane.add(btnParticiperAuDeal);
		
		table_1 = new JTable();
		table_1.setBounds(43, 33, 309, 133);
		contentPane.add(table_1);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Deal, List<Deal>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listeDeals, table_1);
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
		BeanProperty<Deal, String> dealBeanProperty_5 = BeanProperty.create("product.name");
		jTableBinding.addColumnBinding(dealBeanProperty_5).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
