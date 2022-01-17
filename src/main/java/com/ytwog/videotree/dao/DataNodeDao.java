package com.ytwog.videotree.dao;

import com.ytwog.videotree.persistence.entity.DataNode;
import com.ytwog.videotree.repository.TreeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import java.util.List;

@Component
public class DataNodeDao {
    private static final Logger logger = LoggerFactory.getLogger(DataNodeDao.class);
    private final TreeRepository treeRepository;

    @Autowired
    public DataNodeDao(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public List<DataNode> findAll() {
        return treeRepository.findAll();
    }

    public boolean save(DataNode dataNode) {
        try {
            DataNode inserted = treeRepository.insert(dataNode);
        } catch (PersistenceException e) {
            logger.error("Can't insert dataNode={}", dataNode, e);
            return false;
        }
        return true;
    }
}
