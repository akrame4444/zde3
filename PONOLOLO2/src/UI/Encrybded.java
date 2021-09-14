package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CP_ABE.AES;
import CP_ABE.Cipher;
import CP_ABE.Policy;
import SQL.SQLManager;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Encrybded extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void poi(String text,String Key, String owner, String fname) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encrybded frame = new Encrybded(text,Key, owner, fname);
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
	public Encrybded(String text,String Key, String owner, String fname) {
		setType(Type.POPUP);
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 844);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(Key);
		textField.setEditable(false);
		textField.setBounds(118, 214, 391, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your key");
		lblNewLabel.setBounds(10, 217, 98, 14);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(118, 245, 490, 515);
		textPane.setText(text);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("Content");
		lblNewLabel_1.setBounds(10, 245, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Decrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Policy policy = new Policy(SQLManager.getPolicy(fname));
				if (Cipher.GetMk(Key, SQLManager.getPolicy(fname), policy)==("")) {
					NoAccFrm frm = new NoAccFrm();
					frm.ain();
				} else {
					TextViewer txt = new TextViewer(AES.decrypt(SQLManager.getText(fname), Cipher.GetMk(Key, SQLManager.getPolicy(fname), policy)));
					txt.barad(AES.decrypt(SQLManager.getText(fname), Cipher.GetMk(Key, SQLManager.getPolicy(fname), policy)));
				}
			}
		});
		btnNewButton.setBounds(519, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\finalo\\pinalto\\lock (4).png"));
		lblNewLabel_2.setBounds(247, 11, 130, 128);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(247, 771, 130, 23);
		contentPane.add(btnNewButton_1);
	}
}
