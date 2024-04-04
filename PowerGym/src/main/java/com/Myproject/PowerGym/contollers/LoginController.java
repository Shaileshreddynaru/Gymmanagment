package com.Myproject.PowerGym.contollers;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Myproject.PowerGym.Services.AuthenticationService;
import com.Myproject.PowerGym.Services.MemberShipRepository;
import com.Myproject.PowerGym.models.MemberShip;



@Controller

public class LoginController {

private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	 @Autowired
	   private MemberShipRepository repo;

   
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String showWelcomePage(){



        return "login/login";
    }
	@RequestMapping(value="/",method = RequestMethod.POST)
	//login?name=Ranga RequestParam
	public String gotoWelcomePage(@RequestParam String username, 
			@RequestParam String password,ModelMap model) {
		
		if(authenticationService.authenticate(username, password)) {
		
			
			List<MemberShip> membership=repo.findAll();
			   model.addAttribute("membership", membership);
			   
			return "/mainpage/main";
		}
		model.put("Error", "Invalid username/password");
		return "login/login";
	}
	

}