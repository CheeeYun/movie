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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("all") public class signUpUI extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JTextField phone;
	private JLabel textLable;
	private JTextField password2;
	private JLabel textField_2;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpUI frame = new signUpUI();
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
	public  boolean checkPassword(String password) { 
		  String regex = "^(?=.*\\d)(?=.*[~!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,18}$";   //至少1數字.特殊符號.大寫.小寫(8-18碼)
	      return Pattern.matches(regex, password);
	}
	      
	public  boolean checkEmail(String email) {   
	      String regex = "^([\\w_\\-\\.])+@([\\w\\-\\.]+)\\.([A-za-z]{2,6})$";   //格式.....@.....域名
	      return Pattern.matches(regex, email);   
	  }   
	public  boolean checkPhone(String phone) { 
		  String regex = "^[0][9]\\d{2}-\\d{6}$";   //09開頭xxxx-xxxxxx
	      return Pattern.matches(regex, phone); 
	
	}
	public signUpUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 56, 407, 3);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Netfli+");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new loginUI().show();
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(233, 61, 36));
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(17, 6, 114, 53);
		contentPane.add(lblNewLabel);
		
		email = new JTextField();
		email.setBounds(169, 150, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(169, 199, 130, 26);
		contentPane.add(name);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(169, 251, 130, 26);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(169, 338, 130, 26);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(333, 30, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("e-mail :");
		lblNewLabel_2.setBounds(96, 155, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Name :");
		lblNewLabel_3.setBounds(96, 204, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Username :");
		lblNewLabel_4.setBounds(96, 256, 86, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Password :");
		lblNewLabel_5.setBounds(96, 343, 86, 16);
		contentPane.add(lblNewLabel_5);
		
		JCheckBox check = new JCheckBox(" 我同意Netfli+使用您的個資之權限");
		check.setForeground(Color.LIGHT_GRAY);
		check.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		check.setBounds(96, 472, 203, 23);
		contentPane.add(check);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				if(new implMember().queryUser(Username))
				{
					JOptionPane.showMessageDialog(null,"輸入無效帳號或已被註冊");
				}
					
				else
			    {
					if(password.getText().equals(password2.getText()))
					{
						
						String Name=name.getText();
						String Password=password.getText();
						String Email=email.getText();
						String Phone=phone.getText();
						if(checkEmail(Email)&& checkPhone(Phone) &&checkPassword(Password)&& check.isSelected())
						{
							member m=new member(Name,Username,Password,Email,Phone);
							new implMember().add(m);
							new loginUI().show();
							dispose();
							JOptionPane.showMessageDialog(null,"親愛的"+Name+"您已註冊成功"+"\n請直接登入");
						}
						else if(!checkEmail(Email))
						{
							JOptionPane.showMessageDialog(null,"e-mail格式須為xxxx@xxxx");
						}
						else if(!checkPhone(Phone))
						{
							JOptionPane.showMessageDialog(null,"電話格式須為09xx-xxxxxx");
						}
						else if(!check.isSelected())
						{
							JOptionPane.showMessageDialog(null,"尚未同意權限");
						}
						else if(!checkPassword(Password))
						{
							JOptionPane.showMessageDialog(null,"密碼格式不正確");
						}
					}
					else
					{
						
						JOptionPane.showMessageDialog(null,"密碼輸入不相同");
					}
			    }
					
			}   
			});
		btnNewButton.setBounds(135, 504, 117, 29);
		contentPane.add(btnNewButton);
	
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(169, 289, 130, 26);
		contentPane.add(phone);
		
		textLable = new JLabel("Phone :");
		textLable.setBounds(96, 294, 86, 16);
		contentPane.add(textLable);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(169, 376, 130, 26);
		contentPane.add(password2);
		
		textField_2 = new JLabel("Check Password :");
		textField_2.setBounds(55, 381, 115, 16);
		contentPane.add(textField_2);
		
		lblNewLabel_8 = new JLabel("＊請輸入8至18碼（含特殊符號、英文大小寫及數字）");
		lblNewLabel_8.setForeground(Color.PINK);
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_8.setBounds(169, 363, 229, 16);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("＊範例 ：abcde@.com.tw");
		lblNewLabel_9.setForeground(Color.PINK);
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_9.setBounds(178, 171, 229, 16);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_6 = new JLabel("＊範例 ：0912-345678");
		lblNewLabel_6.setForeground(Color.PINK);
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblNewLabel_6.setBounds(179, 310, 107, 16);
		contentPane.add(lblNewLabel_6);
	}
}
