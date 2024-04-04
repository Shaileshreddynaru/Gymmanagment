package com.Myproject.PowerGym.contollers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Myproject.PowerGym.Services.MemberShipRepository;
import com.Myproject.PowerGym.models.MemberShip;



@Controller
@RequestMapping("/MemberShipPlans")

public class MemberShipContoller {
       
	   @Autowired
	   private MemberShipRepository repo;
	   
	   
	   @GetMapping({"", "/"})
	   public String showMemeberShipList(Model model)
	   {	
		   List<MemberShip> membership=repo.findAll();
		   model.addAttribute("membership", membership);
		   return "MemberShipPlans/index";
	   }
	}

