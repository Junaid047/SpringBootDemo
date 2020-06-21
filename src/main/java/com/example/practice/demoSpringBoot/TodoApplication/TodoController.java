package com.example.practice.demoSpringBoot.TodoApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

	@Autowired
	ToDoService service;
	
	@RequestMapping(value="/list-todos", method=RequestMethod.GET)
	public String ShowListTodos(ModelMap model)	{
		model.put("todos", service.retrieveTodos("Junaid"));
		return "list_todos";
	}
	
}
