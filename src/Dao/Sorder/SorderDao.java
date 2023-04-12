package Dao.Sorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Model.Sorder;

@SuppressWarnings("all") public interface SorderDao {

	//連線方法
	

	//create
	void add(Sorder s);
	//read
	//update
	public void update(Sorder s);
	//delete
	public void delete(String username);
}
