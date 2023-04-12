package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.member.implMember;
import Model.member;
import Sorder.orderUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("all") public class changeUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField password2;
	private JTextField password3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeUI frame = new changeUI();
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
	public changeUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 400,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Change My Password");
		lblNewLabel_1.setBounds(254, 24, 140, 16);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 50, 407, 3);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Netfli+");
		lblNewLabel.setBounds(17, 0, 114, 53);
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
		
		username = new JTextField();
		username.setBounds(93, 93, 103, 26);
		username.setColumns(10);
		contentPane.add(username);
		
		password = new JTextField();
		password.setBounds(284, 93, 103, 26);
		password.setColumns(10);
		contentPane.add(password);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Password:\n");
		lblNewLabel_2_2_1.setBounds(208, 98, 85, 16);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Username:");
		lblNewLabel_2_2.setBounds(17, 98, 85, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("New Password:");
		lblNewLabel_2_2_2.setBounds(17, 186, 119, 16);
		lblNewLabel_2_2_2.setForeground(Color.RED);
		contentPane.add(lblNewLabel_2_2_2);
		
		password2 = new JTextField();
		password2.setBounds(127, 181, 130, 26);
		password2.setColumns(10);
		contentPane.add(password2);
		
		password3 = new JTextField();
		password3.setBounds(127, 214, 130, 26);
		password3.setColumns(10);
		contentPane.add(password3);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Password again:");
		lblNewLabel_2_2_2_1.setBounds(17, 219, 119, 16);
		lblNewLabel_2_2_2_1.setForeground(Color.RED);
		contentPane.add(lblNewLabel_2_2_2_1);
		
		JButton submit = new JButton("submit");
		submit.setBounds(284, 198, 88, 29);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String N=password2.getText();
				String Username=username.getText();
				member m=new implMember().queryUsername(Username);
				String Name=m.getName();
				if(password.getText().equals(m.getPassword())&&username.getText().equals(m.getUsername()))
				{
					if(password2.getText().equals(password3.getText()))
					{
						m.setPassword(N);
						new implMember().update(m);
						JOptionPane.showMessageDialog(null,"親愛的"+Name+"\n"+"密碼已更改"+"『"+N+"』"+"，不要忘囉～");
						dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"「新密碼」、「確認密碼」有誤，請重新輸入!!");
					}
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"輸入有誤,或查無此帳號");
				}
				
			}
		});
		contentPane.add(submit);
		
		JLabel lblNewLabel_2 = new JLabel("1.輸入帳號密碼 2.修改密碼");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(27, 65, 170, 16);
		contentPane.add(lblNewLabel_2);
	}
}
