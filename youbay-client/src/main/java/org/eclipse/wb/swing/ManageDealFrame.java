package org.eclipse.wb.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import tn.youbay.delegates.DelegateDeal;
import tn.youbay.entities.Deal;
import tn.youbay.entities.TypeDeal;
import tn.youbay.services.interfaces.IServiceDealRemote;
import javax.swing.JToolBar;

public class ManageDealFrame extends JFrame {

	// ajouter ca
	List<Deal> listeDeals;
	static int idDeal;
	static String type;
	static Date startingDate;
	static Date deadline;
	static float discount;
	static String name;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDealFrame frame = new ManageDealFrame();
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
	public ManageDealFrame() {
		// try catch et context

		DelegateDeal delegateDeal= new DelegateDeal();

		listeDeals = new ArrayList<Deal>();
		listeDeals = delegateDeal.readAllDeals();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(20, 75, 622, 137);
		contentPane.add(table);

		JButton btnConsult = new JButton("Consult Successful Deals");
		btnConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuccessfullDeals sd = new SuccessfullDeals();
				hide();
				sd.show();
			}
		});
		btnConsult.setBounds(251, 349, 166, 23);
		contentPane.add(btnConsult);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelegateDeal delegateDeal= new DelegateDeal();
				int selectedRow = table.getSelectedRow();
				delegateDeal.deleteDealById(Integer.parseInt(table.getModel()
							.getValueAt(selectedRow, 0).toString()));

				System.out.println("deal deleted avec succès");
				//réafficher linterface
				hide();
				ManageDealFrame manageDealFrame = new ManageDealFrame();
				manageDealFrame.setVisible(true);
			}
		});
		btnCancel.setBounds(424, 282, 89, 23);
		contentPane.add(btnCancel);

		JButton btnEditDeadline = new JButton("Edit Deadline");
		btnEditDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row2 = table.getSelectedRow();
				idDeal = Integer.parseInt(table.getModel().getValueAt(row2, 0)
						.toString());
				type = table.getModel().getValueAt(row2, 4).toString();
				startingDate = (Date) table.getModel().getValueAt(row2, 1);
				deadline = (Date) table.getModel().getValueAt(row2, 2);
				
				discount = Float.parseFloat(table.getModel()
						.getValueAt(row2, 3).toString());
				
				name = table.getModel().getValueAt(row2, 5).toString();

				UpdateDeal up = new UpdateDeal();
				hide();
				up.show();
			}
		});
		btnEditDeadline.setBounds(523, 282, 119, 23);
		contentPane.add(btnEditDeadline);

		JButton btnEnableDeal = new JButton("enable Deal");
		btnEnableDeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelegateDeal delegateDeal= new DelegateDeal();
				
				int selectedRow = table.getSelectedRow();
				delegateDeal.enableDeal(Integer.parseInt(table.getModel()
						.getValueAt(selectedRow, 0).toString()));

				System.out.println("deal approved avec succès");
				//réafficher linterface
				hide();
				ManageDealFrame manageDealFrame = new ManageDealFrame();
				manageDealFrame.setVisible(true);
			}
		});
		btnEnableDeal.setBounds(10, 282, 89, 23);
		contentPane.add(btnEnableDeal);

		JButton btnDisable = new JButton("Disable");
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelegateDeal delegateDeal= new DelegateDeal();
				
				int selectedRow = table.getSelectedRow();
				delegateDeal.disableDeal(Integer.parseInt(table.getModel()
						.getValueAt(selectedRow, 0).toString()));

				System.out.println("deal desabled avec succès");
				//réafficher linterface
				hide();
				ManageDealFrame manageDealFrame = new ManageDealFrame();
				manageDealFrame.setVisible(true);
			}
		});
		btnDisable.setBounds(123, 282, 89, 23);
		contentPane.add(btnDisable);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Deal, List<Deal>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, listeDeals, table);
		//
		BeanProperty<Deal, Integer> dealBeanProperty = BeanProperty
				.create("idDeal");
		jTableBinding.addColumnBinding(dealBeanProperty).setColumnName(
				"id Deal");
		//
		BeanProperty<Deal, Date> dealBeanProperty_1 = BeanProperty
				.create("startingDate");
		jTableBinding.addColumnBinding(dealBeanProperty_1).setColumnName(
				"Starting Date");
		//
		BeanProperty<Deal, Date> dealBeanProperty_2 = BeanProperty
				.create("deadline");
		jTableBinding.addColumnBinding(dealBeanProperty_2).setColumnName(
				"deadline");
		//
		BeanProperty<Deal, Float> dealBeanProperty_3 = BeanProperty
				.create("discount");
		jTableBinding.addColumnBinding(dealBeanProperty_3).setColumnName(
				"discount");
		//
		BeanProperty<Deal, TypeDeal> dealBeanProperty_4 = BeanProperty
				.create("type");
		jTableBinding.addColumnBinding(dealBeanProperty_4)
				.setColumnName("type");
		//
		BeanProperty<Deal, String> dealBeanProperty_5 = BeanProperty
				.create("product.nom");
		jTableBinding.addColumnBinding(dealBeanProperty_5).setColumnName(
				"produit");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
