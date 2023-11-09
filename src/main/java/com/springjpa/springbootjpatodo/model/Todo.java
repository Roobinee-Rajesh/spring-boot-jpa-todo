package com.springjpa.springbootjpatodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String todo;
    @Column(name = "delete_flag", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean deleteFlag;
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_Id", referencedColumnName = "id")
    private AppUser appUser;
}
