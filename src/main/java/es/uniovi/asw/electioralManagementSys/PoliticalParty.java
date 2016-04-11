package es.uniovi.asw.electioralManagementSys;

public class PoliticalParty {
	private String paryName;
	private String candidate;
	private String description;
	
	public PoliticalParty(String paryName, String candidate, String description) {
		super();
		this.paryName = paryName;
		this.candidate = candidate;
		this.description = description;
	}

	public String getParyName() {
		return paryName;
	}

	public String getCandidate() {
		return candidate;
	}

	public String getDescription() {
		return description;
	}
	
	
}
