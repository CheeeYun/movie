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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("all") public class mv4 extends JFrame {

	private JPanel contentPane;
	private JTextField place;
	private JTextField round;
	private JTextField seat;
	private JTextField movie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mv4 frame = new mv4();
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
	public mv4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 400, 622);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("電影：");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setBounds(85, 435, 69, 16);
		panel.add(lblNewLabel_1_2);
		
		JTextArea txtrbenedictCumberbatch = new JTextArea();
		txtrbenedictCumberbatch.setText("由本尼迪克特·康伯巴奇 \n(Benedict Cumberbatch) \n配音的這部動畫版蘇斯博士\n的節日故事在節日季前夕完\n美上映。");
		txtrbenedictCumberbatch.setForeground(Color.LIGHT_GRAY);
		txtrbenedictCumberbatch.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtrbenedictCumberbatch.setEditable(false);
		txtrbenedictCumberbatch.setBackground(Color.BLACK);
		txtrbenedictCumberbatch.setBounds(182, 62, 166, 80);
		panel.add(txtrbenedictCumberbatch);
		
		JLabel lblNewLabel_2 = new JLabel("約翰尼英語再次罷工");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(182, 18, 189, 26);
		panel.add(lblNewLabel_2);
		
		JLabel label2 = new JLabel("New label");
		label2.setBounds(46, 230, 302, 203);
		panel.add(label2);
		Image ad2 = new ImageIcon(this.getClass().getResource("/Pic/seat4.png")).getImage();
		label2.setIcon(new ImageIcon(ad2));
		
		place = new JTextField();
		place.setColumns(10);
		place.setBounds(156, 463, 130, 26);
		panel.add(place);
		
		JLabel lblNewLabel_1 = new JLabel("影廳：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(85, 468, 69, 16);
		panel.add(lblNewLabel_1);
		
		round = new JTextField();
		round.setColumns(10);
		round.setBounds(156, 495, 130, 26);
		panel.add(round);
		
		JLabel lblNewLabel_1_1 = new JLabel("場次：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(85, 500, 69, 16);
		panel.add(lblNewLabel_1_1);
		
		seat = new JTextField();
		seat.setColumns(10);
		seat.setBounds(156, 533, 130, 26);
		panel.add(seat);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("座位：");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(85, 538, 69, 16);
		panel.add(lblNewLabel_1_1_1);
		
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
				
				new orderUI().show();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(217, 571, 69, 29);
		panel.add(btnNewButton);
		
		movie = new JTextField();
		movie.setText("約翰尼英語再次罷工");
		movie.setEditable(false);
		movie.setColumns(10);
		movie.setBounds(156, 430, 130, 26);
		panel.add(movie);
		movie.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("場次(本日) : 17:30、19:40、22:00");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(182, 182, 239, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("影廳 : 大武廳、文賢廳 ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(182, 141, 138, 16);
		panel.add(lblNewLabel_4);
		
		JLabel label1 = new JLabel("");
		label1.setForeground(Color.WHITE);
		label1.setBounds(-29, 18, 280, 200);
		panel.add(label1);
		Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/ad19.jpeg")).getImage();
		label1.setIcon(new ImageIcon(ad1));
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new orderUI().setVisible(true);
				dispose();
				}
			
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(156, 571, 69, 29);
		panel.add(btnNewButton_1);
	}

}
