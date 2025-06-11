package com.matrices_multiply;
import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{


    private Canvas canvas;
    JPanel grid = new JPanel();
    public Grid(Canvas canvas){
        this.canvas = canvas;
        grid.setVisible(true);
        grid.setLayout(new GridLayout(3,3));
        
    }

    public void createGrid(){

        for(int i = 1; i <= 9; i++){

            JTextField tf = new JTextField(String.valueOf(i));
            tf.setHorizontalAlignment(JTextField.CENTER);

            tf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tf.setBackground(Color.YELLOW);

            tf.setSize(420,420);
            tf.setPreferredSize(new Dimension(100,100));
            
            grid.add(tf);
        }
        canvas.addComponent(grid);
       
    }
}
