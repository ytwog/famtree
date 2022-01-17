package com.ytwog.videotree.dao;

import com.ytwog.videotree.persistence.entity.AppUser;
import com.ytwog.videotree.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;

@Component
public class AppUserDao {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserDao(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser findByName(String name) {
        return appUserRepository.findByName(name);
    }

    public boolean save(AppUser appUser) {
        try {
            appUserRepository.save(appUser);
        } catch (PersistenceException e) {
            return false;
        }
        return true;
    }
}
