package demo.controller;

import java.util.List;
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
import demo.repository.UserRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getUsers(){
    	return this.userRepository.findAll();
    }
    @PostMapping("/login")
    public Reply login(@RequestBody UserBean bean)
    {
    	Reply reply=new Reply();
    	if(bean==null)
    	{
    		reply.setMessage("Empty Credentials");
    		reply.setStatus(0);
    		reply.setUser(null);
    		reply.setToken("dummy");
    		return reply;
    	}
    	System.out.println(bean);
    	
    	Optional<User> users=this.userRepository.findBytechnicianname(bean.getTechnician_name());
    	if(users.isEmpty()==true)
    	{
    		reply.setMessage("Failure");
        	reply.setStatus(0);
        	reply.setUser(null);
    		reply.setToken("dummy");
        	return reply;
    	}
    	if(users!=null)
    	{	
	        User user=users.get();
	    	if((bean.getTechnician_password().equals(user.getTechnician_password())))
	    	{
	    		reply.setMessage("Success");
	    		reply.setStatus(1);
	    		reply.setUser(user);
	    		reply.setToken("dummy");
//	    		this.userRepository.save(user);
	    		return reply;
	    	}
    	}
    	reply.setMessage("Failure");
    	reply.setStatus(0);
    	reply.setUser(null);
		reply.setToken("dummy");
    	return reply;
    }
}
