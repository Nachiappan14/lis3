package demo.model;

import java.time.LocalDate;

public class SubSampleBean {
	 private String sample_id;
	 private String technician_id;
	 private String station_id;
	 private LocalDate date;
	 private Integer number;

		public String getSample_id() {
			return sample_id;
		}

		public void setSample_id(String sample_id) {
			this.sample_id = sample_id;
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
		
		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}
     
	
}