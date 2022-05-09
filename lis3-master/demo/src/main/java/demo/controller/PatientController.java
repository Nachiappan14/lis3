package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Patient;
import demo.model.PatientBean;
import demo.repository.PatientRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<PatientBean> getPatient(){
    	return this.patientRepository.findAll();
    }
    @PostMapping("/patientform")
    public Patient patientform(@RequestBody PatientBean patientBean)
    {
    	Patient patient=new Patient();
//    	todo: have to check for token 
    	if(patientBean==null)
    	{
    		patient.setMessage("Empty form");
    		patient.setStatus(0);
    		patient.setPatientBean(null);
    		return patient;
    	}   	
    	if(patientBean.getPatient_firstname()==null || patientBean.getPatient_middlename()==null || patientBean.getPatient_lastname()==null || patientBean.getPatient_email()==null || patientBean.getPatient_contactnumber()==null || patientBean.getPatient_address()==null || patientBean.getPatient_city()==null || patientBean.getPatient_state()==null || patientBean.getPatient_pincode()==null ||  patientBean.getTest_name()==null)
    	{
    		patient.setMessage("Partial filled form");
    		patient.setStatus(0);
    		patient.setPatientBean(null);
    		return patient;
    	}

    	patient.setMessage("success");
		patient.setStatus(1);
    	patient.setPatientBean(patientBean);
    	this.patientRepository.save(patientBean);
    	return patient;
	    	
    }
    @GetMapping("/gettestbytest_id")
    public PatientBean getpatientbypatient_id(@RequestBody String uid)
    {
    	return (this.patientRepository.findById(uid)).get();
    }
//    search the samples based on station id, 
//    search the patient list based on 
    
}
