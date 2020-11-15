package ru.realityfamily.opkeeper.Models;

import java.util.UUID;

public class SmallInfo {
    String name;
    UUID id;

    public SmallInfo(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
            this.id = id;
        }
}
