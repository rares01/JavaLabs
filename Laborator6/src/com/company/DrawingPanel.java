package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1000, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    private List<Shape> shapess=new ArrayList<>();
    private List<Color> colors = new ArrayList<>();
    private int currentX,currentY,oldX,oldY;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }


    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }




    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if(frame.configPanel.deleteCombo.getSelectedItem()=="Draw shapes"){
                    drawShape(e.getX(), e.getY());
                    repaint();
                }

                else if(frame.configPanel.deleteCombo.getSelectedItem()=="Delete"){

                    remShape(e.getX(),e.getY());
                    /**Afisam figurile ramase */
                    for(int i=0;i<shapess.size();i++) {
                        //System.out.println("1");
                        graphics.setColor(colors.get(i));
                        graphics.fill(shapess.get(i));
                        repaint();
                    }
                }
                else{
                        /** Pentru free drawing luam primu punct*/
                        oldX=e.getX();
                        oldY=e.getY();
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                /**Free drawing pe culori */
                public void mouseDragged (MouseEvent e) {
                    if (frame.configPanel.deleteCombo.getSelectedItem() == "Free drawing") {

                        currentX = e.getX();
                        currentY = e.getY();
                        String colors = ConfigPanel.getColors();
                        Random rand = new Random();
                        if (graphics != null) {
                            if (colors == "Black") {
                                Color color = new Color(0, 0, 0);
                                graphics.setColor(color);
                            } else {
                                float r = rand.nextFloat();
                                float g = rand.nextFloat();
                                float b = rand.nextFloat();
                                Color color = new Color(r, g, b);
                                graphics.setColor(color);
                            }

                            graphics.drawLine(oldX, oldY, currentX, currentY);
                            repaint();
                            oldX = currentX;
                            oldY = currentY;
                        }
                    }
                }

        });

    }
    /**Facem refresh la canvas  pentru a putea redesena*/
    private void refresh()
    {
        Graphics2D img= image.createGraphics();
        img.setColor(Color.WHITE);
        img.fillRect(0,0,W ,H );
        this.graphics=img;
        this.repaint();

    }
    /**Scoatem figura din lista de figuri si culoarea din lista de culori */
    private void remShape(int x,int y)
    {
        for(int i=this.getShapess().size()-1;i>=0;i--)
        {
            if(this.getShapess().get(i).contains(x,y))
            {
                this.getShapess().remove(i);
                this.getColors().remove(i);
                refresh();
                break;
            }
        }
    }
    private void drawShape(int x, int y) {
        Random rand= new Random();
        int radius = (int) (Math.random() * 100);
       int sides = ConfigPanel.getSidesField();
        String shapes = ConfigPanel.getShapes();
        String colors=ConfigPanel.getColors();
        if(colors== "Black") {
            Color color=new Color(0,0,0);
            graphics.setColor(color);
            this.getColors().add(color);
        }
       else{
           float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color color = new Color(r,g,b);
            graphics.setColor(color);
            this.getColors().add(color);

       }
       /**Avem poligoane,cercuri sau dreptunghiuri */
       if(shapes=="Polygon") {
           RegularPolygon poly=new RegularPolygon(x, y, radius, sides);
           graphics.fill(poly);
           this.getShapess().add(poly);
       }
       else if(shapes=="Circle")
       {
           NodeShape node=new NodeShape(x,y,radius);
           graphics.fill(node);
           this.getShapess().add(node);
       }
       else{
           double rectwidth =  Math.random() * 100;
           double rectheight =  Math.random() * 100;
           Rectangle2D recta= new Rectangle2D.Double(x, y,
                   rectwidth,rectheight);
            graphics.fill(recta);
            this.getShapess().add(recta);
       }
    }
    public void reset() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
    }


    public List<Shape> getShapess() {
        return shapess;
    }

    public List<Color> getColors() {
        return colors;
    }

    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
