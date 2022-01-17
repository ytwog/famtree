package com.ytwog.videotree.controllers;

import com.ytwog.videotree.constant.ConfigParam;
import com.ytwog.videotree.dao.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ConfigInfoController {
    private final ConfigDao configDao;

    @Autowired
    public ConfigInfoController(ConfigDao configDao) {
        this.configDao = configDao;
    }

    @GetMapping("version")
    public @ResponseBody String getDataNodes() {
        return configDao.find(ConfigParam.VERSION);
    }
}
