package com.springjpa.springbootjpatodo.service;

import com.springjpa.springbootjpatodo.model.AppUser;
import com.springjpa.springbootjpatodo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository appUserRepository;


    public AppUser login(AppUser appUser) {
        AppUser loggedInUser =
                appUserRepository.findUserByNameAndPassword(appUser.getName(), appUser.getPassword());
        return loggedInUser;
    }

    public AppUser register(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}
