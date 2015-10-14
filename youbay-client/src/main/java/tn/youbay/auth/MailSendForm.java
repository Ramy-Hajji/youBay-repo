package tn.youbay.auth;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import tn.youbay.services.interfaces.IEmailSenderRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class MailSendForm extends JFrame {

	private JPanel contentPane;
	private JTextField content;
	private JTextField Subject;
	private JTextField Dest;
	private JButton btnB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MailSendForm frame = new MailSendForm();
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
	public MailSendForm() {
		setBounds(100, 100, 533, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		content = new JTextField();
		content.setBounds(92, 145, 380, 127);
		content.setColumns(10);
		contentPane.add(content);
		
		Subject = new JTextField();
		Subject.setBounds(92, 89, 244, 22);
		contentPane.add(Subject);
		Subject.setColumns(10);
		
		Dest = new JTextField();
		Dest.setEditable(false);
		Dest.setBounds(92, 42, 244, 22);
		Dest.setText(ptests.aco.getEmail());

		contentPane.add(Dest);
		Dest.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(406, 292, 97, 25);
		contentPane.add(btnSend);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(25, 45, 56, 16);
		contentPane.add(lblTo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(25, 92, 56, 16);
		contentPane.add(lblSubject);
		
		JLabel lblContent = new JLabel("Content: ");
		lblContent.setBounds(24, 145, 56, 16);
		contentPane.add(lblContent);
		
		btnB = new JButton("");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				S ClaimsList = new S();
				hide();
				ClaimsList.setVisible(true);
			}
		});
		btnB.setIcon(new ImageIcon("C:\\Users\\Asus\\Desktop\\backk.gif"));
		btnB.setBounds(12, 292, 29, 25);
		contentPane.add(btnB);
	}
}
