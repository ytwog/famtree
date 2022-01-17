package com.ytwog.videotree.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Objects;

@Document("data")
public class DataNode {
    @Field
    private String name;
    @Field
    private String description;

    @Id
    private String id;

    public DataNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataNode)) return false;
        DataNode dataNode = (DataNode) o;
        return Objects.equals(name, dataNode.name) && Objects.equals(description, dataNode.description) && Objects.equals(id, dataNode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, id);
    }

    @Override
    public String toString() {
        return "DataNode{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
