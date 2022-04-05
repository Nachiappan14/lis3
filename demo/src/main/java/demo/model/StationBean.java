package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="station")
public class StationBean {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private String stationid;
	@Column(name="stationid")
    private String stationname;
    
    public StationBean()
    {
    }
	public StationBean(String stationid, String stationname)
	{
		this.stationid=stationid;
		this.stationname=stationname;		
	}
	
	public String getStationid() {
		return stationid;
	}

	public void setStationid(String stationid) {
		this.stationid = stationid;
	}

	public String getStationname() {
		return stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
}