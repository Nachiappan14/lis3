package demo.model;

import java.util.List;

public class SampleList
{
     private Integer status;
     private String message;
     private List<SampleBean> sampleBean;
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
	public List<SampleBean> getSampleBean() {
		return sampleBean;
	}
	public void setSampleBean(List<SampleBean> sampleBean) {
		this.sampleBean = sampleBean;
	}
     
    
     
}
