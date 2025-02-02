package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.zxing.WriterException;

import QRPack.QRManager;
import SQL.SQLManager; 

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AttributFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ATTO(String[] args, String email, String fname, String lname, String pw) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttributFrame frame = new AttributFrame(args, email, fname, lname, pw);
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
	public AttributFrame(String[] args, String email, String fname, String lname, String pw) {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox UiDes = new JCheckBox("UI designer");
		UiDes.setBounds(10, 60, 145, 23);
		contentPane.add(UiDes);
		
		JCheckBox UXdes = new JCheckBox("UX designer");
		UXdes.setBounds(175, 60, 145, 23);
		contentPane.add(UXdes);
		
		JCheckBox FrontDev = new JCheckBox("Front-end Devoloper");
		FrontDev.setBounds(347, 60, 145, 23);
		contentPane.add(FrontDev);
		
		JCheckBox QualityEng = new JCheckBox("Quality assurance engineer");
		QualityEng.setBounds(10, 134, 168, 23);
		contentPane.add(QualityEng);
		
		JCheckBox FullDev = new JCheckBox("FullStack devoloper");
		FullDev.setBounds(175, 96, 145, 23);
		contentPane.add(FullDev);
		
		JCheckBox BackDev = new JCheckBox("Back-end devoloper");
		BackDev.setBounds(10, 96, 145, 23);
		contentPane.add(BackDev);
		
		JCheckBox Test = new JCheckBox("Tester");
		Test.setBounds(175, 134, 145, 23);
		contentPane.add(Test);
		
		JButton Validate = new JButton("Validate");
		Validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String QRPath = "./"+fname+lname+"QRCode.png";
				String QR = "email:"+email+" ,attribut: ";
				if (UiDes.isSelected()) {
					QR = QR + "/UIDESIGNER ";
				}
				if (UXdes.isSelected()) { 
					QR = QR + "/UXDESIGNER ";
				}
				if (FrontDev.isSelected()) {
					QR = QR + "/FRONTDEV ";
				}
				if (BackDev.isSelected()) {
					QR = QR + "/BACKDEV ";
				}
				if (FullDev.isSelected()) {
					QR = QR + "/FULLDEV ";
				}
				if (QualityEng.isSelected()) {
					QR = QR + "/QUALITYENGINEER ";
				}
				if (Test.isSelected()) {
					QR = QR + "/TESTER ";
				}
				try {
					QRManager.generateQRCodeImage(QR, 500, 500, QRPath);
				} catch (WriterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String query = "INSERT INTO users " + "VALUES ('"+email+"', '"+fname+"', '"+lname+"', '"+pw+"', '"+QR+"')";
				SQLManager.insertReg(query, QRPath, fname+lname);
				
			}
		});
		Validate.setBounds(171, 227, 145, 23);
		contentPane.add(Validate);
		
		JLabel indicator = new JLabel("");
		indicator.setBounds(171, 202, 145, 14);
		contentPane.add(indicator);
		
		JLabel lblNewLabel = new JLabel("What is your role in the company :");
		lblNewLabel.setBounds(10, 29, 199, 14);
		contentPane.add(lblNewLabel);
	}
}
