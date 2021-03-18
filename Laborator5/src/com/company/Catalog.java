package com.company;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();


    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Catalog() {
    }

    public void add(Item item) {
        items.add(item);
    }
    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void list()
    {
        for(int i=0;i<items.size();i++)
        {
            System.out.println(items.get(i).getId()+ " " + items.get(i).getName()  + " " + items.get(i).getLocation());
        }
    }

}
