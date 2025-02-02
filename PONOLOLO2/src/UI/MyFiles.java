package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SQL.SQLManager;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Window.Type;

public class MyFiles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void sain(String[] args, String path, String Owner) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFiles frame = new MyFiles(path, Owner);
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
	public MyFiles(String path , String Owner) {
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		
		System.out.println("My Files = "+ Owner);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1287, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//String data[][] = {{"Owner","Description","Type"},
		//		   {"Deepak","PGDCA","History"},
		//		   {"Ranjan","M.SC.","Biology"},
		//		   {"Radha","BCA","Computer"}};
		
		String data[][] = SQLManager.FileUploaderuser(Owner);
		
	    String col[] = {"file name","Description","owner","Type"};
        DefaultTableModel model = new DefaultTableModel(data,col);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(1131, 32, 130, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(194, 32, 923, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Open file");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(1203, 755, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete file");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][0];
				SQLManager.Delete(info);
			}
		});
		btnNewButton_2.setBounds(1063, 755, 130, 23);
		contentPane.add(btnNewButton_2);
		
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
		btnNewButton_2_1.setBounds(26, 649, 130, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Return");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frm = new Home(path , Owner);
				frm.sain(null, path, Owner);
				dispose();
			}
		});
		btnNewButton_2_2.setBounds(26, 603, 130, 23);
		contentPane.add(btnNewButton_2_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 65, 1052, 618);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2_3_1 = new JButton("Encrypt");
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = data [table.getSelectedRow()][0];
				Encrypd frm = new Encrypd(info);
				frm.barad(info);
			}
		});
		btnNewButton_2_3_1.setBounds(922, 755, 130, 23);
		contentPane.add(btnNewButton_2_3_1);
	}
}
