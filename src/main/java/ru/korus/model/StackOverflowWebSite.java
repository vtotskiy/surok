package ru.korus.model;

public class StackOverflowWebSite {
    private final String id;
    private final String name;
    private final String desc;


    public StackOverflowWebSite(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
