package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="patient")
public class PatientBean {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
    private String uid;
	private String test_id;
    private String patient_firstname;
    private String patient_middlename;
    private String patient_lastname;
//    gender
    private Gender patient_gender;
    ///dob
    private Date patient_dob;
    private String patient_email;
    private Integer patient_contactnumber;
    private String patient_address;
    private String patient_city;
    private String patient_state;
    private Integer patient_pincode;
    private String patient_referencehospital;
    private String patient_referedby;
    private String patient_hospitalpatientid;
    
    
    public PatientBean()
    {
    }
	public PatientBean(String uid, String test_id,String patient_firstname, String patient_middlename, String patient_lastname, Gender patient_gender, Date patient_dob,
			String patient_email, Integer patient_contactnumber, String patient_address, String patient_city, String patient_state, Integer patient_pincode, String patient_referencehospital, String patient_referedby, String patient_hospitalpatientid ) 
	{
		this.uid=uid;
		this.test_id=test_id;
		this.patient_firstname=patient_firstname;
		this.patient_middlename=patient_middlename;
		this.patient_lastname=patient_lastname;
		///gender
		this.patient_gender=patient_gender;
	    ///dob
		this.patient_dob=patient_dob;
		this.patient_email=patient_email;
		this.patient_contactnumber=patient_contactnumber;
		this.patient_address=patient_address;
		this.patient_city=patient_city;
		this.patient_state=patient_state;
		this.patient_pincode=patient_pincode;
		this.patient_referencehospital=patient_referencehospital;
		this.patient_referedby=patient_referedby;
		this.patient_hospitalpatientid=patient_hospitalpatientid;
		
	}
	public String getUid() {
		return uid;
	}
	public String getTestid() {
		return test_id;
	}
	public void setTestid(String test_id) {
		this.test_id = test_id;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPatient_firstname() {
		return patient_firstname;
	}
	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}
	public String getPatient_middlename() {
		return patient_middlename;
	}
	public void setPatient_middlename(String patient_middlename) {
		this.patient_middlename = patient_middlename;
	}
	public String getPatient_lastname() {
		return patient_lastname;
	}
	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}
//	gender
	public Gender getPatient_gender() {
		return patient_gender;
	}
	public void setPatient_gender(Gender patient_gender) {
		this.patient_gender = patient_gender;
	}
//	dob
	public Date getPatient_dob() {
		return patient_dob;
	}
	public void setPatient_dob(Date patient_dob) {
		this.patient_dob = patient_dob;
	}
	public String getPatient_email() {
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email= patient_email;
	}
	public Integer getPatient_contactnumber() {
		return patient_contactnumber;
	}
	public void setPatient_contactnumber(Integer patient_contactnumber) {
		this.patient_contactnumber = patient_contactnumber;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address= patient_address;
	}
	public String getPatient_city() {
		return patient_city;
	}
	public void setPatient_city(String patient_city) {
		this.patient_city= patient_city;
	}
	public String getPatient_state() {
		return patient_state;
	}
	public void setPatient_state(String patient_state) {
		this.patient_state= patient_state;
	}
	public Integer getPatient_pincode() {
		return patient_pincode;
	}
	public void setPatient_pincode(Integer patient_pincode) {
		this.patient_pincode = patient_pincode;
	}
	public String getPatient_referencehospital() {
		return patient_referencehospital;
	}
	public void setPatient_referencehospital(String patient_referencehospital) {
		this.patient_referencehospital= patient_referencehospital;
	}	
	public String getPatient_referedby() {
		return patient_referedby;
	}
	public void setPatient_referedby(String patient_referedby) {
		this.patient_referedby= patient_referedby;
	}
	public String getPatient_hospitalpatientid() {
		return patient_hospitalpatientid;
	}
	public void setPatient_hospitalpatientid(String patient_hospitalpatientid) {
		this.patient_hospitalpatientid= patient_hospitalpatientid;
	}  
}