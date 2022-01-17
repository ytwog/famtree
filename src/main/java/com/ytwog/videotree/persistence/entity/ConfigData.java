package com.ytwog.videotree.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document("config")
public class ConfigData {
    @Field
    private String name;
    @Field
    private String value;
    @Id
    private String id;

    public ConfigData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
