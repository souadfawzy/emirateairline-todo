package com.emiratesairlines.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emiratesairlines.todo.model.Todo;
import com.emiratesairlines.todo.service.TodoService;

@RestController
@RequestMapping(value = "/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

	@Autowired
	TodoService todoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Todo createTodo(@Valid @RequestBody Todo todo) {
		return todoService.createTodo(todo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") String id) {
		Todo todo = todoService.getTodoById(id);
		if (todo == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		}
	}

	/**
	 * call this method to update Todo status and title
	 * @param id
	 * @param todo
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id, @Valid @RequestBody Todo todo) {
		Todo todoDB = todoService.getTodoById(id);
		
		if (todoDB == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		todoDB.setTitle(todo.getTitle());
		todoDB.setCompleted(todo.isCompleted());
		Todo updatedTodo = todoService.createTodo(todoDB);
		return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("id") String id) {
		todoService.deleteTodo(id);
	}
}
