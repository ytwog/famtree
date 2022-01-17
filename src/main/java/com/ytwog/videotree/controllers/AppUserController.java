package com.ytwog.videotree.controllers;

import com.ytwog.videotree.dto.UserCredentials;
import com.ytwog.videotree.persistence.entity.AppUser;
import com.ytwog.videotree.persistence.entity.DataNode;
import com.ytwog.videotree.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("login")
    public @ResponseBody boolean login(@RequestBody UserCredentials userCredentials) {
        return appUserService.login(userCredentials);
    }

    @PostMapping("sign_up")
    public @ResponseBody boolean signUp(@RequestBody UserCredentials userCredentials) {
        return appUserService.signUp(userCredentials);
    }
}
