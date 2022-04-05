package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name="patient")
public class PatientBean {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="uid")
    private String uid;
	private String test_name;
    private String patient_firstname;
    private String patient_middlename;
    private String patient_lastname;
//    gender
    private Gender patient_gender;
    ///dob
    private String patient_dob;
    private String patient_email;
    private String patient_contactnumber;
    private String patient_address;
    private String patient_city;
    private String patient_state;
    private String patient_pincode;
    private String patient_referencehospital;
    private String patient_referedby;
    private String patient_hospitalpatientid;
    
    
    public PatientBean()
    {
    }
	public PatientBean(String test_name,String patient_firstname, String patient_middlename, String patient_lastname, Gender patient_gender, String patient_dob,
			String patient_email, String patient_contactnumber, String patient_address, String patient_city, String patient_state, String patient_pincode, String patient_referencehospital, String patient_referedby, String patient_hospitalpatientid ) 
	{

		this.test_name=test_name;
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

	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public String getUid() {
		return uid;
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
	public String getPatient_dob() {
		System.out.println(patient_dob);
		return patient_dob;
	}
	public void setPatient_dob(String patient_dob) {
		this.patient_dob = patient_dob;
	}
	public String getPatient_email() {
		System.out.println("getting mail"+patient_email);
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email= patient_email;
	}
	public String getPatient_contactnumber() {
		return patient_contactnumber;
	}
	public void setPatient_contactnumber(String patient_contactnumber) {
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
	public String getPatient_pincode() {
		return patient_pincode;
	}
	public void setPatient_pincode(String patient_pincode) {
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