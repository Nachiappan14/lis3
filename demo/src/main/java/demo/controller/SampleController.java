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
	private PatientRepository patientRepository;
    @GetMapping("/samples")
    public List<SampleBean> getSamples(){
    	return this.sampleRepository.findAll();
    }
    
    @PostMapping("/createsample")
    public Sample createSample(@RequestBody SampleBean sampleBean)
    {
    	Sample sample=new Sample();
//    	have to generate sample_id from uid and date
//    	have to check if any attributes are empty
    	if(sampleBean==null)
    	{
    		sample.setMessage("Empty samples");
    		sample.setStatus(0);
    		sample.setSampleBean(null);
    		return sample;
    	}
    	if(sampleBean.getTest_id()==null || sampleBean.getUid()==null || sampleBean.getTechnician_id()==null || sampleBean.getStation_id()==null || sampleBean.getDate()==null)
    	{
    		sample.setMessage("partial filled sample form");
    		sample.setStatus(0);
    		sample.setSampleBean(null);
    		return sample;
    	}
    	sampleBean.setSample_id(sampleBean.getDate()+ sampleBean.getUid());
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
    		Optional<SampleBean> sampleBean1=this.sampleRepository.findById(subSampleBean.getSample_id());
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