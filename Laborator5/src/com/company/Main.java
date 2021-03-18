package com.company;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("My Books","");
        var song = new Song("bestSong","Dansul pinguinului.mp3","C:/Users/RaresGeorge/Desktop/Faculta/Folder nou/Muzica Aur/");
        var book = new Book("bestBook","Cracking the Coding Interview.pdf","C:/Users/RaresGeorge/Downloads/");
        catalog.add(song);
        catalog.add(book);
        catalog.list();
        CatalogUtil.save(catalog);

    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("My Books");
        CatalogUtil.view(catalog.findById("bestSong"));
        CatalogUtil.view(catalog.findById("bestBook"));
    }
}

