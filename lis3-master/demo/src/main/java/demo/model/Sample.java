package demo.model;

public class Sample
{
     private Integer status;
     private String message;
     private SampleBean sampleBean;
     
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
     public SampleBean getSampleBean() {
		return sampleBean;
	}
	public void setSampleBean(SampleBean sampleBean) {
		this.sampleBean = sampleBean;
	}
}
