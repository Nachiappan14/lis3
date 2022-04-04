package demo.model;

public class Patient 
{
     private Integer status;
     private String message;
     private PatientBean patientBean;
     
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
     public PatientBean getPatientBean() {
		return patientBean;
	}
	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}
}
