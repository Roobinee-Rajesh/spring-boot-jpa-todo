package com.springjpa.springbootjpatodo.controller;

import com.springjpa.springbootjpatodo.model.Todo;
import com.springjpa.springbootjpatodo.request.ToDoRequest;
import com.springjpa.springbootjpatodo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    @Autowired
    ToDoService toDoService;


    @GetMapping("/{userId}")
    public List<Todo> findAllTodo(@PathVariable int userId){
        return toDoService.getAllTodos(userId);
    }


    @PostMapping("/add")
    public  List<Todo> createTodo(@RequestBody ToDoRequest todo){
        return toDoService.createTodo(todo);
    }

    @PutMapping("/update/{todo}")
    public  List<Todo> updateTodo(@RequestBody ToDoRequest todo){
        return toDoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public  List<Todo> deleteTodoById(@PathVariable int id){
        return toDoService.deleteTodoById(id);
    }
}
