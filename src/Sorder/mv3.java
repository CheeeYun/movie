package Sorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.loginUI;
import Dao.Sorder.implSorder;
import Model.Sorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("all") public class mv3 extends JFrame {

	private JPanel contentPane;
	private JTextField movie;
	private JTextField place;
	private JTextField round;
	private JTextField seat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mv3 frame = new mv3();
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
	public mv3() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 400, 622);
		contentPane.add(panel);
		panel.setLayout(null);
		Image ad2 = new ImageIcon(this.getClass().getResource("/Pic/ad18.jpeg")).getImage();
		
		JTextArea txtrbenedictCumberbatch = new JTextArea();
		txtrbenedictCumberbatch.setText("迪士尼的《胡桃夾子》由凱拉奈特莉飾演糖\n梅仙子，講述了一個名叫克拉拉的女孩在薑\n餅人和玩具士兵組成的奇幻王國中的冒險經\n歷。");
		txtrbenedictCumberbatch.setForeground(Color.LIGHT_GRAY);
		txtrbenedictCumberbatch.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtrbenedictCumberbatch.setEditable(false);
		txtrbenedictCumberbatch.setBackground(Color.BLACK);
		txtrbenedictCumberbatch.setBounds(187, 69, 196, 80);
		panel.add(txtrbenedictCumberbatch);
		
		JLabel lblNewLabel_2 = new JLabel("胡桃夾子和四個王國");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(187, 25, 196, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("影廳 : 大武廳、文賢廳 ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(187, 148, 138, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("場次(本日) : 17:30、19:40、22:00");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(187, 189, 239, 16);
		panel.add(lblNewLabel_3);
		
		JLabel label2 = new JLabel("New label");
		label2.setBounds(51, 237, 302, 203);
		panel.add(label2);
		Image ad3 = new ImageIcon(this.getClass().getResource("/Pic/seat4.png")).getImage();
		label2.setIcon(new ImageIcon(ad3));
		
		movie = new JTextField();
		movie.setText("胡桃夾子和四個王國");
		movie.setEditable(false);
		movie.setColumns(10);
		movie.setBounds(147, 433, 130, 26);
		panel.add(movie);
		movie.setEditable(false);
		
		place = new JTextField();
		place.setColumns(10);
		place.setBounds(147, 466, 130, 26);
		panel.add(place);
		
		round = new JTextField();
		round.setColumns(10);
		round.setBounds(147, 498, 130, 26);
		panel.add(round);
		
		seat = new JTextField();
		seat.setColumns(10);
		seat.setBounds(147, 536, 130, 26);
		panel.add(seat);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("座位：");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(76, 541, 69, 16);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("場次：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(76, 503, 69, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("影廳：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(76, 471, 69, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("電影：");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(76, 438, 69, 16);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Movie=movie.getText();
				String Place=place.getText();
				String Round=round.getText();
				String Seat=seat.getText();
				System.out.println(loginUI.getU());
				Sorder s=new Sorder(loginUI.getU(),Movie,Place,Round,Seat);
				new implSorder().add(s);
				
				JOptionPane.showMessageDialog(null,
						 					"親愛的"+new orderUI().getN()+"\n"
											+"今日\t"+Round+"\n"
											+"電影\t"+Movie+"\n"
											+"地點\t"+Place+"\n"
											+"*票卷已加入購物車*");
				
				dispose();
				new orderUI().setVisible(true);
				
				
			
			}
			
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(208, 574, 69, 29);
		panel.add(btnNewButton);
		
		JLabel label1 = new JLabel("");
		label1.setForeground(Color.WHITE);
		label1.setBounds(-24, 25, 280, 200);
		panel.add(label1);
		label1.setIcon(new ImageIcon(ad2));
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new orderUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(147, 574, 69, 29);
		panel.add(btnNewButton_1);
	}
}
