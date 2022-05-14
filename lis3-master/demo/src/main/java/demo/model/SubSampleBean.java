package demo.model;


public class SubSampleBean {
	private String sample_id;
	private Integer number;
	private String sample_type;
   	private Integer quantity;
	private String station_id;
	
	public String getSample_type(){
		return this.sample_type;
	}

	public void setSample_type(String sample_type){
		this.sample_type=sample_type;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer number) {
		this.quantity = number;
	}

	public String getStation_id(){
		return this.station_id;
	}

	public void setStation_id(String sid){
		this.station_id = sid;
	}

	public String getSample_id() {
		return sample_id;
	}
	public void setSample_id(String sample_id) {
		this.sample_id = sample_id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

     
	
}
