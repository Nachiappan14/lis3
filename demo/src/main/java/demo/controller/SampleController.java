package demo.controller;

//import java.sql.Date;
import java.util.Date;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import demo.model.ObservationBean;
import demo.model.PatientBean;
import demo.model.Report;
import demo.model.ReportReply;
import demo.model.SampleBean;
import demo.model.SampleList;
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
	private ReportRepository reportRepository;

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
       LocalDateTime ld=LocalDateTime.now();
       String sub=String.valueOf(ld)+uid;
       LocalDate lds=LocalDate.now();
	   SampleBean sampleBean=new SampleBean(sub,patient.getTest_name(),uid,"1","1",lds,"");
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
    		String sub=subSampleBean.getSample_id()+"$"+String.valueOf(i);
    		Optional<SampleBean> s1=this.sampleRepository.findById(subSampleBean.getSample_id());
    		SampleBean sampleBean1=s1.get();
    		SampleBean subsample=new SampleBean(sub,sampleBean1.getTest_name(),sampleBean1.getUid(),sampleBean1.getTechnician_id(),sampleBean1.getStation_id(),sampleBean1.getDate(),"");
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
    public ReportReply generatereport(@RequestBody String sample_id)
    {
    	String report="";
    	ReportReply reportReply=new ReportReply();
//    	if sample_id is null
    	if(sample_id==null)
    	{
    		reportReply.setMessage("sample_id is null");
    		reportReply.setStatus(0);
    		reportReply.setReport(null);
    		return reportReply;
    	}
    	List<SampleBean> arr=getSamples();
    	for(int i=0;i<arr.size();i++)
    	{
    		if(arr.get(i).getSample_id().contains(sample_id))
    		{
    			report=report+arr.get(i).getSample_id()+" "+arr.get(i).getObservations()+"\n";
    		}
    	}
//    	if sample_id is not present
    	if(report=="")
    	{
    		reportReply.setMessage("no match");
    		reportReply.setStatus(0);
    		reportReply.setReport(null);
    		return reportReply;
    	}
    	Report report1 = new Report();
    	report1.setSample_id(sample_id);
    	report1.setReport(report);
    	this.reportRepository.save(report1);
    	reportReply.setMessage("success");
		reportReply.setStatus(1);
		reportReply.setReport(report1);
		return reportReply;
    }
    
    @GetMapping("/generatepdf")
    public void generatepdf(HttpServletResponse response) throws DocumentException, IOException 
//    public void generatepdf(@RequestBody String sample_id)
    {
    	response.setContentType("application/pdf");
    	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=samples_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<Report> listSamples=this.reportRepository.findAll();
        Pdf exporter = new Pdf(listSamples);
        exporter.export(response);
    }

//
//    private void sendmail() throws AddressException, MessagingException, IOException {
// 	   Properties props = new Properties();
// 	   props.put("mail.smtp.auth", "true");
// 	   props.put("mail.smtp.starttls.enable", "true");
// 	   props.put("mail.smtp.host", "smtp.gmail.com");
// 	   props.put("mail.smtp.port", "587");
// 	   
// 	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
// 	      protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
// 	         return new javax.mail.PasswordAuthentication("lislabinfo2022@gmail.com", "imt2018lis");
// 	      }
// 	   });
// 	   Message msg = new MimeMessage(session);
// 	   msg.setFrom(new InternetAddress("shreyagoshal0202@gmail.com", false));
//
// 	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lislabinfo2022@gmail.com"));
// 	   msg.setSubject("Tutorials point email");
// 	   msg.setContent("Tutorials point email", "text/html");
// 	   msg.setSentDate(new Date());

// 	   MimeBodyPart messageBodyPart = new MimeBodyPart();
// 	   messageBodyPart.setContent("Tutorials point email", "text/html");
//
// 	   Multipart multipart = new MimeMultipart();
// 	   multipart.addBodyPart(messageBodyPart);
// 	   MimeBodyPart attachPart = new MimeBodyPart();
//
// 	   attachPart.attachFile("/var/tmp/image19.png");
// 	   multipart.addBodyPart(attachPart);
// 	   msg.setContent(multipart);
// 	   Transport.send(msg);   
// 	}

// 	@RequestMapping(value = "/sendemail")
// 	public String sendEmail() throws AddressException, MessagingException, IOException {
// 	   sendmail();
// 	   return "Email sent successfully";   
// 	}
//    
    
//    @GetMapping("/searchsamplesbystationid")
//    public void searchbyuid(@RequestBody List<String> lis)
//    {
//    	if(lis.size()==1)
//    	{
//    		List<SampleBean> s= this.sampleRepository.getbystationid(lis.get(0));
//    		 
//    	}
//    	else
//    	{
//    	List<List<String>> lis1;
//    	for(int i=1;i<lis.size();i++)
//    	{
//    		
//    	}
//    	}
//    }
    @PostMapping("/searchsamplesbypatientid")
    public SampleList searchbypatientid(@RequestBody String uid )
    {
    	System.out.println(uid);
    	System.out.println("hello hi");
    	SampleList sampleList=new SampleList();
//  null condition
    	if(uid==null)
    	{
    		sampleList.setMessage("uid is null");
    		sampleList.setStatus(0);
    		sampleList.setSampleBean(null);
    		return sampleList;
    	}
    	List<SampleBean> sampleBean1= this.sampleRepository.getbypatientid(uid);
//    	if uid is not found in the repo
    	if(sampleBean1.isEmpty()==true)
    	{
    		sampleList.setMessage("uid not in repo");
    		sampleList.setStatus(0);
    		sampleList.setSampleBean(null);
    		return sampleList;
    	}
    	sampleList.setMessage("success");
    	sampleList.setStatus(1);
//		SampleBean sampleBean2=sampleBean1.get();
		sampleList.setSampleBean(sampleBean1);
		return sampleList;
    }
}