package Sorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.changeUI;
import Controller.loginUI;
import Controller.soonUI;
import Dao.Sorder.implSorder;
import Dao.member.implMember;
import Model.Sorder;
import Model.member;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.lang.ModuleLayer.Controller;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

@SuppressWarnings("all") public class orderUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel label;
	private JLabel label9;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderUI frame = new orderUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public static String getN()
	{
		String Username=loginUI.getU();
		String str="";
		str=str+new implMember().queryUsername(Username).getName();
		return str;
	}
	public orderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 800, 572);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label0 = new JLabel("");
		label0.setForeground(Color.WHITE);
		label0.setBounds(449, 58, 371, 172);
		panel_1.add(label0);
		
		JLabel lblNewLabel_1 = new JLabel("會員專區");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new changeUI().show();
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 127, 397, 87);
		panel_1.add(scrollPane);
		String Username=loginUI.getU();
		
		List<Sorder> l=new implSorder().queryUsername(Username);
		Sorder[] s=l.toArray(new Sorder[l.size()]);

		//table
		
		
//		Object[][] date= {{"1","2","3","4"}};
		String date[][]=new String[l.size()][4];
		for(int i=0;i<l.size();i++)
		{
			for(int j=0;j<4;j++)
			{
				if(j==0)
				{
					date[i][j]=l.get(i).getMovie();
				}
				if(j==1)
				{
					date[i][j]=l.get(i).getPlace();
				}
				if(j==2)
				{
					date[i][j]=l.get(i).getRound();
				}
				if(j==3)
				{
					date[i][j]=l.get(i).getSeat();
				}
			}
		}
		
		
		String[] columns= {"電影","影廳","時間","座位"};
		table = new JTable(date,columns);
		table.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Clear");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new implSorder().delete(Username);
				dispose();
				new orderUI().show();
			}
		});
		scrollPane.setRowHeaderView(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel_1.setBounds(359, 25, 68, 26);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.GRAY);

		JLabel lblNewLabel_1_1 = new JLabel("成人專區");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"變態！不可以色色～～");
				JOptionPane.showMessageDialog(null,"尚未開放 敬請期待～");
			}
		});
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setBounds(289, 30, 61, 16);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("即將上映");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new soonUI().show();
				dispose();
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1_1.setBounds(216, 30, 61, 16);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("院線電影");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setBounds(143, 30, 61, 16);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel ad16 = new JLabel("New label");
		ad16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv1().show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv7.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad16.setForeground(Color.WHITE);
		ad16.setBounds(-77, 242, 212, 202);
		panel_1.add(ad16);
		
		Image ad = new ImageIcon(this.getClass().getResource("/Pic/ad16.jpeg")).getImage();
		ad16.setIcon(new ImageIcon(ad)); 
		
		
		JLabel ad17 = new JLabel("New label");
		ad17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv2().show();
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv3.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad17.setForeground(Color.WHITE);
		ad17.setBounds(59, 243, 213, 202);
		panel_1.add(ad17);
		Image ad2 = new ImageIcon(this.getClass().getResource("/Pic/ad17.jpeg")).getImage();
		ad17.setIcon(new ImageIcon(ad2));
		
		JLabel ad18 = new JLabel("New label");
		ad18.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv3().show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv6.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad18.setForeground(Color.WHITE);
		ad18.setBounds(201, 242, 210, 202);
		panel_1.add(ad18);
		Image ad3 = new ImageIcon(this.getClass().getResource("/Pic/ad18.jpeg")).getImage();
		ad18.setIcon(new ImageIcon(ad3));
		
		JLabel ad19 = new JLabel("New label");
		ad19.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv4().show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv10.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad19.setForeground(Color.WHITE);
		ad19.setBounds(338, 243, 210, 202);
		panel_1.add(ad19);
		Image ad4 = new ImageIcon(this.getClass().getResource("/Pic/ad19.jpeg")).getImage();
		ad19.setIcon(new ImageIcon(ad4));
		
		JLabel ad20 = new JLabel("New label");
		ad20.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv5().show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv9.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad20.setForeground(Color.WHITE);
		ad20.setBounds(480, 242, 210, 202);
		panel_1.add(ad20);
		Image ad5 = new ImageIcon(this.getClass().getResource("/Pic/ad20.jpeg")).getImage();
		ad20.setIcon(new ImageIcon(ad5));
		
		
		JLabel ad21 = new JLabel("New label");
		ad21.setForeground(Color.WHITE);
		ad21.setBounds(-75, 482, 212, 202);
		panel_1.add(ad21);
		Image ad6 = new ImageIcon(this.getClass().getResource("/Pic/ad21.jpeg")).getImage();
		ad21.setIcon(new ImageIcon(ad6));
		
		JLabel ad22 = new JLabel("New label");
		ad22.setForeground(Color.WHITE);
		ad22.setBounds(59, 482, 212, 202);
		panel_1.add(ad22);
		Image ad7 = new ImageIcon(this.getClass().getResource("/Pic/ad22.jpeg")).getImage();
		ad22.setIcon(new ImageIcon(ad7));
		
		JLabel ad23 = new JLabel("New label");
		ad23.setForeground(Color.WHITE);
		ad23.setBounds(198, 481, 212, 202);
		panel_1.add(ad23);
		Image ad8 = new ImageIcon(this.getClass().getResource("/Pic/ad23.jpeg")).getImage();
		ad23.setIcon(new ImageIcon(ad8));
		
		JLabel ad24 = new JLabel("New label");
		ad24.setForeground(Color.WHITE);
		ad24.setBounds(338, 481, 212, 202);
		panel_1.add(ad24);
		Image ad9 = new ImageIcon(this.getClass().getResource("/Pic/ad24.jpeg")).getImage();
		ad24.setIcon(new ImageIcon(ad9));
		
		JLabel ad25 = new JLabel("New label");
		ad25.setForeground(Color.WHITE);
		ad25.setBounds(478, 480, 212, 202);
		panel_1.add(ad25);
		Image ad10 = new ImageIcon(this.getClass().getResource("/Pic/ad25.jpeg")).getImage();
		ad25.setIcon(new ImageIcon(ad10));
		
		JLabel lblNewLabel_4 = new JLabel("Netfli+");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new loginUI().show();
				dispose();
			}
		});
		lblNewLabel_4.setForeground(new Color(233, 61, 36));
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_4.setBounds(16, 6, 114, 53);
		panel_1.add(lblNewLabel_4);
		
		JLabel ad30 = new JLabel("New label");
		ad30.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new mv6().show();
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv8.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label0.setIcon(new ImageIcon(ad1));
			}
		});
		ad30.setForeground(Color.WHITE);
		ad30.setBounds(620, 242, 210, 202);
		panel_1.add(ad30);
		Image ad11 = new ImageIcon(this.getClass().getResource("/Pic/ad30.jpeg")).getImage();
		ad30.setIcon(new ImageIcon(ad11));
		Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a1.gif")).getImage();
		
		JLabel ad31 = new JLabel("New label");
		ad31.setForeground(Color.WHITE);
		ad31.setBounds(620, 480, 210, 202);
		panel_1.add(ad31);
		Image ad12 = new ImageIcon(this.getClass().getResource("/Pic/ad31.jpeg")).getImage();
		ad31.setIcon(new ImageIcon(ad12));
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 242, 10, 10);
		panel_1.add(panel);
	
		
		
		JLabel buy = new JLabel("結帳");
		buy.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		buy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Model.CreateXL create = new Model.CreateXL();
		        File file = new File("/Users/ericch/Desktop/Netfli+.xls");
				String data[][]=new String[l.size()][4];
				 if(!file.exists()){
			            create.createExcel();
			        }
				for(int i=0;i<l.size();i++)
				{
					for(int j=0;j<4;j++)
					{
						if(j==0)
						{
							date[i][j]=l.get(i).getMovie();
						}
						if(j==1)
						{
							date[i][j]=l.get(i).getPlace();
						}
						if(j==2)
						{
							date[i][j]=l.get(i).getRound();
						}
						if(j==3)
						{
							date[i][j]=l.get(i).getSeat();
						}
					}
					create.insertvalue(Username,l.get(i).getMovie(),l.get(i).getPlace(),l.get(i).getRound(),l.get(i).getSeat());
				}
				
		        
		        JOptionPane.showMessageDialog(getContentPane(), 
		                "明細表已列印成功"+"\n請至超商繳費。", "資訊提示框", JOptionPane.WARNING_MESSAGE);
		    }
			
		});
		buy.setForeground(Color.WHITE);
		buy.setBounds(45, 86, 53, 40);
		panel_1.add(buy);
		
		JLabel lblNewLabel_2 = new JLabel(getN());
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(712, 25, 139, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel label1 = new JLabel("");
		label1.setForeground(Color.WHITE);
		label1.setBounds(676, 11, 38, 40);
		panel_1.add(label1);
		Image ad13 = new ImageIcon(this.getClass().getResource("/Pic/icon1.png")).getImage();
		label1.setIcon(new ImageIcon(ad13));
		
		JLabel label1_1 = new JLabel("");
		label1_1.setForeground(Color.WHITE);
		label1_1.setBounds(14, 86, 38, 40);
		panel_1.add(label1_1);
		Image ad15 = new ImageIcon(this.getClass().getResource("/Pic/m5.png")).getImage();
		label1_1.setIcon(new ImageIcon(ad15));
		
		JLabel label10 = new JLabel("New label");
		label10.setBounds(0, 0, 808, 244);
		panel_1.add(label10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/mtv11.gif")).getImage();
				label10.setIcon(new ImageIcon(ad1));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Image ad1 = new ImageIcon(this.getClass().getResource("/Pic/a2.gif")).getImage();
				label10.setIcon(new ImageIcon(ad1));
			}
		});
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 6, 794, 566);
		panel_1.add(lblNewLabel_3);
		
		
		
	}
}
