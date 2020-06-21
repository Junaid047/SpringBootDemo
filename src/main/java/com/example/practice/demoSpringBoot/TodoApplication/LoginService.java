package com.example.practice.demoSpringBoot.TodoApplication;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean ValidateUser(String userId, String password)
	{
		if(userId.equalsIgnoreCase("Junaid")&&password.equals("password"))
			return true;
		else
			return false;
	}
}
