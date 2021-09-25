package UI;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CP_ABE.AES;
import SQL.SQLManager;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Encrypd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String Policy = "everyone";
	private JRadioButton lastSelected = null ;
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnBackendDevoloper;
	private JRadioButton rdbtnUxDesigner;
	private JRadioButton rdbtnFullstackDevoloper ;
	private JRadioButton rdbtnTester ;
	private JRadioButton rdbtnFrontendDevoloper ;
	private JRadioButton rdbtnQualityAssuranceEngineer  ;
	private JTextArea txtrEveryone ;
	
	/**
	 * Launch the application.
	 */
	public static void barad(String info) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encrypd frame = new Encrypd(info);
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
	public Encrypd(String info) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 829);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(info);
		textField.setEditable(false);
		textField.setBounds(156, 212, 593, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtrEveryone = new JTextArea();
		txtrEveryone.setText("Everyone");
		txtrEveryone.setBounds(156, 391, 593, 194);
		contentPane.add(txtrEveryone);
		
		JButton btnNewButton = new JButton("Or");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	QR = QR + "/UI DESIGNER ";
				//}
				//if (UXdes.isSelected()) { 
				//	QR = QR + "/UX DESIGNER ";
				//}
				//if (FrontDev.isSelected()) {
				//	QR = QR + "/FRONT DEV ";
				//}
				//if (BackDev.isSelected()) {
				//	QR = QR + "/BACK DEV ";
				//}
				//if (FullDev.isSelected()) {
				//	QR = QR + "/FULL DEV ";
				//}
				//if (UiDes.isSelected()) {
				//	QR = QR + "/FULL DEV ";
				//}
				//if (QualityEng.isSelected()) {
				//	QR = QR + "/QUALITY ENGINEER ";
				//}
				//if (Test.isSelected()) {
				//	QR = QR + "/TESTER ";
					
					String tmpString = "";
					
						if (rdbtnNewRadioButton.isSelected()) {
							tmpString = " or UIDESIGNER";
						}
						if (rdbtnBackendDevoloper.isSelected()) {
							tmpString = " or BACKDEV";
						}
						if (rdbtnFrontendDevoloper.isSelected()) {
							tmpString = " or FRONTDEV";
						}
						if (rdbtnFullstackDevoloper.isSelected()) {
							tmpString = " or FULLDEV";
						}
						if (rdbtnQualityAssuranceEngineer.isSelected()) {
							tmpString = " or QUALITYENGINEER";
						}
						if (rdbtnTester.isSelected()) {
							tmpString = " or TESTER";
						}
						if (rdbtnUxDesigner.isSelected()) {
							tmpString = " or UXDESIGNER";
						}
						
						
					Policy = Policy + tmpString;
					txtrEveryone.setText(Policy);
			}
		});
		btnNewButton.setBounds(562, 596, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAnd = new JButton("And");
		btnAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	QR = QR + "/UI DESIGNER ";
			//}
			//if (UXdes.isSelected()) { 
			//	QR = QR + "/UX DESIGNER ";
			//}
			//if (FrontDev.isSelected()) {
			//	QR = QR + "/FRONT DEV ";
			//}
			//if (BackDev.isSelected()) {
			//	QR = QR + "/BACK DEV ";
			//}
			//if (FullDev.isSelected()) {
			//	QR = QR + "/FULL DEV ";
			//}
			//if (UiDes.isSelected()) {
			//	QR = QR + "/FULL DEV ";
			//}
			//if (QualityEng.isSelected()) {
			//	QR = QR + "/QUALITY ENGINEER ";
			//}
			//if (Test.isSelected()) {
			//	QR = QR + "/TESTER ";
				
				String tmpString = "";
				
					if (rdbtnNewRadioButton.isSelected()) {
						tmpString = " and UIDESIGNER";
					}
					if (rdbtnBackendDevoloper.isSelected()) {
						tmpString = " and BACKDEV";
					}
					if (rdbtnFrontendDevoloper.isSelected()) {
						tmpString = " and FRONTDEV";
					}
					if (rdbtnFullstackDevoloper.isSelected()) {
						tmpString = " and FULLDEV";
					}
					if (rdbtnQualityAssuranceEngineer.isSelected()) {
						tmpString = " and QUALITYENGINEER";
					}
					if (rdbtnTester.isSelected()) {
						tmpString = " and TESTER";
					}
					if (rdbtnUxDesigner.isSelected()) {
						tmpString = " and UXDESIGNER";
					}
					
					
				Policy = Policy + tmpString;
				txtrEveryone.setText(Policy);
			}
		});
		btnAnd.setBounds(463, 596, 89, 23);
		contentPane.add(btnAnd);
		
		CheckboxGroup cbg = new CheckboxGroup();
		
		JButton btnNewButton_1 = new JButton("Validate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CP_ABE.Policy p = new CP_ABE.Policy(txtrEveryone.getText());
				int key = p.getMKey();
				String encrybdo = AES.encrypt(SQLManager.getText(info), ""+key);
				System.out.println("is tetxt = "+encrybdo);
				SQLManager.UpdateText(info, encrybdo);
				SQLManager.UpdatePolicy(info, txtrEveryone.getText());
				dispose();
			}
		});
		btnNewButton_1.setBounds(321, 756, 145, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\Asset\\lock (4).png"));
		lblNewLabel.setBounds(321, 33, 130, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("File name");
		lblNewLabel_1.setBounds(10, 215, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Attributes");
		lblNewLabel_1_1.setBounds(10, 276, 83, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Policy Description");
		lblNewLabel_1_2.setBounds(10, 396, 136, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	QR = QR + "/UI DESIGNER ";
			//}
			//if (UXdes.isSelected()) { 
			//	QR = QR + "/UX DESIGNER ";
			//}
			//if (FrontDev.isSelected()) {
			//	QR = QR + "/FRONT DEV ";
			//}
			//if (BackDev.isSelected()) {
			//	QR = QR + "/BACK DEV ";
			//}
			//if (FullDev.isSelected()) {
			//	QR = QR + "/FULL DEV ";
			//}
			//if (UiDes.isSelected()) {
			//	QR = QR + "/FULL DEV ";
			//}
			//if (QualityEng.isSelected()) {
			//	QR = QR + "/QUALITY ENGINEER ";
			//}
			//if (Test.isSelected()) {
			//	QR = QR + "/TESTER ";
				
				String tmpString = "";
				
					if (rdbtnNewRadioButton.isSelected()) {
						tmpString = "UIDESIGNER";
					}
					if (rdbtnBackendDevoloper.isSelected()) {
						tmpString = "BACKDEV";
					}
					if (rdbtnFrontendDevoloper.isSelected()) {
						tmpString = "FRONTDEV";
					}
					if (rdbtnFullstackDevoloper.isSelected()) {
						tmpString = "FULLDEV";
					}
					if (rdbtnQualityAssuranceEngineer.isSelected()) {
						tmpString = "QUALITYENGINEER";
					}
					if (rdbtnTester.isSelected()) {
						tmpString = "TESTER";
					}
					if (rdbtnUxDesigner.isSelected()) {
						tmpString = "UXDESIGNER";
					}
					
					
				Policy = tmpString;
				txtrEveryone.setText(tmpString);
			}
		});
		btnAdd.setBounds(660, 596, 89, 23);
		contentPane.add(btnAdd);
		
		rdbtnNewRadioButton = new JRadioButton("UI designer");
		rdbtnNewRadioButton.setBounds(156, 272, 109, 23);
		group.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnBackendDevoloper = new JRadioButton("Back-end devoloper");
		rdbtnBackendDevoloper.setBounds(156, 308, 145, 23);
		group.add(rdbtnBackendDevoloper);
		contentPane.add(rdbtnBackendDevoloper);
		
		rdbtnUxDesigner = new JRadioButton("UX designer");
		rdbtnUxDesigner.setBounds(321, 267, 145, 23);
		group.add(rdbtnUxDesigner);
		contentPane.add(rdbtnUxDesigner);
		
		rdbtnFullstackDevoloper = new JRadioButton("FullStack devoloper");
		rdbtnFullstackDevoloper.setBounds(321, 308, 145, 23);
		group.add(rdbtnFullstackDevoloper);
		contentPane.add(rdbtnFullstackDevoloper);
		
		rdbtnTester = new JRadioButton("Tester");
		rdbtnTester.setBounds(156, 346, 145, 23);
		group.add(rdbtnTester);
		contentPane.add(rdbtnTester);
		
		rdbtnFrontendDevoloper = new JRadioButton("Front-end Devoloper");
		rdbtnFrontendDevoloper.setBounds(493, 272, 145, 23);
		group.add(rdbtnFrontendDevoloper);
		contentPane.add(rdbtnFrontendDevoloper);
		
		rdbtnQualityAssuranceEngineer = new JRadioButton("Quality assurance engineer");
		rdbtnQualityAssuranceEngineer.setBounds(493, 308, 176, 23);
		group.add(rdbtnQualityAssuranceEngineer);
		contentPane.add(rdbtnQualityAssuranceEngineer);
	}
}
