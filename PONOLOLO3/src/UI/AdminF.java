package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CP_ABE.AES;
import CP_ABE.Key;
import SQL.SQLManager;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AdminF extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void sain(String[] args, String path, String Owner) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminF frame = new AdminF(path, Owner);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param info 
	 */
	public AdminF(String path , String Owner) {
		System.out.println("home= "+ Owner);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 828);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//String data[][] = {{"Owner","Description","Type"},
		//		   {"Deepak","PGDCA","History"},
		//		   {"Ranjan","M.SC.","Biology"},
		//		   {"Radha","BCA","Computer"}};
		
		String data[][] = SQLManager.UserUploader();
		
	    String col[] = {"First name","Last name","Email", "Access Level"};
        DefaultTableModel model = new DefaultTableModel(data,col);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Asset\\lock (4).png"));
		lblNewLabel.setBounds(26, 65, 130, 128);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Log off");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogReg frm = new LogReg(null);
				frm.poompe(null);
				dispose();
			}
			
		});
		btnNewButton_2_1.setBounds(26, 721, 130, 23);
		contentPane.add(btnNewButton_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 11, 867, 733);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2_1_1 = new JButton("Grant administration");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][2];
				SQLManager.UpdateConfi(info, "2");
				AdminF f = new AdminF(path, Owner);
				f.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_1_1.setBounds(931, 755, 130, 23);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("Grant DataOwner");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][2];
				SQLManager.UpdateConfi(info, "1");
				AdminF f = new AdminF(path, Owner);
				f.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_1_2.setBounds(791, 755, 130, 23);
		contentPane.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_1_3 = new JButton("Delete User");
		btnNewButton_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][2];
				SQLManager.DeleteUser(info);
				AdminF f = new AdminF(path, Owner);
				f.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_1_3.setBounds(511, 755, 130, 23);
		contentPane.add(btnNewButton_2_1_3);
		
		JButton btnNewButton_2_1_4 = new JButton("DataFrame");
		btnNewButton_2_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home HomeFrame = new Home(path, Owner);
				HomeFrame.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_1_4.setBounds(26, 687, 130, 23);
		contentPane.add(btnNewButton_2_1_4);
		
		JButton btnNewButton_2_1_2_1 = new JButton("Revoke prevliges");
		btnNewButton_2_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][2];
				SQLManager.UpdateConfi(info, "0");
				AdminF f = new AdminF(path, Owner);
				f.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_1_2_1.setBounds(651, 755, 130, 23);
		contentPane.add(btnNewButton_2_1_2_1);
	}
}
