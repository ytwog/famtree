package com.ytwog.videotree.controllers;

import com.ytwog.videotree.dao.DataNodeDao;
import com.ytwog.videotree.persistence.entity.DataNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tree_info/")
public class TreeInfoController {
    private final DataNodeDao dataNodeDao;

    @Autowired
    public TreeInfoController(DataNodeDao dataNodeDao) {
        this.dataNodeDao = dataNodeDao;
    }

    @GetMapping("data_nodes")
    public @ResponseBody List<DataNode> getDataNodes() {
        return dataNodeDao.findAll();
    }

    @PostMapping("save")
    public @ResponseBody boolean getDataNodes(@RequestBody DataNode dataNode) {
        return dataNodeDao.save(dataNode);
    }
}
