package com.Myproject.PowerGym.contollers;





import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Myproject.PowerGym.Services.AuthenticationService;
import com.Myproject.PowerGym.Services.MemberShipRepository;
import com.Myproject.PowerGym.Services.UserRepository;
import com.Myproject.PowerGym.models.MemberShip;
import com.Myproject.PowerGym.models.User;
import com.Myproject.PowerGym.models.UserDto;



@Controller

public class UserRegistrationController {


	 @Autowired
	   private UserRepository repo;
	 @Autowired
	   private MemberShipRepository repo1;
	

   
	@RequestMapping(value="/Registration", method = RequestMethod.GET)
    public String showUserPage(ModelMap model){

             UserDto obj=new UserDto();
           model.addAttribute("obj",obj);
           List<MemberShip> membership=repo1.findAll();
		   model.addAttribute("membership", membership);
        return "Registration/UserRegistration";
    }
	
	@RequestMapping(value="/Registration",method = RequestMethod.POST)
	 public String showUserPageSuccess(@ModelAttribute("obj") UserDto info,ModelMap model){
		
		User user=new User();
          user.setUser_name(info.getUsername());
          user.setAge(info.getAge());
          user.setGender(info.getGender());
          user.setMobileNumber(info.getMobileNumber());
          user.setChoose(info.getChoose());
        repo.save(user);
      model.put("success", "Successfully Registered "+info.getUsername());
      return "Registration/UserRegistration";
      
}
	@RequestMapping(value="/User")
	public String showUserList(Model model)
	   {	
		   List<User> user=repo.findAll();
		   model.addAttribute("user",user );
		   return "Customer/Customer";
	   }
}