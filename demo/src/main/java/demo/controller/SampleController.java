package demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.ObservationBean;
import demo.model.PatientBean;
import demo.model.SampleBean;
import demo.model.Sample;
import demo.model.SubSampleBean;
import demo.repository.ReportRepository;
import demo.repository.PatientRepository;
import demo.repository.SampleRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SampleController {
	@Autowired
	private SampleRepository sampleRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ReportRepository observationsRepository;
    @GetMapping("/samples")
    public List<SampleBean> getSamples(){
    	return this.sampleRepository.findAll();
    }
    
    @PostMapping("/createsample")
    public Sample createSample(@RequestBody String uid)
    {
    	System.out.println(uid);
    	Sample sample=new Sample();
//    	if uid is null
    	if(uid==null)
    	{
    	    sample.setMessage("uid is not given");
    		sample.setStatus(0);
    		sample.setSampleBean(null);
    		return sample;
    	}
       Optional<PatientBean> p=this.patientRepository.findByuid(uid);
       PatientBean patient=p.get();
       LocalDate ld=LocalDate.now();
       String sub=String.valueOf(ld)+uid;
	   SampleBean sampleBean=new SampleBean(sub,patient.getTest_id(),uid,"1","1",ld,"");
       sample.setMessage("success");
	   sample.setStatus(1);
	   sample.setSampleBean(sampleBean);
	   this.sampleRepository.save(sampleBean);
	   return sample;
    }
    
    @PostMapping("/createsubsample")
    public Sample createSubSample(@RequestBody SubSampleBean subSampleBean)
    {
    	Sample sample=new Sample();
    	if(subSampleBean==null)
    	{
    		sample.setMessage("Enter values");
    		sample.setStatus(0);
    		sample.setSampleBean(null);
    	}
    	if(subSampleBean.getSample_id()==null || subSampleBean.getNumber()==null)
    	{
    		sample.setMessage("Entered partial values");
    		sample.setStatus(0);
    		sample.setSampleBean(null);
    	}
    	for(int i=1;i<=subSampleBean.getNumber();i++)
    	{
    		String sub=subSampleBean.getSample_id()+"."+String.valueOf(i);
    		Optional<SampleBean> s1=this.sampleRepository.findById(subSampleBean.getSample_id());
    		SampleBean sampleBean1=s1.get();
    		SampleBean subsample=new SampleBean(sub,sampleBean1.getTest_id(),sampleBean1.getUid(),sampleBean1.getTechnician_id(),sampleBean1.getStation_id(),sampleBean1.getDate(),"");
    		this.sampleRepository.save(subsample);
    		sample.setMessage("success");
    		sample.setStatus(1);
    		sample.setSampleBean(subsample);
    		this.sampleRepository.save(subsample);
    	}
    	return sample;
    }
    @PostMapping("/addobservations")
    public Sample addObservation(@RequestBody ObservationBean observationBean)
    {
    	Sample sample=new Sample();
    	if(observationBean==null)
    	{
        	sample.setMessage("Enter values");
        	sample.setStatus(0);
        	sample.setSampleBean(null);
        	return sample;
    	}
    	if(observationBean.getSample_id()==null || observationBean.getObservation()==null)
    	{
    		sample.setMessage("Entered partial values");
        	sample.setStatus(0);
        	sample.setSampleBean(null);
        	return sample;
    	}
    		Optional<SampleBean> sampleBean=this.sampleRepository.findById(observationBean.getSample_id());
    		SampleBean sampleBean1=sampleBean.get();
    		sampleBean1.setObservations(observationBean.getObservation());
    		sample.setMessage("Entered partial values");
        	sample.setStatus(0);
        	sample.setSampleBean(sampleBean1);
        	return sample;
        	
    }
    @PostMapping("/generatereport")
    public void generate(@RequestBody String sample_id)
    {
    	
    }
    
}