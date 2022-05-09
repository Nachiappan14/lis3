package demo.model;

public class ReportReply 
{
     private Integer status;
     private String message;
     private Report report;
     
    public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
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

}
