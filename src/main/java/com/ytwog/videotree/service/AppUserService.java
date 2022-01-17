package com.ytwog.videotree.service;

import antlr.StringUtils;
import com.ytwog.videotree.dao.AppUserDao;
import com.ytwog.videotree.dto.UserCredentials;
import com.ytwog.videotree.persistence.entity.AppUser;
import com.ytwog.videotree.exception.VideoTreeException;
import com.ytwog.videotree.security.dto.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Objects;

@Service
public class AppUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AppUserDao appUserDao;

    @Autowired
    public AppUserService(PasswordEncoder passwordEncoder, AppUserDao appUserDao) {
        this.passwordEncoder = passwordEncoder;
        this.appUserDao = appUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserDao.findByName(username);
        if(Objects.isNull(appUser)) {
            throw new VideoTreeException(MessageFormat.format("Username {0} not found", username));
        }
        return new AppUserDetails(
            appUser.getName(),
            appUser.getHashedPass(),
            Collections.emptySet(),
            true,
            true,
            true,
            true
        );
    }

    public boolean signUp(UserCredentials userCredentials) {
        AppUser appUser = new AppUser();
        appUser.setName(userCredentials.getLogin());
        appUser.setHashedPass(passwordEncoder.encode(userCredentials.getPassword()));
        return appUserDao.save(appUser);
    }

    public boolean login(UserCredentials userCredentials) {
        return passwordEncoder.matches(
            userCredentials.getPassword(),
            appUserDao.findByName(userCredentials.getLogin()).getHashedPass()
        );
    }
}
