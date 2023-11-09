package com.springjpa.springbootjpatodo.controller;

import com.springjpa.springbootjpatodo.model.AppUser;
import com.springjpa.springbootjpatodo.service.AppUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appuser")
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    @RequestMapping("/login")
    public AppUser login(@RequestBody AppUser appUser){
        return appUserService.login(appUser);
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser appUser){
        return appUserService.register(appUser);
    }
}
