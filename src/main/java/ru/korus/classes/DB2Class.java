package ru.korus.classes;

import org.springframework.stereotype.Component;

@Component
public class DB2Class {

    private String Id;
    private String Up_ID;
    private String Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUp_ID() {
        return Up_ID;
    }

    public void setUp_ID(String up_id) {
        Up_ID = up_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}