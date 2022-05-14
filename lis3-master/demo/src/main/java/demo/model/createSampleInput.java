package demo.model;

public class createSampleInput {
	private String uid;
	private String sample_type;
   	private Integer quantity;
	private String station_id;
   
	public String getUid() {
		return this.uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
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
}
