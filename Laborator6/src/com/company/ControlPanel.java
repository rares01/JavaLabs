
package com.company;

import com.company.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn= new JButton(("Load"));
    JButton resetBtn= new JButton(("Reset"));
    JButton exitBtn= new JButton(("Exit"));
 //...TODO



    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
    }
    private void save(ActionEvent e) {
        //fc.setVisible(true);
        JFileChooser fc= new JFileChooser();
        fc.showSaveDialog(null);

        try {
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                java.io.File f = fc.getSelectedFile();
                ImageIO.write(frame.canvas.image, "PNG", new File(f.getPath()));

        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)
    {
        frame.reset();
    }
    private void exit(ActionEvent e)
    {
            frame.dispose();
    }
    private void load(ActionEvent e) {
        JFileChooser fc= new JFileChooser();
        fc.showOpenDialog(this);
        try {
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            java.io.File f = fc.getSelectedFile();
           frame.canvas.graphics.drawImage(ImageIO.read(new File(f.getPath())),0,0,this) ;

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


}
