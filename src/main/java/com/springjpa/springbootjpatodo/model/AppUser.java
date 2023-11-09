package com.springjpa.springbootjpatodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private List<Todo> todo;

}
