package com.emiratesairlines.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emiratesairlines.todo.model.Todo;
import com.emiratesairlines.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoRepository todoRepository;
	@Override
	public List<Todo> getAllTodos() {
		
		Sort sortByCreationDateDesc = new Sort(Sort.Direction.DESC, "creationDate");
		return todoRepository.findAll(sortByCreationDateDesc);
	}
	@Override
	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	@Override
	public Todo getTodoById(String id) {
		return todoRepository.findOne(Long.parseLong(id));
	}
	
	@Override
	public void deleteTodo(String id) {
		todoRepository.delete(Long.parseLong(id));
	}
}
