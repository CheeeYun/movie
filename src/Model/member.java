package Model;

public class member {
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phone;
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public member( String name, String username, String password, String email, String phone) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public member(String username, String password) {
			super();
			this.username = username;
			this.password = password;
	}
	public member( String username,String email, String phone) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}