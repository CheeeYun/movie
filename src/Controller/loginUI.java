package Controller;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Dao.member.implMember;

import Model.member;
import Sorder.orderUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Calendar;
import java.util.GregorianCalendar;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class loginUI extends JFrame implements KeyListener  {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField username;
	private static JPasswordField password;
	private JLabel clockLable;
	private JButton login;
	

	/**
	 * Launch the application.
	 */
	
	public static String getU()
	{
		String str="";
		str=username.getText();
		return str;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					loginUI frame = new loginUI();
					frame.setVisible(true);
					password.addKeyListener(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			String Username=username.getText();
			String Password=password.getText();
			member m= new implMember().queryMember(Username,Password);
			if(m!=null)
			{
				new orderUI().show();
				dispose();
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Oops!!!輸入密碼錯誤，請再輸入一次");
			}
		}
		}
		
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 public void clock()
     { 
	     Thread cclock=new Thread()
	     {
		            public void run()
		            {
		            	try
		            	{
		            		for(;;) {
		      		      Calendar cal=new GregorianCalendar();
		      	          int day=cal.get(Calendar.DAY_OF_MONTH);
		      	          int month=cal.get(Calendar.MONTH)+1;
		      	          int year=cal.get(Calendar.YEAR);
		      	          int second=cal.get(Calendar.SECOND);
		      	          int minute=cal.get(Calendar.MINUTE);
		      	          int hour=cal.get(Calendar.HOUR);	      	          
		      	          clockLable.setText("Day:\t\t"+year+"/"+month+"/"+day+"\t\tTime\t\t"+hour+":"+minute+":"+second);
		            			
		      	          sleep(1000);
		            	 }
		            	}
		         catch (InterruptedException e) 
		            	{
						e.printStackTrace();
			             }
                  }
	    };
	    cclock.start();
	    }
	/**
	 * Create the frame.
	 */
	
	public loginUI()  { 
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, -11, 400, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		
		username = new JTextField();
		username.setBounds(134, 418, 130, 26);
		panel.add(username);
		username.setColumns(10);
		
		JButton login = new JButton("login");
		
			
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				member m= new implMember().queryMember(Username,Password);
				if(m!=null)
				{
					new orderUI().show();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Oops!!!輸入密碼錯誤，請再輸入一次");
				}
			}
		});
		login.setForeground(Color.BLACK);
		login.setBackground(new Color(255, 38, 0));
		login.setBounds(162, 528, 71, 29);
		panel.add(login);
		
		JLabel lblNewLabel_1 = new JLabel("Forgot ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(262, 600, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password...?");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new forgotPasswordUI().setVisible(true);
				
			}
		});
		lblNewLabel_1_1.setForeground(Color.CYAN);
		lblNewLabel_1_1.setBounds(305, 600, 78, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(164, 401, 100, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(164, 456, 100, 16);
		panel.add(lblNewLabel_2_1);
		
		password = new JPasswordField();
		password.setBounds(134, 476, 130, 26);
		panel.add(password);
		
		
		JLabel lblNewLabel_3 = new JLabel("Sing Up");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new signUpUI().show();
				dispose();
			}
		});
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(262, 569, 61, 16);
		panel.add(lblNewLabel_3);
		
		
	    clockLable = new JLabel("clock");
		clockLable.setForeground(Color.LIGHT_GRAY);
		clockLable.setBounds(26, 600, 224, 16);
		panel.add(clockLable);
		
		JLabel lblNewLabel_4 = new JLabel("Netfli+");
		lblNewLabel_4.setForeground(new Color(233, 61, 36));
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_4.setBounds(123, 106, 152, 53);
		panel.add(lblNewLabel_4);
	
		
		
		
		clock();
		
		
		
		
	}

	
}
