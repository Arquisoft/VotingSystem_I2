package es.uniovi.PollingStation.model;

public class Option {

	private long id;
	private String name;
	private String comment;
	
	public Option(long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}

	@Override
	public String toString() {
		String res= id + ": " + name;
		if (!comment.equals(""))
			res += ", " + comment;
		return res;
	}
		

	
}

