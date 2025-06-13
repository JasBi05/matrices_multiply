package com.matrices_multiply;
import javax.swing.*;
import java.awt.*;

public class Calc {

    public int matrixA[][];
    public int matrixB[][];
    public int matrixR[][];


    public void multiply(){
        if (matrixA == null || matrixB == null) return;
        if (matrixR == null) matrixR = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += matrixA[row][k] * matrixB[k][col];
                }
                matrixR[row][col] = sum;
            }
        }
    }
}
