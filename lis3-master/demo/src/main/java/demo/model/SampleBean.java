package demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	 private String observations;
	private String parent;
	private String sample_type;
	private int quantity;
	private int status;
	private String rs_technician_id;
	 private LocalDate rs_date;
	 private String gs_technician_id;
	 private LocalDate gs_date;
	 private String as_technician_id;
	 private LocalDate as_date;
	 private String vs_technician_id;
	 private LocalDate vs_date;
	 private String verified;
	 public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public SampleBean()
	    {
	    }

		public SampleBean(String sample_id, String test_name, String uid, String observations, String parent,
			String sample_type, int quantity, int status, String rs_technician_id, LocalDate ld,
			String gs_technician_id, LocalDate ld2, String as_technician_id, LocalDate ld3,
			String vs_technician_id, LocalDate ld4, String verified) {
		this.sample_id = sample_id;
		this.test_name = test_name;
		this.uid = uid;
		this.observations = observations;
		this.parent = parent;
		this.sample_type = sample_type;
		this.quantity = quantity;
		this.status = status;
		this.rs_technician_id = rs_technician_id;
		this.rs_date = ld;
		this.gs_technician_id = gs_technician_id;
		this.gs_date = ld2;
		this.as_technician_id = as_technician_id;
		this.as_date = ld3;
		this.vs_technician_id = vs_technician_id;
		this.vs_date = ld4;
		this.verified=verified;
	}

		public String getSample_id() {
			return sample_id;
		}

		public void setSample_id(String sample_id) {
			this.sample_id = sample_id;
		}

		public String getTest_name() {
			return test_name;
		}

		public void setTest_name(String test_name) {
			this.test_name = test_name;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public String getSample_type() {
			return sample_type;
		}

		public void setSample_type(String sample_type) {
			this.sample_type = sample_type;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getRs_technician_id() {
			return rs_technician_id;
		}

		public void setRs_technician_id(String rs_technician_id) {
			this.rs_technician_id = rs_technician_id;
		}

		public LocalDate getRs_date() {
			return rs_date;
		}

		public void setRs_date(LocalDate rs_date) {
			this.rs_date = rs_date;
		}

		public String getGs_technician_id() {
			return gs_technician_id;
		}

		public void setGs_technician_id(String gs_technician_id) {
			this.gs_technician_id = gs_technician_id;
		}

		public LocalDate getGs_date() {
			return gs_date;
		}

		public void setGs_date(LocalDate gs_date) {
			this.gs_date = gs_date;
		}

		public String getAs_technician_id() {
			return as_technician_id;
		}

		public void setAs_technician_id(String as_technician_id) {
			this.as_technician_id = as_technician_id;
		}

		public LocalDate getAs_date() {
			return as_date;
		}

		public void setAs_date(LocalDate as_date) {
			this.as_date = as_date;
		}

		public String getVs_technician_id() {
			return vs_technician_id;
		}

		public void setVs_technician_id(String vs_technician_id) {
			this.vs_technician_id = vs_technician_id;
		}

		public LocalDate getVs_date() {
			return vs_date;
		}

		public void setVs_date(LocalDate vs_date) {
			this.vs_date = vs_date;
		}

		public String getVerified() {
			return verified;
		}

		public void setVerified(String verified) {
			this.verified = verified;
		}
	
}