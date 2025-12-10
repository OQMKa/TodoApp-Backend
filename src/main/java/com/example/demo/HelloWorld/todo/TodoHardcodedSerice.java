package com.example.demo.HelloWorld.todo;
import java.util.*;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class TodoHardcodedSerice {
	private static List<Todo> todos = new ArrayList();
	private static int idcounter=0;
	static {
		todos.add(new Todo(++idcounter, "om", "learn to dance", "Low", new Date()));
		todos.add(new Todo(++idcounter, "om", "learn about microservices","High", new Date()));
		todos.add(new Todo(++idcounter, "om", "learn about angular","High", new Date()));
		todos.add(new Todo(++idcounter, "om", "Adding another todo in list","High", new Date()));
		
	}
	public List<Todo> findAll(){
		return todos;
	}
	//DELETE
	public Todo deleteById(long id) {
		Todo todo =findById(id);
		if(todo==null)  return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}
	//RETREIVE
	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for(Todo todo :todos) {
			if (todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	//SAVE AND CONTIUE - > UPDATE
	public Todo saveAndContinue(Todo todo) {
//		console.log("saveAndContinue started!.");
		if (todo.getId()==-1||todo.getId()==0	) {
			todo.setId(++idcounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
		
	}
}

