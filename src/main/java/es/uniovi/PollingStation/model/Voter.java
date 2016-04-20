package es.uniovi.PollingStation.model;

public class Voter {

	private String login;
	private int code;

	public Voter(String login, int code) {
		super();
		this.login = login;
		this.code = code;
	}

	public String getLogin() {
		return login;
	}
	
	public int getCode() {
		return code;
	}

}
