package com.ytwog.videotree.repository;

import com.ytwog.videotree.persistence.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, String> {
    AppUser findByName(String name);
}
