package com.matrices_multiply;
import javax.swing.*;
import java.awt.*;

public class Canvas{

    private JFrame frame;
    private JPanel contentPanel;

    public Canvas(){

        createCanvas();
    }

    public void createCanvas(){

        frame = new JFrame();
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
        frame.setTitle("Matrices Multiply");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(790,1000);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

    }

    public void addComponent(Component c){
        contentPanel.add(c);
        contentPanel.revalidate();
        contentPanel.repaint();
        contentPanel.setBackground(Color.BLUE);
    }

    public void importGrid(){
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        Grid grid = new Grid(this);
        grid.createGrid();
        
        contentPanel.add(Box.createRigidArea(new Dimension(40, 0))); // 40 Pixel Abstand
        grid.createGrid();
        }
    
}
