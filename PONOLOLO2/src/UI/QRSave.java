package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class QRSave extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void qro(String[] args, String path) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRSave frame = new QRSave(path);
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
	public QRSave(String path) {
		setType(Type.POPUP);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 971, 902);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    BufferedImage img;
		try {
			img = ImageIO.read(new File(path));
			ImageIcon icon = new ImageIcon(img);
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(20, 11, 925, 807);
			contentPane.add(lblNewLabel);
			lblNewLabel.setIcon(icon);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(432, 829, 125, 23);
		contentPane.add(btnNewButton);
	}

}
