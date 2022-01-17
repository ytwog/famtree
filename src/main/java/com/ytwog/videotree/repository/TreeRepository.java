package com.ytwog.videotree.repository;

import com.ytwog.videotree.persistence.entity.DataNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends MongoRepository<DataNode, String> {
    DataNode findByName(String name);
}
