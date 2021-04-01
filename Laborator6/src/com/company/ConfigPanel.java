package com.company;
import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
   static JLabel sidesLabel; // we’re drawing regular polygons
    static JLabel shapeLabel;
   static JSpinner sidesField; // number of sides
    static JComboBox colorCombo; // the color of the shape
    static JComboBox shapeCombo;
    static JComboBox deleteCombo;
    static JLabel deleteLabel;
    static JLabel colorLabel;
    static JSpinner strokeField;
    static JLabel strokeLabel;
    private String colors[]={"Black","Random"};
    private String shapes[]={"Polygon","Circle","Rectangle"};
    private String todo[]={"Draw shapes","Free drawing","Delete"};
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        deleteLabel =  new JLabel("What to do:");
        deleteCombo= new JComboBox(todo);


        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black

        shapeLabel = new JLabel("Shapes:");
        shapeCombo=new JComboBox(shapes);


        colorLabel = new JLabel("Color");
        colorCombo = new JComboBox(colors);

        strokeLabel = new JLabel("Stroke");
        strokeField = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        strokeField.setValue(4);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(deleteLabel);
        add(deleteCombo);
        add(shapeLabel);
        add(shapeCombo);
        add(colorLabel);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorLabel);
        add(colorCombo);
    }

    public static String getColors() {
        return (String) colorCombo.getSelectedItem();
    }

    public static int getSidesField() {
        return (int) sidesField.getValue();
    }

    public static String getShapes() {
        return (String) shapeCombo.getSelectedItem();
    }
}
