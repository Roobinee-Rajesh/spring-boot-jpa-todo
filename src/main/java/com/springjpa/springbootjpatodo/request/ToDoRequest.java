package com.springjpa.springbootjpatodo.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoRequest {
    private int id;
    private String todo;
    private int userId;
}
