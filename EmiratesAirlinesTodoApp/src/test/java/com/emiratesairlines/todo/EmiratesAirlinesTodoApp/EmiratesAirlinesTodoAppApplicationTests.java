package com.emiratesairlines.todo.EmiratesAirlinesTodoApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emiratesairlines.todo.model.Todo;
import com.emiratesairlines.todo.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmiratesAirlinesTodoAppApplicationTests {

	@Autowired
	TodoService todoService;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void shouldReturnTodoCreated(){
		Todo todo=new Todo();
		todo.setTitle("New Todo Created");
		todoService.createTodo(todo);
	}
	
	@Test
	public void shouldReturnTodo(){
		todoService.getTodoById("");
	}
	
	@Test
	public void shouldDeleteTodo(){
		todoService.deleteTodo("");
	}
	
}
