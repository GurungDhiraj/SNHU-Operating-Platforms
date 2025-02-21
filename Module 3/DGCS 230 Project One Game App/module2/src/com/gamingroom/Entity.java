package com.gamingroom;

public class Entity {
    private long id;
    private String name;

    public Entity()
    {
        id = 0;
        name = " ";
    }

    public Entity(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    // Getter for id
    public long getId(){return id;}

    // Getter for name
    public String getName(){return name;}


    public String toString(){return "Game [id=" + id + ", name=" + name + "]";}

}
