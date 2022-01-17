package com.ytwog.videotree.repository;

import com.ytwog.videotree.persistence.entity.ConfigData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends MongoRepository<ConfigData, String> {
    ConfigData findByName(String name);
}
