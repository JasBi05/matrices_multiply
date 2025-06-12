package com.matrices_multiply;
import javax.swing.*;
import java.awt.*;

public class Canvas{

    private JFrame frame;
    private JPanel contentPanel;
    private GridBagConstraints gbc;

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
        contentPanel.setBackground(Color.LIGHT_GRAY);
    }


    public void importGrid(){
        gbc = new GridBagConstraints();
        contentPanel.setLayout(new GridBagLayout());

        printText();

        //first matrix
        Grid grid = new Grid(this, 300, 300);
        grid.createGrid();
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(grid.grid, gbc);

        //second matrix
        Grid grid2 = new Grid(this, 300, 300);
        grid2.createGrid();
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPanel.add(grid2.grid, gbc);
        

        //third matrix -> Result matrix
        Grid grid3 = new Grid(this, 300, 300);
        grid3.createGrid();
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(grid3.grid, gbc);
    }
    
    private void printText(){
        
        // Label for Matrix A
        JLabel labelA = new JLabel("Matrix A");
        labelA.setForeground(Color.BLACK);
        labelA.setFont(new Font("Courier New", Font.BOLD, 18)); 
        gbc.gridx = 2;
        gbc.gridy = 0;
        contentPanel.add(labelA, gbc);

        // Label for Matrix B
        JLabel labelB = new JLabel("Matrix B");
        labelB.setForeground(Color.BLACK); 
        labelB.setFont(new Font("Courier New", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(labelB, gbc);

        // Label for Ergebnis
        JLabel labelR = new JLabel("Result");
        labelR.setForeground(Color.BLACK); 
        labelR.setFont(new Font("Courier New", Font.BOLD, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPanel.add(labelR, gbc);

    }
}
