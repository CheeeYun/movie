package Model;

public class Sorder {
	private Integer id;
	private String username;
	private String movie;
	private String place;
	private String round;
	private String seat;
	public Sorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sorder(String username,String movie, String place, String round, String seat) {
		super();
		this.username = username;
		this.movie = movie;
		this.place = place;
		this.round = round;
		this.seat = seat;
	}
	public Sorder(String movie, String place, String round, String seat) {
		super();
		this.movie = movie;
		this.place = place;
		this.round = round;
		this.seat = seat;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Integer getId() {
		return id;
	}
	

}
