package es.uniovi.electoral.model;

public class PollingStation {

	private long code;
	private String province;
	private String city;
	private String district;
	private String country;
	
	public PollingStation(long code, String province, String city,
			String district, String country) {
		super();
		this.code = code;
		this.province = province;
		this.city = city;
		this.district = district;
		this.country = country;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
