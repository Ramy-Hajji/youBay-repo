package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class AdministratorManagement extends JFrame {

	private JPanel contentPane;
	addCategory aC;
	manageCategories mC;
	manageSubcategories mS;
	Overview o;
	categorySuggestions cS;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorManagement frame = new AdministratorManagement();
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
	public AdministratorManagement() {
		setTitle("Categories Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 185, 40);
		panel.add(menuBar);
		
		JMenu mnCategories = new JMenu("Categories");
		mnCategories.setFont(new Font("Segoe UI", Font.BOLD, 30));
		menuBar.add(mnCategories);
		
		JMenuItem mntmAddCategory = new JMenuItem("Add Category");
		mntmAddCategory.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mntmAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aC = new addCategory();
				scrollPane.setViewportView(aC);
				
			}
		});
		mnCategories.add(mntmAddCategory);
		
		JMenuItem mntmManageCategories = new JMenuItem("Manage Categories");
		mntmManageCategories.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mntmManageCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mC = new manageCategories();
				scrollPane.setViewportView(mC);
			}
		});
		mnCategories.add(mntmManageCategories);
		
		JMenuItem mntmManageSubcategories = new JMenuItem("Manage Subcategories");
		mntmManageSubcategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mS = new manageSubcategories();
				scrollPane.setViewportView(mS);
			}
		});
		mntmManageSubcategories.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mnCategories.add(mntmManageSubcategories);
		
		JMenuItem mntmOverviewCategories = new JMenuItem("OverView Categories & SubCategories");
		mntmOverviewCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = new Overview();
				scrollPane.setViewportView(o);
			}
		});
		
		JMenuItem mntmCategorySuggestions = new JMenuItem("Suggestions of Categories");
		mntmCategorySuggestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cS = new categorySuggestions();
				scrollPane.setViewportView(cS);
			}
		});
		mntmCategorySuggestions.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mnCategories.add(mntmCategorySuggestions);
		mntmOverviewCategories.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		mnCategories.add(mntmOverviewCategories);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 91, 856, 535);
		panel.add(scrollPane);
	}
}
