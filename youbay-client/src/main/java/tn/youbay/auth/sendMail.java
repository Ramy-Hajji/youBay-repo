package tn.youbay.auth;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.youbay.services.interfaces.IEmailSenderRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sendMail extends JPanel {
	private JTextField content;
	private JTextField Subject;
	private JTextField Dest;

	/**
	 * Create the panel.
	 */
	public sendMail() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 13, 635, 454);
		add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Send");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Context context =  new InitialContext();
					IEmailSenderRemote remote;
					remote=(IEmailSenderRemote) context.lookup("/youbay-ejb/EmailSender!tn.youbay.services.IEmailSenderRemote");
			         String[] tos= {ptests.aco.getEmail()};

					 if (remote.SendMail("oussama.rekik@esprit.tn","tigran1993",Subject.getText(),content.getText(), tos)){
				            System.out.println("ok");

				        }
				            else
				        {
				            System.out.println("error");
				        }
				} catch (NamingException exception) {
					// TODO Auto-generated catch block
					
				}
			}
		});
		button.setBounds(452, 337, 97, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(58, 337, 29, 25);
		panel.add(button_1);
		
		content = new JTextField();
		content.setColumns(10);
		content.setBounds(138, 190, 380, 127);
		panel.add(content);
		
		JLabel label = new JLabel("Content: ");
		label.setBounds(70, 190, 56, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Subject");
		label_1.setBounds(71, 137, 56, 16);
		panel.add(label_1);
		
		Subject = new JTextField();
		Subject.setColumns(10);
		Subject.setBounds(138, 134, 219, 22);
		panel.add(Subject);
		
		Dest = new JTextField();
		Dest.setText((String) null);
		Dest.setEditable(false);
		Dest.setColumns(10);
		Dest.setBounds(138, 87, 219, 22);
		Dest.setText(S.aco.getEmail());

		panel.add(Dest);
		
		JLabel label_2 = new JLabel("To:");
		label_2.setBounds(71, 90, 56, 16);
		panel.add(label_2);

	}
}
