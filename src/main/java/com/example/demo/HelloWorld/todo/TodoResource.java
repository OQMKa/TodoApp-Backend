package com.example.demo.HelloWorld.todo;
import java.net.URI;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.HelloWorld.todo.Todo;

@RestController
@CrossOrigin(origins="http://localhost:4200")	
public class TodoResource {
	@Autowired
	private TodoHardcodedSerice todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){	
		return todoService.findAll();
	}
	//DELETE/users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){     
		// ResponstEntity allow us to return a specific status back LIKE (.OK, .NOT_FOUND, .UNAUTHORZED ETC.)
		
		Todo todo = todoService.deleteById(id);
		if (todo!=null) { //THIS SHOULD HAPPEN POSITIVELY
			return ResponseEntity.noContent().build();		
		}
		return ResponseEntity.notFound().build()
;	}
	
	//Adding Update mechanism here..
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id){	
		return todoService.findById(id);
	}
//	Edit/Update a todo
//	PUT/users/{user_name}/todos
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,@RequestBody Todo todo){
		Todo toUpdated = todoService.saveAndContinue(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		
	}
	//Use below logic to create the new id with description. 
	//this will create the new id (idCounter++ and the new description!.
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(@PathVariable String username,@RequestBody Todo todo){
		Todo createdTodo = todoService.saveAndContinue(todo);
		
		
		//location
		//get current resource url
		//}{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return  ResponseEntity.created(uri).build();
		
	}
	
	
	
	
//
//	CREATE a new todo
//	POST/users/{user_name}/todos/
	
	
}

