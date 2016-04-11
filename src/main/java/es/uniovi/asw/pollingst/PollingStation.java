package es.uniovi.asw.pollingst;

public class PollingStation {

	private int pollStCode;
	private String pollStDistrict;
	private String pollStRegion;
	
	public PollingStation(int pollStCode, String pollStDistrict, String pollStRegion) {
		super();
		this.pollStCode = pollStCode;
		this.pollStDistrict = pollStDistrict;
		this.pollStRegion = pollStRegion;
	}

	public int getPollStCode() {
		return pollStCode;
	}

	public String getPollStDistrict() {
		return pollStDistrict;
	}

	public String getPollStRegion() {
		return pollStRegion;
	}
	
}
