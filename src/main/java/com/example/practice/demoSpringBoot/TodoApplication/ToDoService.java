package com.example.practice.demoSpringBoot.TodoApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class ToDoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "Junaid", "Learn Spring", new Date(), false));
		todos.add(new Todo(2, "Junaid", "Learn Java", new Date(), false));
		todos.add(new Todo(3, "Junaid", "Learn Docker", new Date(), false));
	}
	
	public List<Todo> retrieveTodos(String user)	{
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo:todos)	{
			if(todo.getUser().equals(user))	{
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isdone)
	{
		todos.add(new Todo(++todoCount,name,desc,targetDate,false));
	}
	
	public void deleteTodo(int id) { 
		for (Todo todo:todos) {
			if(todo.getId()==id)
				deleteTodo(id);
		}
	}
}
