package Controller;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sorder.orderUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("all") public class soonUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					soonUI frame = new soonUI();
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
	public soonUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("院線電影");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new orderUI().show();
				dispose();
			}
		});
		lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(144, 30, 61, 16);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("即將上映");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(217, 30, 61, 16);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("成人專區");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"變態！不可以色色～～");
				JOptionPane.showMessageDialog(null,"尚未開放 敬請期待～");
			}
		});
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(290, 30, 61, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("會員專區");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new changeUI().show();
			}
		});
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(360, 25, 68, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Netfli+");
		lblNewLabel_4.setForeground(new Color(233, 61, 36));
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_4.setBounds(17, 6, 114, 53);
		panel.add(lblNewLabel_4);
		Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a6.gif")).getImage();
		
		JLabel lblNewLabel = new JLabel("2.28敬請期待");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 97));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(90, 241, 734, 141);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("2.28敬請期待");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 97));
		lblNewLabel_2.setBounds(90, 230, 734, 141);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(217, 30, 368, 564);
		panel.add(label);
		label.setIcon(new ImageIcon(ad1));
	}

}
