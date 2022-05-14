package demo.controller;

import java.util.ArrayList;
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
import demo.model.createSampleInput;

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
    public Sample createSample(@RequestBody createSampleInput csi)
    {
    	// System.out.println(uid);
		String uid = csi.getUid();
		String sample_type = csi.getSample_type();
		Integer quantity = csi.getQuantity();
		String station_id = csi.getStation_id();

		System.out.println(uid+" "+sample_type+" "+quantity.toString()+" "+station_id);
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
       String sub=String.valueOf(ld)+"$"+uid;
//       String sub1=
       LocalDate lds=LocalDate.now();
//       String sample_id, String test_name, String uid, String observations, String parent,
//   			String sample_type, int quantity, String status, String rs_technician_id, LocalDate rs_date,
//   			String gs_technician_id, LocalDate gs_date, String as_technician_id, LocalDate as_date,
//   			String vs_technician_id, LocalDate vs_date) 
	   SampleBean sampleBean=new SampleBean(sub,patient.getTest_name(),uid,"1","",sample_type,quantity,1,"",lds,"",lds,"",lds,"",lds,"1",station_id);
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
    		SampleBean subsample=new SampleBean(sub,sampleBean1.getTest_name(),sampleBean1.getUid(),sampleBean1.getObservations(),sampleBean1.getSample_id(),sampleBean1.getSample_type() ,sampleBean1.getQuantity()/subSampleBean.getNumber(),sampleBean1.getStatus()+1,sampleBean1.getRs_technician_id() ,sampleBean1.getRs_date(),sampleBean1.getGs_technician_id() ,sampleBean1.getGs_date(),sampleBean1.getAs_technician_id(),sampleBean1.getAs_date(),sampleBean1.getVs_technician_id(),sampleBean1.getVs_date(),"1",subSampleBean.getStation_id());
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

    private void sendmail() throws AddressException, MessagingException, IOException {
 	   Properties props = new Properties();
 	   props.put("mail.smtp.auth", "true");
 	   props.put("mail.smtp.starttls.enable", "true");
 	   props.put("mail.smtp.host", "smtp.gmail.com");
 	   props.put("mail.smtp.port", "587");
 	   
 	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
 	      protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
 	         return new javax.mail.PasswordAuthentication("lislabinfo2022@gmail.com", "imt2018lis");
 	      }
 	   });
 	   Message msg = new MimeMessage(session);
 	   msg.setFrom(new InternetAddress("lislabinfo2022@gmail.com", false));

 	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("lislabinfo2022@gmail.com"));
 	   msg.setSubject("Tutorials point email");
 	   msg.setContent("Tutorials point email", "text/html");
 	   msg.setSentDate(new Date());

 	   MimeBodyPart messageBodyPart = new MimeBodyPart();
 	   messageBodyPart.setContent("Tutorials point email", "text/html");

 	   Multipart multipart = new MimeMultipart();
 	   multipart.addBodyPart(messageBodyPart);
// 	   MimeBodyPart attachPart = new MimeBodyPart();
//
// 	   attachPart.attachFile("/var/tmp/image19.png");
// 	   multipart.addBodyPart(attachPart);
 	   msg.setContent(multipart);
 	   Transport.send(msg);   
 	}

 	@RequestMapping(value = "/sendemail")
 	public String sendEmail() throws AddressException, MessagingException, IOException {
 	   sendmail();
 	   return "Email sent successfully";
    
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
    }
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
    @PostMapping("/searchsamplesbystationid")
	public SampleList searchbystationid(@RequestBody String station_id )
	{
   	 System.out.println(station_id);
   	 System.out.println("hello station");
   	 SampleList sampleList=new SampleList();
//  null condition
   	 if(station_id==null)
   	 {
   		 sampleList.setMessage("stationid is null");
   		 sampleList.setStatus(0);
   		 sampleList.setSampleBean(null);
   		 return sampleList;
   	 }
   	 List<SampleBean> sampleBean1= this.sampleRepository.getbystationid(station_id);
//   	 if uid is not found in the repo
   	 if(sampleBean1.isEmpty()==true)
   	 {
   		 sampleList.setMessage("stationid not in repo");
   		 sampleList.setStatus(0);
   		 sampleList.setSampleBean(null);
   		 return sampleList;
   	 }
   	 sampleList.setMessage("success");
   	 sampleList.setStatus(1);
//   	 SampleBean sampleBean2=sampleBean1.get();
   	 sampleList.setSampleBean(sampleBean1);
   	 return sampleList;
	}
    @PostMapping("/showSamplesByDate")
	public List<String> showSamplesByDate(@RequestBody LocalDate ld )
	{
    	List<SampleBean> p= this.sampleRepository.getbydate(ld);
    	List<String> res=new ArrayList<>();
    	for(int i=0;i<p.size();i++)
    	{
    		res.add(p.get(i).getSample_id());
    	}
    	return res;
	}
    @GetMapping("/countsamples")
    public String countsamples()
    {
    	return Integer.toString(this.sampleRepository.getsamples().size());
    }
    @PostMapping("/getsamplebysampleid")
    public SampleBean getsamplebysampleid(@RequestBody String sample_id)
    {
    	return this.sampleRepository.getById(sample_id);
    }
    @PostMapping("/getreportbytest_id")
    public String getreportbytest_id(@RequestBody String uid)
    {
    	return (this.reportRepository.findById(uid)).get().getReport();
    }
    @PostMapping("/setobbytest_id")
    public void setobbytest_id(@RequestBody Report pp)
    {
    	Report p=this.reportRepository.findById(pp.getSample_id()).get();
    	p.setReport(pp.getReport());
    }
    @PostMapping("/getstatusbysampleid")
    public int getstatusbysampleid(@RequestBody String sample_id)
    {
    	return this.sampleRepository.getById(sample_id).getStatus();
    }
    @PostMapping("/getsamplesbystationid")
    public List<SampleBean> getsamplesbystationid(@RequestBody String station_id)
    {
    	return this.sampleRepository.getsamplesbystationid(station_id);
    }
    @PostMapping("/editstatus")
    public void editstatus(@RequestBody String sample_id) 
    {
    	SampleBean s=this.sampleRepository.findById(sample_id).get();
    	s.setStatus(s.getStatus()+1);
    }
    @PostMapping("/getsubsamplebysampleid")
    public  List<SampleBean> getsubsamplebysampleid(@RequestBody String sample_id)
    {
    	List<SampleBean> arr=this.sampleRepository.getsamples();
    	List<SampleBean> res= new ArrayList<>();
    	for(int i=0;i<arr.size();i++)
    	{
    		if(arr.get(i).getSample_id().contains(sample_id))
    		{
    			res.add(arr.get(i));
    		}
    	}
       return res;
    }
}
