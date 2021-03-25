package com.company;

import com.company.ControlPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
       configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
       add(configPanel,"North");
        add(controlPanel,"South");
        add(canvas, "Center"); //this is BorderLayout.CENTER


        pack();
    }
    public void reset()
    {
        canvas.reset();
    }

    public void loadImg(BufferedImage image){
        canvas.loadImage(image);
    }


}

