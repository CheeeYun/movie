package Dao.Sorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.member.DbConnection;
import Model.Sorder;
import Model.member;


@SuppressWarnings("all") public class implSorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//連線測試
//		System.out.println(SorderDao.getDb());
		//add測試
//		Sorder s=new Sorder("速度與激情9","文賢廳","18:40","B2");
//		new implSorder().add(s);
//		System.out.println(new implSorder().queryAll("22"));


	}
	public static Connection getDb()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/studio";
		String user="root";
		String password="3R5EJF3D";
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void add(Sorder s)
	{
		Connection conn=DbConnection.getDb();
		String SQL="insert into studio.Sorder(username,movie,place,round,seat)"
				+"values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, s.getUsername());
			ps.setString(2, s.getMovie());
			ps.setString(3, s.getPlace());
			ps.setString(4, s.getRound());
			ps.setString(5, s.getSeat());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Sorder> queryUsername(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from studio.Sorder where username=?;";
		List<Sorder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Sorder s=new Sorder();
				s.setUsername(rs.getString("username"));
				s.setMovie(rs.getString("movie"));
				s.setPlace(rs.getString("place"));
				s.setRound(rs.getString("round"));
				s.setSeat(rs.getString("seat"));
				l.add(s);
				

			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}
	public void update(Sorder s) {
		Connection conn=DbConnection.getDb();
		String SQL="update studio.Sorder set movie=?,place=?,round=?,seat=? where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, s.getMovie());
			ps.setString(2, s.getPlace());
			ps.setString(3, s.getRound());
			ps.setString(4, s.getSeat());
			ps.setString(5, s.getUsername());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void delete(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from studio.Sorder where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,username);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
