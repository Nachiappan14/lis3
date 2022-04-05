package demo.model;

public class Station
{
     private Integer status;
     private String message;
     private StationBean stationBean;
     
    public Integer getStatus() {
 		return status;
 	}
 	public void setStatus(Integer status) {
 		this.status = status;
 	}
 	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     public StationBean getStationBean() {
		return stationBean;
	}
	public void setStationBean(StationBean stationBean) {
		this.stationBean = stationBean;
	}
}
