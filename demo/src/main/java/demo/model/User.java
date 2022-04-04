package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technician")
public class User {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private String technician_id;
	@Column(name="technician_name")
    private String technicianname;
    private String technician_password;
    private String technician_email;
    private Integer technician_contactnumber;
    private Integer technician_age;
    private String technician_gender;
    private Integer role_reception;
    private Integer role_grossing;
    private Integer role_analyzing;
    private Integer role_reporting;
    private Integer role_admin;
    private Integer role_doctor;
    
    
    public User()
    {
    }
	public User(String technician_id, String technicianname, String technician_password, String technician_email, 
			Integer technician_contactnumber, Integer technician_age, String technician_gender,Integer role_reception,
			Integer role_grossing, Integer role_analyzing, Integer role_reporting, Integer role_admin, Integer role_doctor) {
		this.technician_id=technician_id;
		this.technicianname=technicianname;
		this.technician_password=technician_password;
		this.technician_email=technician_email;
		this.technician_contactnumber=technician_contactnumber;
		this.technician_age=technician_age;
		this.technician_gender=technician_gender;
		this.role_reception=role_reception;
		this.role_grossing=role_grossing;
		this.role_analyzing=role_analyzing;
		this.role_reporting=role_reporting;
		this.role_admin=role_admin;
		this.role_doctor=role_doctor;
		
	}
	public String getTechnician_id() {
		return technician_id;
	}
	public void setTechnician_id(String technician_id) {
		this.technician_id = technician_id;
	}
	public String getTechnicianname() {
		return technicianname;
	}
	public void setTechnicianname(String technicianname) {
		this.technicianname = technicianname;
	}
	public String getTechnician_password() {
		return technician_password;
	}
	public void setTechnician_password(String technician_password) {
		this.technician_password = technician_password;
	}
	public String getTechnician_email() {
		return technician_email;
	}
	public void setTechnician_email(String technician_email) {
		this.technician_email = technician_email;
	}
	public Integer getTechnician_contactnumber() {
		return technician_contactnumber;
	}
	public void setTechnician_contactnumber(Integer technician_contactnumber) {
		this.technician_contactnumber = technician_contactnumber;
	}
	public Integer getTechnician_age() {
		return technician_age;
	}
	public void setTechnician_age(Integer technician_age) {
		this.technician_age = technician_age;
	}
	public String getTechnician_gender() {
		return technician_gender;
	}
	public void setTechnician_gender(String technician_gender) {
		this.technician_gender = technician_gender;
	}
	public Integer getRole_reception() {
		return role_reception;
	}
	public void setRole_reception(Integer role_reception) {
		this.role_reception = role_reception;
	}
	public Integer getRole_grossing() {
		return role_grossing;
	}
	public void setRole_grossing(Integer role_grossing) {
		this.role_grossing = role_grossing;
	}
	public Integer getRole_analyzing() {
		return role_analyzing;
	}
	public void setRole_analyzing(Integer role_analyzing) {
		this.role_analyzing = role_analyzing;
	}
	public Integer getRole_reporting() {
		return role_reporting;
	}
	public void setRole_reporting(Integer role_reporting) {
		this.role_reporting = role_reporting;
	}
	public Integer getRole_admin() {
		return role_admin;
	}
	public void setRole_admin(Integer role_admin) {
		this.role_admin = role_admin;
	}
	public Integer getRole_doctor() {
		return role_doctor;
	}
	public void setRole_doctor(Integer role_doctor) {
		this.role_doctor = role_doctor;
	}
}