package com.company;

public abstract class Being implements setAndGetName {
    private String name;
    private final int id;
    private static int count_peoples;
    private String location;

    static {
        count_peoples = 0;
    }

    public Being(String name, String location) {
        this.name = name;
        this.location = location;
        this.id = count_peoples;
        count_peoples++;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String s) {
        name = s;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        System.out.printf("%s ступил на %s\n", name, location);
    }
}


