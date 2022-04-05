package demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sample")
public class SampleBean {
	@Id
//		@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sample_id")
	 private String sample_id;
//	todo: unique identification of rows
	 private String test_name;
	 private String uid;
	 private String technician_id;
	 private String station_id;
	 private LocalDate date;
	 private String observations;
	 public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public SampleBean()
	    {
	    }
	 
		public SampleBean(String sample_id, String test_name,String uid, String technician_id, String station_id, LocalDate ld,String observations) 
		{
			this.sample_id=sample_id;
			this.test_name=test_name;
			this.uid=uid;
			this.technician_id=technician_id;
			this.station_id=station_id;
			this.date=ld;
			this.observations=observations;
			
		}

		public String getTest_name() {
			return test_name;
		}

		public void setTest_name(String test_name) {
			this.test_name = test_name;
		}

		public String getSample_id() {
			return sample_id;
		}

		public void setSample_id(String sample_id) {
			this.sample_id = sample_id;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getTechnician_id() {
			return technician_id;
		}

		public void setTechnician_id(String technician_id) {
			this.technician_id = technician_id;
		}

		public String getStation_id() {
			return station_id;
		}

		public void setStation_id(String station_id) {
			this.station_id = station_id;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}
     
	
}