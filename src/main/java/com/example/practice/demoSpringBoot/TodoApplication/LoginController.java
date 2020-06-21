package com.example.practice.demoSpringBoot.TodoApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController	{
	
	@Autowired
	LoginService signInService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String LoginMessage(ModelMap model)
	{
		return "loginpage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String LoginAction(ModelMap model, @RequestParam String name, @RequestParam String password)
	{
		boolean IsValid = signInService.ValidateUser(name, password);
		System.out.println("IsValid is: "+IsValid);
		if(!IsValid)	{
			model.put("message","Invalid Credentials");
			return "loginpage";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}