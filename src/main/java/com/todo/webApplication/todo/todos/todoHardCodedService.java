package com.todo.webApplication.todo.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class todoHardCodedService {

	private static List<Todo> todos = new ArrayList();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter,"kkmishra@gmail.com","learn to new technologies",new Date(),false));
		todos.add(new Todo(++idCounter,"kkmishra@gmail.com","learn to new microservice",new Date(),false));
		todos.add(new Todo(++idCounter,"kkmishra@gmail.com","learn to new angular 7",new Date(),false));
		todos.add(new Todo(++idCounter,"kkmishra@gmail.com","learn to new todos",new Date(),false));
		todos.add(new Todo(++idCounter,"kkmishra@gmail.com","learn to new spring boot",new Date(),false));

	}
	public List<Todo> getAllTodos()
	{
		return todos;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			deleteTodoById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteTodoById(long id) {
		Todo todo = findById(id);
		if(todo==null) {return null;
		}
		todos.remove(todo);
		return todo;
	}

	public Todo findById(long id) {
		for(Todo todos: todos) {
			if(todos.getId() == id) {
				return todos;
			}
		}
		return null;
	}
}

