package tn.youbay.auth;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Accueil extends JFrame {

	private JPanel contentPane;
	static JScrollPane spane;
	addCategory aC;
	manageCategories mC;
	manageSubcategories mS;
	Overview o;
	categorySuggestions cS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Accueil frame = new Accueil();
					frame.setVisible(true);
					spane.setViewportView(new ptests());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Accueil() {
		setTitle("Adminstration Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SyntheticaLookAndFeel.setWindowsDecorated(false);
		UIManager.put("Synthetica.dialog.icon.enabled", true);

		try {
			UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		// if ("Nimbus".equals(info.getName())) {
		// UIManager.put("nimbusBase",new Color(50,50,50));
		// UIManager.put("TitledBorder.position",TitledBorder.CENTER);
		// UIManager.put("nimbusBlueGrey",new Color(65,40,20));
		// UIManager.put("control",new Color(128,128,128));
		// UIManager.setLookAndFeel(info.getClassName());
		// break;
		// }
		// }
		// }
		// catch ( Exception e) {
		setBounds(250, 250, 1000, 850);
		//
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnManageClaims = new JMenu("Manage claims");
		menuBar.add(mnManageClaims);

		JMenuItem mntmShowClaims = new JMenuItem("Show claims");
		mntmShowClaims.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				spane.setViewportView(new ptests());

			}
		});
		mnManageClaims.add(mntmShowClaims);

		JMenuItem menuItem = new JMenuItem("New menu item");
		mnManageClaims.add(menuItem);

		JMenu mnManageProducts = new JMenu("Products");
		menuBar.add(mnManageProducts);

		JMenuItem mntmDeleteProducts = new JMenuItem("Manage Products");
		mntmDeleteProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spane.setViewportView(new ListProductsJP());
			}
		});
		mnManageProducts.add(mntmDeleteProducts);

		JMenu mnManageCategories = new JMenu("Categories");
		menuBar.add(mnManageCategories);

		JMenuItem mntmAddCategories = new JMenuItem("Manage categories");
		mntmAddCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mC = new manageCategories();
				spane.setViewportView(mC);

			}
		});

		JMenuItem mntmNewMenuItem = new JMenuItem("Add category");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aC = new addCategory();
				spane.setViewportView(aC);
			}
		});
		mnManageCategories.add(mntmNewMenuItem);
		mnManageCategories.add(mntmAddCategories);

		JMenuItem mntmAddSubcategory = new JMenuItem("Manage sub-category");
		mntmAddSubcategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mS = new manageSubcategories();
				spane.setViewportView(mS);

			}
		});
		mnManageCategories.add(mntmAddSubcategory);

		JMenuItem mntmDeleteCategories = new JMenuItem("Suggestions");
		mntmDeleteCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cS = new categorySuggestions();
				spane.setViewportView(cS);

			}
		});
		mnManageCategories.add(mntmDeleteCategories);

		JMenuItem mntmEditCategories = new JMenuItem(
				"Overview categories & sub-categories");
		mntmEditCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = new Overview();
				spane.setViewportView(o);

			}
		});
		mnManageCategories.add(mntmEditCategories);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		spane = new JScrollPane();
		spane.setBounds(5, 5, 965, 641);
		contentPane.add(spane);

	}
}
