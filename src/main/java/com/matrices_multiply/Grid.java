package com.matrices_multiply;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{


    private Canvas canvas;
    JPanel grid = new JPanel();
    private int width;
    private int height;

    public Grid(Canvas canvas, int width, int height){
        this.canvas = canvas;
        this.width = width;
        this.height = height;
        
        grid.setVisible(true);
        grid.setLayout(new GridLayout(3,3));
        grid.setPreferredSize(new Dimension(width, height));
    }

    public void createGrid(){

        for(int i = 1; i <= 9; i++){

            JTextField tf = new JTextField(String.valueOf(i));
            tf.setHorizontalAlignment(JTextField.CENTER);

            tf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tf.setBackground(Color.WHITE);

            tf.setSize(420,420);
            tf.setPreferredSize(new Dimension(50,50));
            
            grid.add(tf);
        }
        canvas.addComponent(grid);
       
    }
}
