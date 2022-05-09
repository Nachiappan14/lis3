package demo.controller;

import java.util.List;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.User;
import demo.model.UserBean;
import demo.model.Reply;
import demo.model.Station;
import demo.model.StationBean;
import demo.repository.StationRepository;
import demo.repository.UserRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class AdminController {
	@Autowired
	private StationRepository stationRepository;
	@Autowired
	private UserRepository userRepository;
    @GetMapping("/stations")
    public List<StationBean> getStation(){
    	return this.stationRepository.findAll();
    }
    @PostMapping("/addstation")
    public Station addstation(@RequestBody StationBean stationBean)
    {
    	Station station = new Station();
    	if(stationBean==null)
    	{
    		station.setMessage("Empty values");
    		station.setStatus(0);
    		station.setStationBean(null);
    		return station;
    	}
    	if(stationBean.getStationid() ==null || stationBean.getStationname() ==null)
    	{
    		station.setMessage("Partial Empty values");
    		station.setStatus(0);
    		station.setStationBean(null);
    		return station;
    	}
//    	if id already exists
    	Optional<StationBean> stationBean1=this.stationRepository.findBystationid(stationBean.getStationid());
    	if(stationBean1.isEmpty()==false)
    	{
    		station.setMessage("id already exists");
    		station.setStatus(0);
    		station.setStationBean(null);
    		return station;
    	}	
    	station.setMessage("Success");
    	station.setStatus(1);
    	station.setStationBean(stationBean);
    	this.stationRepository.save(stationBean);
      	return station;
    }
    
    @PostMapping("/addusers")
    public Reply addusers(@RequestBody User user)
    {
    	Reply reply=new Reply();
    	if(user==null)
    	{
    		reply.setMessage("Empty values");
    		reply.setStatus(0);
    		reply.setUser(null);
    		return reply;
    	}
//    	check if any value is null
    	if(user.getTechnician_id() ==null || user.getTechnicianname()==null || user.getTechnician_password() ==null || user.getTechnician_email()==null || user.getTechnician_contactnumber()==null || user.getTechnician_age() ==null || user.getTechnician_gender() ==null )
    	{
    		reply.setMessage("Partial Empty values");
    		reply.setStatus(0);
    		reply.setUser(null);
    		return reply;
    	}
//    	give atleast one role
    	if(user.getRole_reception()==null && user.getRole_grossing() ==null && user.getRole_analyzing()==null && user.getRole_reporting()==null && user.getRole_admin() ==null && user.getRole_doctor() ==null)  
    	{
    		reply.setMessage("Assign atleast one role");
    		reply.setStatus(0);
    		reply.setUser(null);
    		return reply;
    	}
//    	check if id exists
    	Optional<User> user1=this.userRepository.findBytechnicianname(user.getTechnicianname());
    	if(user1.isEmpty()==false)
    	{
    		reply.setMessage("id already exists");
    		reply.setStatus(0);
    		reply.setUser(null);
    		return reply;
    	}	
    	reply.setMessage("Success");
    	reply.setStatus(1);
    	
    	Argon2PasswordEncoder encoder=new Argon2PasswordEncoder();
    	user.setTechnician_password(encoder.encode(user.getTechnician_password()));
    	
    	reply.setUser(user);
    	this.userRepository.save(user);
      	return reply;	
    }
}