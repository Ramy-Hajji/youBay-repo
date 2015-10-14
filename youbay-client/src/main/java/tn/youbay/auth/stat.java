package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class stat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stat frame = new stat();
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
	public stat() {
		
             
    
  
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultPieDataset pieDataset = new DefaultPieDataset();
	    

	       pieDataset.setValue("Like", new Integer(1));
	     pieDataset.setValue("Dislike", new Integer(85));
	      JFreeChart chart=ChartFactory.createPieChart("Votes", pieDataset, true, true, true);
	   //  ChartFrame frame=new ChartFrame("Pie", chart);
	    // p.setForegroundAlpha(TOP_ALIGNMENT);

//	     frame.setVisible(true);
//	     frame.setSize(450, 500);
	     ChartPanel chartp = new ChartPanel(chart);
	     chartp.setBounds(0, 13, 680, 420);
	     contentPane.add(chartp);
	     chart.setBackgroundPaint(new Color(0, 0, 0, 0));
	}
}
