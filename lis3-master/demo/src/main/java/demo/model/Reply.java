package demo.model;

public class Reply 
{
     private Integer status;
     private String message;
     private User user;
     private String token;
     
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
     public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
