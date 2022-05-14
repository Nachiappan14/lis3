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
	
	public String getSampleType(){
		return this.sample_type;
	}

	public void setSampleType(sample_type){
		this.sample_type=sample_type;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer number) {
		this.quantity = number;
	}

	public String getStationId(){
		return this.station_id;
	}

	public void setStationId(String sid){
		this.station_id = sid;
	}
}
