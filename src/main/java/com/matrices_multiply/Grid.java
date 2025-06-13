package com.matrices_multiply;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Grid extends JPanel{

    //Seal for the matrix to identify which table is which matrix in order 
    //to assign it to the correct 2d array
    public enum GridType { MATRIX_A, MATRIX_B, RESULT }

    private Canvas canvas;
    private int width;
    private int height;
    private JTextField fields[][];
    private GridType type;

    JPanel grid = new JPanel();
    Calc calc = new Calc();

    public Grid(Canvas canvas, int width, int height, GridType type){
        this.canvas = canvas;
        this.width = width;
        this.height = height;
        this.type = type;
        grid.setVisible(true);
        grid.setLayout(new GridLayout(3,3));
        grid.setPreferredSize(new Dimension(width, height));
    }

    public void createGrid(){
        fields = new JTextField[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

            JTextField tf = new JTextField("");
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tf.setBackground(Color.WHITE);
            tf.setPreferredSize(new Dimension(50,50));
            fields[row][col] = tf;
            grid.add(tf);

            // DocumentListener for Live-Evaluation
            tf.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            saveTextFieldAndCalc();
            finalResult();
            }

             public void removeUpdate(DocumentEvent e) {
            saveTextFieldAndCalc();
            finalResult();
            }

            public void changedUpdate(DocumentEvent e) {
            saveTextFieldAndCalc();
            finalResult();
            }
            });

            }
            canvas.addComponent(grid);
        }
    }

    private void saveTextFieldAndCalc() {
        saveTextField();
        calc.multiply();
    
    }

    public void saveTextField(){
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            String text = fields[row][col].getText();
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
            if (type == GridType.MATRIX_A) {
                calc.matrixA[row][col] = value;
            } else if (type == GridType.MATRIX_B) {
                calc.matrixB[row][col] = value;
            } else if (type == GridType.RESULT) {
                calc.matrixR[row][col] = value;
            }
            }
        }
    }
    public void finalResult(){

          for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                fields[row][col].setText(String.valueOf(calc.matrixR[row][col]));
            }
        }
    }
}
