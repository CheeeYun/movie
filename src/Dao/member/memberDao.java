package Dao.member;

import Model.member;

public interface memberDao {

	//create
	
	void add(member m);//新增會員
	
	//read
	public String queryALl();//查詢全部
	member queryId(int id);
	member queryUsername(String username);
	public member queryMember(String username,String password);//登入驗證
	public member queryPassword(String username,String email,String phone);//查詢密碼
	boolean queryUser(String username);//檢查帳號是否重複
	//update
	void update(member m);//更新
	void updatePassword(member m);//修改密碼
	
	//delete
	void delete(int id);//刪除
	
	
	
	
	
	
	
	
	
	
}
