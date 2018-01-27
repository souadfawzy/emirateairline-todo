package com.emiratesairlines.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emiratesairlines.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
