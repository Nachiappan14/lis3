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

import demo.model.PatientBean;
import demo.model.SampleBean;
import demo.model.Sample;
import demo.model.SubSampleBean;
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
    @GetMapping("/samples")
    public List<SampleBean> getSamples(){
    	return this.sampleRepository.findAll();
    }
    
    @PostMapping("/createsample")
    public Sample createSample(@RequestBody String uid)
    {
    	System.out.println(uid);
       Optional<PatientBean> p=this.patientRepository.findByuid(uid);
       PatientBean patient=p.get();
       LocalDate ld=LocalDate.now();
       String sub=String.valueOf(ld)+uid;
	   SampleBean sampleBean=new SampleBean(sub,patient.getTest_id(),uid,"1","1",ld);
	   Sample sample=new Sample();
       sample.setMessage("success");
	   sample.setStatus(1);
	   sample.setSampleBean(sampleBean);
	   this.sampleRepository.save(sampleBean);
	   return sample;
    }
    
    @PostMapping("/createsubsample")
    public void createSubSample(@RequestBody SubSampleBean subSampleBean)
    {
    	for(int i=1;i<=subSampleBean.getNumber();i++)
    	{
    		String sub=subSampleBean.getSample_id()+"."+String.valueOf(i);
    		Optional<SampleBean> s1=this.sampleRepository.findById(subSampleBean.getSample_id());
    		SampleBean sampleBean1=s1.get();
    		SampleBean subsample=new SampleBean(sub,sampleBean1.getTest_id(),sampleBean1.getUid(),subSampleBean.getTechnician_id(),subSampleBean.getStation_id(),subSampleBean.getDate());
    		this.sampleRepository.save(subsample);
    		Sample sample=new Sample();
    		sample.setMessage("success");
    		sample.setStatus(1);
    		sample.setSampleBean(subsample);
    		this.sampleRepository.save(subsample);
    	}
    }
}