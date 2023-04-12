package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.member.implMember;

import Model.member;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@SuppressWarnings("all") public class forgotPasswordUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField email;
	private JTextField phone;
	private JLabel label1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPasswordUI frame = new forgotPasswordUI();
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
	public forgotPasswordUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 407, 3);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Netfli+");
		lblNewLabel.setBounds(17, 6, 114, 53);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new loginUI().show();
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(233, 61, 36));
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Find My Password");
		lblNewLabel_1.setBounds(280, 30, 114, 16);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel_1);
		
		
		
		username = new JTextField();
		username.setBounds(150, 110, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(74, 115, 85, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("e-mail:");
		lblNewLabel_2_1.setBounds(74, 143, 85, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phone:");
		lblNewLabel_2_1_1.setBounds(74, 170, 85, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		email = new JTextField();
		email.setBounds(150, 137, 130, 26);
		email.setColumns(10);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setBounds(150, 165, 130, 26);
		phone.setColumns(10);
		contentPane.add(phone);
		
		JLabel label1 = new JLabel();
		label1.setBounds(74, 277, 171, 16);
		contentPane.add(label1);
		
		JButton check = new JButton("Find now");
		check.setBounds(172, 203, 85, 29);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				String Email=email.getText();
				String Phone=phone.getText();
				member m=new implMember().queryPassword(Username,Email,Phone);
				if(m!=null)
				{
					JOptionPane.showMessageDialog(null,"親愛的"+Username+"\n您的密碼為"+m.getPassword()+"\n不要再忘記嚕～");
					label1.setText(m.getPassword());
					new loginUI().show();
					dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"親，輸入不正確！!"+"\n請再次嘗試～");
				}
			}
		});
		contentPane.add(check);
		
		JLabel lblNewLabel_3 = new JLabel("輸入帳號、信箱地址及電話找回您的密碼");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(74, 71, 269, 16);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
