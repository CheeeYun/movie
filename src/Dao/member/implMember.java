package Dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.member;

@SuppressWarnings("all") public class implMember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test add
//		member m=new member("4","4","4","4","4");
//		new implMember().add(m);
		//test quaryALl
//		System.out.println(new implMember().queryAll());
		//test quaryId
//		System.out.println(new implMember().queryId(1));
		//test quaryMember
//		System.out.println(new implMember().queryMember("5", "5"));
		//test Update
//		member m=new implMember().queryId(2);
//		m.setPassword("100");
//		new implMember().update(m);
		//test updatePassword
//		member m=new member("2","22");
//		new implMember().updatePassword(m);
		//test quaryPassword
		System.out.println(new implMember().queryPassword("4","4","4"));
		//test quaryUser
//		System.out.println(new implMember().queryUser("2"));
		//test delete
//		new implMember().delete(2);
	}
    
	public void add(member m)
	{
		Connection conn=DbConnection.getDb();
		String SQL="insert into studio.member"
				+"(name,username,password,email,phone)"
				+" value(?,?,?,?,?);";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String queryAll()
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member;";
		String show="";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")+
						"\t名字:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\te-mail:"+rs.getString("email")+
						"  電話:"+rs.getString("phone")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	public List<member> queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<member> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				l.add(m);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}
	
	
	member queryId(int id)
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member where id=?;";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	public member queryUsername(String username)
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member where username=?;";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	
	public member queryMember(String username,String password)
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member where username=? and password=?;";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	public member queryPassword(String username,String email,String phone)
	{
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member where username=? and email=? and phone=?;";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, phone);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.member where username=?";
		boolean m=false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	
	public void update(member m)
	{
		Connection conn=DbConnection.getDb();
		String SQL="update studio.member set name=?,username=?,password=?,email=?,phone=?"
				 	+"where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getPhone());
			ps.setInt(6, m.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatePassword(member m)
	{
		Connection conn=DbConnection.getDb();
		String SQL="update studio.member set password=?"
				 	+"where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getPassword());
			ps.setString(2, m.getUsername());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from studio.member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
