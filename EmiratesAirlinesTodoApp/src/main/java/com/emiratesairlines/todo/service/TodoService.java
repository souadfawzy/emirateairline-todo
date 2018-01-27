package com.emiratesairlines.todo.service;

import java.util.List;

import com.emiratesairlines.todo.model.Todo;

public interface TodoService {

	 List<Todo> getAllTodos();
	 Todo createTodo(Todo todo);
	 Todo getTodoById(String id);
	 void deleteTodo(String id);
}
