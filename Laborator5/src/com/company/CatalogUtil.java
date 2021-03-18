package com.company;

import java.awt.*;
import java.io.*;

public class CatalogUtil implements Serializable {
    String name;
    String path;

    public CatalogUtil(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath() + catalog.getName()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog cat=null;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            cat = (Catalog) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return cat;
    }


    public static void view(Item item) {
        try {
            //constructor of file class having file as argument
            File file = new File(item.getLocation() + item.getName());
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())         //checks file exists or not
            {
                //System.out.println(item.getName());
                desktop.open(file);
            };              //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();
        }
        //… browse or open, depending of the location type
    }
}
