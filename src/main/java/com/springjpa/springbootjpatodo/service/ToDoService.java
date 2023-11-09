package com.springjpa.springbootjpatodo.service;

import com.springjpa.springbootjpatodo.model.AppUser;
import com.springjpa.springbootjpatodo.model.Todo;
import com.springjpa.springbootjpatodo.repository.AppUserRepository;
import com.springjpa.springbootjpatodo.repository.ToDoRepository;
import com.springjpa.springbootjpatodo.request.ToDoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> getAllTodos( int userId) {
        return toDoRepository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> createTodo(ToDoRequest todo){
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(user);
        toDoRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }
    public List<Todo> updateTodo(ToDoRequest todo){
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserId()).get();
        originalTodo.setAppUser(user);
        toDoRepository.save(originalTodo);
        return getAllTodos(todo.getUserId());
    }
    public List<Todo> deleteTodoById(Integer id){
        int userId = toDoRepository.findById(id).get().getAppUser().getId();
        toDoRepository.deleteById(id);
        return getAllTodos(userId);
    }
}
