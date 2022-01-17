package com.ytwog.videotree.security;

import com.ytwog.videotree.dao.AppUserDao;
import com.ytwog.videotree.persistence.entity.AppUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class SecurityConfigTest {
    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String USER_NAME = "ytwog";
    private static final String PASSWORD = "o9p0[-]=";

    @Test
    void loadSampleAppUser() {
        AppUser appUser = new AppUser();
        appUser.setName(USER_NAME);
        appUser.setHashedPass(
            passwordEncoder.encode(PASSWORD)
        );

        System.out.println(appUserDao.save(appUser) ? "User successfully added" : "User already exist");
    }
}