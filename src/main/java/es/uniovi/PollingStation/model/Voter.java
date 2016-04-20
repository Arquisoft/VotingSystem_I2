package es.uniovi.PollingStation.model;

public class Voter {

	private String login;
	private String password;
	private int code;

	public Voter(String login, String password, int code) {
		super();
		this.login = login;
		this.password = password;
		this.code = code;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
	public int getCode() {
		return code;
	}

}
