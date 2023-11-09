package com.springjpa.springbootjpatodo.repository;

import com.springjpa.springbootjpatodo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT u FROM AppUser u WHERE u.name = :name AND u.password = :password")
    AppUser findUserByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
