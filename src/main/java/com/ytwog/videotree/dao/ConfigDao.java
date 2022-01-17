package com.ytwog.videotree.dao;

import com.ytwog.videotree.persistence.entity.ConfigData;
import com.ytwog.videotree.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigDao {
    private final ConfigRepository configRepository;

    @Autowired
    public ConfigDao(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public List<ConfigData> findAll() {
        return configRepository.findAll();
    }

    public String find(String paramName) {
        return configRepository.findByName(paramName).getValue();
    }
}
