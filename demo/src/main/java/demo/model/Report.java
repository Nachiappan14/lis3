package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reports")
public class Report {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="sample_id")
      private String sample_id;
      private String report;
    public Report()
    {
    	
    }

	public Report(String sample_id, String report) {
		this.sample_id = sample_id;
		this.report = report;
	}

	public String getSample_id() {
		return sample_id;
	}
	public void setSample_id(String sample_id) {
		this.sample_id = sample_id;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
      
}
