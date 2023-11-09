package com.springjpa.springbootjpatodo.repository;

import com.springjpa.springbootjpatodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<Todo,Integer> {
}
