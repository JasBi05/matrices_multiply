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
    private Grid resultGrid; 
    private Calc calc;

    JPanel grid = new JPanel();

    public Grid(Canvas canvas, int width, int height, GridType type, Grid resultGrid, Calc calc){
        this.canvas = canvas;
        this.width = width;
        this.height = height;
        this.type = type;
        this.resultGrid = resultGrid;
        this.calc = calc;
        grid.setVisible(true);
        grid.setLayout(new GridLayout(3,3));
        grid.setPreferredSize(new Dimension(width, height));
    }

    public void createGrid(){
        fields = new JTextField[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

            JTextField tf = new JTextField("1");
            tf.setHorizontalAlignment(JTextField.CENTER);
            tf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tf.setBackground(Color.WHITE);
            tf.setPreferredSize(new Dimension(50,50));
            fields[row][col] = tf;
            grid.add(tf);

            // DocumentListener for live calculation
            tf.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { saveTextFieldAndCalc(); }
            public void removeUpdate(DocumentEvent e) { saveTextFieldAndCalc(); }
            public void changedUpdate(DocumentEvent e) { saveTextFieldAndCalc(); }
            });

            }
            canvas.addComponent(grid);
        }
    }

    private void saveTextFieldAndCalc() {
        saveTextField();
        calc.multiply();
        if (resultGrid != null) {
            resultGrid.updateFieldsFromCalc();
        }
    }

    
    public void updateFieldsFromCalc() {
        if (type == GridType.RESULT) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    fields[row][col].setText(String.valueOf(calc.matrixR[row][col]));
                }
            }
        }
    }

    public void saveTextField(){
    for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
            String text = fields[row][col].getText();
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                value = 0;
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
}
