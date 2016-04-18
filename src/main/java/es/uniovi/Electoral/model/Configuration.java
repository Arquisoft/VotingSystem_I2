package es.uniovi.Electoral.model;

import java.sql.Timestamp;


public class Configuration {

	private String name;
	private Timestamp startDate;
	private Timestamp endDate;
	private String type;
	private String comment;
	
	public Configuration(String name, Timestamp startDate, Timestamp endDate,
			String type, String comment) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
