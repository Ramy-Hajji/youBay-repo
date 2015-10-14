package tn.youbay.auth;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import tn.youbay.delegates.DelegateProduct;
import tn.youbay.entities.Product;
import tn.youbay.entities.PaymentWay;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListProductFrame extends JFrame {
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
	 private JTextField search;
	 private JTable table;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListProductFrame frame = new ListProductFrame();
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
	public ListProductFrame() {
           DelegateProduct d = new DelegateProduct();
           
			Products = new ArrayList<Product>();
			Products = d.FindAll();
			
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 454);
		getContentPane().setLayout(null);

		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row1 = table.getSelectedRow();
				DelegateProduct d = new DelegateProduct();

					int id = Integer.parseInt(table.getModel()
							.getValueAt(row1, 0).toString());
					System.out.println(id);

					d.delete(id);
			}

				

		});
		delete.setBounds(271, 350, 98, 23);
		getContentPane().add(delete);

		JButton Active = new JButton("Activate");
		Active.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row1 = table.getSelectedRow();
				DelegateProduct d = new DelegateProduct();

					int id = Integer.parseInt(table.getModel()
							.getValueAt(row1, 0).toString());
					System.out.println(id);

					d.activate(id);

				

			}
		});
		Active.setBounds(409, 350, 89, 23);
		getContentPane().add(Active);
		
		JButton Edit = new JButton("Edit Product");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				
		EditProduct e = new EditProduct();
		
		
				hide();
				e.show();
			}
		});
		Edit.setBounds(525, 350, 108, 23);
		getContentPane().add(Edit);
		
		JButton btnPdf = new JButton("Pdf");
		btnPdf.addActionListener(new ActionListener() {
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
		btnPdf.setBounds(137, 350, 89, 23);
		getContentPane().add(btnPdf);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				
				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				DelegateProduct d = new DelegateProduct();
				
				
				
				
					
					
					
				
				
				
			}
		});
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
		});
		table.setBounds(149, 139, 448, 198);
		getContentPane().add(table);
		search.setBounds(210, 69, 183, 23);
		getContentPane().add(search);
		search.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(101, 70, 83, 17);
		getContentPane().add(lblNewLabel);
		
		JButton btnRech = new JButton("Rech");
		btnRech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					Products=d.Search(search.getText());
					initDataBindings();
				
				
				
			}
		});
		btnRech.setBounds(409, 69, 89, 23);
		getContentPane().add(btnRech);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListProductFrame f = new ListProductFrame();
				hide();
				f.show();
			}
		});
		btnLoad.setBounds(635, 11, 89, 23);
		getContentPane().add(btnLoad);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"D:\\esprit 3A2\\pdev\\PiDEV\\Pidev Image\\fond d'ecran anarchiste.png"));
		label.setBounds(0, 0, 734, 433);
		getContentPane().add(label);
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
